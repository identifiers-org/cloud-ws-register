package org.identifiers.org.cloud.ws.register.models.validators;

import org.identifiers.org.cloud.ws.register.models.ResourceAccessHelper;
import org.identifiers.org.cloud.ws.register.models.WebPageChecker;
import org.identifiers.org.cloud.ws.register.models.WebPageCheckerFactory;
import org.identifiers.org.cloud.ws.register.api.requests.prefixregistration.ServiceRequestRegisterPrefixPayload;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * Project: register
 * Package: org.identifiers.org.cloud.ws.register.models
 * Timestamp: 2018-02-01 12:21
 * ---
 */
@Component
@Scope("prototype")
@Qualifier("prefixRegistrationRequestValidatorResourceAccessRule")
public class PrefixRegistrationRequestValidatorResourceAccessRule implements PrefixRegistrationRequestValidator {
    @Override
    public boolean validate(ServiceRequestRegisterPrefixPayload request) throws PrefixRegistrationRequestValidatorException {
        // TODO
        if (request.getResourceAccessRule() == null) {
            throw new PrefixRegistrationRequestValidatorException("MISSING required Resource Access Rule");
        }
        // Check that PLACEHOLDER_ID is uniquely present
        if (StringUtils.countOccurrencesOf(request.getResourceAccessRule(), ResourceAccessHelper.RESOURCE_ACCESS_RULE_PLACEHOLDER_ID) != 1) {
            throw new PrefixRegistrationRequestValidatorException(String.format("ID placeholder '%s' IS REQUIRED to be present at least once in the resource access rule", ResourceAccessHelper.RESOURCE_ACCESS_RULE_PLACEHOLDER_ID));
        }
        WebPageChecker webPageChecker = WebPageCheckerFactory.getWebPageChecker();
        String urlToCheck = StringUtils.replace(request.getResourceAccessRule(), ResourceAccessHelper.RESOURCE_ACCESS_RULE_PLACEHOLDER_ID, "placeholderId");
        // Remove the PLACEHOLDER_ID from thr URL for standalone checking
        if (!webPageChecker.checkForValidUrl(urlToCheck)) {
            throw new PrefixRegistrationRequestValidatorException(String.format("INVALID resource access rule '%s'", request.getResourceAccessRule()));
        }
        return true;
    }
}
