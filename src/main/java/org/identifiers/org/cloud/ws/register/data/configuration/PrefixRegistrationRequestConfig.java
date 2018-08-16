package org.identifiers.org.cloud.ws.register.data.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

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
}
