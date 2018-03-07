package org.identifiers.org.cloud.ws.register.models.validators;

import org.identifiers.org.cloud.ws.register.models.api.requests.RegisterApiRequestRegisterPrefix;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * Project: register
 * Package: org.identifiers.org.cloud.ws.register.models
 * Timestamp: 2018-02-02 10:58
 * ---
 */
public class PrefixRegistrationRequestValidatorCrossedRegexPatternAndExampleIdentifier implements PrefixRegistrationRequestValidator {
    private static Logger logger = LoggerFactory.getLogger(PrefixRegistrationRequestValidatorCrossedRegexPatternAndExampleIdentifier.class);

    @Override
    public boolean validate(RegisterApiRequestRegisterPrefix request) throws PrefixRegistrationRequestValidatorException {
        List<String> errors = new ArrayList<>();
        // Check Example Identifier
        try {
            new PrefixRegistrationRequestValidatorExampleIdentifier().validate(request);
        } catch (PrefixRegistrationRequestValidatorException e) {
            errors.add(e.getMessage());
        }
        // Check Regex Pattern
        try {
            new PrefixRegistrationRequestValidatorRegexPattern().validate(request);
        } catch (PrefixRegistrationRequestValidatorException e) {
            errors.add(e.getMessage());
        }
        // Report errors if any
        if (!errors.isEmpty()) {
            throw new PrefixRegistrationRequestValidatorException(String.join("\n", errors));
        }
        // Cross-validation
        logger.debug("Validating regex pattern '{}' against '{}'", request.getRegexPattern(), request.getExampleIdentifier());
        Pattern pattern = Pattern.compile(request.getRegexPattern());
        Matcher matcher = pattern.matcher(request.getExampleIdentifier());
        if (!matcher.matches()) {
            throw new PrefixRegistrationRequestValidatorException(String.format("There is a MISMATCH between the provided Example Identifier '%s' and the provided Regular Expression Pattern '%s'", request.getExampleIdentifier(), request.getRegexPattern()));
        }
        return true;
    }
}
