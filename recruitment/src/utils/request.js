import axios from "axios";
import {Message, MessageBox} from 'element-ui'
import store from "@/store/store";
import router from "@/router/router";

const service = axios.create({
  baseURL: process.env.baseURL, // base_url of api
  timeout: 15000, // request expired time
  header: "Content-Type:application/x-www-form-urlencoded"
});

// Request interceptor
service.interceptors.request.use(config => {
  if (store.state.token != '') {
    config.headers['Authorization'] = store.state.token
  }
  return config
}, error => {
  console.log(error) // for debug
  Promise.reject(error)
})

// Response interceptor
service.interceptors.response.use(
  response => {
    const res = response.data;
    if ((typeof res.code != "undefined" && res.code != 200) ||
      (typeof res.status != "undefined" && res.status != true)) {
      if (typeof res.code != "undefined" && res.code != 403) {
        Message({
          message: res.message,
          type: "error",
          duration: 5 * 1000
        });
      }
      if (typeof res.status != "undefined" && res.status != true) {
        Message({
          message: "Remote interface error",
          type: "error",
          duration: 5 * 1000
        });
      }
      // 403: token expired or invalid authority ;
      if (res.code === 403) {
        store.commit("logout");
        MessageBox.confirm("You have been logged out", "State exception", {
          confirmButtonText: "Confirm",
          cancelButtonText: "Cancel",
          type: "warning"
        }).then(() => {
            // window.location.href = '#/'
            router.push({
              path: "/"
            });
            location.reload();
          })
          .catch(() => {
            router.push({
              path: "/"
            });
            location.reload();
          });
      }
      return Promise.reject("error");
    } else {
      return response.data;
    }
  },
  error => {
    console.log('Error: ' + error.message)
    var message;
    if (error.response.status == 504) {
      message = 'Connection expired'
    } else {
      message = error.message
    }
    Message({
      message: message,
      type: 'error',
      duration: 5 * 1000
    })
    return Promise.reject(error)
  }
)

export default service
