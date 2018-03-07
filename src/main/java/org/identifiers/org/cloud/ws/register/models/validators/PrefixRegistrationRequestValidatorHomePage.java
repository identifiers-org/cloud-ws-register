package org.identifiers.org.cloud.ws.register.models.validators;

import org.identifiers.org.cloud.ws.register.models.WebPageChecker;
import org.identifiers.org.cloud.ws.register.models.WebPageCheckerException;
import org.identifiers.org.cloud.ws.register.models.WebPageCheckerFactory;
import org.identifiers.org.cloud.ws.register.models.api.requests.RegisterApiRequestRegisterPrefix;

/**
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * Project: register
 * Package: org.identifiers.org.cloud.ws.register.models
 * Timestamp: 2018-01-31 10:52
 * ---
 */
public class PrefixRegistrationRequestValidatorHomePage implements PrefixRegistrationRequestValidator {

    private WebPageChecker webPageChecker = WebPageCheckerFactory.getWebPageChecker();

    @Override
    public boolean validate(RegisterApiRequestRegisterPrefix request) throws PrefixRegistrationRequestValidatorException {
        // TODO - Refactor this code out as a URL checker
        // Home Page URL for the resource is required
        if (request.getHomePage() == null) {
            throw new PrefixRegistrationRequestValidatorException("MISSING URL describing the resource");
        }
        boolean valid = true;
        try {
            valid = webPageChecker.checkWebPageUrl(request.getHomePage());
        } catch (WebPageCheckerException e) {
            throw new PrefixRegistrationRequestValidatorException(e.getMessage());
        }
        return valid;
    }
}
