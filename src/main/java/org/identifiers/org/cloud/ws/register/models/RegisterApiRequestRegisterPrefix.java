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
}
