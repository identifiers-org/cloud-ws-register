package org.identifiers.org.cloud.ws.register.models;

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
        return false;
    }
}
