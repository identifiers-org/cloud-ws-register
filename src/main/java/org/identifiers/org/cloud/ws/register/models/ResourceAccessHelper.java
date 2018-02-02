package org.identifiers.org.cloud.ws.register.models;

import javax.validation.constraints.NotNull;

/**
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * Project: register
 * Package: org.identifiers.org.cloud.ws.register.models
 * Timestamp: 2018-02-02 10:00
 * ---
 */
public class ResourceAccessHelper {
    public static final String RESOURCE_ACCESS_RULE_PLACEHOLDER_ID = "{$id}";

    public static String getResourceUrlFor(@NotNull String accessRule, @NotNull String id) {
        return accessRule.replace(RESOURCE_ACCESS_RULE_PLACEHOLDER_ID, id);
    }
}
