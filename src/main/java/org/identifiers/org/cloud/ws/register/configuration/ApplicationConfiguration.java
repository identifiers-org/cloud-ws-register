package org.identifiers.org.cloud.ws.register.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisKeyValueAdapter;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

/**
 * Project: register
 * Package: org.identifiers.org.cloud.ws.register.configuration
 * Timestamp: 2018-08-16 12:14
 *
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * ---
 */
@Configuration
@EnableRedisRepositories(enableKeyspaceEvents = RedisKeyValueAdapter.EnableKeyspaceEvents.ON_STARTUP)
public class ApplicationConfiguration {
    
}
