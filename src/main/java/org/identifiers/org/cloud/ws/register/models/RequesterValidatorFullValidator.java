package org.identifiers.org.cloud.ws.register.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * Project: register
 * Package: org.identifiers.org.cloud.ws.register.models
 * Timestamp: 2018-02-02 14:19
 * ---
 */
public class RequesterValidatorFullValidator implements RequesterValidator {
    @Override
    public boolean validate(Requester requester) throws RequesterValidatorException {
        List<String> errors = new ArrayList<>();
        List<RequesterValidator> validators = Arrays.asList(new RequesterValidatorEmail(), new RequesterValidatorName());
        // Iterate over the validators
        for (RequesterValidator validator :
                validators) {
            try {
                validator.validate(requester);
            } catch (RequesterValidatorException e) {
                errors.add(e.getMessage());
            }
        }
        // Report errors if any
        if (!errors.isEmpty()) {
            throw new RequesterValidatorException(String.join("\n", errors));
        }
        return false;
    }
}
