package org.identifiers.org.cloud.ws.register.models;

import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

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
        Requester requester;
        String testDescription;

        public TestDataUseCase setRequester(Requester requester) {
            this.requester = requester;
            return this;
        }

        public TestDataUseCase setTestDescription(String testDescription) {
            this.testDescription = testDescription;
            return this;
        }
    }

    private List<TestDataUseCase> getValidTestDataUseCases() {
        // TODO
    }

    private List<TestDataUseCase> getNotValidTestCasesData() {
        // TODO
    }
}