package org.identifiers.org.cloud.ws.register.models;

import java.util.List;

/**
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * Project: register
 * Package: org.identifiers.org.cloud.ws.register.models
 * Timestamp: 2018-01-30 22:34
 * ---
 */
public class PrefixRegistrationRequestValidatorStrategyFullValidation implements PrefixRegistrationRequestValidatorStrategy {
    @Override
    public List<PrefixRegistrationRequestValidator> getValidationChain() {
        return null;
    }
}
