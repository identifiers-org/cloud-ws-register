package org.identifiers.org.cloud.ws.register.api.models;

import org.identifiers.org.cloud.ws.register.api.requests.prefixregistration.ServiceRequestRegisterPrefix;
import org.identifiers.org.cloud.ws.register.api.responses.prefixregistration.ServiceResponseRegisterPrefix;
import org.identifiers.org.cloud.ws.register.api.responses.prefixregistration.ServiceResponseRegisterPrefixPayload;
import org.identifiers.org.cloud.ws.register.models.agents.PrefixRegistrationAgent;
import org.identifiers.org.cloud.ws.register.models.agents.PrefixRegistrationAgentException;
import org.identifiers.org.cloud.ws.register.models.validators.PrefixRegistrationRequestValidatorException;
import org.identifiers.org.cloud.ws.register.models.validators.PrefixRegistrationRequestValidatorStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

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

    private ServiceResponseRegisterPrefix createDefaultResponse() {
        ServiceResponseRegisterPrefix response = new ServiceResponseRegisterPrefix();
        response.setApiVersion(apiVersion).setHttpStatus(HttpStatus.OK);
        response.setPayload(new ServiceResponseRegisterPrefixPayload());
        return response;
    }

    // helpers
    private ServiceResponseRegisterPrefix registerValidRequest(ServiceRequestRegisterPrefix request, ServiceResponseRegisterPrefix response) {
        // TODO
        return response;
    }

    private ServiceResponseRegisterPrefix cacheValidRequest(ServiceRequestRegisterPrefix request, ServiceResponseRegisterPrefix response) {
        // TODO
    }

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
            // Use a registration agent to push the request further
            try {
                prefixRegistrationAgent.registerPrefix(request.getPayload());
            } catch (PrefixRegistrationAgentException e) {
                response.setErrorMessage(e.getMessage());
                response.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return response;
    }

}
