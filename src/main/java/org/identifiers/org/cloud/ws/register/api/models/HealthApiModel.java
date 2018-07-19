package org.identifiers.org.cloud.ws.register.api.models;

import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Project: register
 * Package: org.identifiers.org.cloud.ws.register.api.models
 * Timestamp: 2018-07-19 12:55
 *
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * ---
 */
@Component
public class HealthApiModel {
    private static String runningSessionId = UUID.randomUUID().toString();

    public String livenessCheck() {
        return runningSessionId;
    }

    // TODO - Refactor this to actually reflect whether the service ir ready or not
    public String readinessCheck() {
        return runningSessionId;
    }
}