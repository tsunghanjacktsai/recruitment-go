<template>
  <div>
    <div class="right-sideabr">
      <h4>Account</h4>
      <ul class="list-item">
        <li><router-link to="/resume">My Resume</router-link></li>
        <li>
          <router-link to="/notification"
            >Notifications</router-link
          >
        </li>
        <li>
          <router-link to="/manage-job">Manage Jobs</router-link>
        </li>
        <li>
          <router-link to="/change-password"
            >Change Password</router-link
          >
        </li>
        <li><router-link to="/index">Sign Out</router-link></li>
      </ul>
    </div>
  </div>
</template>
<script>
export default {
    name: 'RightSideBar'
}
</script>
