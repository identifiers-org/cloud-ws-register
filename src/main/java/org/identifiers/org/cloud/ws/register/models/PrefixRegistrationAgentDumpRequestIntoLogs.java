package org.identifiers.org.cloud.ws.register.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.identifiers.org.cloud.ws.register.models.api.requests.RegisterApiRequestRegisterPrefix;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * Project: register
 * Package: org.identifiers.org.cloud.ws.register.models
 * Timestamp: 2018-02-03 15:19
 * ---
 */
@Component
@Scope("prototype")
@Profile("development")
public class PrefixRegistrationAgentDumpRequestIntoLogs implements PrefixRegistrationAgent {
    private static Logger logger = LoggerFactory.getLogger(PrefixRegistrationAgentDumpRequestIntoLogs.class);

    @Override
    public void registerPrefix(RegisterApiRequestRegisterPrefix prefixRegistrationRequest) throws PrefixRegistrationAgentException {
        String registrationData = "--- IT COULD NOT BE SERIALIZED ---";
        ObjectMapper mapper = new ObjectMapper();
        try {
            // TODO - Use external formaters that can be set in run time to format the request
            registrationData = mapper.writeValueAsString(prefixRegistrationRequest);
            logger.info("REGISTERING PREFIX registration request\n{}", registrationData);
        } catch (JsonProcessingException e) {
            // TODO - nothing to do here right now
            logger.error("VALID Prefix registration request COULD NOT BE DUMPED in JSON format, which is kind of impossible...");
        }
    }
}
