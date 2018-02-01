package org.identifiers.org.cloud.ws.register.models;

import java.util.Arrays;
import java.util.List;

/**
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * Project: register
 * Package: org.identifiers.org.cloud.ws.register.models
 * Timestamp: 2018-01-30 22:34
 * ---
 */
public class PrefixRegistrationRequestValidatorStrategyFullValidation implements PrefixRegistrationRequestValidatorStrategy {

    private PrefixRegistrationRequestValidatorPreferredPrefix prefixValidator;

    // This is for dependency injection via constructor
    public PrefixRegistrationRequestValidatorStrategyFullValidation(PrefixRegistrationRequestValidatorPreferredPrefix prefixValidator) {
        this.prefixValidator = prefixValidator;
    }

    @Override
    public List<PrefixRegistrationRequestValidator> getValidationChain() {
        return Arrays.asList(
                new PrefixRegistrationRequestValidatorName(),
                new PrefixRegistrationRequestValidatorDescription(),
                new PrefixRegistrationRequestValidatorHomePage(),
                new PrefixRegistrationRequestValidatorOrganization(),
                prefixValidator
        );
    }
}
