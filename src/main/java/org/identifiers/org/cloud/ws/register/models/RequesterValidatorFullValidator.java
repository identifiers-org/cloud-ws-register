package org.identifiers.org.cloud.ws.register.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * Project: register
 * Package: org.identifiers.org.cloud.ws.register.models
 * Timestamp: 2018-02-02 14:19
 * ---
 */
public class RequesterValidatorFullValidator implements RequesterValidator {
    @Override
    public boolean validate(Requester requester) throws RequesterValidatorException {
        List<String> errors = new ArrayList<>();
        List<RequesterValidator> validators = Arrays.asList(new RequesterValidatorEmail(), new RequesterValidatorName());
        return false;
    }
}
