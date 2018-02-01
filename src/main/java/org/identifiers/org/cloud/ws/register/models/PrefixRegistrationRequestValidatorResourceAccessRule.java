package org.identifiers.org.cloud.ws.register.models;

import org.springframework.util.StringUtils;

/**
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * Project: register
 * Package: org.identifiers.org.cloud.ws.register.models
 * Timestamp: 2018-02-01 12:21
 * ---
 */
public class PrefixRegistrationRequestValidatorResourceAccessRule implements PrefixRegistrationRequestValidator {
    private static String PLACEHOLDER_ID = "{$id}";

    @Override
    public boolean validate(RegisterApiRequestRegisterPrefix request) throws PrefixRegistrationRequestValidatorException {
        // TODO
        if (request.getResourceAccessRule() == null) {
            throw new PrefixRegistrationRequestValidatorException("MISSING required Resource Access Rule");
        }
        WebPageChecker webPageChecker = WebPageCheckerFactory.getWebPageChecker();
        // TODO - Check that PLACEHOLDER_ID is uniquely present
        if (StringUtils.countOccurrencesOf(request.getResourceAccessRule(), PLACEHOLDER_ID) != 1) {
            throw new PrefixRegistrationRequestValidatorException(String.format("ID placeholder '%s' IS REQUIRED to be present at least once in the resource access rule", PLACEHOLDER_ID));
        }
        String urlToCheck = StringUtils.replace(request.getResourceAccessRule(), PLACEHOLDER_ID, "placeholderId");
        // TODO - Remove the PLACEHOLDER_ID from thr URL for standalone checking
        if (!webPageChecker.checkForValidUrl(urlToCheck)) {
            throw new PrefixRegistrationRequestValidatorException(String.format("INVALID resource access rule '%s'", request.getResourceAccessRule()));
        }
        return true;
    }
}
