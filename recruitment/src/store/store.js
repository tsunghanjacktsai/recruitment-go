import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    roles: localStorage.getItem('roles') == null ? '' : localStorage.getItem('roles'),
    token: localStorage.getItem('token') == null ? '' : localStorage.getItem('token'),
    username: localStorage.getItem('username') == null ? '' : localStorage.getItem('username')

  }, mutations: {
    login(state, data) {
      // Change state
      this.state.token = data.token;
      localStorage.setItem('token', data.token);
      // Set username
      this.state.name = data.name;
      localStorage.setItem('username', data.usersname)
      // Set roles
      this.state.roles = data.roles;
      localStorage.setItem('roles', data.roles)
    },
    logout(state) {
      localStorage.removeItem('token');
      this.state.token = '';
      localStorage.removeItem('username');
      this.state.username = '';
      localStorage.removeItem('roles');
      this.state.roles = '';
    },
    refresh(state, token) {  //refresh token
      this.state.token = token;
      localStorage.setItem('token', token);
    }
  }
})