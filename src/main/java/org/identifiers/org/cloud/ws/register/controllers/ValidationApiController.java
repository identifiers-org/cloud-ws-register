package org.identifiers.org.cloud.ws.register.controllers;

import org.identifiers.org.cloud.ws.register.models.ValidationApiModel;
import org.identifiers.org.cloud.ws.register.models.api.requests.validation.ServiceRequestValidateRegisterPrefixName;
import org.identifiers.org.cloud.ws.register.models.api.responses.validation.ServiceResponseValidateRegisterPrefixName;
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
 * Timestamp: 2018-03-08 6:15
 * ---
 */
@RestController
public class ValidationApiController {

    @Autowired
    private ValidationApiModel model;

    @RequestMapping(value = "/validateRegisterPrefixName", method = RequestMethod.POST)
    public ResponseEntity<?> validateRegisterPrefixName(@RequestBody ServiceRequestValidateRegisterPrefixName request) {
        ServiceResponseValidateRegisterPrefixName response = model.validateRegisterPrefixName(request);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }
}
