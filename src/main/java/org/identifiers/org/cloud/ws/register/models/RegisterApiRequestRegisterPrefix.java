package org.identifiers.org.cloud.ws.register.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * Project: register
 * Package: org.identifiers.org.cloud.ws.register.models
 * Timestamp: 2018-01-30 17:47
 * ---
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegisterApiRequestRegisterPrefix implements Serializable {
    private String name;
    private String description;
    private String homePage;
    private String organization;
    private String preferredPrefix;
    private String resourceAccessRule;
    private String exampleIdentifier;
    private String regexPattern;
    private String[] references;
    private String additionalInformation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHomePage() {
        return homePage;
    }

    public void setHomePage(String homePage) {
        this.homePage = homePage;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getPreferredPrefix() {
        return preferredPrefix;
    }

    public void setPreferredPrefix(String preferredPrefix) {
        this.preferredPrefix = preferredPrefix;
    }

    public String getResourceAccessRule() {
        return resourceAccessRule;
    }

    public void setResourceAccessRule(String resourceAccessRule) {
        this.resourceAccessRule = resourceAccessRule;
    }

    public String getExampleIdentifier() {
        return exampleIdentifier;
    }

    public void setExampleIdentifier(String exampleIdentifier) {
        this.exampleIdentifier = exampleIdentifier;
    }

    public String getRegexPattern() {
        return regexPattern;
    }

    public void setRegexPattern(String regexPattern) {
        this.regexPattern = regexPattern;
    }

    public String[] getReferences() {
        return references;
    }

    public void setReferences(String[] references) {
        this.references = references;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }
}
