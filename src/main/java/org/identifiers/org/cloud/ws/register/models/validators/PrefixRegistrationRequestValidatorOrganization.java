package org.identifiers.org.cloud.ws.register.models.validators;

import org.identifiers.org.cloud.ws.register.models.api.requests.RegisterApiRequestRegisterPrefix;

/**
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * Project: register
 * Package: org.identifiers.org.cloud.ws.register.models
 * Timestamp: 2018-01-31 14:20
 * ---
 */
public class PrefixRegistrationRequestValidatorOrganization implements PrefixRegistrationRequestValidator {
    // Up to this point, a developer may be wondering why I return a value that it is not used, because in case a
    // validator "fails", I notify the "not valid" state and also the reason via an exception. It could have been done
    // by using a POJO that contains a boolean 'valid' to flag whether the attribute that was tested is valid or not, a
    // string to tell the client code why the validation failed, and then leave the exception mechanism for reporting
    // only actual exceptional situations that happened within the process. But, in the current iteration of this
    // component, I only need to know if it failed (in order to continue or not), and it case it did fail, I always
    // want to know why. So that's why I decided to do it via this coding style.
    @Override
    public boolean validate(RegisterApiRequestRegisterPrefix request) throws PrefixRegistrationRequestValidatorException {
        if (request.getOrganization() == null) {
            throw new PrefixRegistrationRequestValidatorException("The name of the providing organization is MISSING");
        }
        return true;
    }
}
