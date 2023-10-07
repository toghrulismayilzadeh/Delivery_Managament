package com.div.service;

import com.div.model.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JWTService {
    public String generateToken(UserDetails userDetails){
        return Jwts.builder().setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .signWith(getSiginKey(), SignatureAlgorithm.HS256)
                .compact();
    }
    public String extractUserName(String token){
        return extractClaim(token, Claims::getSubject);
    }
    public  <T> T extractClaim(String token, Function<Claims, T> claimsResolvers){
        final Claims claims = extracktAllClaim(token);
        return claimsResolvers.apply(claims);
    }
    public Claims extracktAllClaim(String token){
        return Jwts.parserBuilder().setSigningKey(getSiginKey()).build().parseClaimsJwt(token).getBody();
    }

    public Key getSiginKey() {
        byte[] key = Decoders.BASE64.decode("8e557245-73e2-4286-969a-ff57fe326336");
        return Keys.hmacShaKeyFor(key);
    }
    public boolean isTokenValid(String token,UserDetails userDetails){
        final String username= extractUserName(token);
        return (username.equals(userDetails.getUsername()) && isTokenExpired(token));
    }

    public boolean isTokenExpired(String token) {
        return extractClaim(token,Claims :: getExpiration).before(new Date());
    }

    public String generateRefreshToken(Map<String, Object> extraClaim, UserDetails userDetails) {
        return Jwts.builder().setClaims(extraClaim).setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 604800000))
                .signWith(getSiginKey(), SignatureAlgorithm.HS256)
                .compact();
    }
}
