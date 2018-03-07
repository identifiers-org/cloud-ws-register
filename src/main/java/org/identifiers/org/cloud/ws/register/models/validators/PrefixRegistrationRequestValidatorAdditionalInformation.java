package org.identifiers.org.cloud.ws.register.models.validators;

import org.identifiers.org.cloud.ws.register.models.api.requests.RegisterApiRequestRegisterPrefix;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * Project: register
 * Package: org.identifiers.org.cloud.ws.register.models
 * Timestamp: 2018-02-02 12:55
 * ---
 */
public class PrefixRegistrationRequestValidatorAdditionalInformation implements PrefixRegistrationRequestValidator {
    private static Logger logger = LoggerFactory.getLogger(PrefixRegistrationRequestValidatorAdditionalInformation.class);

    @Override
    public boolean validate(RegisterApiRequestRegisterPrefix request) throws PrefixRegistrationRequestValidatorException {
        // Validate by default, no requirements are enforced
        logger.info("DEFAULT policy for Additional Information is ALWAYS VALID");
        if (request.getAdditionalInformation() == null) {
            logger.info("NO Additional Information has been provided");
        }
        return true;
    }
}
