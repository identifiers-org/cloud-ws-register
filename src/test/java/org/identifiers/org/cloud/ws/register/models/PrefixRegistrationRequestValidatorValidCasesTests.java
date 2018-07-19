package org.identifiers.org.cloud.ws.register.models;

import org.identifiers.org.cloud.ws.register.api.requests.prefixregistration.ServiceRequestRegisterPrefixPayload;
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
    private ServiceRequestRegisterPrefixPayload request;
    private String testDescription;

    public PrefixRegistrationRequestValidatorValidCasesTests(PrefixRegistrationRequestValidator validator, ServiceRequestRegisterPrefixPayload request, String testDescription) {
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
                {new PrefixRegistrationRequestValidatorName(), new ServiceRequestRegisterPrefixPayload().setName("TestName"), "Request with valid name"},
                {new PrefixRegistrationRequestValidatorDescription(), new ServiceRequestRegisterPrefixPayload().setDescription("This is a valid description, according to the rules"), "Prefix registration request description is present and meets the requirements"},
                {new PrefixRegistrationRequestValidatorHomePage(), new ServiceRequestRegisterPrefixPayload().setHomePage(String.format("%s/200", UnitTestsHelper.SERVICE_HTTP_STATUS_URL)), "Valid home page is accepted"},
                {new PrefixRegistrationRequestValidatorOrganization(), new ServiceRequestRegisterPrefixPayload().setOrganization("This is a Sample Organization Inc."), "Organization information is supplied"},
                {new PrefixRegistrationRequestValidatorResourceAccessRule(), new ServiceRequestRegisterPrefixPayload().setResourceAccessRule("http://www.ebi.ac.uk/pdbe/entry/pdb/{$id}"), "Valid resource access rule"},
                {new PrefixRegistrationRequestValidatorResourceAccessRule(), new ServiceRequestRegisterPrefixPayload().setResourceAccessRule("http://www.ebi.ac.uk/pdbe/entry/{$id}/another"), "Valid resource access rule"},
                {new PrefixRegistrationRequestValidatorResourceAccessRule(), new ServiceRequestRegisterPrefixPayload().setResourceAccessRule("http://www.ebi.ac.uk/pdbe/entry/{$id}/another/path"), "Valid resource access rule"},
                {new PrefixRegistrationRequestValidatorExampleIdentifier(), new ServiceRequestRegisterPrefixPayload().setExampleIdentifier("34765"), "Example Identifier is present"},
                {new PrefixRegistrationRequestValidatorCrossedExampleIdentifierResourceAccessRule(), new ServiceRequestRegisterPrefixPayload().setResourceAccessRule(chebiAccessRule).setExampleIdentifier(String.valueOf(chebiSampleId)), "Valid cross validation of resource access rule and example identifier"},
                {new PrefixRegistrationRequestValidatorRegexPattern(), new ServiceRequestRegisterPrefixPayload().setRegexPattern("\\d+$"), "Regex Pattern is present"},
                {new PrefixRegistrationRequestValidatorCrossedRegexPatternAndExampleIdentifier(), new ServiceRequestRegisterPrefixPayload().setRegexPattern(chebiRegexPattern).setExampleIdentifier(String.valueOf(chebiSampleId)), "Valid cross-validation of example identifier and regular expression pattern describing the identifier"},
                {new PrefixRegistrationRequestValidatorReferences(), new ServiceRequestRegisterPrefixPayload(), "Empty provision of References validates"},
                {new PrefixRegistrationRequestValidatorReferences(), new ServiceRequestRegisterPrefixPayload().setReferences(new String[] {"Unrestricted provision of references"}), "Provision of References, validates"},
                {new PrefixRegistrationRequestValidatorAdditionalInformation(), new ServiceRequestRegisterPrefixPayload(), "Empty provision of Additional Information, validates"},
                {new PrefixRegistrationRequestValidatorAdditionalInformation(), new ServiceRequestRegisterPrefixPayload().setAdditionalInformation("Unrestricted provision of additional information"), "provision of Additional Information, validates"},
                {new PrefixRegistrationRequestValidatorRequester(), new ServiceRequestRegisterPrefixPayload().setRequester(new Requester().setEmail("valid@email.com")),"Provisioned requester details validate"}
        });
    }
}
