import request from "@/utils/request";

export default {
  getApplicationScoreByMarker(applicationid) {
    return request({
      url: "/score/get-application-score-by-marker/" + applicationid,
      method: "get"
    });
  }
};
