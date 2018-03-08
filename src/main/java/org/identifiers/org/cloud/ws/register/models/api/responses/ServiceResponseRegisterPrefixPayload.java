package org.identifiers.org.cloud.ws.register.models.api.responses;

import java.io.Serializable;

/**
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * Project: register
 * Package: org.identifiers.org.cloud.ws.register.models.api.responses
 * Timestamp: 2018-03-08 5:42
 * ---
 */
public class ServiceResponseRegisterPrefixPayload implements Serializable {
    private String comment = "No comments on your prefix registration request";

    public String getComment() {
        return comment;
    }

    public ServiceResponseRegisterPrefixPayload setComment(String comment) {
        this.comment = comment;
        return this;
    }
}
