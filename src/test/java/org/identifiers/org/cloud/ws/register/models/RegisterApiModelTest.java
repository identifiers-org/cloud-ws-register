package org.identifiers.org.cloud.ws.register.models;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

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
        RegisterApiRequestRegisterPrefix request;
        String testDescription;

        TestDataUseCase setRequest(RegisterApiRequestRegisterPrefix request) {
            this.request = request;
            return this;
        }

        TestDataUseCase setTestDescription(String testDescription) {
            this.testDescription = testDescription;
            return this;
        }
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private RegisterApiModel registerApiModel;

    public RegisterApiModelTest(RegisterApiModel registerApiModel) {
        this.registerApiModel = registerApiModel;
    }

    @Test
    public void testValidPrefixRegistrationRequests() {
        // TODO
    }

    @Test
    public void testInvalidUseCases() {
        // TODO
    }

    private List<TestDataUseCase> getValidTestCasesData() {
        return Arrays.asList(
                // TODO
                new TestDataUseCase()
                        .setTestDescription("Valid prefix registration request")
                        .setRequest(new RegisterApiRequestRegisterPrefix()
                                .setName("Valid new testing prefix mynewprefix")
                                .setDescription("This is a valid test prefix registration request")
                                .setHomePage("http://identifiers.org/")
                                .setOrganization("EMBL-EBI Unit Testing Organization")
                                .setPreferredPrefix("mynewprefix")
                                .setResourceAccessRule("http://httpstat.us/{$id}")
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
        );
    }
}