import request from "@/utils/request";

export default {
  getEvaluatorsByPostid(postid) {
    return request({
      url: "/evaluator/get-evaluators-by-postid/" + postid,
      method: "get"
    });
  }
};
