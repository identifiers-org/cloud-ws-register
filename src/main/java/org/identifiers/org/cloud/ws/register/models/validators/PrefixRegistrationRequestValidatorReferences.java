package org.identifiers.org.cloud.ws.register.models.validators;

import org.identifiers.org.cloud.ws.register.models.api.requests.RegisterApiRequestRegisterPrefix;
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
        logger.info("References validation policy is VALID by default");
        if (request.getReferences() == null) {
            logger.info("No references have been provided");
        } else {
            logger.info(String.format("#%d Reference entries have been provided", request.getReferences().length));
        }
        return true;
    }
}
