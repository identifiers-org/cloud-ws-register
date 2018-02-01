package org.identifiers.org.cloud.ws.register.models;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
@RunWith(Parameterized.class)
public class PrefixValidatorTests {

    @Autowired
    private PrefixRegistrationRequestValidatorPreferredPrefix prefixValidator;
    // Test parameters
    private RegisterApiRequestRegisterPrefix request;
    private String testDescription;

    public PrefixValidatorTests(RegisterApiRequestRegisterPrefix request, String testDescription) {
        this.request = request;
        this.testDescription = testDescription;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getTestingValues() {
        // TODO
        return Arrays.asList(new Object[][]{
                // Test name validator
                {new RegisterApiRequestRegisterPrefix().setPreferredPrefix("myfirstprefix"), "This request has an invalid name, it is null"}
        });
    }
}
