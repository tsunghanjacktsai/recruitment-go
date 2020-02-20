package com.recruit.recruitment.filter;

import com.recruit.recruitment.config.JwtConfig;
import com.recruit.recruitment.config.RedisConfig;
import com.recruit.recruitment.controller.ErrorController;
import com.recruit.recruitment.service.UserService;
import com.recruit.recruitment.utils.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class JwtTokenFilter extends OncePerRequestFilter {
  @Autowired
  private UserService userService;

  @Autowired
  private RequestUtil requestUtil;

  @Autowired
  private RedisTemplate<String, String> redisTemplate;

  @Autowired
  private JwtConfig jwtConfig;

  /**
   * Max frequency limit of requests in a range of time
   */
  private static final int LIMIT_REQUEST_FREQUENCY_COUNT = 8;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
    throws ServletException, IOException {
    String ipAddress = requestUtil.getIpAddress(request);
    String redisKey = RedisConfig.REDIS_IP_PREFIX + ipAddress;
    if (redisTemplate.hasKey(redisKey)) {
      String value = redisTemplate.opsForValue().get(redisKey);
      Integer count = Integer.parseInt(value);
      if (count > JwtTokenFilter.LIMIT_REQUEST_FREQUENCY_COUNT) {
        request.getRequestDispatcher(ErrorController.FREQUENT_OPERATION).forward(request, response);
        return;
      } else {
        count++;
        redisTemplate.opsForValue().set(redisKey, "1", RedisConfig.REDIS_LIMIT_REQUEST_FREQUENCY_TIME,
          TimeUnit.MILLISECONDS);

      }
    } else {
      redisTemplate.opsForValue().set(redisKey, "1", RedisConfig.REDIS_LIMIT_REQUEST_FREQUENCY_TIME,
        TimeUnit.MILLISECONDS);
    }
    validatePermission(request, response, chain);
  }

  /**
   * Validate permission
   *
   * @param request
   * @param response
   * @param chain
   */
  private void validatePermission(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
    throws IOException, ServletException {
    boolean giveFlag = false;
    String authHeader = request.getHeader(jwtConfig.getHeader());
    if (authHeader != null && authHeader.startsWith(jwtConfig.getPrefix())) {
      UserDetails userDetails = userService.loadUserByToken(authHeader);
      if (null != userDetails) {
        // If the request passes validation
        if (SecurityContextHolder.getContext().getAuthentication() == null) {
          UsernamePasswordAuthenticationToken authentication =
            new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
          authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
          SecurityContextHolder.getContext().setAuthentication(authentication);
        }
      } else {
        giveFlag = true;
      }
    } else {
      // Token validation failed
      giveFlag = true;
    }
    if (giveFlag) {
      // Token validation failed, granted as visitor authority (roles are not entered in roles table)
      List<SimpleGrantedAuthority> authorities = new ArrayList<>();
      authorities.add(new SimpleGrantedAuthority("NORMAL"));
      // Propose identity
      User user = new User("NORMAL", "NORMAL", authorities);
      UsernamePasswordAuthenticationToken authentication =
        new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
      // Granted authority
      SecurityContextHolder.getContext().setAuthentication(authentication);
    }
    chain.doFilter(request, response);
  }
}
