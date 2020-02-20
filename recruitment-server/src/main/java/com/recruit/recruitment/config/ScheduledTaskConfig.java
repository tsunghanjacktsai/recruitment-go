package com.recruit.recruitment.config;

import com.recruit.recruitment.mapper.*;
import com.recruit.recruitment.model.pojo.Application;
import com.recruit.recruitment.model.pojo.Evaluator;
import com.recruit.recruitment.model.pojo.Notification;
import com.recruit.recruitment.model.pojo.Post;
import com.recruit.recruitment.service.ApplicationService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class ScheduledTaskConfig {
  @Autowired
  private ApplicationService applicationService;

  @Autowired
  private PostMapper postMapper;

  @Autowired
  private UserMapper userMapper;

  @Autowired
  private EvaluatorMapper evaluatorMapper;

  @Autowired
  private ResumeMapper resumeMapper;

  @Autowired
  private NotificationMapper notificationMapper;

  @Autowired
  private RabbitTemplate rabbitTemplate;

  private static final String PASS_MESSAGE = "Passed";
  private static final String FAIL_MESSAGE = "Rejected";

//  @Scheduled(cron = "0 0 0 * * ?")
  @Scheduled(cron = "0 */1 * * * ?")
  public void inspectPosts() {
    List<Post> posts = postMapper.selectAll();
    Date curDate = new Date();
    for (Post post : posts) {
      try {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (formatter.parse(post.getDue()).compareTo(curDate) <= 0) {
          List<Application> applications =
            applicationService.findApplicationsByPostid(post.getPostid());

          System.out.println("Hello");

          if (applications != null) {
            applications.sort(Comparator.comparing(Application::getScoreavg).reversed());

            HashMap<String, Integer> map = new HashMap<>();
            for (int i = 0; i < post.getPicknum(); i++) {
              double scoreAvg = applications.get(i).getScoreavg().doubleValue();
              if (map.get(Double.toString(scoreAvg)) == null) {
                map.put(Double.toString(scoreAvg), 1);
              }
            }
            for (int i = post.getPicknum(); i < applications.size(); i++) {
              double scoreAvg = applications.get(i).getScoreavg().doubleValue();
              if (map.get(Double.toString(scoreAvg)) != null) {
                post.setPicknum(post.getPicknum() + 1);
              }
            }

            for (int i = 0; i < applications.size(); i++) {
              Application application = applications.get(i);
              HashMap<String, String> messageMap = new HashMap<>();
              Notification notification = new Notification();
              int userid = resumeMapper.selectByPrimaryKey(application.getResumeid()).getUserid();
              if (i < post.getPicknum()) {
                sendNotification(post, notification, userid, PASS_MESSAGE);
              } else {
                sendNotification(post, notification, userid, FAIL_MESSAGE);
              }
            }
          }

          List<String> evaluators = evaluatorMapper.selectEvaluatorNameByPostid(post.getPostid());
          for (String evaluator : evaluators) {
            Notification notification = new Notification();
            notification.setUserid(userMapper.selectByUsername(evaluator).getUserid());
            notification.setContent(
              "The result of " + post.getJobname() + " at " + post.getCompanyname() + " had been sent to candidates");
            notificationMapper.insertSelective(notification);
          }

          postMapper.deleteByPrimaryKey(post.getPostid());
        }
      } catch (ParseException e) {
        e.printStackTrace();
      }
    }
  }

  private void sendNotification(Post post, Notification notification, int userid, String content) {
    rabbitTemplate.convertAndSend(RabbitMqConfig.STATUS_QUEUE, generateContent(
      userMapper.selectByPrimaryKey(userid).getMail(),
      post.getJobname(), post.getCompanyname(),
      content));
    notification.setUserid(userid);
    notification.setContent("Your application to " + post.getJobname() + " at " +
      post.getCompanyname() + " had been " + content);
    notificationMapper.insertSelective(notification);
  }

  private HashMap<String, String> generateContent(String mail, String jobName,
                                                  String companyName, String status) {
    HashMap<String, String> map = new HashMap<>();
    map.put("mail", mail);
    map.put("jobname", jobName);
    map.put("companyname", companyName);
    map.put("status", status);
    return map;
  }
}
