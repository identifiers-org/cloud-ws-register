package org.identifiers.org.cloud.ws.register.models;

/**
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * Project: register
 * Package: org.identifiers.org.cloud.ws.register.models
 * Timestamp: 2018-01-31 14:20
 * ---
 */
public class PrefixRegistrationRequestValidatorOrganization implements PrefixRegistrationRequestValidator {
    @Override
    public boolean validate(RegisterApiRequestRegisterPrefix request) throws PrefixRegistrationRequestValidatorException {
        if (request.getOrganization() == null) {
            throw new PrefixRegistrationRequestValidatorException("The name of the providing organization is MISSING");
        }
        return true;
    }
}
