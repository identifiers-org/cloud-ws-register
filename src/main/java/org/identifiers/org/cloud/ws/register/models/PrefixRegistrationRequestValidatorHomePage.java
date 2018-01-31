package org.identifiers.org.cloud.ws.register.models;

import org.apache.commons.validator.routines.UrlValidator;

/**
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * Project: register
 * Package: org.identifiers.org.cloud.ws.register.models
 * Timestamp: 2018-01-31 10:52
 * ---
 */
public class PrefixRegistrationRequestValidatorHomePage implements PrefixRegistrationRequestValidator {
    @Override
    public boolean validate(RegisterApiRequestRegisterPrefix request) throws PrefixRegistrationRequestValidatorException {
        // Home Page URL for the resource is required
        if (request.getHomePage() == null) {
            throw new PrefixRegistrationRequestValidatorException("MISSING URL describing the resource");
        }
        // Check for invalid URL
        if (!(new UrlValidator()).isValid(request.getHomePage())) {
            throw new PrefixRegistrationRequestValidatorException(String.format("Home Page URL '%s' is NOT VALID", request.getHomePage()));
        }
        return true;
    }
}
