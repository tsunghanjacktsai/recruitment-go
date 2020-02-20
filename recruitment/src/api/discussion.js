import request from "@/utils/request";
import qs from "qs";

export default {
  sendDiscussion(title, receivers, content) {
    return request({
      url: "/discussion/send-discussion",
      method: "put",
      data: qs.stringify(
        {
          title: title,
          content: content,
          receivers: JSON.stringify(receivers)
        },
        {
          indices: false
        }
      )
    });
  },
  getDiscussionByNotificationid(notificationid) {
    return request({
      url: "/discussion/get-discussion-by-notificationid/" + notificationid,
      method: "get"
    });
  },
  getReceiverByReplytoid(replytoid) {
    return request({
      url: "/discussion/get-receiver-by-replytoid/" + replytoid,
      method: "get"
    });
  }
};
