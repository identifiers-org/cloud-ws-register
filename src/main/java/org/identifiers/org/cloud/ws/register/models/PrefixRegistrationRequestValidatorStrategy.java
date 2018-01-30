package org.identifiers.org.cloud.ws.register.models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * Project: register
 * Package: org.identifiers.org.cloud.ws.register.models
 * Timestamp: 2018-01-30 22:14
 * ---
 */
public interface PrefixRegistrationRequestValidatorStrategy extends PrefixRegistrationRequestValidator {
    default List<PrefixRegistrationRequestValidator> getValidationChain() {
        return new ArrayList<>();
    }

    @Override
    default boolean validate(RegisterApiRequestRegisterPrefix request) throws PrefixRegistrationRequestValidatorException {
        // List of errors for reporting to the client
        List<String> errors = new ArrayList<>();
        // Get all the validation errors
        errors = getValidationChain()
                .parallelStream()
                .map(validator -> {
                    try {
                        validate(request);
                    } catch (PrefixRegistrationRequestValidatorException e) {
                        return e.getMessage();
                    }
                    return null;
                })
                .collect(Collectors.toList())
                .stream()
                .filter(item -> item != null).collect(Collectors.toList());
        if (!errors.isEmpty()) {
            // Report the errors
            throw new PrefixRegistrationRequestValidatorException(String.join("\n", errors));
        }
        return true;
    }
}
