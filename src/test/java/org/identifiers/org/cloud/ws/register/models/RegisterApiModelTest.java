package org.identifiers.org.cloud.ws.register.models;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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

        public TestDataUseCase setRequest(RegisterApiRequestRegisterPrefix request) {
            this.request = request;
            return this;
        }

        public TestDataUseCase setTestDescription(String testDescription) {
            this.testDescription = testDescription;
            return this;
        }
    }

    @Rule
    private ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testValidPrefixRegistrationRequests() {
        // TODO
    }
}