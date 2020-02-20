package com.recruit.recruitment.utils;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 */
@Component
public class FormatUtil {
  private static final Pattern MAIL_PATTERN = Pattern.compile("\\w+@\\w+(\\.\\w{2,3})*\\.\\w{2,3}");

  /**
   * Validate mail format
   *
   * @param mail
   * @return
   */
  public boolean checkMail(String mail) {
    Matcher matcher = MAIL_PATTERN.matcher(mail);
    return matcher.matches();
  }

  /**
   * Check if string params are null in Controller
   *
   * @param strs
   * @return
   */
  public boolean checkStringNull(String... strs) {
    for (String str : strs) {
      if (str == null || str.equals("")) {
        return false;
      }
    }
    return true;
  }

  /**
   * Check if object params are null in Controller
   *
   * @param objs
   * @return
   */
  public boolean checkObjectNull(Object... objs) {
    for (Object obj : objs) {
      if (obj == null) {
        return false;
      }
    }
    return true;
  }

  /**
   * Check if integers are positive
   *
   * @param numbers
   * @return
   */
  public boolean checkPositive(Integer... numbers) {
    for (Integer number : numbers) {
      if (number <= 0) {
        return false;
      }
    }
    return true;
  }
}
