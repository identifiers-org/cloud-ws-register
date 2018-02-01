package org.identifiers.org.cloud.ws.register.models;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.Collection;

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
    }

    @Autowired
    private PrefixRegistrationRequestValidatorPreferredPrefix prefixValidator;

    @Test
    public void testValidUseCases() {
        // TODO
    }

    public static Collection<Object[]> getValidTestCasesData() {
        // TODO
        return Arrays.asList(new Object[][]{
                // Test name validator
                {new RegisterApiRequestRegisterPrefix().setPreferredPrefix("myfirstprefix"), "This request has an invalid name, it is null"}
        });
    }
}
