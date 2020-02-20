package com.recruit.recruitment.controller;

import com.recruit.recruitment.model.entity.Result;
import com.recruit.recruitment.model.entity.StatusCode;
import com.recruit.recruitment.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notification")
public class NotificationController {
  @Autowired
  NotificationService notificationService;

  @GetMapping("/get-notifications-by-user")
  public Result getNotificationsByUserid() {
    try {
      return Result.create(StatusCode.SUCCESS, "Query successful",
        notificationService.findNotificationsByUser());
    } catch (RuntimeException e) {
      return Result.create(StatusCode.ERROR, "Query failed");
    }
  }

  @DeleteMapping("/delete-notification-by-notificationid/{notificationid}")
  public Result deleteNotificationByNotificationid(@PathVariable Integer notificationid) {
    try {
      notificationService.deleteNotificationByNotificationid(notificationid);
      return Result.create(StatusCode.SUCCESS, "Delete successful");
    } catch (RuntimeException e) {
      return Result.create(StatusCode.ERROR, "Delete failed");
    }
  }
}
