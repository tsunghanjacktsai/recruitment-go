package com.recruit.recruitment.utils;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomUtil {
  private Random random = new Random();

  /**
   * Return the random number in the specified field
   *
   * @param start
   * @param end
   * @return
   */
  public synchronized int nextInt(int start, int end) {
    return random.nextInt(end - start) + start + 1;
  }
}
