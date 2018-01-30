package org.identifiers.org.cloud.ws.register.controllers;

import org.identifiers.org.cloud.ws.register.models.RegisterApiModel;
import org.springframework.beans.factory.annotation.Autowired;
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
}
