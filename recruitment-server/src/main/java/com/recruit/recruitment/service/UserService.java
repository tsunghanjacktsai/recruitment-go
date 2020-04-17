package com.recruit.recruitment.service;

import com.recruit.recruitment.model.pojo.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Map;

public interface UserService {
  /**
   * Registration
   *
   * @param user
   * @return
   */
  void register(User user);

  /**
   * Login
   *
   * @param user
   * @return
   */
  Map login(User user);

  /**
   * Logout
   */
  void logout();

  /**
   * Update password
   *
   * @param oldPassword
   * @param newPassword
   * @param code
   */
  void changePassword(String oldPassword, String newPassword);

  /**
   * Forget password
   *
   * @param userName
   * @param mailCode
   * @param newPassword
   */
  void forgetPassword(String userName, String newPassword, String mailCode);

  /**
   * Load user by token
   *
   * @param authHeader
   * @return
   */
  UserDetails loadUserByToken(String authHeader);


  /**
   * Get mail code from Redis
   *
   * @param mail
   * @return
   */
  String getMailCodeFromRedis(String mail);

  /**
   * Send mail and mail code to the message queue
   *
   * @param mail
   */
  void sendMail(String username, String mail);
}
