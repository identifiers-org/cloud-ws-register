package org.identifiers.org.cloud.ws.register.models;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

/**
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * Project: register
 * Package: org.identifiers.org.cloud.ws.register.models
 * Timestamp: 2018-02-01 9:28
 * ---
 */
@SpringBootTest
@SpringBootConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class PrefixValidatorTests {

    class TestDataUseCase {
        PrefixRegistrationRequestValidator validator;
        String testDescription;

        public TestDataUseCase(PrefixRegistrationRequestValidator validator, String testDescription) {
            this.validator = validator;
            this.testDescription = testDescription;
        }
    }

    @Autowired
    private PrefixRegistrationRequestValidatorPreferredPrefix prefixValidator;

    @Test
    public void testValidUseCases() {
        // TODO
    }

    public List<TestDataUseCase> getValidTestCasesData() {
        // TODO
        return Arrays.asList(

        );
    }
}
