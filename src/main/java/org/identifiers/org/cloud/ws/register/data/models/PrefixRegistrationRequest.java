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

    public String getId() {
        return id;
    }

    public PrefixRegistrationRequest setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public PrefixRegistrationRequest setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public PrefixRegistrationRequest setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getHomePage() {
        return homePage;
    }

    public PrefixRegistrationRequest setHomePage(String homePage) {
        this.homePage = homePage;
        return this;
    }

    public String getOrganization() {
        return organization;
    }

    public PrefixRegistrationRequest setOrganization(String organization) {
        this.organization = organization;
        return this;
    }

    public String getPreferredPrefix() {
        return preferredPrefix;
    }

    public PrefixRegistrationRequest setPreferredPrefix(String preferredPrefix) {
        this.preferredPrefix = preferredPrefix;
        return this;
    }

    public String getResourceAccessRule() {
        return resourceAccessRule;
    }

    public PrefixRegistrationRequest setResourceAccessRule(String resourceAccessRule) {
        this.resourceAccessRule = resourceAccessRule;
        return this;
    }

    public String getExampleIdentifier() {
        return exampleIdentifier;
    }

    public PrefixRegistrationRequest setExampleIdentifier(String exampleIdentifier) {
        this.exampleIdentifier = exampleIdentifier;
        return this;
    }

    public String getRegexPattern() {
        return regexPattern;
    }

    public PrefixRegistrationRequest setRegexPattern(String regexPattern) {
        this.regexPattern = regexPattern;
        return this;
    }

    public String[] getReferences() {
        return references;
    }

    public PrefixRegistrationRequest setReferences(String[] references) {
        this.references = references;
        return this;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public PrefixRegistrationRequest setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
        return this;
    }

    public Requester getRequester() {
        return requester;
    }

    public PrefixRegistrationRequest setRequester(Requester requester) {
        this.requester = requester;
        return this;
    }

    public String getToken() {
        return token;
    }

    public PrefixRegistrationRequest setToken(String token) {
        this.token = token;
        return this;
    }

    public Long getTimeToLeave() {
        return timeToLeave;
    }

    public PrefixRegistrationRequest setTimeToLeave(Long timeToLeave) {
        this.timeToLeave = timeToLeave;
        return this;
    }
}
