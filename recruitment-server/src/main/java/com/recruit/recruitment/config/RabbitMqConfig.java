package com.recruit.recruitment.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {
  /**
   * Mail code message queue
   */
  public static final String MAIL_CODE_QUEUE = "MAIL_CODE";
  /**
   * Status message queue
   */
  public static final String STATUS_QUEUE = "STATUS";
  /**
   * Application message queue
   */
  public static final String APPLICATION_QUEUE = "APPLICATION";
  /**
   * Discussion message queue
   */
  public static final String DISCUSSION_QUEUE = "DISCUSSION";
}
