package org.identifiers.org.cloud.ws.register.api.controllers;

import org.identifiers.org.cloud.ws.register.api.models.RegisterApiModel;
import org.identifiers.org.cloud.ws.register.api.requests.prefixregistration.ServiceRequestCheckPrefixRegistrationStatus;
import org.identifiers.org.cloud.ws.register.api.requests.prefixregistration.ServiceRequestRegisterPrefix;
import org.identifiers.org.cloud.ws.register.api.responses.prefixregistration.ServiceResponseCheckPrefixRegistrationStatus;
import org.identifiers.org.cloud.ws.register.api.responses.prefixregistration.ServiceResponseRegisterPrefix;
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
    public ResponseEntity<?> registerPrefix(@RequestBody ServiceRequestRegisterPrefix request) {
        // The model associated with the controller should handle any possible exception that could happen while running
        // the business logic, thus, the controller should handle only exceptions within the domain of the controller.
        ServiceResponseRegisterPrefix serviceResponseRegisterPrefix = registerApiModel.registerPrefix(request);
        return new ResponseEntity<>(serviceResponseRegisterPrefix, serviceResponseRegisterPrefix.getHttpStatus());
    }

    @RequestMapping(value="/check_prefix_registration_status", method = RequestMethod.POST)
    public ResponseEntity<?> checkPrefixRegistrationStatus(@RequestBody ServiceRequestCheckPrefixRegistrationStatus request) {
        ServiceResponseCheckPrefixRegistrationStatus response = registerApiModel.checkPrefixRegistrationStatus(request);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }

}
