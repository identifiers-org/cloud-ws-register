package org.identifiers.org.cloud.ws.register.models;

import org.identifiers.org.cloud.ws.register.models.api.requests.validation.ServiceRequestValidate;
import org.identifiers.org.cloud.ws.register.models.api.responses.ServiceResponse;
import org.identifiers.org.cloud.ws.register.models.api.responses.prefixregistration.ServiceResponseRegisterPrefixPayload;
import org.identifiers.org.cloud.ws.register.models.api.responses.validation.ServiceResponseValidateRequest;
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
    @Qualifier("prefixRegistrationRequestValidatorPreferredPrefix")
    private PrefixRegistrationRequestValidator prefixValidator;

    @Autowired
    @Qualifier("prefixRegistrationRequestValidatorName")
    private PrefixRegistrationRequestValidator nameValidator;

    @Autowired
    @Qualifier("prefixRegistrationRequestValidatorDescription")
    private PrefixRegistrationRequestValidator descriptionValidator;

    @Autowired
    @Qualifier("prefixRegistrationRequestValidatorHomePage")
    private PrefixRegistrationRequestValidator homePageValidator;

    @Autowired
    @Qualifier("prefixRegistrationRequestValidatorOrganization")
    private PrefixRegistrationRequestValidator organizationValidator;

    @Autowired
    @Qualifier("prefixRegistrationRequestValidatorResourceAccessRule")
    private PrefixRegistrationRequestValidator resourceAccessRuleValidator;

    @Autowired
    @Qualifier("prefixRegistrationRequestValidatorCrossedExampleIdentifierResourceAccessRule")
    private PrefixRegistrationRequestValidator crossedExampleIdentifierResourceAccessRuleValidator;

    @Autowired
    @Qualifier("prefixRegistrationRequestValidatorCrossedRegexPatternAndExampleIdentifier")
    private PrefixRegistrationRequestValidator crossedRegexPatternAndExampleIdentifierValidator;

    @Autowired
    @Qualifier("prefixRegistrationRequestValidatorReferences")
    private PrefixRegistrationRequestValidator referencesValidator;

    @Autowired
    @Qualifier("prefixRegistrationRequestValidatorAdditionalInformation")
    private PrefixRegistrationRequestValidator additionalInformationValidator;

    @Autowired
    @Qualifier("prefixRegistrationRequestValidatorRequester")
    private PrefixRegistrationRequestValidator requesterValidator;

    private <T> void initDefaultResponse(ServiceResponse<T> response, T payload) {
        response.setApiVersion(apiVersion)
                .setHttpStatus(HttpStatus.OK);
        response.setPayload(payload);
    }

    private ServiceResponseValidateRequest doValidation(ServiceRequestValidate request,
                                                        PrefixRegistrationRequestValidator validator) {
        ServiceResponseValidateRequest response = new ServiceResponseValidateRequest();
        initDefaultResponse(response, new ServiceResponseRegisterPrefixPayload());
        // Validate the request
        boolean isValidRequest = false;
        try {
            isValidRequest = validator.validate(request.getPayload());
        } catch (PrefixRegistrationRequestValidatorException e) {
            response.setErrorMessage(e.getMessage());
            response.setHttpStatus(HttpStatus.BAD_REQUEST);
            response.getPayload().setComment("VALIDATION FAILED");
        }
        if (isValidRequest) {
            response.getPayload().setComment("VALIDATION OK");
        }
        return response;
    }

    // --- API ---

    public ServiceResponseValidateRequest validateRegisterPrefixName(ServiceRequestValidate request) {
        // TODO - Check API version information?
        return doValidation(request, nameValidator);
    }

    public ServiceResponseValidateRequest validateRegisterPrefixDescription(ServiceRequestValidate request) {
        // TODO - Check API version information?
        return doValidation(request, descriptionValidator);
    }
}
