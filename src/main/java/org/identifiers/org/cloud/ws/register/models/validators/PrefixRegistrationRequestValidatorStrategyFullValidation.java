package org.identifiers.org.cloud.ws.register.models.validators;

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
public class PrefixRegistrationRequestValidatorStrategyFullValidation implements PrefixRegistrationRequestValidatorStrategy {

    @Autowired
    private PrefixRegistrationRequestValidatorPreferredPrefix prefixValidator;

    @Autowired
    @Qualifier("prefixRegistrationRequestValidatorName")
    private PrefixRegistrationRequestValidator nameValidator;

    @Override
    public List<PrefixRegistrationRequestValidator> getValidationChain() {
        return Arrays.asList(
                nameValidator,
                new PrefixRegistrationRequestValidatorDescription(),
                new PrefixRegistrationRequestValidatorHomePage(),
                new PrefixRegistrationRequestValidatorOrganization(),
                prefixValidator,
                new PrefixRegistrationRequestValidatorResourceAccessRule(),
                new PrefixRegistrationRequestValidatorCrossedExampleIdentifierResourceAccessRule(),
                new PrefixRegistrationRequestValidatorCrossedRegexPatternAndExampleIdentifier(),
                new PrefixRegistrationRequestValidatorReferences(),
                new PrefixRegistrationRequestValidatorAdditionalInformation(),
                new PrefixRegistrationRequestValidatorRequester()
        );
    }
}
