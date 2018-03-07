package org.identifiers.org.cloud.ws.register.models;

import org.identifiers.org.cloud.ws.register.models.api.requests.RegisterApiRequestRegisterPrefix;
import org.identifiers.org.cloud.ws.register.models.validators.*;
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
        String chebiAccessRule = "http://www.ebi.ac.uk/chebi/searchId.do?chebiId=CHEBI:{$id}";
        int chebiSampleId = 36927;
        String chebiRegexPattern = "\\d+$";
        return Arrays.asList(new Object[][]{
                // Test name validator
                {new PrefixRegistrationRequestValidatorName(), new RegisterApiRequestRegisterPrefix().setName("TestName"), "Request with valid name"},
                {new PrefixRegistrationRequestValidatorDescription(), new RegisterApiRequestRegisterPrefix().setDescription("This is a valid description, according to the rules"), "Prefix registration request description is present and meets the requirements"},
                {new PrefixRegistrationRequestValidatorHomePage(), new RegisterApiRequestRegisterPrefix().setHomePage(String.format("%s/200", UnitTestsHelper.SERVICE_HTTP_STATUS_URL)), "Valid home page is accepted"},
                {new PrefixRegistrationRequestValidatorOrganization(), new RegisterApiRequestRegisterPrefix().setOrganization("This is a Sample Organization Inc."), "Organization information is supplied"},
                {new PrefixRegistrationRequestValidatorResourceAccessRule(), new RegisterApiRequestRegisterPrefix().setResourceAccessRule("http://www.ebi.ac.uk/pdbe/entry/pdb/{$id}"), "Valid resource access rule"},
                {new PrefixRegistrationRequestValidatorResourceAccessRule(), new RegisterApiRequestRegisterPrefix().setResourceAccessRule("http://www.ebi.ac.uk/pdbe/entry/{$id}/another"), "Valid resource access rule"},
                {new PrefixRegistrationRequestValidatorResourceAccessRule(), new RegisterApiRequestRegisterPrefix().setResourceAccessRule("http://www.ebi.ac.uk/pdbe/entry/{$id}/another/path"), "Valid resource access rule"},
                {new PrefixRegistrationRequestValidatorExampleIdentifier(), new RegisterApiRequestRegisterPrefix().setExampleIdentifier("34765"), "Example Identifier is present"},
                {new PrefixRegistrationRequestValidatorCrossedExampleIdentifierResourceAccessRule(), new RegisterApiRequestRegisterPrefix().setResourceAccessRule(chebiAccessRule).setExampleIdentifier(String.valueOf(chebiSampleId)), "Valid cross validation of resource access rule and example identifier"},
                {new PrefixRegistrationRequestValidatorRegexPattern(), new RegisterApiRequestRegisterPrefix().setRegexPattern("\\d+$"), "Regex Pattern is present"},
                {new PrefixRegistrationRequestValidatorCrossedRegexPatternAndExampleIdentifier(), new RegisterApiRequestRegisterPrefix().setRegexPattern(chebiRegexPattern).setExampleIdentifier(String.valueOf(chebiSampleId)), "Valid cross-validation of example identifier and regular expression pattern describing the identifier"},
                {new PrefixRegistrationRequestValidatorReferences(), new RegisterApiRequestRegisterPrefix(), "Empty provision of References validates"},
                {new PrefixRegistrationRequestValidatorReferences(), new RegisterApiRequestRegisterPrefix().setReferences(new String[] {"Unrestricted provision of references"}), "Provision of References, validates"},
                {new PrefixRegistrationRequestValidatorAdditionalInformation(), new RegisterApiRequestRegisterPrefix(), "Empty provision of Additional Information, validates"},
                {new PrefixRegistrationRequestValidatorAdditionalInformation(), new RegisterApiRequestRegisterPrefix().setAdditionalInformation("Unrestricted provision of additional information"), "provision of Additional Information, validates"},
                {new PrefixRegistrationRequestValidatorRequester(), new RegisterApiRequestRegisterPrefix().setRequester(new Requester().setEmail("valid@email.com")),"Provisioned requester details validate"}
        });
    }
}
