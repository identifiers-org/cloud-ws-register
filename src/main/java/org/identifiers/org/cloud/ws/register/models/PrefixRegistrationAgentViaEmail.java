package org.identifiers.org.cloud.ws.register.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
        ObjectMapper mapper = new ObjectMapper();
        try {
            logger.info("REGISTERING PREFIX registration request\n{}", mapper.writeValueAsString(prefixRegistrationRequest));
        } catch (JsonProcessingException e) {
            // TODO - nothing to do here right now
        }
    }
}
