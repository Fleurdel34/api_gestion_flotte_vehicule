package fr.studi.transport.security.jwt;


import fr.studi.transport.security.service.UserDetailsImpl;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;




@Component
public class JwtUtils {

    @Value("${transport.jwtSecret}")
    private String jwtSecret;

    @Value("${transport.jwtExprationMs}")
    private int jwtExpirationInMs;

    public String generateToken(Authentication authentication){

        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();

        return Jwts.builder()
                .setSubject(userPrincipal.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() +jwtExpirationInMs))
                .signWith(key(), SignatureAlgorithm.HS256)
                .compact();

    }

    private Key key(){
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }

    public String getUsernameFromJwtToken(String token){
        return Jwts.parser()
                .setSigningKey(key()).build()
                .parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateJwtToken(String token){
        try {
            Jwts.parser()
                    .setSigningKey(key()).build().parse(token);
            return true;
        }catch (MalformedJwtException malformedJwtException) {
            System.out.println("Invalid JWT token:" + malformedJwtException.getMessage());
        }catch (ExpiredJwtException e){
            System.out.println("JWT token is expired:" + e.getMessage());
        }catch (UnsupportedJwtException exception){
            System.out.println("JWT token is unsupported:" + exception.getMessage());
        }catch(IllegalArgumentException illegalArgumentException){
            System.out.println("JWT claims string is empty:" + illegalArgumentException.getMessage());
        }
        return false;
    }
}
