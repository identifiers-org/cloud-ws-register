package org.identifiers.org.cloud.ws.register.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * Project: register
 * Package: org.identifiers.org.cloud.ws.register.models
 * Timestamp: 2018-01-30 17:03
 * ---
 */
// For this iteration, it is ok for this model to be a singleton
@Component
public class RegisterApiModel {
    private static Logger logger = LoggerFactory.getLogger(RegisterApiModel.class);

    public RegisterApiResponse registerPrefix(RegisterApiRequestRegisterPrefix request) {
        RegisterApiResponse response = new RegisterApiResponse();
        // TODO
        return response;
    }
}
