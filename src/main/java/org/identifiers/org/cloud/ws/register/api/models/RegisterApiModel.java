package org.identifiers.org.cloud.ws.register.api.models;

import org.identifiers.org.cloud.ws.register.api.requests.prefixregistration.ServiceRequestCheckPrefixRegistrationStatus;
import org.identifiers.org.cloud.ws.register.api.requests.prefixregistration.ServiceRequestRegisterPrefix;
import org.identifiers.org.cloud.ws.register.api.responses.prefixregistration.ServiceResponseCheckPrefixRegistrationStatus;
import org.identifiers.org.cloud.ws.register.api.responses.prefixregistration.ServiceResponseRegisterPrefix;
import org.identifiers.org.cloud.ws.register.api.responses.prefixregistration.ServiceResponseRegisterPrefixPayload;
import org.identifiers.org.cloud.ws.register.data.PrefixRegistrationRequestHelper;
import org.identifiers.org.cloud.ws.register.data.models.PrefixRegistrationRequest;
import org.identifiers.org.cloud.ws.register.data.services.PrefixRegistrationRequestService;
import org.identifiers.org.cloud.ws.register.models.agents.PrefixRegistrationAgent;
import org.identifiers.org.cloud.ws.register.models.agents.PrefixRegistrationAgentException;
import org.identifiers.org.cloud.ws.register.models.validators.PrefixRegistrationRequestValidatorException;
import org.identifiers.org.cloud.ws.register.models.validators.PrefixRegistrationRequestValidatorStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * Project: register
 * Package: org.identifiers.org.cloud.ws.register.models
 * Timestamp: 2018-01-30 17:03
 * ---
 */
// For this iteration, it is ok for this model to be a singleton
@Component
public class RegisterApiModel {
    public static final String apiVersion = "1.0";
    private static Logger logger = LoggerFactory.getLogger(RegisterApiModel.class);

    @Autowired
    private PrefixRegistrationRequestValidatorStrategy validatorStrategy;

    @Autowired
    private PrefixRegistrationAgent prefixRegistrationAgent;

    @Autowired
    private PrefixRegistrationRequestService prefixRegistrationRequestService;

    private ServiceResponseRegisterPrefix createDefaultResponse() {
        ServiceResponseRegisterPrefix response = new ServiceResponseRegisterPrefix();
        response.setApiVersion(apiVersion).setHttpStatus(HttpStatus.OK);
        response.setPayload(new ServiceResponseRegisterPrefixPayload());
        return response;
    }

    // helpers

    /**
     * This helper will move the prefix registration request forward in the process, by using a prefix registration agent.
     * If the given 'response' already has an HTTP status other than 'OK', it won't do anything.
     * @param request a valid prefix registration request
     * @param response the response that is being built for sending it back to the client
     * @return the ongoing response to the client, with possible changes depending on how the helper completes its job.
     */
    private ServiceResponseRegisterPrefix registerValidRequest(PrefixRegistrationRequest request, ServiceResponseRegisterPrefix response) {
        if (response.getHttpStatus() != HttpStatus.OK) {
            logger.warn("Not registering valid request for prefix '{}' from requester '{}', " +
                    "because the response already has error '{}' and HTTP Status '{}'",
                    request.getPreferredPrefix(),
                    request.getRequester().getEmail(),
                    response.getErrorMessage(),
                    response.getHttpStatus().value());
        } else {
            // Use a registration agent to push the request further
            logger.info("Pushing registration request for prefix '{}' from requester '{}' forward",
                    request.getPreferredPrefix(), request.getRequester().getEmail());
            try {
                prefixRegistrationAgent.registerPrefix(request);
            } catch (PrefixRegistrationAgentException e) {
                response.setErrorMessage(e.getMessage());
                response.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return response;
    }

    private void setToken(PrefixRegistrationRequest prefixRegistrationRequest) {
        prefixRegistrationRequest.setToken(UUID.randomUUID().toString());
    }

    /**
     * This helper will cache the given valid prefix registration request.
     * @param request a valid prefix registration request
     * @param response the response that is being built for sending it back to the client
     * @return the ongoing response to the client, with possible changes depending on hwo the helper completes its job.
     */
    private ServiceResponseRegisterPrefix cacheValidRequest(PrefixRegistrationRequest request, ServiceResponseRegisterPrefix response) {
        if (response.getHttpStatus() != HttpStatus.OK) {
            logger.warn("Not caching valid request for prefix '{}' from requester '{}'," +
                            " because the response already has error '{}' and HTTP Status '{}'",
                    request.getPreferredPrefix(),
                    response.getErrorMessage(),
                    response.getHttpStatus().value());
        } else {
            try {
                prefixRegistrationRequestService.save(request);
            } catch (RuntimeException e) {
                // If we could not cache the valid prefix registration request, it still is a valid prefix registration
                // request, so we just log the error, but we won't tell the client about it.
                logger.error("Could not cache prefix registration request for prefix '{}', requester '{}', due to '{}'",
                        request.getPreferredPrefix(), request.getRequester().getEmail(), e.getMessage());
            }
        }
        return response;
    }

    // --- API ---
    public ServiceResponseRegisterPrefix registerPrefix(ServiceRequestRegisterPrefix request) {
        // TODO - Check API version information?
        ServiceResponseRegisterPrefix response = createDefaultResponse();
        // Validate the request
        boolean isValidRequest = false;
        try {
            isValidRequest = validatorStrategy.validate(request.getPayload());
        } catch (PrefixRegistrationRequestValidatorException e) {
            response.setErrorMessage(e.getMessage());
            response.setHttpStatus(HttpStatus.BAD_REQUEST);
        }
        if (isValidRequest) {
            PrefixRegistrationRequest requestModel = PrefixRegistrationRequestHelper.getPrefixRegistrationRequestFrom(request.getPayload());
            setToken(requestModel);
            registerValidRequest(requestModel, response);
            cacheValidRequest(requestModel, response);
        }
        return response;
    }

    public ServiceResponseCheckPrefixRegistrationStatus checkPrefixRegistrationStatus(ServiceRequestCheckPrefixRegistrationStatus request) {
        // TODO
    }
}
