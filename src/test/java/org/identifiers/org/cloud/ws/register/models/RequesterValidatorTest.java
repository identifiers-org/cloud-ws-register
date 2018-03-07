package org.identifiers.org.cloud.ws.register.models;

import org.identifiers.org.cloud.ws.register.models.validators.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * Project: register
 * Package: org.identifiers.org.cloud.ws.register.models
 * Timestamp: 2018-02-02 13:41
 * ---
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class RequesterValidatorTest {

    class TestDataUseCase {
        RequesterValidator validator;
        Requester requester;
        String testDescription;

        TestDataUseCase setRequester(Requester requester) {
            this.requester = requester;
            return this;
        }

        TestDataUseCase setTestDescription(String testDescription) {
            this.testDescription = testDescription;
            return this;
        }

        TestDataUseCase setValidator(RequesterValidator validator) {
            this.validator = validator;
            return this;
        }
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testValidUseCases() {
        getValidTestDataUseCases().parallelStream().forEach(testDataUseCase -> assertThat(testDataUseCase.testDescription, testDataUseCase.validator.validate(testDataUseCase.requester), is(true)));
    }

    @Test
    public void testInvalidUseCases() {
        // Set the expected exception and test description
        expectedException.expect(RequesterValidatorException.class);
        getNotValidTestCasesData().parallelStream().forEach(testDataUseCase -> {
            expectedException.reportMissingExceptionWithMessage(String.format("MISSING INVALIDATION for '%s'", testDataUseCase.testDescription));
            testDataUseCase.validator.validate(testDataUseCase.requester);
        });
    }

    private List<TestDataUseCase> getValidTestDataUseCases() {
        // TODO
        return Arrays.asList(
                new TestDataUseCase().setValidator(new RequesterValidatorName()).setTestDescription("Requester Name NOT provided, validates").setRequester(new Requester()),
                new TestDataUseCase().setValidator(new RequesterValidatorName()).setTestDescription("Requester Name provided, validates").setRequester(new Requester().setName("Just a name")),
                new TestDataUseCase().setValidator(new RequesterValidatorEmail()).setTestDescription("Requester valid e-mail address is provided and valid").setRequester(new Requester().setEmail("myemail@somedomain.com")),
                new TestDataUseCase().setValidator(new RequesterValidatorFullValidator()).setTestDescription("Full Requester validation").setRequester(new Requester().setEmail("valid@email.com"))
        );
    }

    private List<TestDataUseCase> getNotValidTestCasesData() {
        // TODO
        return Arrays.asList(
                new TestDataUseCase().setValidator(new RequesterValidatorEmail()).setTestDescription("Requester invalid e-mail address is provided and valid").setRequester(new Requester().setEmail("myemailATsomedomain.com")),
                new TestDataUseCase().setValidator(new RequesterValidatorFullValidator()).setTestDescription("Requester invalid e-mail address is provided and valid").setRequester(new Requester().setEmail("myemailATsomedomain.com"))
        );
    }
}