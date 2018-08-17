package org.identifiers.org.cloud.ws.register.api.requests.prefixregistration;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * Project: register
 * Package: org.identifiers.org.cloud.ws.register.api.requests.prefixregistration
 * Timestamp: 2018-08-17 15:01
 *
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * ---
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ServiceRequestCheckPrefixRegistrationStatusPayload implements Serializable {
    private String prefix;
    private String token;

    public String getPrefix() {
        return prefix;
    }

    public ServiceRequestCheckPrefixRegistrationStatusPayload setPrefix(String prefix) {
        this.prefix = prefix;
        return this;
    }

    public String getToken() {
        return token;
    }

    public ServiceRequestCheckPrefixRegistrationStatusPayload setToken(String token) {
        this.token = token;
        return this;
    }
}
