package org.identifiers.org.cloud.ws.register.models;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

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

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    public PrefixRegistrationRequestValidatorNotValidCasesTests(PrefixRegistrationRequestValidator validator, RegisterApiRequestRegisterPrefix request, String testDescription) {
        this.validator = validator;
        this.request = request;
        this.testDescription = testDescription;
    }

    @Test
    public void invalidTestCases() {
        // TODO
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getTestingValues() {
        // TODO
        return Arrays.asList(new Object[][]{
                // Test name validator
                {new PrefixRegistrationRequestValidatorName(), new RegisterApiRequestRegisterPrefix(), "This request has an invalid name, it is null"}
        });
    }

}
