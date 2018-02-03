package org.identifiers.org.cloud.ws.register.configuration;

import org.identifiers.org.cloud.ws.register.models.PrefixRegistrationAgent;
import org.identifiers.org.cloud.ws.register.models.PrefixRegistrationAgentViaEmail;
import org.identifiers.org.cloud.ws.register.models.PrefixRegistrationRequestValidatorStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

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

    // E-mail subsystem configuration
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
    private String emailBooleanDebug;

    @Bean
    public PrefixRegistrationRequestValidatorStrategy validatorStrategy() {
        return sectedValidatorStrategy;
    }
    @Bean
    public PrefixRegistrationAgent prefixRegistrationAgent() {
        return new PrefixRegistrationAgentViaEmail();
    }

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
        
        return javaMailSender;
    }
}
