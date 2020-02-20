<template>
  <div>
    <!-- Header Section Start -->
    <header id="home" class="hero-area">
      <nav class="navbar navbar-expand-lg fixed-top scrolling-navbar">
        <div class="container">
          <div class="theme-header clearfix">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
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
              <img
                src="../../assets/img/logo.png"
                alt=""
                class="navbar-brand"
              />
            </div>
          </div>
        </div>
      </nav>
    </header>
    <!-- Header Section End -->

    <!-- Page Header Start -->
    <div class="page-header">
      <div class="container">
        <div class="row">
          <div class="col-lg-12">
            <div class="inner-header">
              <h3>Login</h3>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- Page Header End -->

    <!-- Content section Start -->
    <section id="content" class="section-padding">
      <div class="container">
        <div class="row justify-content-center">
          <div class="col-lg-5 col-md-6 col-xs-12">
            <div class="page-login-form box">
              <h3>
                Login
              </h3>
              <form class="login-form">
                <div class="form-group">
                  <div class="input-icon">
                    <i class="lni-user"></i>
                    <input
                      v-model="form.loginUsername"
                      type="text"
                      class="form-control"
                      placeholder="Username"
                    />
                  </div>
                </div>
                <div class="form-group">
                  <div class="input-icon">
                    <i class="lni-lock"></i>
                    <input
                      v-model="form.loginPwd"
                      type="password"
                      class="form-control"
                      placeholder="Password"
                    />
                  </div>
                </div>
                <br />
              </form>
              <button class="btn btn-common log-btn" @click="userLogin">
                Submit
              </button>
              <ul class="form-links">
                <li class="text-center">
                  <router-link to="/register"
                    >Don't have an account?</router-link
                  >
                </li>
              </ul>
              <ul class="form-links">
                <li class="text-center">
                  <router-link to="/forget-password"
                    >Forget password?</router-link
                  >
                </li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!-- Content section End -->
  </div>
</template>
<style>
@import "../../assets/css/bootstrap.min.css";
@import "../../assets/css/line-icons.css";
@import "../../assets/css/owl.carousel.min.css";
@import "../../assets/css/owl.theme.default.css";
@import "../../assets/css/slicknav.min.css";
@import "../../assets/css/animate.css";
@import "../../assets/css/main.css";
@import "../../assets/css/responsive.css";
</style>
<!-- jQuery first, then Tether, then Bootstrap JS. -->
<script src="../../assets/js/jquery-min.js"></script>
<script src="../../assets/js/popper.min.js"></script>
<script src="../../assets/js/bootstrap.min.js"></script>
<script src="../../assets/js/owl.carousel.min.js"></script>
<script src="../../assets/js/jquery.slicknav.js"></script>
<script src="../../assets/js/jquery.counterup.min.js"></script>
<script src="../../assets/js/waypoints.min.js"></script>
<script src="../../assets/js/form-validator.min.js"></script>
<script src="../../assets/js/contact-form-script.js"></script>
<script src="../../assets/js/main.js"></script>
<script>
import user from "@/api/user";
export default {
  name: "Login",
  data() {
    return {
      form: {
        loginUsername: "",
        loginPwd: ""
      }
    };
  },
  methods: {
    userLogin() {
      if (
        this.form.loginUsername.length <= 0 ||
        this.form.loginPwd.length <= 0
      ) {
        this.$message({
          message: "Incomplete info",
          type: "error"
        });
        return;
      }
      user.login(this.form.loginUsername, this.form.loginPwd).then(response => {
        this.form.loginPwd = "";
        this.$store.commit("login", response.data); // store token
        this.$router.push({
          path: "/home"
        });
        this.$message({
          message: "Login successful",
          type: "success"
        });
      });
    }
  }
};
</script>
