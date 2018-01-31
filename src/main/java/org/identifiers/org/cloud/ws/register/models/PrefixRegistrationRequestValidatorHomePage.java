package org.identifiers.org.cloud.ws.register.models;

import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * Project: register
 * Package: org.identifiers.org.cloud.ws.register.models
 * Timestamp: 2018-01-31 10:52
 * ---
 */
public class PrefixRegistrationRequestValidatorHomePage implements PrefixRegistrationRequestValidator {

    @Autowired
    private WebPageChecker webPageChecker;

    @Override
    public boolean validate(RegisterApiRequestRegisterPrefix request) throws PrefixRegistrationRequestValidatorException {
        // TODO - Refactor this code out as a URL checker
        // Home Page URL for the resource is required
        if (request.getHomePage() == null) {
            throw new PrefixRegistrationRequestValidatorException("MISSING URL describing the resource");
        }
        // Check for invalid URL
        if (!(new UrlValidator()).isValid(request.getHomePage())) {
            throw new PrefixRegistrationRequestValidatorException(String.format("Home Page URL '%s' is NOT VALID", request.getHomePage()));
        }
        // Detect Dead home page by accessing it and making sure we get an HTTP 200 OK, in the future, more complex
        // checkers can be externalized, and pack as dead home page detection strategies
        int status = 0;
        try {
            // TODO - Add a re-try policy for when we try to connect the URL
            URL testUrl = new URL(request.getHomePage());
            HttpURLConnection connection = (HttpURLConnection) testUrl.openConnection();
            connection.setRequestMethod("GET");
            // TODO - Refactor this out as constants
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            status = connection.getResponseCode();
            connection.disconnect();
        } catch (IOException e) {
            // Including MalformedURLException
            throw new PrefixRegistrationRequestValidatorException(String.format("When checking your home page, '%s', the following error occurred '%s'", request.getHomePage(), e.getMessage()));
        }
        if (HttpStatus.valueOf(status) != HttpStatus.OK) {
            throw new PrefixRegistrationRequestValidatorException(String.format("When checking your home page at '%s', we got the following HTTP Status Code %d", request.getHomePage(), status));
        }
        return true;
    }
}
