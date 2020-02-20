package com.recruit.recruitment.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class BeanConfig {
  /**
   * The encoding method of spring-security
   *
   * @return
   */
  @Bean
  public BCryptPasswordEncoder encoder() {
    return new BCryptPasswordEncoder();
  }

  /**
   * The json tool of spring boot
   *
   * @return
   */
  @Bean
  public ObjectMapper objectMapper() {
    return new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);
  }

  /**
   * Init a message queue for sending mail
   *
   * @return
   */
  @Bean
  public Queue sendSmsQueue() {
    return new Queue(RabbitMqConfig.MAIL_CODE_QUEUE);
  }
}
