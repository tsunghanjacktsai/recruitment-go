package com.recruit.recruitment.utils;

import com.recruit.recruitment.config.JwtConfig;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.*;

/**
 * The util for jwt
 */
@Component
public class JwtTokenUtil implements Serializable {
  private static final long Serial_Version_UID = -5625635588908941275L;
  private static final String CLAIM_KEY_USERNAME = "sub";
  private static final String CLAIM_KEY_CREATED = "created";
  private static final String CLAIM_KEY_ROLES = "roles";

  @Autowired
  private JwtConfig jwtConfig;

  /**
   * Get username from request
   *
   * @param request
   * @return
   */
  public String getUsernameFromRequest(HttpServletRequest request) {
    String token = request.getHeader(jwtConfig.getHeader());
    token = token.substring(jwtConfig.getPrefix().length());
    return token == null ? null : getUsernameFromToken(token);
  }

  /**
   * Get username from token
   *
   * @param token
   * @return
   */
  public String getUsernameFromToken(String token) {
    String username;
    try {
      final Claims claims = getClaimsFromToken(token);
      username = claims.getSubject();
    } catch (Exception e) {
      username = null;
    }
    return username;
  }

  private Claims getClaimsFromToken(String token) {
    Claims claims;
    try {
      claims = Jwts.parser().setSigningKey(jwtConfig.
        getSecret()).
        parseClaimsJws(token).
        getBody();
    } catch (Exception e) {
      claims = null;
    }
    return claims;
  }

  /**
   * Get created date from token
   *
   * @param token
   * @return
   */
  public Date getCreatedDateFromToken(String token) {
    Date created;
    try {
      final Claims claims = getClaimsFromToken(token);
      created = new Date((Long)claims.get(CLAIM_KEY_CREATED));
    } catch (Exception e) {
      created = null;
    }
    return created;
  }

  /**
   * Get expiration date from token
   *
   * @param token
   * @return
   */
  public Date getExpirationDateFromToken(String token) {
    Date expiration;
    try {
      final Claims claims = getClaimsFromToken(token);
      expiration = claims.getExpiration();
    } catch (Exception e) {
      expiration = null;
    }
    return expiration;
  }

  /**
   * Generate expiration date (ms)
   *
   * @return
   */
  private Date generateExpirationDate() {
    return new Date(System.currentTimeMillis() + jwtConfig.getTime() * 1000);
  }

  /**
   * Check if token is expired
   *
   * @param token
   * @return
   */
  public Boolean isTokenExpired(String token) {
    final Date expiration = getExpirationDateFromToken(token);
    boolean isExpired = expiration.before(new Date());
    return isExpired;
  }

  /**
   * Generate token
   *
   * @param userDetails
   * @return
   */
  public String generateToken(UserDetails userDetails) {
    Map<String, Object> claims = new HashMap<>();
    claims.put(CLAIM_KEY_USERNAME, userDetails.getUsername());
    claims.put(CLAIM_KEY_CREATED, new Date()); // token created time
    List<String> roles = new ArrayList<>();
    Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
    for (GrantedAuthority authority : authorities) {
      roles.add(authority.getAuthority());
    }
    claims.put(CLAIM_KEY_ROLES, roles); // user roles
    return generateToken(claims);
  }

  private String generateToken(Map<String, Object> claims) {
    return Jwts.builder().
      setClaims(claims).
      setExpiration(generateExpirationDate()).
      signWith(SignatureAlgorithm.HS512, jwtConfig.getSecret()).
      compact();
  }

  public Boolean canTokenBeRefreshed(String token) {
    return !isTokenExpired(token);
  }

  public String refreshToken(String token) {
    String refreshedToken;
    try {
      final Claims claims = getClaimsFromToken(token);
      claims.put(CLAIM_KEY_CREATED, new Date());
      refreshedToken = generateToken(claims);
    } catch (Exception e) {
      refreshedToken = null;
    }
    return refreshedToken;
  }

  /**
   * Validate token
   *
   * @param token
   * @param userDetails
   * @return
   */
  public Boolean validateToken(String token, UserDetails userDetails) {
    final String username = getUsernameFromToken(token);
    return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
  }

  public List<String> getRolesFromToken(String authToken) {
    List<String> roles;
    try {
      final Claims claims = getClaimsFromToken(authToken);
      roles = (List<String>) claims.get(CLAIM_KEY_ROLES);
    } catch (Exception e) {
      roles = null;
    }
    return roles;
  }
}
