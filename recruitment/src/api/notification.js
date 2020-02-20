import request from "@/utils/request";
import qs from "qs";

export default {
  getNotificationsByUser() {
    return request({
      url: "/notification/get-notifications-by-user",
      method: "get"
    });
  },
  deleteNotificationById(notificationid) {
    return request({
      url:
        "/notification/delete-notification-by-notificationid/" + notificationid,
      method: "delete"
    });
  },
  sendDiscussion(title, receivers, content) {
    return request({
      url: "/notification/send-discussion",
      method: "put",
      data: qs.stringify(
        {
          title: title,
          receivers: JSON.stringify(receivers),
          content: content
        },
        {
          indices: false
        }
      )
    });
  }
};
