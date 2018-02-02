package org.identifiers.org.cloud.ws.register.models;

/**
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * Project: register
 * Package: org.identifiers.org.cloud.ws.register.models
 * Timestamp: 2018-02-02 13:06
 * ---
 */
public class PrefixRegistrationRequestValidatorRequester implements PrefixRegistrationRequestValidator {
    @Override
    public boolean validate(RegisterApiRequestRegisterPrefix request) throws PrefixRegistrationRequestValidatorException {
        if (request.getRequester() == null) {
            throw new PrefixRegistrationRequestValidatorException("MISSING REQUIRED Requester information");
        }
        // Delegate validation to specialized validator
        try {
            RequesterValidatorFactory.getDefaultValidator().validate(request.getRequester());
        } catch (RequesterValidatorException e) {
            throw new PrefixRegistrationRequestValidatorException(e.getMessage());
        }
        return true;
    }
}
