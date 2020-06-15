package com.reddit.clone.redditapi.config;

import com.reddit.clone.redditapi.model.User;
import io.jsonwebtoken.Jwts;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class JwtProvider {

    public String generateToken(Authentication authentication) {
       User principal = (User) authentication.getPrincipal();

       return Jwts.builder()
               .setSubject(principal.getUsername())
               .signWith(getPrivateKey())
               .compact();
;    }
}
