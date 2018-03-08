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
    @Qualifier("prefixRegistrationRequestValidatorPreferredPrefix")
    private PrefixRegistrationRequestValidator prefixValidator;

    @Autowired
    @Qualifier("prefixRegistrationRequestValidatorName")
    private PrefixRegistrationRequestValidator nameValidator;

    @Autowired
    @Qualifier("prefixRegistrationRequestValidatorDescription")
    private PrefixRegistrationRequestValidator descriptionValidator;

    @Autowired
    @Qualifier("prefixRegistrationRequestValidatorHomePage")
    private PrefixRegistrationRequestValidator homePageValidator;

    @Autowired
    @Qualifier("prefixRegistrationRequestValidatorOrganization")
    private PrefixRegistrationRequestValidator organizationValidator;

    @Autowired
    @Qualifier("prefixRegistrationRequestValidatorResourceAccessRule")
    private PrefixRegistrationRequestValidator resourceAccessRuleValidator;

    @Autowired
    @Qualifier("prefixRegistrationRequestValidatorCrossedExampleIdentifierResourceAccessRule")
    private PrefixRegistrationRequestValidator crossedExampleIdentifierResourceAccessRuleValidator;

    @Autowired
    @Qualifier("prefixRegistrationRequestValidatorCrossedRegexPatternAndExampleIdentifier")
    private PrefixRegistrationRequestValidator crossedRegexPatternAndExampleIdentifierValidator;

    @Autowired
    @Qualifier("prefixRegistrationRequestValidatorReferences")
    private PrefixRegistrationRequestValidator referencesValidator;

    @Autowired
    @Qualifier("prefixRegistrationRequestValidatorAdditionalInformation")
    private PrefixRegistrationRequestValidator additionalInformationValidator;

    @Autowired
    @Qualifier("prefixRegistrationRequestValidatorRequester")
    private PrefixRegistrationRequestValidator requesterValidator;

    @Override
    public List<PrefixRegistrationRequestValidator> getValidationChain() {
        return Arrays.asList(
                nameValidator,
                descriptionValidator,
                homePageValidator,
                organizationValidator,
                prefixValidator,
                resourceAccessRuleValidator,
                crossedExampleIdentifierResourceAccessRuleValidator,
                crossedRegexPatternAndExampleIdentifierValidator,
                referencesValidator,
                additionalInformationValidator,
                requesterValidator
        );
    }
}
