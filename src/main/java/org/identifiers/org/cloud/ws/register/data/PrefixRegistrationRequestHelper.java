package org.identifiers.org.cloud.ws.register.data;

import org.identifiers.org.cloud.ws.register.api.requests.prefixregistration.ServiceRequestRegisterPrefix;
import org.identifiers.org.cloud.ws.register.data.models.PrefixRegistrationRequest;

/**
 * Project: register
 * Package: org.identifiers.org.cloud.ws.register.data
 * Timestamp: 2018-08-17 9:18
 *
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * ---
 *
 * This class implements several helper methods for model transformation within what it could be considered as a kind of
 * factory methods.
 */
public class PrefixRegistrationRequestHelper {
    public static PrefixRegistrationRequest getPrefixRegistrationRequestFrom(ServiceRequestRegisterPrefix request) {
        // TODO
        return new PrefixRegistrationRequest()
                .setName(request.getPayload().getName())
                .setDescription(request.getPayload().getDescription())
                .setHomePage(request.getPayload().getHomePage())
                .setOrganization(request.getPayload().getOrganization())
                .setPreferredPrefix(request.getPayload().getPreferredPrefix())
                .setResourceAccessRule(request.getPayload().getResourceAccessRule())
                .setExampleIdentifier(request.getPayload().getExampleIdentifier())
                .setRegexPattern(request.getPayload().getRegexPattern())
                .setReferences(request.getPayload().getReferences())
                .setAdditionalInformation(request.getPayload().getAdditionalInformation())
                .setRequester(request.getPayload().getRequester());
    }
}
