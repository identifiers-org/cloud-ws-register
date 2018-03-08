package org.identifiers.org.cloud.ws.register.models.validators;

import org.identifiers.org.cloud.ws.register.models.api.requests.ServiceRequestRegisterPrefixPayload;

/**
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * Project: register
 * Package: org.identifiers.org.cloud.ws.register.models
 * Timestamp: 2018-02-01 14:51
 * ---
 */
public class PrefixRegistrationRequestValidatorExampleIdentifier implements PrefixRegistrationRequestValidator {
    @Override
    public boolean validate(ServiceRequestRegisterPrefixPayload request) throws PrefixRegistrationRequestValidatorException {
        // Check the ID information is present
        if (request.getExampleIdentifier() == null) {
            throw new PrefixRegistrationRequestValidatorException("MISSING REQUIRED Example Identifier");
        }
        return true;
    }
}
