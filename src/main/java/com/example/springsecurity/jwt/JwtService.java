package com.example.springsecurity.jwt;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;

@Service
public class JwtService {


    private String secretkey = "";

    public String generatetoken(String username) {

        HashMap<String , Object> claims = new HashMap<>();
        return Jwts.builder()
                .claims()
                .add(claims)
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() +  60 * 60 *10))
                .and()
                .signWith(getKey())
                .compact();
    }

    public Key getKey(){
        byte[] keybytes = Decoders.BASE64.decode(secretkey)
        return Keys.hmacShaKeyFor(keybytes);
    }
}
