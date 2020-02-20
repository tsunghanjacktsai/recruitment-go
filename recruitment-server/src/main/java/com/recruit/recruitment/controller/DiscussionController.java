package com.recruit.recruitment.controller;

import com.recruit.recruitment.model.entity.Result;
import com.recruit.recruitment.model.entity.StatusCode;
import com.recruit.recruitment.service.DiscussionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/discussion")
public class DiscussionController {
  @Autowired
  DiscussionService discussionService;

  @PutMapping("/send-discussion")
  public Result sendDiscussion(String title, String content,
                               @RequestParam(value="receivers", required = false) String receivers) {
    try {
      discussionService.addDiscussion(title, content, receivers);
      return Result.create(StatusCode.SUCCESS, "Send successful");
    } catch (RuntimeException e) {
      return Result.create(StatusCode.ERROR, "Send failed");
    }
  }

  @GetMapping("/get-discussion-by-notificationid/{notificationid}")
  public Result getDiscussionByNotificationid(@PathVariable Integer notificationid) {
    try {
      return Result.create(StatusCode.SUCCESS, "Query successful",
        discussionService.findDiscussionByNotificationid(notificationid));
    } catch (RuntimeException e) {
      return Result.create(StatusCode.ERROR, "Query failed");
    }
  }

  @GetMapping("/get-receiver-by-replytoid/{replytoid}")
  public Result getReceiverByReplytoid(@PathVariable Integer replytoid) {
    try {
      return Result.create(StatusCode.SUCCESS, "Query successful",
        discussionService.findReceiverByReplytoid(replytoid));
    } catch (RuntimeException e) {
      return Result.create(StatusCode.ERROR, "Query failed");
    }
  }
}
