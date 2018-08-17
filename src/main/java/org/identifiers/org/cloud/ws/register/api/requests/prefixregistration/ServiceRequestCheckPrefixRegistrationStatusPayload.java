package org.identifiers.org.cloud.ws.register.api.requests.prefixregistration;

/**
 * Project: register
 * Package: org.identifiers.org.cloud.ws.register.api.requests.prefixregistration
 * Timestamp: 2018-08-17 15:01
 *
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * ---
 */
public class ServiceRequestCheckPrefixRegistrationStatusPayload {
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
