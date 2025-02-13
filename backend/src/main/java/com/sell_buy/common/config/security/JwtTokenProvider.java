package com.sell_buy.common.config.security;

import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Base64;

@Component
public class JwtTokenProvider {

    private final Key secretKey;
    private final Integer expireTime;

    public JwtTokenProvider(@Value("${jwt.secret}") String secretKey,
                            @Value("${jwt.expiration}") Integer expireTime) {
        byte[] decodedSecretKey = Base64.getDecoder().decode(secretKey);
        this.secretKey = Keys.hmacShaKeyFor(decodedSecretKey);
        this.expireTime = expireTime;
    }

    
}
