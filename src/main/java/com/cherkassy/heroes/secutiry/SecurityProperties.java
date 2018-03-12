package com.cherkassy.heroes.secutiry;

import lombok.Data;

@Data
public class SecurityProperties {
    private String secret = "SecretKeyToGenJWTs";
    private long expirationTime = 864_000_000; // 10 days
    private String tokenPrefix = "Bearer ";
    private String headerString = "Authorization";
}