package org.identifiers.org.cloud.ws.register.controllers;

import org.identifiers.org.cloud.ws.register.models.ValidationApiModel;
import org.identifiers.org.cloud.ws.register.models.api.requests.validation.ServiceRequestValidate;
import org.identifiers.org.cloud.ws.register.models.api.responses.validation.ServiceResponseValidateRequest;
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
    public ResponseEntity<?> validateRegisterPrefixName(@RequestBody ServiceRequestValidate request) {
        ServiceResponseValidateRequest response = model.validateRegisterPrefixName(request);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }

    @RequestMapping(value = "/validateRegisterPrefixDescription", method = RequestMethod.POST)
    public ResponseEntity<?> validateRegisterPrefixDescription(@RequestBody ServiceRequestValidate request) {
        ServiceResponseValidateRequest response = model.validateRegisterPrefixDescription(request);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }
    @RequestMapping(value = "/validateRegisterPrefixHomePage", method = RequestMethod.POST)
    public ResponseEntity<?> validateRegisterPrefixHomePage(@RequestBody ServiceRequestValidate request) {
        ServiceResponseValidateRequest response = model.validateRegisterPrefixHomePage(request);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }

    @RequestMapping(value = "/validateRegisterPrefixOrganization", method = RequestMethod.POST)
    public ResponseEntity<?> validateRegisterPrefixOrganization(@RequestBody ServiceRequestValidate request) {
        ServiceResponseValidateRequest response = model.validateRegisterPrefixOrganization(request);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }

    @RequestMapping(value = "/validateRegisterPrefixPreferredPrefix", method = RequestMethod.POST)
    public ResponseEntity<?> validateRegisterPrefixPreferredPrefix(@RequestBody ServiceRequestValidate request) {
        ServiceResponseValidateRequest response = model.validateRegisterPrefixPreferredPrefix(request);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }
    @RequestMapping(value = "/validateRegisterPrefixResourceAccessRule", method = RequestMethod.POST)
    public ResponseEntity<?> validateRegisterPrefixResourceAccessRule(@RequestBody ServiceRequestValidate request) {
        ServiceResponseValidateRequest response = model.validateRegisterPrefixResourceAccessRule(request);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }
    @RequestMapping(value = "/validateRegisterPrefixExampleIdentifier", method = RequestMethod.POST)
    public ResponseEntity<?> validateRegisterPrefixExampleIdentifier(@RequestBody ServiceRequestValidate request) {
        ServiceResponseValidateRequest response = model.validateRegisterPrefixExampleIdentifier(request);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }
    @RequestMapping(value = "/validateRegisterPrefixRegexPattern", method = RequestMethod.POST)
    public ResponseEntity<?> validateRegisterPrefixRegexPattern(@RequestBody ServiceRequestValidate request) {
        ServiceResponseValidateRequest response = model.validateRegisterPrefixRegexPattern(request);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }
    @RequestMapping(value = "/validateRegisterPrefixReferences", method = RequestMethod.POST)
    public ResponseEntity<?> validateRegisterPrefixReferences(@RequestBody ServiceRequestValidate request) {
        ServiceResponseValidateRequest response = model.validateRegisterPrefixReferences(request);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }
    @RequestMapping(value = "/validateRegisterPrefixAdditionalInformation", method = RequestMethod.POST)
    public ResponseEntity<?> validateRegisterPrefixAdditionalInformation(@RequestBody ServiceRequestValidate request) {
        ServiceResponseValidateRequest response = model.validateRegisterPrefixAdditionalInformation(request);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }
    @RequestMapping(value = "/validateRegisterPrefixRequester", method = RequestMethod.POST)
    public ResponseEntity<?> validateRegisterPrefixRequester(@RequestBody ServiceRequestValidate request) {
        ServiceResponseValidateRequest response = model.validateRegisterPrefixRequester(request);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }
}
