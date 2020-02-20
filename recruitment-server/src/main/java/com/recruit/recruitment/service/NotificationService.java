package com.recruit.recruitment.service;

import com.recruit.recruitment.model.pojo.Notification;

import java.util.List;

public interface NotificationService {
  void deleteNotificationByNotificationid(Integer notificationid);

  List<Notification> findNotificationsByUser();
}
