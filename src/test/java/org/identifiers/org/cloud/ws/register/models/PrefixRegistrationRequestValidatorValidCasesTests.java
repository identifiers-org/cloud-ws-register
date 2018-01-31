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

    // Testing subjects

    public PrefixRegistrationRequestValidatorValidCasesTests(PrefixRegistrationRequestValidator validator, RegisterApiRequestRegisterPrefix request, String testDescription) {
        this.validator = validator;
        this.request = request;
        this.testDescription = testDescription;
    }

    @Test
    public void testValidUseCase() {
        assertThat(testDescription, validator.validate(request), is(true));
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getTestingValues() {
        // TODO
        return Arrays.asList(new Object[][]{
                // Test name validator
                {new PrefixRegistrationRequestValidatorName(), new RegisterApiRequestRegisterPrefix().setName("TestName"), "Request with valid name"},
                {new PrefixRegistrationRequestValidatorDescription(), new RegisterApiRequestRegisterPrefix().setDescription("This is a valid description, according to the rules"), "Prefix registration request description is present and meets the requirements"},
                {new PrefixRegistrationRequestValidatorHomePage(), new RegisterApiRequestRegisterPrefix().setHomePage("http://httpstat.us/200"), "Valid home page is accepted"},
                {new PrefixRegistrationRequestValidatorOrganization(), new RegisterApiRequestRegisterPrefix().setOrganization("This is a Sample Organization Inc."), "Organization information is supplied"},
                {new PrefixRegistrationRequestValidatorPreferredPrefix(), new RegisterApiRequestRegisterPrefix().setPreferredPrefix("newunknownprefix"), "Non-existing prefix validates"}
        });
    }
}
