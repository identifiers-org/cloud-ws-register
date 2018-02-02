package org.identifiers.org.cloud.ws.register.models;

import org.junit.Test;
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

    @Test
    public void testValidUseCases() {
        getValidTestDataUseCases().parallelStream().forEach(testDataUseCase -> assertThat(testDataUseCase.testDescription, testDataUseCase.validator.validate(testDataUseCase.requester), is(true)));
    }

    private List<TestDataUseCase> getValidTestDataUseCases() {
        // TODO
        return Arrays.asList(
                new TestDataUseCase().setValidator(new RequesterValidatorName()).setTestDescription("Requester Name NOT provided, validates").setRequester(new Requester()),
                new TestDataUseCase().setValidator(new RequesterValidatorName()).setTestDescription("Requester Name provided, validates").setRequester(new Requester().setName("Just a name"))
        );
    }

    private List<TestDataUseCase> getNotValidTestCasesData() {
        // TODO
    }
}