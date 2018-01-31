package org.identifiers.org.cloud.ws.register.models;

import org.apache.commons.validator.routines.UrlValidator;

/**
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * Project: register
 * Package: org.identifiers.org.cloud.ws.register.models
 * Timestamp: 2018-01-31 12:26
 * ---
 */
public class WebPageCheckerDefault implements WebPageChecker {
    @Override
    public boolean checkWebPageUrl(String webPageUrl) throws WebPageCheckerException {
        // TODO
        // Check for invalid URL
        if (!(new UrlValidator()).isValid(webPageUrl)) {
            throw new WebPageCheckerException(String.format("Home Page URL '%s' is NOT VALID", webPageUrl));
        }
        return true;
    }
}
