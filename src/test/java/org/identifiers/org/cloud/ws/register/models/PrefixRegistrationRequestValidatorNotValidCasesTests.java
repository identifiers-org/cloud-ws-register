package org.identifiers.org.cloud.ws.register.models;

import org.identifiers.org.cloud.ws.register.models.api.requests.prefixregistration.ServiceRequestRegisterPrefixPayload;
import org.identifiers.org.cloud.ws.register.models.validators.*;
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
    private ServiceRequestRegisterPrefixPayload request;
    private String testDescription;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    public PrefixRegistrationRequestValidatorNotValidCasesTests(PrefixRegistrationRequestValidator validator, ServiceRequestRegisterPrefixPayload request, String testDescription) {
        this.validator = validator;
        this.request = request;
        this.testDescription = testDescription;
    }

    @Test
    public void invalidTestCases() {
        // Set the expected exception and test description
        expectedException.expect(PrefixRegistrationRequestValidatorException.class);
        expectedException.reportMissingExceptionWithMessage(String.format("MISSING INVALIDATION for '%s'", testDescription));
        // Unit testing code that will throw the exception
        validator.validate(request);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getTestingValues() {
        return Arrays.asList(new Object[][]{
                // Test name validator
                {new PrefixRegistrationRequestValidatorName(), new ServiceRequestRegisterPrefixPayload(), "This request has an invalid name, it is null"},
                {new PrefixRegistrationRequestValidatorDescription(), new ServiceRequestRegisterPrefixPayload(), "Prefix registration request description is missing"},
                {new PrefixRegistrationRequestValidatorDescription(), new ServiceRequestRegisterPrefixPayload().setDescription("This description is not enough"), "Prefix registration request description is present but it doesn't meet the requirements"},
                {new PrefixRegistrationRequestValidatorHomePage(), new ServiceRequestRegisterPrefixPayload(), "Missing URL error catched"},
                {new PrefixRegistrationRequestValidatorHomePage(), new ServiceRequestRegisterPrefixPayload().setHomePage("ht:/this_url_is_not_valid"), "Invalid URL error caught"},
                {new PrefixRegistrationRequestValidatorHomePage(), new ServiceRequestRegisterPrefixPayload().setHomePage(String.format("%s/404", UnitTestsHelper.SERVICE_HTTP_STATUS_URL)), "Dead homepage error caught"},
                {new PrefixRegistrationRequestValidatorOrganization(), new ServiceRequestRegisterPrefixPayload(), "Missing organization information error is caught"},
                {new PrefixRegistrationRequestValidatorResourceAccessRule(), new ServiceRequestRegisterPrefixPayload(), "Missing resource access rule caught"},
                {new PrefixRegistrationRequestValidatorResourceAccessRule(), new ServiceRequestRegisterPrefixPayload().setResourceAccessRule("://www.ebi.ac.uk/pdbe/entry/{$id}/another"), "Invalid resource access rule caught"},
                {new PrefixRegistrationRequestValidatorResourceAccessRule(), new ServiceRequestRegisterPrefixPayload().setResourceAccessRule("http://www.ebi.ac.uk/pdbe/entry/another/path"), "Missing '{$id}' placeholder caught"},
                {new PrefixRegistrationRequestValidatorExampleIdentifier(), new ServiceRequestRegisterPrefixPayload(), "Missing Example Identifier caught"},
                {new PrefixRegistrationRequestValidatorCrossedExampleIdentifierResourceAccessRule(), new ServiceRequestRegisterPrefixPayload(), "Missing resource access rule and example identifier"},
                {new PrefixRegistrationRequestValidatorCrossedExampleIdentifierResourceAccessRule(), new ServiceRequestRegisterPrefixPayload().setResourceAccessRule(String.format("%s/200%s", UnitTestsHelper.SERVICE_HTTP_STATUS_URL, ResourceAccessHelper.RESOURCE_ACCESS_RULE_PLACEHOLDER_ID)), "Resource Access Rule present, but missing Example Identifier"},
                {new PrefixRegistrationRequestValidatorCrossedExampleIdentifierResourceAccessRule(), new ServiceRequestRegisterPrefixPayload().setExampleIdentifier("873465"), "Example Identifier present, but missing Resource Access Rule"},
                {new PrefixRegistrationRequestValidatorCrossedExampleIdentifierResourceAccessRule(), new ServiceRequestRegisterPrefixPayload().setResourceAccessRule(String.format("%s/%s", UnitTestsHelper.SERVICE_HTTP_STATUS_URL, ResourceAccessHelper.RESOURCE_ACCESS_RULE_PLACEHOLDER_ID)).setExampleIdentifier("404"), "Resource Access Rule and Example Identifier present, but they lead to a bad landing page"},
                {new PrefixRegistrationRequestValidatorRegexPattern(), new ServiceRequestRegisterPrefixPayload(), "Missing regex pattern"},
                {new PrefixRegistrationRequestValidatorCrossedRegexPatternAndExampleIdentifier(), new ServiceRequestRegisterPrefixPayload(), "NOT Valid cross-validation of example identifier and regular expression pattern describing the identifier, missing regex pattern and example identifier"},
                {new PrefixRegistrationRequestValidatorCrossedRegexPatternAndExampleIdentifier(), new ServiceRequestRegisterPrefixPayload().setRegexPattern("\\d+$"), "NOT Valid cross-validation of example identifier and regular expression pattern describing the identifier, present regex pattern but missing example identifier"},
                {new PrefixRegistrationRequestValidatorCrossedRegexPatternAndExampleIdentifier(), new ServiceRequestRegisterPrefixPayload().setExampleIdentifier("ENSX00000139618"), "NOT Valid cross-validation of example identifier and regular expression pattern describing the identifier, present example identifier but missing regex pattern"},
                {new PrefixRegistrationRequestValidatorCrossedRegexPatternAndExampleIdentifier(), new ServiceRequestRegisterPrefixPayload().setRegexPattern("\\d+$").setExampleIdentifier("ENSX00000139618"), "NOT Valid cross-validation of example identifier and regular expression pattern describing the identifier"},
                {new PrefixRegistrationRequestValidatorRequester(), new ServiceRequestRegisterPrefixPayload(),"MISSING requester details DOES NOT VALIDATE"},
                {new PrefixRegistrationRequestValidatorRequester(), new ServiceRequestRegisterPrefixPayload().setRequester(new Requester().setEmail("invalidATemail.com")),"Provisioned requester details DOES NOT VALIDATE"}
        });
    }

}
