package org.identifiers.org.cloud.ws.register.models.validators;

import org.identifiers.org.cloud.ws.register.models.api.requests.prefixregistration.ServiceRequestRegisterPrefixPayload;

/**
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * Project: register
 * Package: org.identifiers.org.cloud.ws.register.models
 * Timestamp: 2018-01-30 21:09
 * ---
 */
public interface PrefixRegistrationRequestValidator {
    // Well, this default implementation doesn't really bring anything on the table but semantic sugar
    default boolean validate(ServiceRequestRegisterPrefixPayload request) throws PrefixRegistrationRequestValidatorException {
        return false;
    }
}
