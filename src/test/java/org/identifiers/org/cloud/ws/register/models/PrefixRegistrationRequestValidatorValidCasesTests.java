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
        String chebiAccessRule = "http://www.ebi.ac.uk/chebi/searchId.do?chebiId=CHEBI:{$id}";
        int chebiSampleId = 36927;
        return Arrays.asList(new Object[][]{
                // Test name validator
                {new PrefixRegistrationRequestValidatorName(), new RegisterApiRequestRegisterPrefix().setName("TestName"), "Request with valid name"},
                {new PrefixRegistrationRequestValidatorDescription(), new RegisterApiRequestRegisterPrefix().setDescription("This is a valid description, according to the rules"), "Prefix registration request description is present and meets the requirements"},
                {new PrefixRegistrationRequestValidatorHomePage(), new RegisterApiRequestRegisterPrefix().setHomePage("http://httpstat.us/200"), "Valid home page is accepted"},
                {new PrefixRegistrationRequestValidatorOrganization(), new RegisterApiRequestRegisterPrefix().setOrganization("This is a Sample Organization Inc."), "Organization information is supplied"},
                {new PrefixRegistrationRequestValidatorResourceAccessRule(), new RegisterApiRequestRegisterPrefix().setResourceAccessRule("http://www.ebi.ac.uk/pdbe/entry/pdb/{$id}"), "Valid resource access rule"},
                {new PrefixRegistrationRequestValidatorResourceAccessRule(), new RegisterApiRequestRegisterPrefix().setResourceAccessRule("http://www.ebi.ac.uk/pdbe/entry/{$id}/another"), "Valid resource access rule"},
                {new PrefixRegistrationRequestValidatorResourceAccessRule(), new RegisterApiRequestRegisterPrefix().setResourceAccessRule("http://www.ebi.ac.uk/pdbe/entry/{$id}/another/path"), "Valid resource access rule"},
                {new PrefixRegistrationRequestValidatorExampleIdentifier(), new RegisterApiRequestRegisterPrefix().setExampleIdentifier("34765"), "Example Identifier is present"},
                {new PrefixRegistrationRequestValidatorCrossedExampleIdentifierResourceAccessRule(), }
        });
    }
}
