package org.identifiers.org.cloud.ws.register.models.validators;

/**
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * Project: register
 * Package: org.identifiers.org.cloud.ws.register.models
 * Timestamp: 2018-02-02 14:34
 * ---
 */
public class RequesterValidatorFactory {
    public static RequesterValidator getDefaultValidator() {
        return new RequesterValidatorFullValidator();
    }
}
