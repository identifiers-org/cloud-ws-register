package org.identifiers.org.cloud.ws.register.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * Project: register
 * Package: org.identifiers.org.cloud.ws.register.models
 * Timestamp: 2018-02-02 12:36
 * ---
 */
public class PrefixRegistrationRequestValidatorReferences implements PrefixRegistrationRequestValidator {
    private static Logger logger = LoggerFactory.getLogger(PrefixRegistrationRequestValidatorReferences.class);
    
    @Override
    public boolean validate(RegisterApiRequestRegisterPrefix request) throws PrefixRegistrationRequestValidatorException {
        // References are not enforced, so they just validate
        return true;
    }
}
