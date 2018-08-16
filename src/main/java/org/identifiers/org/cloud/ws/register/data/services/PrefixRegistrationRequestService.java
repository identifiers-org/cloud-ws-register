package org.identifiers.org.cloud.ws.register.data.services;

import org.identifiers.org.cloud.ws.register.data.repositories.PrefixRegistrationRequestRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Project: register
 * Package: org.identifiers.org.cloud.ws.register.data.services
 * Timestamp: 2018-08-16 14:21
 *
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * ---
 */
@Component
public class PrefixRegistrationRequestService {
    private static final Logger logger = LoggerFactory.getLogger(PrefixRegistrationRequestService.class);

    @Autowired
    private PrefixRegistrationRequestRepository repository;
    // TODO
}
