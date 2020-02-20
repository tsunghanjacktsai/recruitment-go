import request from "@/utils/request";
import qs from "qs";

export default {
  applyToJob(postid) {
    return request({
      url: "/application/apply-job/" + postid,
      method: "put"
    });
  },
  checkIfApplied(postid) {
    return request({
      url: "/application/check-if-applied/" + postid,
      method: "get"
    });
  },
  getApplicationsByUser() {
    return request({
      url: "/application/get-applications-by-user",
      method: "get"
    });
  },
  getApplicationsByPostid(postid) {
    return request({
      url: "/application/get-applications-by-postid/" + postid,
      method: "get"
    });
  },
  getApplicationByApplicationid(applicationid) {
    return request({
      url: "/application/get-application-by-applicationid/" + applicationid,
      method: "get"
    });
  },
  deleteApplicationByApplicationid(applicationid) {
    return request({
      url: "/application/delete-application-by-applicationid/" + applicationid,
      method: "delete"
    });
  },
  scoreApplication(applicationid, score) {
    return request({
      url: "/application/score-application/" + applicationid,
      method: "put",
      data: qs.stringify({
        score: score
      })
    });
  }
};
