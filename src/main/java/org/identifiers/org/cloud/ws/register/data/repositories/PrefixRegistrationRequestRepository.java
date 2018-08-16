package org.identifiers.org.cloud.ws.register.data.repositories;

import org.identifiers.org.cloud.ws.register.data.models.PrefixRegistrationRequest;
import org.springframework.data.repository.CrudRepository;

/**
 * Project: register
 * Package: org.identifiers.org.cloud.ws.register.data.repositories
 * Timestamp: 2018-08-16 14:20
 *
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * ---
 */
public interface PrefixRegistrationRequestRepository extends CrudRepository<PrefixRegistrationRequest, String> {
    //
}
