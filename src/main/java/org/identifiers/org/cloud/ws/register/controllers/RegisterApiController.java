package org.identifiers.org.cloud.ws.register.controllers;

import org.identifiers.org.cloud.ws.register.models.RegisterApiModel;
import org.identifiers.org.cloud.ws.register.models.api.requests.ServiceRequestRegisterPrefix;
import org.identifiers.org.cloud.ws.register.models.api.responses.ServiceResponseRegisterPrefix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * Project: register
 * Package: org.identifiers.org.cloud.ws.register.controllers
 * Timestamp: 2018-01-30 17:02
 * ---
 */
@RestController
public class RegisterApiController {

    @Autowired
    private RegisterApiModel registerApiModel;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<?> registerPrefix(@RequestBody ServiceRequestRegisterPrefix serviceRequestRegisterPrefixPayload) {
        // The model associated with the controller should handle any possible exception that could happen while running
        // the business logic, thus, the controller should handle only exceptions within the domain of the controller.
        ServiceResponseRegisterPrefix serviceResponseRegisterPrefix = registerApiModel.registerPrefix(serviceRequestRegisterPrefixPayload);
        return new ResponseEntity<>(serviceResponseRegisterPrefix, serviceResponseRegisterPrefix.getHttpStatus());
    }

    // liveness probe
    @RequestMapping(value = "/liveness_check")
    public String livenessCheck() {
        // TODO - This will be refactored out later, it will be the model who will implement the logic to determine
        // TODO - whether the service should be considered "alive" or not, but this code will live here for testing
        // TODO - purposes
        return registerApiModel.livenessCheck();
    }

    // Readiness check
    @RequestMapping(value = "/readiness_check")
    public String readinessCheck() {
        // TODO - This will be refactored out later, it will be the model who will implement the logic to determine
        // TODO - whether the service should be considered "ready" or not, but this code will live here for testing
        // TODO - purposes
        return registerApiModel.readinessCheck();
    }

}
