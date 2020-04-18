package com.recruit.recruitment.service;

import com.recruit.recruitment.model.pojo.Discussion;

import java.util.List;

public interface DiscussionService {
  void addDiscussion(String title, String content, String receivers);

  Discussion findDiscussionByNotificationid(Integer notificationid);

  List<String> findReceiversBySenderid(Integer senderid);
}
