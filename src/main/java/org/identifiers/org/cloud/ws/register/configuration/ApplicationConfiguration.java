package org.identifiers.org.cloud.ws.register.configuration;

import org.identifiers.org.cloud.ws.register.models.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * Project: register
 * Package: org.identifiers.org.cloud.ws.register.configuration
 * Timestamp: 2018-01-30 22:37
 * ---
 */
@Configuration
public class ApplicationConfiguration {

    @Bean
    public PrefixRegistrationRequestValidatorStrategy prefixRegistrationRequestValidatorStrategy() {
        return new PrefixRegistrationRequestValidatorStrategyFullValidation();
    }

    @Bean
    public PrefixRegistrationAgent prefixRegistrationAgent() {
        return new PrefixRegistrationAgentViaEmail();
    }
}
