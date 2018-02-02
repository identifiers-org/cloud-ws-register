package org.identifiers.org.cloud.ws.register.models;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * Project: register
 * Package: org.identifiers.org.cloud.ws.register.models
 * Timestamp: 2018-02-02 9:50
 * ---
 */
public class PrefixRegistrationRequestValidatorCrossedExampleIdentifierResourceAccessRule implements PrefixRegistrationRequestValidator {
    @Override
    public boolean validate(RegisterApiRequestRegisterPrefix request) throws PrefixRegistrationRequestValidatorException {
        List<String> errors = new ArrayList<>();
        // Check resource access rule
        try {
            new PrefixRegistrationRequestValidatorResourceAccessRule().validate(request);
        } catch (PrefixRegistrationRequestValidatorException e) {
            errors.add(e.getMessage());
        }
        return true;
    }
}
