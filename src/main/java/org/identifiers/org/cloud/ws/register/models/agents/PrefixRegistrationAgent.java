package org.identifiers.org.cloud.ws.register.models.agents;

import org.identifiers.org.cloud.ws.register.models.api.requests.prefixregistration.ServiceRequestRegisterPrefixPayload;

/**
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * Project: register
 * Package: org.identifiers.org.cloud.ws.register.models
 * Timestamp: 2018-01-30 23:08
 * ---
 */
public interface PrefixRegistrationAgent {
    void registerPrefix(ServiceRequestRegisterPrefixPayload prefixRegistrationRequest) throws PrefixRegistrationAgentException;
}
