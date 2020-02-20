<template>
  <div>
    <div class="right-sideabr">
      <h4>Account</h4>
      <ul class="list-item">
        <li>
          <a class="dropdown-item" href="#" @click="loadMyResume">
            My Resume
          </a>
        </li>
        <li>
          <router-link to="/notification">Notifications</router-link>
        </li>
        <li>
          <router-link to="/add-discussion">Discussions</router-link>
        </li>
        <li>
          <router-link to="/manage-job">Manage Jobs</router-link>
        </li>
        <li>
          <router-link to="/manage-application"
            >Manage Applications</router-link
          >
        </li>
        <li>
          <router-link to="/change-password">Change Password</router-link>
        </li>
        <li><a href="#" @click="userLogout">Sign Out</a></li>
      </ul>
    </div>
  </div>
</template>
<script>
import user from "@/api/user";
import resume from "@/api/resume";
export default {
  name: "RightSideBar",
  methods: {
    loadMyResume() {
      resume.getMyResume().then(res => {
        this.$router.push({
          name: "Resume",
          params: {
            resumeid: res.data.resumeid
          }
        });
      });
    },
    userLogout() {
      user.logout().then(res => {
        this.$store.commit("logout"); // clear token
        this.$message({
          message: "Logout successful",
          type: "success"
        });
        this.$router.push({
          path: "/logout"
        });
      });
    }
  }
};
</script>
