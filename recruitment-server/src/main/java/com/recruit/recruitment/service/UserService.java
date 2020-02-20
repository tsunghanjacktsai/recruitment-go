package com.recruit.recruitment.service;

import com.recruit.recruitment.model.pojo.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Map;

public interface UserService {
  /**
   * Registration
   * @param user
   * @return
   */
  void register(User user);

  /**
   * Login
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
  void updatePassword(String oldPassword, String newPassword);

  /**
   * Forget password
   *
   * @param userName
   * @param mailCode
   * @param newPassword
   */
  void forgetPassword(String userName, String mailCode, String newPassword);

  /**
   * Find the user by userid
   *
   * @param userid
   * @return
   */
  User findUser(Integer userid);

  /**
   * Find all users
   *
   * @param orderby
   * @return
   */
  List<User> findAllUsers(String orderby);

  /**
   * Update user info
   *
   * @param user
   * @return
   */
  int updateUser(User user);

  /**
   * Load user by token
   *
   * @param authHeader
   * @return
   */
  UserDetails loadUserByToken(String authHeader);

  /**
   * Validate mailcode
   *
   * @param mail
   * @param code
   * @return
   */
  boolean checkMailCode(String mail, String code);

  /**
   * Get mail code from Redis
   * @param mail
   * @return
   */
  String getMailCodeFromRedis(String mail);

  /**
   * Send mail and mail code to the message queue
   *
   * @param mail
   */
  void sendMail(String mail);
}
