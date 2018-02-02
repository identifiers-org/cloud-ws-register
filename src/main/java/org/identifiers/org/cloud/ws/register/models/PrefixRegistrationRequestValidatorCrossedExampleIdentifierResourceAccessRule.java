package org.identifiers.org.cloud.ws.register.models;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * Project: register
 * Package: org.identifiers.org.cloud.ws.register.models
 * Timestamp: 2018-02-02 9:50
 * ---
 */
public class PrefixRegistrationRequestValidatorCrossedExampleIdentifierResourceAccessRule implements PrefixRegistrationRequestValidator {
    @Override
    public boolean validate(RegisterApiRequestRegisterPrefix request) throws PrefixRegistrationRequestValidatorException {
        List<String> errors = new ArrayList<>();
        // Check resource access rule
        try {
            new PrefixRegistrationRequestValidatorResourceAccessRule().validate(request);
        } catch (PrefixRegistrationRequestValidatorException e) {
            errors.add(e.getMessage());
        }
        // Check example identifier
        try {
            new PrefixRegistrationRequestValidatorExampleIdentifier().validate(request);
        } catch (PrefixRegistrationRequestValidatorException e) {
            errors.add(e.getMessage());
        }
        // If any error, report back
        if (!errors.isEmpty()) {
            throw new PrefixRegistrationRequestValidatorException(String.join("\n", errors));
        }
        // Cross-validate example identifier
        try {
            WebPageCheckerFactory.getWebPageChecker().checkWebPageUrl(ResourceAccessHelper.getResourceUrlFor(request.getResourceAccessRule(), request.getExampleIdentifier()));
        } catch (WebPageCheckerException e) {
            throw new PrefixRegistrationRequestValidatorException(
                    String.format("The provided Resource Access Rule '%s' " +
                            "combined with the provided Example Identifier '%s' " +
                            "into '%s' DOES NOT VALIDATE", request.getResourceAccessRule(),
                            request.getExampleIdentifier(),
                            ResourceAccessHelper.getResourceUrlFor(request.getResourceAccessRule(),
                                    request.getExampleIdentifier())));
        }
        return true;
    }
}
