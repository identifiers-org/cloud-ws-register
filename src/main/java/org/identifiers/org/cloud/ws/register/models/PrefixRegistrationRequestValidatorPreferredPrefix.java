package org.identifiers.org.cloud.ws.register.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * Project: register
 * Package: org.identifiers.org.cloud.ws.register.models
 * Timestamp: 2018-01-31 14:40
 * ---
 */
public class PrefixRegistrationRequestValidatorPreferredPrefix implements PrefixRegistrationRequestValidator {
    private static Logger logger = LoggerFactory.getLogger(PrefixRegistrationRequestValidatorPreferredPrefix.class);

    // TODO - Let's see how this plays with Docker, later. It should go through a discovery service, but I'll find out
    // TODO - later how to lay all the pieces together for testing, development and production
    @Value("${org.identifiers.cloud.ws.register.resolver.host}")
    private String resolverHost;
    @Value("${org.identifiers.cloud.ws.register.resolver.port}")
    private int resolverPort;
    
    @Override
    public boolean validate(RegisterApiRequestRegisterPrefix request) throws PrefixRegistrationRequestValidatorException {
        // TODO

        return false;
    }
}
