package com.github.cassiusbessa.vision.common.application.service;

import java.util.Date;
import java.util.UUID;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.stereotype.Component;

@Component
public class TokenService {

    private static final String SECRET = "your-secure-secret";
    private static final long EXPIRATION_TIME = 86400000L;

    public String generateToken(UUID accountId) {
        Algorithm algorithm = Algorithm.HMAC256(SECRET);
        return JWT.create()
                .withIssuer("auth0")
                .withClaim("accountId", accountId.toString())
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(algorithm);
    }

    public boolean validateToken(String token) {
        Algorithm algorithm = Algorithm.HMAC256(SECRET);
        try {
            JWT.require(algorithm).build().verify(token);
            return true;
        } catch (JWTVerificationException exception) {
            return false;
        }
    }

    public String getAccountId(String token) {
        return JWT.decode(token).getClaim("accountId").asString();
    }
}
