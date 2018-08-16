package org.identifiers.org.cloud.ws.register.data.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Project: register
 * Package: org.identifiers.org.cloud.ws.register.data.configuration
 * Timestamp: 2018-08-16 13:29
 *
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * ---
 */
@Component
public class PrefixRegistrationRequestConfig {
    private static final Logger logger = LoggerFactory.getLogger(PrefixRegistrationRequestConfig.class);

    public static Long timeToLive = 10L;

    @Value("${org.identifiers.cloud.ws.registry.backend.data.prefixregistrationrequest.ttl.seconds}")
    private Long timeToLiveParam;

    @PostConstruct
    private void init() {
        logger.info("Setting prefix registration request Time To Live value to {} seconds", timeToLiveParam);
        timeToLive = timeToLiveParam;
    }
}
