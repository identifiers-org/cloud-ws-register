package org.identifiers.org.cloud.ws.register.models;

import org.identifiers.org.cloud.ws.register.models.api.requests.validation.ServiceRequestValidateRegisterPrefixName;
import org.identifiers.org.cloud.ws.register.models.api.responses.ServiceResponse;
import org.identifiers.org.cloud.ws.register.models.api.responses.prefixregistration.ServiceResponseRegisterPrefixPayload;
import org.identifiers.org.cloud.ws.register.models.api.responses.validation.ServiceResponseValidateRegisterPrefixName;
import org.identifiers.org.cloud.ws.register.models.validators.PrefixRegistrationRequestValidator;
import org.identifiers.org.cloud.ws.register.models.validators.PrefixRegistrationRequestValidatorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * Project: register
 * Package: org.identifiers.org.cloud.ws.register.models
 * Timestamp: 2018-03-08 6:15
 * ---
 */
@Component
@Scope("prototype")
public class ValidationApiModel {
    public static final String apiVersion = "1.0";
    private static Logger logger = LoggerFactory.getLogger(ValidationApiModel.class);

    @Autowired
    @Qualifier("prefixRegistrationRequestValidatorName")
    private PrefixRegistrationRequestValidator nameValidator;

    private <T> void initDefaultResponse(ServiceResponse<T> response, T payload) {
        response.setApiVersion(apiVersion)
                .setHttpStatus(HttpStatus.OK);
        response.setPayload(payload);
    }

    public ServiceResponseValidateRegisterPrefixName validateRegisterPrefixName(ServiceRequestValidateRegisterPrefixName request) {
        // TODO - Check API version information?
        ServiceResponseValidateRegisterPrefixName response = new ServiceResponseValidateRegisterPrefixName();
        initDefaultResponse(response, new ServiceResponseRegisterPrefixPayload());
        // Validate the request
        boolean isValidRequest = false;
        try {
            isValidRequest = nameValidator.validate(request.getPayload());
        } catch (PrefixRegistrationRequestValidatorException e) {
            response.setErrorMessage(e.getMessage());
            response.setHttpStatus(HttpStatus.BAD_REQUEST);
        }
        if (isValidRequest) {
            response.getPayload().setComment("VALIDATION OK");
        }
        return response;
    }
}
