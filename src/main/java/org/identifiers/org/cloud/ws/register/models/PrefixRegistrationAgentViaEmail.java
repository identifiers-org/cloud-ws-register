package org.identifiers.org.cloud.ws.register.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * Project: register
 * Package: org.identifiers.org.cloud.ws.register.models
 * Timestamp: 2018-01-30 23:13
 * ---
 */
public class PrefixRegistrationAgentViaEmail implements PrefixRegistrationAgent {
    private static Logger logger = LoggerFactory.getLogger(PrefixRegistrationAgentViaEmail.class);
    
    @Override
    public void registerPrefix(RegisterApiRequestRegisterPrefix prefixRegistrationRequest) throws PrefixRegistrationAgentException {
        // TODO
    }
}
