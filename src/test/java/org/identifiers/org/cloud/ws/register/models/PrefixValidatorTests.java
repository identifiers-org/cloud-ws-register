package org.identifiers.org.cloud.ws.register.models;

import org.identifiers.org.cloud.ws.register.api.requests.prefixregistration.ServiceRequestRegisterPrefixPayload;
import org.identifiers.org.cloud.ws.register.models.validators.PrefixRegistrationRequestValidator;
import org.identifiers.org.cloud.ws.register.models.validators.PrefixRegistrationRequestValidatorException;
import org.identifiers.org.cloud.ws.register.models.validators.PrefixRegistrationRequestValidatorPreferredPrefix;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * Project: register
 * Package: org.identifiers.org.cloud.ws.register.models
 * Timestamp: 2018-02-01 9:28
 * ---
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PrefixValidatorTests {

    class TestDataUseCase {
        PrefixRegistrationRequestValidator validator;
        ServiceRequestRegisterPrefixPayload request;
        String testDescription;

        TestDataUseCase setValidator(PrefixRegistrationRequestValidator validator) {
            this.validator = validator;
            return this;
        }

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
    private PrefixRegistrationRequestValidatorPreferredPrefix prefixValidator;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testValidUseCases() {
        getValidTestCasesData().parallelStream().forEach(testDataUseCase -> assertThat(testDataUseCase.testDescription, testDataUseCase.validator.validate(testDataUseCase.request), is(true)));
    }

    @Test
    public void testInvalidUseCases() {
        // Set the expected exception and test description
        expectedException.expect(PrefixRegistrationRequestValidatorException.class);
        getNotValidTestCasesData().parallelStream().forEach(testDataUseCase -> {
            expectedException.reportMissingExceptionWithMessage(String.format("MISSING INVALIDATION for '%s'", testDataUseCase.testDescription));
            testDataUseCase.validator.validate(testDataUseCase.request);
        });
    }

    // TODO - On these data providers, keep in mind that this unit test is not prefect, it provides no sample data and
    // TODO - it gives for granted that some particular prefixes are not registered but others are, but this is extreme agile
    // TODO - building a prototype to make it evolve over time later on. This note is just a reminder that, in the future, some
    // TODO - iteration could improve how strict this test is.
    private List<TestDataUseCase> getValidTestCasesData() {
        return Arrays.asList(
                new TestDataUseCase()
                        .setTestDescription("Valid prefix accepted")
                        .setRequest(new ServiceRequestRegisterPrefixPayload().setPreferredPrefix("mynewprefix"))
                        .setValidator(prefixValidator),
                new TestDataUseCase()
                        .setTestDescription("Another valid prefix accepted")
                        .setRequest(new ServiceRequestRegisterPrefixPayload().setPreferredPrefix("myotherprefix"))
                        .setValidator(prefixValidator)
        );
    }

    private List<TestDataUseCase> getNotValidTestCasesData() {
        return Arrays.asList(
                new TestDataUseCase()
                        .setTestDescription("Valid prefix NOT accepted, 'chebi'")
                        .setRequest(new ServiceRequestRegisterPrefixPayload().setPreferredPrefix("chebi"))
                        .setValidator(prefixValidator),
                new TestDataUseCase()
                        .setTestDescription("Another NOT valid prefix, 'pdb'")
                        .setRequest(new ServiceRequestRegisterPrefixPayload().setPreferredPrefix("pdb"))
                        .setValidator(prefixValidator)
        );
    }
}
