package org.identifiers.org.cloud.ws.register.models;

/**
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * Project: register
 * Package: org.identifiers.org.cloud.ws.register.models
 * Timestamp: 2018-01-30 21:09
 * ---
 */
public interface PrefixRegistrationRequestValidator {
    boolean validate(RegisterApiRequestRegisterPrefix request) throws PrefixRegistrationRequestValidatorException;
}
