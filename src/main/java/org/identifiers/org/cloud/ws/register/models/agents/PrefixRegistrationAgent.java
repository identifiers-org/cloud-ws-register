package org.identifiers.org.cloud.ws.register.models.agents;

import org.identifiers.org.cloud.ws.register.data.models.PrefixRegistrationRequest;

/**
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * Project: register
 * Package: org.identifiers.org.cloud.ws.register.models
 * Timestamp: 2018-01-30 23:08
 * ---
 */
public interface PrefixRegistrationAgent {
    void registerPrefix(PrefixRegistrationRequest prefixRegistrationRequest) throws PrefixRegistrationAgentException;
}
