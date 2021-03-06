package org.identifiers.org.cloud.ws.register.models;

import org.identifiers.org.cloud.ws.register.api.models.RegisterApiModel;
import org.identifiers.org.cloud.ws.register.api.requests.prefixregistration.ServiceRequestRegisterPrefix;
import org.identifiers.org.cloud.ws.register.api.requests.prefixregistration.ServiceRequestRegisterPrefixPayload;
import org.identifiers.org.cloud.ws.register.api.responses.prefixregistration.ServiceResponseRegisterPrefix;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * Project: register
 * Package: org.identifiers.org.cloud.ws.register.models
 * Timestamp: 2018-02-02 16:09
 * ---
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RegisterApiModelTest {

    class TestDataUseCase {
        ServiceRequestRegisterPrefixPayload request;
        String testDescription;

        TestDataUseCase setRequest(ServiceRequestRegisterPrefixPayload request) {
            this.request = request;
            return this;
        }

        TestDataUseCase setTestDescription(String testDescription) {
            this.testDescription = testDescription;
            return this;
        }
    }

    @Autowired
    private RegisterApiModel registerApiModel;

    @Test
    public void testValidPrefixRegistrationRequests() {
        getValidTestCasesData().parallelStream().forEach(testDataUseCase -> {
            ServiceRequestRegisterPrefix request = new ServiceRequestRegisterPrefix();
            request.setApiVersion("1.0");
            request.setPayload(testDataUseCase.request);
            ServiceResponseRegisterPrefix response = registerApiModel.registerPrefix(request);
            assertThat(testDataUseCase.testDescription, response.getHttpStatus() == HttpStatus.OK, is(true));
        });
    }

    @Test
    public void testInvalidUseCases() {
        getNotValidTestCasesData().parallelStream().forEach(testDataUseCase -> {
            ServiceRequestRegisterPrefix request = new ServiceRequestRegisterPrefix();
            request.setApiVersion("1.0");
            request.setPayload(testDataUseCase.request);
            ServiceResponseRegisterPrefix response = registerApiModel.registerPrefix(request);
            assertThat(testDataUseCase.testDescription, response.getHttpStatus() == HttpStatus.BAD_REQUEST, is(true));
        });
    }

    private List<TestDataUseCase> getValidTestCasesData() {
        return Arrays.asList(
                new TestDataUseCase()
                        .setTestDescription("Valid prefix registration request")
                        .setRequest(new ServiceRequestRegisterPrefixPayload()
                                .setName("Valid new testing prefix mynewprefix")
                                .setDescription("This is a valid test prefix registration request, and I need it to be long")
                                .setHomePage("http://identifiers.org/")
                                .setOrganization("EMBL-EBI Unit Testing Organization")
                                .setPreferredPrefix("mynewprefix")
                                .setResourceAccessRule(String.format("%s/{$id}", UnitTestsHelper.SERVICE_HTTP_STATUS_URL))
                                .setExampleIdentifier("200")
                                .setRegexPattern("\\d+$")
                                .setReferences(new String[]{"Reference 1", "Publication 1", "Citation 1"})
                                .setAdditionalInformation("Additional information for this EMBL-EBI testing prefix")
                                .setRequester(new Requester()
                                        .setName("EBI Tester")
                                        .setEmail("ebitester@ebi.ac.uk"))
        ));
    }

    private List<TestDataUseCase> getNotValidTestCasesData() {
        return Arrays.asList(
                // TODO
                new TestDataUseCase()
                        .setTestDescription("Prefix registration request missing 'name'")
                        .setRequest(new ServiceRequestRegisterPrefixPayload()
                                .setDescription("This is a valid test prefix registration request, and I need it to be long")
                                .setHomePage("http://identifiers.org/")
                                .setOrganization("EMBL-EBI Unit Testing Organization")
                                .setPreferredPrefix("mynewprefix")
                                .setResourceAccessRule(String.format("%s/{$id}", UnitTestsHelper.SERVICE_HTTP_STATUS_URL))
                                .setExampleIdentifier("200")
                                .setRegexPattern("\\d+$")
                                .setReferences(new String[]{"Reference 1", "Publication 1", "Citation 1"})
                                .setAdditionalInformation("Additional information for this EMBL-EBI testing prefix")
                                .setRequester(new Requester()
                                        .setName("EBI Tester")
                                        .setEmail("ebitester@ebi.ac.uk"))
                        ),
                new TestDataUseCase()
                        .setTestDescription("Prefix registration request with too short description")
                        .setRequest(new ServiceRequestRegisterPrefixPayload()
                                .setName("Valid new testing prefix mynewprefix")
                                .setDescription("This description is too short")
                                .setHomePage("http://identifiers.org/")
                                .setOrganization("EMBL-EBI Unit Testing Organization")
                                .setPreferredPrefix("mynewprefix")
                                .setResourceAccessRule(String.format("%s/{$id}", UnitTestsHelper.SERVICE_HTTP_STATUS_URL))
                                .setExampleIdentifier("200")
                                .setRegexPattern("\\d+$")
                                .setReferences(new String[]{"Reference 1", "Publication 1", "Citation 1"})
                                .setAdditionalInformation("Additional information for this EMBL-EBI testing prefix")
                                .setRequester(new Requester()
                                        .setName("EBI Tester")
                                        .setEmail("ebitester@ebi.ac.uk"))
                        ),
                new TestDataUseCase()
                        .setTestDescription("Prefix registration request with invalid home page")
                        .setRequest(new ServiceRequestRegisterPrefixPayload()
                                .setName("Valid new testing prefix mynewprefix")
                                .setDescription("This is a valid test prefix registration request, and I need it to be long")
                                .setHomePage(String.format("%s/404", UnitTestsHelper.SERVICE_HTTP_STATUS_URL))
                                .setOrganization("EMBL-EBI Unit Testing Organization")
                                .setPreferredPrefix("mynewprefix")
                                .setResourceAccessRule(String.format("%s/{$id}", UnitTestsHelper.SERVICE_HTTP_STATUS_URL))
                                .setExampleIdentifier("200")
                                .setRegexPattern("\\d+$")
                                .setReferences(new String[]{"Reference 1", "Publication 1", "Citation 1"})
                                .setAdditionalInformation("Additional information for this EMBL-EBI testing prefix")
                                .setRequester(new Requester()
                                        .setName("EBI Tester")
                                        .setEmail("ebitester@ebi.ac.uk"))
                        ),

                new TestDataUseCase()
                        .setTestDescription("Prefix registration request with invalid resource access rule")
                        .setRequest(new ServiceRequestRegisterPrefixPayload()
                                .setName("Valid new testing prefix mynewprefix")
                                .setDescription("This is a valid test prefix registration request, and I need it to be long")
                                .setHomePage(String.format("%s/200", UnitTestsHelper.SERVICE_HTTP_STATUS_URL))
                                .setOrganization("EMBL-EBI Unit Testing Organization")
                                .setPreferredPrefix("mynewprefix")
                                .setResourceAccessRule(String.format("%s/no_placeholder", UnitTestsHelper.SERVICE_HTTP_STATUS_URL))
                                .setExampleIdentifier("200")
                                .setRegexPattern("\\d+$")
                                .setReferences(new String[]{"Reference 1", "Publication 1", "Citation 1"})
                                .setAdditionalInformation("Additional information for this EMBL-EBI testing prefix")
                                .setRequester(new Requester()
                                        .setName("EBI Tester")
                                        .setEmail("ebitester@ebi.ac.uk"))
                        ),
                new TestDataUseCase()
                        .setTestDescription("Prefix registration request with invalid regular expression pattern")
                        .setRequest(new ServiceRequestRegisterPrefixPayload()
                                .setName("Valid new testing prefix mynewprefix")
                                .setDescription("This is a valid test prefix registration request, and I need it to be long")
                                .setHomePage(String.format("%s/200", UnitTestsHelper.SERVICE_HTTP_STATUS_URL))
                                .setOrganization("EMBL-EBI Unit Testing Organization")
                                .setPreferredPrefix("mynewprefix")
                                .setResourceAccessRule(String.format("%s/{$id}", UnitTestsHelper.SERVICE_HTTP_STATUS_URL))
                                .setExampleIdentifier("200")
                                .setRegexPattern("[A-Z]+$")
                                .setReferences(new String[]{"Reference 1", "Publication 1", "Citation 1"})
                                .setAdditionalInformation("Additional information for this EMBL-EBI testing prefix")
                                .setRequester(new Requester()
                                        .setName("EBI Tester")
                                        .setEmail("ebitester@ebi.ac.uk"))
                        ),
                new TestDataUseCase()
                        .setTestDescription("Prefix registration request with multiple errors")
                        .setRequest(new ServiceRequestRegisterPrefixPayload()
                                .setName("Valid new testing prefix mynewprefix")
                                .setDescription("This description is too short")
                                .setHomePage(String.format("%s/404", UnitTestsHelper.SERVICE_HTTP_STATUS_URL))
                                .setOrganization("EMBL-EBI Unit Testing Organization")
                                .setPreferredPrefix("chebi")
                                .setResourceAccessRule(String.format("%s/{$ilksjdfd}", UnitTestsHelper.SERVICE_HTTP_STATUS_URL))
                                .setExampleIdentifier("200")
                                .setRegexPattern("[A-Z]+$")
                                .setReferences(new String[]{"Reference 1", "Publication 1", "Citation 1"})
                                .setAdditionalInformation("Additional information for this EMBL-EBI testing prefix")
                                .setRequester(new Requester()
                                        .setName("EBI Tester")
                                        .setEmail("ebitester@ebi.ac.uk"))
                        )
                );
    }
}