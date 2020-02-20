package com.recruit.recruitment.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.recruit.recruitment.config.JwtConfig;
import com.recruit.recruitment.config.MailConfig;
import com.recruit.recruitment.config.RabbitMqConfig;
import com.recruit.recruitment.mapper.RoleMapper;
import com.recruit.recruitment.service.RoleService;
import com.recruit.recruitment.model.pojo.Role;
import com.recruit.recruitment.model.pojo.User;
import com.recruit.recruitment.mapper.UserMapper;
import com.recruit.recruitment.service.UserService;
import com.recruit.recruitment.utils.JwtTokenUtil;
import com.recruit.recruitment.utils.RandomUtil;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
@SuppressWarnings("NRServiceOrDaoClassShouldEndWithImpl")
public class UserServiceImpl implements UserDetailsService, UserService {
  @Autowired
  private UserMapper userMapper;

  @Autowired
  private RoleMapper roleMapper;

  @Autowired
  private RoleService roleService;

  @Autowired
  private BCryptPasswordEncoder encoder;

  @Autowired
  private JwtTokenUtil jwtTokenUtil;

  @Autowired
  private RandomUtil randomUtil;

  @Autowired
  private JwtConfig jwtConfig;

  @Autowired
  private HttpServletRequest request;

  @Autowired
  private RedisTemplate<String, String> redisTemplate;

  @Autowired
  private RabbitTemplate rabbitTemplate;

  @Override
  @Transactional(rollbackFor = Exception.class)
  public void register(User user) {
    final String username = user.getUsername();
    if (userMapper.selectByUsername(username) != null) {
      throw new RuntimeException("Username had been registered");
    }
    if (userMapper.selectByMail(user.getMail()) != null) {
      throw new RuntimeException("Mail had been registered");
    }

    List<Role> roles = new ArrayList<>(1);
    roles.add(roleService.findRoleByName("USER"));
    user.setRoles(roles); // user granted with USER authority

    final String rawpassword = user.getPassword();
    user.setPassword(encoder.encode(rawpassword));
    userMapper.insertSelective(user);
    for (Role role : roles) {
      roleMapper.insertUserRoles(user.getUserid(), role.getRoleid());
    }
  }

  @Override
  public Map login(User user) {
    User dbUser = userMapper.selectByUsername(user.getUsername());
    if (dbUser == null || !encoder.matches(user.getPassword(), dbUser.getPassword())) {
      throw new UsernameNotFoundException("Username or password error");
    }
    final UserDetails userDetails = this.loadUserByUsername(user.getUsername());
    final String token = jwtTokenUtil.generateToken(userDetails);
    Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
    List<String> roles = new ArrayList<>();
    for (GrantedAuthority authority : authorities) {
      roles.add(authority.getAuthority());
    }
    Map<String, Object> map = new HashMap<>(3);
    map.put("token", jwtConfig.getPrefix() + token);
    map.put("username", user.getUsername());
    map.put("roles", roles);
    // Store token into Redis
    redisTemplate.opsForValue().set(JwtConfig.REDIS_TOKEN_KEY_PREFIX + user.getUsername(),
      jwtConfig.getPrefix() + token, jwtConfig.getTime(), TimeUnit.SECONDS);
    return map;
  }

  @Override
  public void logout() {
    String username = jwtTokenUtil.getUsernameFromRequest(request);
    redisTemplate.delete(JwtConfig.REDIS_TOKEN_KEY_PREFIX + username);
  }

  @Override
  @Transactional(rollbackFor = Exception.class)
  public void updatePassword(String oldPassword, String newPassword) {
    String username = jwtTokenUtil.getUsernameFromRequest(request);
    User user = new User();
    user.setUsername(username);
    user = userMapper.selectByUsername(user.getUsername());
    if (!encoder.matches(oldPassword, user.getPassword())) {
      throw new RuntimeException("Invalid password");
    }
    user.setPassword(encoder.encode(newPassword));
    userMapper.updateByPrimaryKeySelective(user);
  }

  @Override
  public void forgetPassword(String userName, String mailCode, String newPassword) {
    User user = userMapper.selectByUsername(userName);
    if (user == null) {
      throw new RuntimeException("Invalid username");
    }
    if (!checkMailCode(user.getMail(), mailCode)) {
      throw new RuntimeException("Invalid mail code");
    }
    user.setPassword(encoder.encode(newPassword));
    // Update user password
    userMapper.updateByPrimaryKeySelective(user);
  }

  @Override
  public User findUser(Integer userid) {
    return userMapper.selectByPrimaryKey(userid);
  }

  @Override
  public List<User> findAllUsers(String orderby) {
    PageHelper.orderBy(orderby);
    return userMapper.selectAll();
  }

  @Override
  public int updateUser(User user) {
    return userMapper.updateByPrimaryKeySelective(user);
  }

  @Override
  public UserDetails loadUserByUsername(String username) {
    User user = userMapper.selectByUsername(username);
    List<SimpleGrantedAuthority> authorities = new ArrayList<>(1);
    List<Role> roles = roleMapper.selectUserRole(user.getUserid());
    for (Role role : roles) {
      authorities.add(new SimpleGrantedAuthority(role.getRolename()));
    }
    return new org.springframework.security.core.userdetails.User(user.getUsername(), "***********", authorities);
  }

  @Override
  public UserDetails loadUserByToken(String authHeader) {
    // Extract prefix, get token
    final String authToken = authHeader.substring(jwtConfig.getPrefix().length());
    String username = jwtTokenUtil.getUsernameFromToken(authToken);
    // Invalid token
    if (username == null) {
      return null;
    }
    String redisToken = redisTemplate.opsForValue().get(JwtConfig.REDIS_TOKEN_KEY_PREFIX + username);
    // Cannot get value from Redis or the value incompatible
    if (!authHeader.equals(redisToken)) {
      return null;
    }
    User user = new User();
    user.setUsername(username);
    List<String> roles = jwtTokenUtil.getRolesFromToken(authToken);
    List<SimpleGrantedAuthority> authorities = new ArrayList<>();
    for (String role : roles) {
      authorities.add(new SimpleGrantedAuthority(role));
    }
    return new org.springframework.security.core.userdetails.User(user.getUsername(), "***********", authorities);
  }

  @Override
  public boolean checkMailCode(String mail, String code) {
    String mailCode = getMailCodeFromRedis(mail);
    return code.equals(mailCode) ? true : false;
  }

  @Override
  public String getMailCodeFromRedis(String mail) {
    return redisTemplate.opsForValue().get(MailConfig.REDIS_MAIL_KEY_PREFIX + mail);
  }

  @Override
  public void sendMail(String mail) {
    Integer random = randomUtil.nextInt(100000, 999999);
    Map<String, String> map = new HashMap<>();
    String code = random.toString();
    map.put("mail", mail);
    map.put("code", code);
    redisTemplate.opsForValue().set(MailConfig.REDIS_MAIL_KEY_PREFIX + mail, code,
      MailConfig.EXPIRED_TIME, TimeUnit.MINUTES);
    rabbitTemplate.convertAndSend(RabbitMqConfig.MAIL_QUEUE, map);
  }
}
