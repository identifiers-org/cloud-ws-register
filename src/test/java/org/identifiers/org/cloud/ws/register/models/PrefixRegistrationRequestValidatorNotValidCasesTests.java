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
                {new PrefixRegistrationRequestValidatorName(), new RegisterApiRequestRegisterPrefix(), "This request has an invalid name, it is null"},
                {new PrefixRegistrationRequestValidatorDescription(), new RegisterApiRequestRegisterPrefix(), "Prefix registration request description is missing"},
                {new PrefixRegistrationRequestValidatorDescription(), new RegisterApiRequestRegisterPrefix().setDescription("This description is not enough"), "Prefix registration request description is present but it doesn't meet the requirements"},
                {new PrefixRegistrationRequestValidatorHomePage(), new RegisterApiRequestRegisterPrefix(), "Missing URL error catched"},
                {new PrefixRegistrationRequestValidatorHomePage(), new RegisterApiRequestRegisterPrefix().setHomePage("ht:/this_url_is_not_valid"), "Invalid URL error caught"},
                {new PrefixRegistrationRequestValidatorHomePage(), new RegisterApiRequestRegisterPrefix().setHomePage(String.format("%s/404", UnitTestsHelper.SERVICE_HTTP_STATUS_URL)), "Dead homepage error caught"},
                {new PrefixRegistrationRequestValidatorOrganization(), new RegisterApiRequestRegisterPrefix(), "Missing organization information error is caught"},
                {new PrefixRegistrationRequestValidatorResourceAccessRule(), new RegisterApiRequestRegisterPrefix(), "Missing resource access rule caught"},
                {new PrefixRegistrationRequestValidatorResourceAccessRule(), new RegisterApiRequestRegisterPrefix().setResourceAccessRule("://www.ebi.ac.uk/pdbe/entry/{$id}/another"), "Invalid resource access rule caught"},
                {new PrefixRegistrationRequestValidatorResourceAccessRule(), new RegisterApiRequestRegisterPrefix().setResourceAccessRule("http://www.ebi.ac.uk/pdbe/entry/another/path"), "Missing '{$id}' placeholder caught"},
                {new PrefixRegistrationRequestValidatorExampleIdentifier(), new RegisterApiRequestRegisterPrefix(), "Missing Example Identifier caught"},
                {new PrefixRegistrationRequestValidatorCrossedExampleIdentifierResourceAccessRule(), new RegisterApiRequestRegisterPrefix(), "Missing resource access rule and example identifier"},
                {new PrefixRegistrationRequestValidatorCrossedExampleIdentifierResourceAccessRule(), new RegisterApiRequestRegisterPrefix().setResourceAccessRule(String.format("%s/200%s", UnitTestsHelper.SERVICE_HTTP_STATUS_URL, ResourceAccessHelper.RESOURCE_ACCESS_RULE_PLACEHOLDER_ID)), "Resource Access Rule present, but missing Example Identifier"},
                {new PrefixRegistrationRequestValidatorCrossedExampleIdentifierResourceAccessRule(), new RegisterApiRequestRegisterPrefix().setExampleIdentifier("873465"), "Example Identifier present, but missing Resource Access Rule"},
                {new PrefixRegistrationRequestValidatorCrossedExampleIdentifierResourceAccessRule(), new RegisterApiRequestRegisterPrefix().setResourceAccessRule(String.format("%s/%s", UnitTestsHelper.SERVICE_HTTP_STATUS_URL, ResourceAccessHelper.RESOURCE_ACCESS_RULE_PLACEHOLDER_ID)).setExampleIdentifier("404"), "Resource Access Rule and Example Identifier present, but they lead to a bad landing page"},
                {new PrefixRegistrationRequestValidatorRegexPattern(), new RegisterApiRequestRegisterPrefix(), "Missing regex pattern"},
                {new PrefixRegistrationRequestValidatorCrossedRegexPatternAndExampleIdentifier(), new RegisterApiRequestRegisterPrefix(), "NOT Valid cross-validation of example identifier and regular expression pattern describing the identifier, missing regex pattern and example identifier"},
                {new PrefixRegistrationRequestValidatorCrossedRegexPatternAndExampleIdentifier(), new RegisterApiRequestRegisterPrefix().setRegexPattern("\\d+$"), "NOT Valid cross-validation of example identifier and regular expression pattern describing the identifier, present regex pattern but missing example identifier"},
                {new PrefixRegistrationRequestValidatorCrossedRegexPatternAndExampleIdentifier(), new RegisterApiRequestRegisterPrefix().setExampleIdentifier("ENSX00000139618"), "NOT Valid cross-validation of example identifier and regular expression pattern describing the identifier, present example identifier but missing regex pattern"},
                {new PrefixRegistrationRequestValidatorCrossedRegexPatternAndExampleIdentifier(), new RegisterApiRequestRegisterPrefix().setRegexPattern("\\d+$").setExampleIdentifier("ENSX00000139618"), "NOT Valid cross-validation of example identifier and regular expression pattern describing the identifier"},
                {new PrefixRegistrationRequestValidatorRequester(), new RegisterApiRequestRegisterPrefix(),"MISSING requester details DOES NOT VALIDATE"},
                {new PrefixRegistrationRequestValidatorRequester(), new RegisterApiRequestRegisterPrefix().setRequester(new Requester().setEmail("invalidATemail.com")),"Provisioned requester details DOES NOT VALIDATE"}
        });
    }

}
