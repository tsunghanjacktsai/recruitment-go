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
@RabbitListener(queues = RabbitMqConfig.APPLICATION_QUEUE)
public class ApplicationListener {
  @Autowired
  private JavaMailSender mailSender;

  @Autowired
  private MailMessage mailMessage;

  @RabbitHandler
  public void executeSms(Map<String, String> map) {
    String mail = map.get("mail");
    String jobname = map.get("jobname");
    String companyname = map.get("companyname");
    try {
      sendMail(mail, jobname, companyname);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void sendMail(String mail, String jobname, String companyName) {
    mailSender.send(mailMessage.create(mail,
      "Recruitment-GO: Your application of " + jobname + " at " + companyName + " Has Been Sent",
      "Job Name: " + jobname +
        "\r\nCompany Name: " + companyName +
        "\r\nStatus: pending"));
  }
}
