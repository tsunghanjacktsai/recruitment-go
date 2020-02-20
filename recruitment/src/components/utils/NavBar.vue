<template>
  <div>
    <!-- Navbar Start -->
    <nav class="navbar navbar-expand-lg fixed-top scrolling-navbar">
      <div class="container">
        <div class="theme-header clearfix">
          <!-- Brand and toggle get grouped for better mobile display -->
          <div class="navbar-header" style="text-align:left">
            <button
              class="navbar-toggler"
              type="button"
              data-toggle="collapse"
              data-target="#main-navbar"
              aria-controls="main-navbar"
              aria-expanded="false"
              aria-label="Toggle navigation"
            >
              <span class="navbar-toggler-icon"></span>
              <span class="lni-menu"></span>
              <span class="lni-menu"></span>
              <span class="lni-menu"></span>
            </button>
            <router-link to="/home" class="navbar-brand">
              <img src="../../assets/img/logo.png" alt="" style="width:100%" />
            </router-link>
          </div>
          <div class="collapse navbar-collapse" id="main-navbar">
            <ul class="navbar-nav mr-auto w-100 justify-content-end">
              <li class="nav-item">
                <router-link class="nav-link" to="/home">
                  Home
                </router-link>
              </li>
              <li class="nav-item">
                <router-link class="nav-link" to="/notification">
                  Notifications
                </router-link>
              </li>
              <li class="nav-item">
                <router-link class="nav-link" to="/add-discussion">
                  Discussions
                </router-link>
              </li>
              <li class="nav-item dropdown">
                <a
                  class="nav-link dropdown-toggle"
                  href="#"
                  data-toggle="dropdown"
                  aria-haspopup="true"
                  aria-expanded="false"
                >
                  Candidates
                </a>
                <ul class="dropdown-menu">
                  <li>
                    <a class="dropdown-item" href="#" @click="loadMyResume">
                      My Resume
                    </a>
                  </li>
                  <li>
                    <router-link class="dropdown-item" to="/manage-application"
                      >Manage Applications</router-link
                    >
                  </li>
                  <li>
                    <router-link class="dropdown-item" to="/browse-category"
                      >Browse Categories</router-link
                    >
                  </li>
                </ul>
              </li>
              <li class="nav-item dropdown">
                <a
                  class="nav-link dropdown-toggle"
                  href="#"
                  data-toggle="dropdown"
                  aria-haspopup="true"
                  aria-expanded="false"
                >
                  Employers
                </a>
                <ul class="dropdown-menu">
                  <li>
                    <router-link class="dropdown-item" to="/add-job"
                      >Add Job</router-link
                    >
                  </li>
                  <li>
                    <router-link class="dropdown-item" to="/manage-job"
                      >Manage Jobs</router-link
                    >
                  </li>
                  <li>
                    <router-link class="dropdown-item" to="/browse-resume"
                      >Browse Resumes</router-link
                    >
                  </li>
                </ul>
              </li>
              <li class="button-group">
                <router-link to="/add-job" class="button btn btn-common"
                  >Post a Job</router-link
                >
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#" @click="userLogout">
                  Logout
                </a>
              </li>
            </ul>
          </div>
        </div>
      </div>
      <div
        class="mobile-menu"
        data-logo="../../assets/img/logo-mobile.png"
      ></div>
    </nav>
    <!-- Navbar End -->
  </div>
</template>
<script>
import user from "@/api/user";
import resume from "@/api/resume";
export default {
  name: "NavBar",
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
