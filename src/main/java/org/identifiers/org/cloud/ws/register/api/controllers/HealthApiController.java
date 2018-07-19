package org.identifiers.org.cloud.ws.register.api.controllers;

import org.identifiers.org.cloud.ws.register.api.models.HealthApiModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Project: register
 * Package: org.identifiers.org.cloud.ws.register.api.controllers
 * Timestamp: 2018-07-19 12:56
 *
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * ---
 */
@RestController
public class HealthApiController {
    @Autowired
    private HealthApiModel model;

    // liveness probe
    @RequestMapping(value = "/liveness_check")
    public String livenessCheck() {
        return model.livenessCheck();
    }

    // Readiness check
    @RequestMapping(value = "/readiness_check")
    public String readinessCheck() {
        return model.readinessCheck();
    }
}
