package org.identifiers.org.cloud.ws.register.models;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * Project: register
 * Package: org.identifiers.org.cloud.ws.register.models
 * Timestamp: 2018-01-30 23:21
 * ---
 */
@RunWith(Parameterized.class)
public class PrefixRegistrationRequestValidatorValidCasesTests {
    private PrefixRegistrationRequestValidator validator;
    private RegisterApiRequestRegisterPrefix request;
    private String testDescription;

    @Test
    public void testValidUseCase() {
        assertThat(testDescription, validator.validate(request), is(true));
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getTestingValues() {
        // TODO
        return Arrays.asList(new Object[][]{
                // Test name validator
                {new PrefixRegistrationRequestValidatorName(), new RegisterApiRequestRegisterPrefix().setName("TestName"), "Request with valid name"}
        });
    }
}
