package org.identifiers.org.cloud.ws.register.models;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * Project: register
 * Package: org.identifiers.org.cloud.ws.register.models
 * Timestamp: 2018-02-01 9:28
 * ---
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class PrefixValidatorTests {

    @Autowired
    private PrefixRegistrationRequestValidatorPreferredPrefix prefixValidator;
}
