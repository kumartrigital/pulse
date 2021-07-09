package com.gss.pulseworkflow.oauth.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import com.gss.pulseworkflow.model.PulseUser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * @author saurkumar
 *
 */
@Service
public class TokenService {

    @Value("${external.jwt.secret_key}")
    private String secret;

    @Autowired
    private PulseEncryption encryption;
    private int expirayDelay = 10000;
    private static final String SEPARATOR = ",";

    public String createToken(PulseUser user) {
        return Jwts.builder().setClaims(buildClaim(user)).signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    public PulseUser parseToken(String token) {
        PulseUser user = null;
        if(token==null || token.trim().length()<1) {
        	return null;
        }
        try {
            Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(encryption.decrypt(token, secret)).getBody();
            user = parseClaims(claims);
            user.setToken(token);
        } catch (Exception ex) {
            throw new RuntimeException("Token is not valid");
        }
        return user;
    }
    
    public String buildTokenHash(String token)  {
        String tokenHash = encryption.encrypt(token, secret);
        System.out.println(tokenHash);
        return tokenHash;
    }

    private Claims buildClaim(PulseUser user) {
        Claims claims = Jwts.claims();
        claims.setSubject(user.getUsername());
        claims.setExpiration(getExpirationDate());
        claims.put("userId", user.getUserId());
        claims.put("accessToken",  user.getAccessToken());
        claims.put("refreshToken", user.getRefreshToken());
        claims.put("expiresIn", user.getExpiresIn());
        claims.put("logout", user.getLogoutToken());
        claims.put("email", user.getEmailId());
        claims.put("fullName", user.getFullName());
        addRoles(claims, user.getAuthorities());
        return claims;
    }

    private PulseUser parseClaims(Claims claims) {
        PulseUser user = null;
        if (claims != null) {
            String username = claims.getSubject();
            String roles = (String) claims.get("roles");
            Collection<GrantedAuthority> authorities = new ArrayList<>();
            if (roles != null) {
                String[] splitedRoles = roles.split(SEPARATOR);
                for (String role : splitedRoles) {
                    authorities.add(new SimpleGrantedAuthority(role));
                }
            }
            user = new PulseUser(username, "", authorities);
            user.setUserId(claims.get("userId") == null? null :String.valueOf(claims.get("userId")));
            user.setAccessToken(String.valueOf(claims.get("accessToken")));
            user.setRefreshToken(String.valueOf(claims.get("refreshToken")));
            user.setExpiresIn(String.valueOf(claims.get("expiresIn")));
            user.setLogoutToken(claims.get("logout")== null ? null : String.valueOf(claims.get("logout")));
            user.setEmailId(claims.get("email")== null ? null : String.valueOf(claims.get("email")));
            user.setFullName(claims.get("fullName")== null ? null : String.valueOf(claims.get("fullName")));

        }
        return user;
    }

    private void addRoles(Claims claims, Collection<? extends GrantedAuthority> authoriteis) {
        if (authoriteis != null && !authoriteis.isEmpty()) {
            StringBuilder builder = new StringBuilder();
            for (GrantedAuthority authority : authoriteis) {
                if (builder.length() > 0) {
                    builder.append(SEPARATOR);
                }
                builder.append(authority.getAuthority());
            }
            claims.put("roles", builder.toString());
        }
    }

    private Date getExpirationDate() {
        Calendar calc = Calendar.getInstance();
        calc.add(Calendar.MINUTE, expirayDelay);
        return calc.getTime();
    }
}