package org.identifiers.org.cloud.ws.register.models;

/**
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * Project: register
 * Package: org.identifiers.org.cloud.ws.register.models
 * Timestamp: 2018-02-01 12:21
 * ---
 */
public class PrefixRegistrationRequestValidatorResourceAccessRule implements PrefixRegistrationRequestValidator {
    private static String PLACEHOLDER_ID = "{$id}";

    @Override
    public boolean validate(RegisterApiRequestRegisterPrefix request) throws PrefixRegistrationRequestValidatorException {
        // TODO
        if (request.getResourceAccessRule() == null) {
            throw new PrefixRegistrationRequestValidatorException("MISSING required Resource Access Rule");
        }
        return true;
    }
}
