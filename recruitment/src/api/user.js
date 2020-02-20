import request from "@/utils/request";
import qs from "qs";

export default {
  login(username, password) {
    return request({
      url: "/user/login",
      method: "post",
      // header: 'Content-Type:application/x-www-form-urlencoded',
      data: qs.stringify({ username: username, password: password })
    });
  },
  register(mail, username, password) {
    return request({
      url: "/user/register",
      method: "post",
      // header: 'Content-Type:application/x-www-form-urlencoded',
      data: qs.stringify({
        mail: mail,
        username: username,
        password: password
      })
    });
  },
  logout() {
    return request({
      url: "/user/logout",
      method: "get"
    });
  },
  sendMail(username, mail) {
    return request({
      url: "/user/send-mail",
      method: "post",
      data: qs.stringify({ username: username, mail: mail })
    });
  },
  changePwd(oldPwd, newPwd) {
    return request({
      url: "/user/change-password",
      method: "post",
      data: qs.stringify({
        oldPassword: oldPwd,
        newPassword: newPwd
      })
    });
  },
  forgetPwd(username, newPwd, mailCode) {
    return request({
      url: "/user/forget-password",
      method: "post",
      data: qs.stringify({
        username: username,
        newPassword: newPwd,
        mailCode: mailCode
      })
    });
  }
};
