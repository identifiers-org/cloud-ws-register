package org.identifiers.org.cloud.ws.register.models;

import org.identifiers.org.cloud.ws.register.models.api.requests.RegisterApiRequestRegisterPrefix;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
        // Get all the validation errors
        List<String> errors = getValidationChain()
                .parallelStream()
                .map(validator -> {
                    try {
                        validator.validate(request);
                    } catch (PrefixRegistrationRequestValidatorException e) {
                        return e.getMessage();
                    }
                    return null;
                })
                .collect(Collectors.toList())
                .stream()
                .filter(Objects::nonNull).collect(Collectors.toList());
        if (!errors.isEmpty()) {
            // Report the errors
            throw new PrefixRegistrationRequestValidatorException(String.join("\n", errors));
        }
        return true;
    }
}
