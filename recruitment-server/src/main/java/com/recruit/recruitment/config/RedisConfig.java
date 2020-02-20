package com.recruit.recruitment.config;

/**
 * Configuration of the storage of Redis
 */
public class RedisConfig {
  /**
   * Max Post num storing in Redis
   */
  public static final int REDIS_MAX_POST_NUM = 10;
  /**
   * The key of Post storing in Redis
   */
  public static final String REDIS_POST = "POST";
  /**
   * Prefix of Post storing in Redis
   */
  public static final String REDIS_POST_PREFIX = "POST_";
  /**
   * The caching key of category
   */
  public static final String REDIS_CATEGORY = "CATEGORY";
  /**
   * IP_127.0.0.1
   */
  public static final String REDIS_IP_PREFIX = "IP_";
  /**
   * The limit of the request frequency
   */
  public static final long REDIS_LIMIT_REQUEST_FREQUENCY_TIME = 1000L;
}
