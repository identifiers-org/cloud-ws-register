package org.identifiers.org.cloud.ws.register.models;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
}
