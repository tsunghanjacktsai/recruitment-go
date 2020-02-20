import request from "@/utils/request";
import qs from "qs";

export default {
  getJob() {
    return request({
      url: "/job/get-job",
      method: "get"
    });
  }
};
