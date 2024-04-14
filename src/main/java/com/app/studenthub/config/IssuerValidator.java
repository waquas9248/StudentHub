package com.app.studenthub.config;

import org.springframework.security.oauth2.core.OAuth2Error;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2TokenValidatorResult;
import org.springframework.security.oauth2.jwt.Jwt;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class IssuerValidator implements OAuth2TokenValidator<Jwt> {
    // Base URL for constructing the expected issuer URL
    private static final String ISSUER_BASE_URL = "https://login.microsoftonline.com/";

    @Override
    public OAuth2TokenValidatorResult validate(Jwt jwt) {
        // Retrieve the tenant ID from the JWT's claims
        String tenantId = jwt.getClaimAsString("tid");
        // Construct the expected issuer URL
        String expectedIssuer = ISSUER_BASE_URL + tenantId + "/v2.0";

        byte[] expectedBytes = expectedIssuer.getBytes(StandardCharsets.UTF_8);
        byte[] actualBytes = jwt.getIssuer().toString().getBytes(StandardCharsets.UTF_8);

        if (Arrays.equals(expectedBytes, actualBytes)) {
            return OAuth2TokenValidatorResult.success();
        }


        // If they don't match, return a validation failure
        OAuth2Error error = new OAuth2Error("invalid_issuer", "Invalid issuer: " + jwt.getIssuer() + " was not equal to expected issuer " + expectedIssuer, null);
        return OAuth2TokenValidatorResult.failure(error);
    }
}
