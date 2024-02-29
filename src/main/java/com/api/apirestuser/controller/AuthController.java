package com.api.apirestuser.controller;

import com.api.apirestuser.utils.UserCredentials;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Key;
import java.util.Date;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS512);

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@RequestBody UserCredentials credentials) {

        if ("user".equals(credentials.getUsername()) && "001bciusertoken".equals(credentials.getPassword())) {

            String token = Jwts.builder()
                    .setSubject(credentials.getUsername())
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + 86400000))
                    .signWith(SECRET_KEY, SignatureAlgorithm.HS512)
                    .compact();


            TokenResponse tokenResponse = new TokenResponse(token);
            return ResponseEntity.ok(tokenResponse);
        } else {

            return ResponseEntity.status(401).body(new TokenResponse(null));
        }
    }


    public static class TokenResponse {
        private final String token;

        public TokenResponse(String token) {
            this.token = token;
        }

        public String getToken() {
            return token;
        }
    }


}
