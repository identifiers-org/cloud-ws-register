package org.identifiers.org.cloud.ws.register.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * Project: register
 * Package: org.identifiers.org.cloud.ws.register.models
 * Timestamp: 2018-01-30 22:34
 * ---
 */
@Component
@Scope("prototype")
@Qualifier("PrefixRegistrationRequestValidatorStrategyFullValidation")
public class PrefixRegistrationRequestValidatorStrategyFullValidation implements PrefixRegistrationRequestValidatorStrategy {

    @Autowired
    private PrefixRegistrationRequestValidatorPreferredPrefix prefixValidator;

    @Override
    public List<PrefixRegistrationRequestValidator> getValidationChain() {
        return Arrays.asList(
                new PrefixRegistrationRequestValidatorName(),
                new PrefixRegistrationRequestValidatorDescription(),
                new PrefixRegistrationRequestValidatorHomePage(),
                new PrefixRegistrationRequestValidatorOrganization(),
                prefixValidator,
                new PrefixRegistrationRequestValidatorResourceAccessRule(),
                new PrefixRegistrationRequestValidatorCrossedExampleIdentifierResourceAccessRule(),
                new PrefixRegistrationRequestValidatorCrossedRegexPatternAndExampleIdentifier(),
                new PrefixRegistrationRequestValidatorReferences(),
                new PrefixRegistrationRequestValidatorAdditionalInformation()
        );
    }
}
