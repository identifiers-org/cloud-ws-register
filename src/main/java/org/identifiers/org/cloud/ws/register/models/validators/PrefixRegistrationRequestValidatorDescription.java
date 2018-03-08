package org.identifiers.org.cloud.ws.register.models.validators;

import org.identifiers.org.cloud.ws.register.models.api.requests.prefixregistration.ServiceRequestRegisterPrefixPayload;

/**
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * Project: register
 * Package: org.identifiers.org.cloud.ws.register.models
 * Timestamp: 2018-01-31 10:26
 * ---
 */
public class PrefixRegistrationRequestValidatorDescription implements PrefixRegistrationRequestValidator {
    public static final int DESCRIPTION_CONTENT_MIN_CHARS = 50;

    @Override
    public boolean validate(ServiceRequestRegisterPrefixPayload request) throws PrefixRegistrationRequestValidatorException {
        if ((request.getDescription() == null) || (request.getDescription().length() < DESCRIPTION_CONTENT_MIN_CHARS)) {
            throw new PrefixRegistrationRequestValidatorException(String.format("Prefix request description must be provided and be longer than %d characters", DESCRIPTION_CONTENT_MIN_CHARS));
        }
        return true;
    }
}
