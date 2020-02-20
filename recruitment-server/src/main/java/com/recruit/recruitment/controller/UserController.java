package com.recruit.recruitment.controller;

import com.recruit.recruitment.config.MailConfig;
import com.recruit.recruitment.service.UserService;
import com.recruit.recruitment.utils.FormatUtil;
import com.recruit.recruitment.model.entity.Result;
import com.recruit.recruitment.model.entity.StatusCode;
import com.recruit.recruitment.model.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
  @Autowired
  private UserService userService;

  @Autowired
  private FormatUtil formatUtil;

  @PostMapping("/register")
  public Result register(User user) {
    if (!formatUtil.checkStringNull(user.getUsername(), user.getMail(),
      user.getPassword())) {
      return Result.create(StatusCode.ERROR, "Incomplete info");
    }
    try {
      userService.register(user);
      return Result.create(StatusCode.SUCCESS, "Registration successful");
    } catch (RuntimeException e) {
      return Result.create(StatusCode.ERROR, "Registration failed. " + e.getMessage());
    }
  }

  @PostMapping("/login")
  public Result login(User user) {
    if (!formatUtil.checkStringNull(user.getUsername(), user.getPassword())) {
      return Result.create(StatusCode.ERROR, "Incomplete info");
    }
    try {
      Map map = userService.login(user);
      return Result.create(StatusCode.SUCCESS, "Login successful", map);
    } catch (UsernameNotFoundException e) {
      return Result.create(StatusCode.LOGIN_ERROR, "Login failed. Username or password error");
    } catch (RuntimeException e) {
      return Result.create(StatusCode.LOGIN_ERROR, e.getMessage());
    }
  }

  @GetMapping("/logout")
  public Result logout() {
    userService.logout();
    return Result.create(StatusCode.SUCCESS, "Logout successful");
  }

  @PreAuthorize("hasAuthority('USER')")
  @PostMapping("/change-password")
  public Result changePassword(String oldPassword, String newPassword) {
    if (!formatUtil.checkStringNull(oldPassword, newPassword)) {
      return Result.create(StatusCode.ERROR, "Incomplete info");
    }
    try {
      userService.changePassword(oldPassword, newPassword);
      return Result.create(StatusCode.SUCCESS, "Password changed");
    } catch (RuntimeException e) {
      return Result.create(StatusCode.ERROR, e.getMessage());
    }
  }

  @PostMapping("/forget-password")
  public Result forgetPassword(String username, String newPassword, String mailCode) {
    if (!formatUtil.checkStringNull(username, mailCode, newPassword)) {
      return Result.create(StatusCode.ERROR, "Incomplete info");
    }
    try {
      userService.forgetPassword(username, newPassword, mailCode);
      return Result.create(StatusCode.SUCCESS, "Reset successful");
    } catch (RuntimeException e) {
      return Result.create(StatusCode.ERROR, e.getMessage());
    }
  }

  @PostMapping("/send-mail")
  public Result sendMail(String username, String mail) {
    if (!(formatUtil.checkStringNull(username, mail)) || (!formatUtil.checkMail(mail))) {
      return Result.create(StatusCode.ERROR, "Invalid mail address");
    }
    String redisMailCode = userService.getMailCodeFromRedis(mail);
    if (redisMailCode != null) {
      return Result.create(StatusCode.ERROR, "You cannot re-send mail code in " +
        MailConfig.EXPIRED_TIME + " minutes");
    } else {
      try {
        userService.sendMail(username, mail);
        return Result.create(StatusCode.SUCCESS, "Send successful");
      } catch (RuntimeException e) {
        return Result.create(StatusCode.ERROR, e.getMessage());
      }
    }
  }
}
