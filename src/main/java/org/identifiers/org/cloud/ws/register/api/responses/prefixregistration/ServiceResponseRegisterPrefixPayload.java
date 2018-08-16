package org.identifiers.org.cloud.ws.register.api.responses.prefixregistration;

import java.io.Serializable;

/**
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * Project: register
 * Package: org.identifiers.org.cloud.ws.register.models.api.responses
 * Timestamp: 2018-03-08 5:42
 * ---
 */
public class ServiceResponseRegisterPrefixPayload implements Serializable {
    // Comments on the prefix registration request
    private String comment = "No comments on your prefix registration request";
    // This is an ephemeral token whose lifecycle is tight to the lifecycle of the prefix registration requests, so,
    // once the prefix registration has been solved, either rejected or accepted, this token is no longer valid.
    private String token = "";

    public String getComment() {
        return comment;
    }

    public ServiceResponseRegisterPrefixPayload setComment(String comment) {
        this.comment = comment;
        return this;
    }
}
