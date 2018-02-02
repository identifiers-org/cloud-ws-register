package org.identifiers.org.cloud.ws.register.models;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * Project: register
 * Package: org.identifiers.org.cloud.ws.register.models
 * Timestamp: 2018-02-02 10:58
 * ---
 */
public class PrefixRegistrationRequestValidatorCrossedRegexPatternAndExampleIdentifier implements PrefixRegistrationRequestValidator {
    @Override
    public boolean validate(RegisterApiRequestRegisterPrefix request) throws PrefixRegistrationRequestValidatorException {
        List<String> errors = new ArrayList<>();
        // Check Example Identifier
        try {
            new PrefixRegistrationRequestValidatorExampleIdentifier().validate(request);
        } catch (PrefixRegistrationRequestValidatorException e) {
            errors.add(e.getMessage());
        }
        // Check Regex Pattern
        try {
            new PrefixRegistrationRequestValidatorRegexPattern().validate(request);
        } catch (PrefixRegistrationRequestValidatorException e) {
            errors.add(e.getMessage());
        }
        return true;
    }
}
