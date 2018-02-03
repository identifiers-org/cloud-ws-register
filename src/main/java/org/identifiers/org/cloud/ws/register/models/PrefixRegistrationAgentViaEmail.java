package org.identifiers.org.cloud.ws.register.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

/**
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * Project: register
 * Package: org.identifiers.org.cloud.ws.register.models
 * Timestamp: 2018-01-30 23:13
 * ---
 */
@Component
@Scope("prototype")
@Qualifier("PrefixRegistrationAgentViaEmail")
public class PrefixRegistrationAgentViaEmail implements PrefixRegistrationAgent {
    private static Logger logger = LoggerFactory.getLogger(PrefixRegistrationAgentViaEmail.class);

    private JavaMailSender javaMailSender;

    public PrefixRegistrationAgentViaEmail(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void registerPrefix(RegisterApiRequestRegisterPrefix prefixRegistrationRequest) throws PrefixRegistrationAgentException {
        // TODO
        ObjectMapper mapper = new ObjectMapper();
        try {
            logger.info("REGISTERING PREFIX registration request\n{}", mapper.writeValueAsString(prefixRegistrationRequest));
        } catch (JsonProcessingException e) {
            // TODO - nothing to do here right now
            logger.error("VALID Prefix registration request COULD NOT BE DUMPED in JSON format, which is kind of impossible...");
        }
    }
}
