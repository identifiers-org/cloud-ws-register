package org.identifiers.org.cloud.ws.register.configuration;

import org.identifiers.org.cloud.ws.register.models.PrefixRegistrationAgent;
import org.identifiers.org.cloud.ws.register.models.PrefixRegistrationRequestValidatorStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    @Autowired @Qualifier("PrefixRegistrationRequestValidatorStrategyFullValidation")
    private PrefixRegistrationRequestValidatorStrategy selectedValidatorStrategy;

    @Autowired @Qualifier("PrefixRegistrationAgentViaEmail")
    private PrefixRegistrationAgent selectedPrefixRegistrationAgent;

    @Bean
    public PrefixRegistrationRequestValidatorStrategy validatorStrategy() {
        return selectedValidatorStrategy;
    }

    @Bean
    public PrefixRegistrationAgent prefixRegistrationAgent() {
        return selectedPrefixRegistrationAgent;
    }

}
