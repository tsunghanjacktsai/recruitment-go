package com.recruit.recruitment.serviceImpl;

import com.recruit.recruitment.config.RabbitMqConfig;
import com.recruit.recruitment.mapper.DiscussionMapper;
import com.recruit.recruitment.mapper.NotificationMapper;
import com.recruit.recruitment.mapper.UserMapper;
import com.recruit.recruitment.model.pojo.Discussion;
import com.recruit.recruitment.model.pojo.Notification;
import com.recruit.recruitment.model.pojo.User;
import com.recruit.recruitment.service.DiscussionService;
import com.recruit.recruitment.utils.JwtTokenUtil;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class DiscussionServiceImpl implements DiscussionService {
  @Autowired
  DiscussionMapper discussionMapper;

  @Autowired
  NotificationMapper notificationMapper;

  @Autowired
  UserMapper userMapper;

  @Autowired
  HttpServletRequest request;

  @Autowired
  JwtTokenUtil jwtTokenUtil;

  @Autowired
  RabbitTemplate rabbitTemplate;

  @Override
  public void addDiscussion(String title, String content, String receivers) {
    User sender = userMapper.selectByUsername(jwtTokenUtil.getUsernameFromRequest(request));
    if (receivers != null) {
      Discussion discussion = new Discussion();
      int receiverid = -1;
      if (receivers.contains("\"tiClasses\":[\"ti-valid\"]")) {
        try {
          JSONArray receiverArr = new JSONArray(receivers);
          for (int i = 0; i < receiverArr.length(); i++) {
            discussion.setTitle(title);
            discussion.setContent(content);
            discussion.setSenderid(sender.getUserid());

            JSONObject obj = receiverArr.getJSONObject(i);
            String receiver = obj.getString("text");
            receiverid = getReceiverid(receiverid, discussion, receiver);
          }
        } catch (JSONException e) {
          e.printStackTrace();
        }
      } else {
        List<String> receiverList = new ArrayList<>(Arrays.asList(
          receivers.substring(1, receivers.length() - 1).split(",")));
        for (String receiver : receiverList) {
          discussion.setTitle(title);
          discussion.setContent(content);
          discussion.setSenderid(sender.getUserid());
          receiverid = getReceiverid(receiverid, discussion, receiver.replace("\"", ""));
        }
      }
      if (receiverid != -1) {
        Notification notification = new Notification();
        notification.setUserid(receiverid);
        notification.setContent("You have received a message from " + sender.getUsername());
        notificationMapper.insertSelective(notification);

        discussion.setNotificationid(notificationMapper.selectByMaxPostid());
        discussionMapper.insertSelective(discussion);

        HashMap<String, String> map = new HashMap<>();
        map.put("mail", userMapper.selectByPrimaryKey(receiverid).getMail());
        map.put("title", title);
        map.put("content", content);
        rabbitTemplate.convertAndSend(RabbitMqConfig.DISCUSSION_QUEUE, map);
      }
    } else {
      throw new RuntimeException("The mail address is not matched for any other users");
    }
  }

  private int getReceiverid(int receiverid, Discussion discussion, String receiver) {
    Pattern emailPattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
    Matcher matcher = emailPattern.matcher(receiver);
    if (matcher.matches()) {
      receiverid = userMapper.selectByMail(receiver).getUserid();
    } else {
      receiverid = userMapper.selectByUsername(receiver).getUserid();
    }
    if (receiverid != -1) {
      discussion.setReceiverid(receiverid);
    }
    return receiverid;
  }

  @Override
  public Discussion findDiscussionByNotificationid(Integer notificationid) {
    return discussionMapper.selectByNotificationid(notificationid);
  }

  @Override
  public List<String> findReceiversBySenderid(Integer senderid) {
    List<String> receivers = new ArrayList<>();
    receivers.add((userMapper.selectByPrimaryKey(senderid).getUsername()));
    return receivers;
  }
}
