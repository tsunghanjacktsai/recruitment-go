package com.recruit.recruitment.mq;

import com.recruit.recruitment.config.MailConfig;
import com.recruit.recruitment.config.RabbitMqConfig;
import com.recruit.recruitment.model.entity.MailMessage;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Customer of the mail message queue
 */
@Component
@RabbitListener(queues = RabbitMqConfig.MAIL_CODE_QUEUE)
public class MailCodeListener {
  @Autowired
  private JavaMailSender mailSender;

  @Autowired
  private MailMessage mailMessage;

  @RabbitHandler
  public void executeSms(Map<String, String> map) {
    String mail = map.get("mail");
    String code = map.get("code");
    try {
      this.sendMail(mail, code);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void sendMail(String mail, String code) {
    mailSender.send(mailMessage.create(mail, "Recruitment-GO: Registration Mail Code",
      "Mail code: " + code + "\r\nExpired time: " + MailConfig.EXPIRED_TIME + " minutes"));
  }
}
