package org.identifiers.org.cloud.ws.register.models;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * Project: register
 * Package: org.identifiers.org.cloud.ws.register.models
 * Timestamp: 2018-01-31 0:05
 * ---
 */
@RunWith(Parameterized.class)
public class PrefixRegistrationRequestValidatorNotValidCasesTests {
    private PrefixRegistrationRequestValidator validator;
    private RegisterApiRequestRegisterPrefix request;
    private String testDescription;

    public PrefixRegistrationRequestValidatorNotValidCasesTests(PrefixRegistrationRequestValidator validator, RegisterApiRequestRegisterPrefix request, String testDescription) {
        this.validator = validator;
        this.request = request;
        this.testDescription = testDescription;
    }
}
