package org.identifiers.org.cloud.ws.register.models;

/**
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * Project: register
 * Package: org.identifiers.org.cloud.ws.register.models
 * Timestamp: 2018-01-30 22:00
 * ---
 */
public class PrefixRegistrationRequestValidatorName implements PrefixRegistrationRequestValidator {
    @Override
    public boolean validate(RegisterApiRequestRegisterPrefix request) throws PrefixRegistrationRequestValidatorException {
        return request.getName() != null;
    }
}
