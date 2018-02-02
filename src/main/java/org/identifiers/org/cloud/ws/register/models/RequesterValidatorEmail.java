package org.identifiers.org.cloud.ws.register.models;

import org.apache.commons.validator.routines.EmailValidator;

/**
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * Project: register
 * Package: org.identifiers.org.cloud.ws.register.models
 * Timestamp: 2018-02-02 14:01
 * ---
 */
public class RequesterValidatorEmail implements RequesterValidator {
    @Override
    public boolean validate(Requester requester) throws RequesterValidatorException {
        if (requester.getEmail() == null) {
            throw new RequesterValidatorException("MISSING REQUIRED Requester e-mail address");
        }
        if (!EmailValidator.getInstance().isValid(requester.getEmail())) {
            throw new RequesterValidatorException(String.format("The provided Requester e-mail address '%s' IS NOT VALID", requester.getEmail()));
        }
        return true;
    }
}
