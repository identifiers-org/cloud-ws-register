package org.identifiers.org.cloud.ws.register.models;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

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
        RequesterValidator requesterValidator;
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

        TestDataUseCase setRequesterValidator(RequesterValidator requesterValidator) {
            this.requesterValidator = requesterValidator;
            return this;
        }
    }

    @Test
    public void testValidUseCases() {
        getValidTestDataUseCases().parallelStream().forEach(testDataUseCase -> assertThat(testDataUseCase.testDescription));
    }

    private List<TestDataUseCase> getValidTestDataUseCases() {
        // TODO
        return Arrays.asList(
                new TestDataUseCase().setTestDescription("Requester Name NOT provided, validates").setRequester(new Requester()),
                new TestDataUseCase().setTestDescription("Requester Name provided, validates").setRequester(new Requester().setName("Just a name"))
        );
    }

    private List<TestDataUseCase> getNotValidTestCasesData() {
        // TODO
    }
}