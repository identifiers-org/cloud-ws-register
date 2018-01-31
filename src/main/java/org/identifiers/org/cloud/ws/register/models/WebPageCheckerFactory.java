package org.identifiers.org.cloud.ws.register.models;

/**
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * Project: register
 * Package: org.identifiers.org.cloud.ws.register.models
 * Timestamp: 2018-01-31 12:55
 * ---
 */
public class WebPageCheckerFactory {
    public static WebPageChecker getWebPageChecker() {
        return new WebPageCheckerDefault();
    }
}
