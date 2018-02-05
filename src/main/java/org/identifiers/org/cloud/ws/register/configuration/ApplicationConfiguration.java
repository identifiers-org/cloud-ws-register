package org.identifiers.org.cloud.ws.register.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * Project: register
 * Package: org.identifiers.org.cloud.ws.register.configuration
 * Timestamp: 2018-01-30 22:37
 * ---
 */
@Configuration
@Profile({"production", "standalone"})
public class ApplicationConfiguration {
    // Production Environment Application Configuration
/*    @Autowired @Qualifier("PrefixRegistrationRequestValidatorStrategyFullValidation")
    private PrefixRegistrationRequestValidatorStrategy selectedValidatorStrategy;
*/
/*    @Autowired @Qualifier("PrefixRegistrationAgentViaEmail")
    private PrefixRegistrationAgent selectedPrefixRegistrationAgent;
*/
/*    @Bean
    public PrefixRegistrationRequestValidatorStrategy validatorStrategy() {
        return selectedValidatorStrategy;
    }
*/
/*    @Bean
    public PrefixRegistrationAgent prefixRegistrationAgent() {
        return selectedPrefixRegistrationAgent;
    }
*/
}
