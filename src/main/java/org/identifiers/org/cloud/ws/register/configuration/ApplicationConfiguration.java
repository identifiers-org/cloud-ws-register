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
    private PrefixRegistrationRequestValidatorStrategy sectedValidatorStrategy;

    @Autowired @Qualifier("PrefixRegistrationAgentViaEmail")
    private PrefixRegistrationAgent prefixRegistrationAgent;

/*    // E-mail subsystem configuration
    @Value("${WS_REGISTRY_CONFIG_EMAIL_HOST}")
    private String emailHost;
    @Value("${WS_REGISTRY_CONFIG_EMAIL_PORT}")
    private int emailPort;
    @Value("${WS_REGISTRY_CONFIG_EMAIL_USERNAME}")
    private String emailUserName;
    @Value("${WS_REGISTRY_CONFIG_EMAIL_PASSWORD}")
    private String emailPassword;
    @Value("${WS_REGISTRY_CONFIG_EMAIL_TRANSPORT_PROTOCOL}")
    private String emailTransportProtocol;
    @Value("${WS_REGISTRY_CONFIG_EMAIL_BOOLEAN_SMTP_AUTH}")
    private String emailBooleanSmtpAuth;
    @Value("${WS_REGISTRY_CONFIG_EMAIL_BOOLEAN_START_TLS}")
    private String emailBooleanStarttlsEnable;
    @Value("${WS_REGISTRY_CONFIG_EMAIL_BOOLEAN_DEBUG}")
    private String emailBooleanDebug;*/

    @Bean
    public PrefixRegistrationRequestValidatorStrategy validatorStrategy() {
        return sectedValidatorStrategy;
    }

    @Bean
    public PrefixRegistrationAgent getPrefixRegistrationAgent() {
        return prefixRegistrationAgent;
    }

/*
    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        // Host access configuration
        javaMailSender.setHost(emailHost);
        javaMailSender.setPort(emailPort);
        javaMailSender.setUsername(emailUserName);
        javaMailSender.setPassword(emailPassword);
        // Properties
        Properties properties = javaMailSender.getJavaMailProperties();
        properties.put("mail.transport.protocol", emailTransportProtocol);
        properties.put("mail.smtp.auth", emailBooleanSmtpAuth);
        properties.put("mail.smtp.starttls.enable", emailBooleanStarttlsEnable);
        properties.put("mail.debug", emailBooleanDebug);
        return javaMailSender;
    }
*/
}
