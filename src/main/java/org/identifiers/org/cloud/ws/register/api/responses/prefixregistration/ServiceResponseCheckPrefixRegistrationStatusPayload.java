package org.identifiers.org.cloud.ws.register.api.responses.prefixregistration;

import java.io.Serializable;

/**
 * Project: register
 * Package: org.identifiers.org.cloud.ws.register.api.responses.prefixregistration
 * Timestamp: 2018-08-17 15:04
 *
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * ---
 */
public class ServiceResponseCheckPrefixRegistrationStatusPayload implements Serializable {
    private String message;
    private String prefix;
    private String status;
    private String requestedTimestamp;

    public String getMessage() {
        return message;
    }

    public ServiceResponseCheckPrefixRegistrationStatusPayload setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getPrefix() {
        return prefix;
    }

    public ServiceResponseCheckPrefixRegistrationStatusPayload setPrefix(String prefix) {
        this.prefix = prefix;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public ServiceResponseCheckPrefixRegistrationStatusPayload setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getRequestedTimestamp() {
        return requestedTimestamp;
    }

    public ServiceResponseCheckPrefixRegistrationStatusPayload setRequestedTimestamp(String requestedTimestamp) {
        this.requestedTimestamp = requestedTimestamp;
        return this;
    }
}
