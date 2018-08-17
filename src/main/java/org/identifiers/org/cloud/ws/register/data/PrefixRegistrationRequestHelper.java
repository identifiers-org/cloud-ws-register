package org.identifiers.org.cloud.ws.register.data;

import org.identifiers.org.cloud.ws.register.api.requests.prefixregistration.ServiceRequestRegisterPrefixPayload;
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
    public static PrefixRegistrationRequest getPrefixRegistrationRequestFrom(ServiceRequestRegisterPrefixPayload requestModel) {
        // TODO
        return new PrefixRegistrationRequest()
                .setName(requestModel.getName())
                .setDescription(requestModel.getDescription())
                .setHomePage(requestModel.getHomePage())
                .setOrganization(requestModel.getOrganization())
                .setPreferredPrefix(requestModel.getPreferredPrefix())
                .setResourceAccessRule(requestModel.getResourceAccessRule())
                .setExampleIdentifier(requestModel.getExampleIdentifier())
                .setRegexPattern(requestModel.getRegexPattern())
                .setReferences(requestModel.getReferences())
                .setAdditionalInformation(requestModel.getAdditionalInformation())
                .setRequester(requestModel.getRequester());
    }
}
