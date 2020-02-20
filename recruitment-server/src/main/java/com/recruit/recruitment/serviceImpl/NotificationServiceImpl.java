package com.recruit.recruitment.serviceImpl;

import com.recruit.recruitment.mapper.NotificationMapper;
import com.recruit.recruitment.mapper.UserMapper;
import com.recruit.recruitment.model.pojo.Notification;
import com.recruit.recruitment.service.NotificationService;
import com.recruit.recruitment.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {
  @Autowired
  private NotificationMapper notificationMapper;

  @Autowired
  private UserMapper userMapper;

  @Autowired
  private JwtTokenUtil jwtTokenUtil;

  @Autowired
  private HttpServletRequest request;

  @Override
  public void deleteNotificationByNotificationid(Integer notificationid) {
    notificationMapper.deleteByPrimaryKey(notificationid);
  }

  @Override
  public List<Notification> findNotificationsByUser() {
    List<Notification> notifications = notificationMapper.selectByUserid(userMapper.selectByUsername(
      jwtTokenUtil.getUsernameFromRequest(request)).getUserid());
    for (Notification notification : notifications) {
      if (notification.getContent().startsWith("You have received a message from")) {
        notification.setIfDiscussion(true);
      } else {
        notification.setIfDiscussion(false);
      }
    }
    return notifications;
  }
}
