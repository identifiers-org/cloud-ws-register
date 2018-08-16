package org.identifiers.org.cloud.ws.register.data.models;

import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

/**
 * Project: register
 * Package: org.identifiers.org.cloud.ws.register.data.models
 * Timestamp: 2018-08-16 12:02
 *
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * ---
 */
@RedisHash("RegistryPrefixRegistrationRequest")
public class PrefixRegistrationRequest implements Serializable {
}
