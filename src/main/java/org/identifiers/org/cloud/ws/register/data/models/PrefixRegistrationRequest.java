package org.identifiers.org.cloud.ws.register.data.models;

import org.identifiers.org.cloud.ws.register.data.configuration.PrefixRegistrationRequestConfig;
import org.identifiers.org.cloud.ws.register.models.Requester;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

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
    @Id private String id;
    private String name = "";
    private String description = "";
    private String homePage = "";
    private String organization = "";
    @Indexed private String preferredPrefix = "";
    private String resourceAccessRule = "";
    private String exampleIdentifier = "";
    private String regexPattern = "";
    private String[] references = {""};
    private String additionalInformation = "";
    private Requester requester;
    // Management
    @Indexed private String token = "";
    private Long timeToLeave = PrefixRegistrationRequestConfig.timeToLive;
    @Indexed private String timestamp = (new Timestamp(new Date().getTime())).toString();

    public Timestamp getTimestamp() {
        return Timestamp.valueOf(timestamp);
    }

    public PrefixRegistrationRequest setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp.toString();
        return this;
    }


}
