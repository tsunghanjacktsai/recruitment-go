import request from '@/utils/request'
import qs from 'qs';

export default {
  login(username, password) {
    return request({
      url: '/user/login',
      method: 'post',
      // header: 'Content-Type:application/x-www-form-urlencoded',
      data: qs.stringify({'username': username, 'password': password})
    })
  },
  register(mail, username, password) {
    return request({
      url: '/user/register',
      method: 'post',
      // header: 'Content-Type:application/x-www-form-urlencoded',
      data: qs.stringify({
        'mail': mail,
        'username': username,
        'password': password
      })
    })
  },
  logout(){
    return request({
      url: '/user/logout',
      method: 'get'
    })
  },
  sendMail(mail) {
    return request({
      url: '/user/send-mail',
      method: 'post',
      data: qs.stringify({'mail': mail})
    })
  }
}