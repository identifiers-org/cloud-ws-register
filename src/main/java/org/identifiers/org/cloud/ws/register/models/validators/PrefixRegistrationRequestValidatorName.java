package org.identifiers.org.cloud.ws.register.models.validators;

import org.identifiers.org.cloud.ws.register.api.requests.prefixregistration.ServiceRequestRegisterPrefixPayload;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * Project: register
 * Package: org.identifiers.org.cloud.ws.register.models
 * Timestamp: 2018-01-30 22:00
 * ---
 */
// TODO - It is ok right now to leave this annotations here, as the validator doesn't use any properties and such, but
// TODO - if these annotations are here to stay, then I should modify the validation strategies later on to not instantiate these components themselves but autowire them or get them injected via constructor
@Component
@Scope("prototype")
@Qualifier("prefixRegistrationRequestValidatorName")
public class PrefixRegistrationRequestValidatorName implements PrefixRegistrationRequestValidator {
    @Override
    public boolean validate(ServiceRequestRegisterPrefixPayload request) throws PrefixRegistrationRequestValidatorException {
        if (request.getName() == null) {
            throw new PrefixRegistrationRequestValidatorException("'Name' attribute must be provided");
        }
        return true;
    }
}
