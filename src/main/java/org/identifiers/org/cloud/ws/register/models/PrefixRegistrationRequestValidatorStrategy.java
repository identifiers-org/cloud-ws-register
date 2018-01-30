package org.identifiers.org.cloud.ws.register.models;

import java.util.ArrayList;
import java.util.List;

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
        // TODO
        return false;
    }
}
