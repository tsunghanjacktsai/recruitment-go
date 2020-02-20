package com.recruit.recruitment.mq;

import com.recruit.recruitment.config.RabbitMqConfig;
import com.recruit.recruitment.model.entity.MailMessage;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queues = RabbitMqConfig.DISCUSSION_QUEUE)
public class DiscussionListenter {
  @Autowired
  private JavaMailSender mailSender;

  @Autowired
  private MailMessage mailMessage;

  @RabbitHandler
  public void executeSms(Map<String, String> map) {
    String mail = map.get("mail");
    String title = map.get("title");
    String content = map.get("content");
    try {
      sendMail(mail, title, content);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void sendMail(String mail, String title, String content) {
    mailSender.send(mailMessage.create(mail, "Recruitment-GO: " + title, content));
  }
}
