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
              <h3>Create Your Account</h3>
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
                Create Your account
              </h3>
              <form class="login-form">
                <div class="form-group">
                  <div class="input-icon">
                    <i class="lni-envelope"></i>
                    <input
                      v-model="form.registerMail"
                      type="text"
                      class="form-control"
                      name="Mail"
                      placeholder="Mail Address"
                    />
                  </div>
                </div>
                <div class="form-group">
                  <div class="input-icon">
                    <i class="lni-user"></i>
                    <input
                      v-model="form.registerUsername"
                      type="text"
                      class="form-control"
                      name="username"
                      placeholder="Username"
                    />
                  </div>
                </div>
                <div class="form-group">
                  <div class="input-icon">
                    <i class="lni-lock"></i>
                    <input
                      v-model="form.registerPwd"
                      type="password"
                      class="form-control"
                      placeholder="Password"
                    />
                  </div>
                </div>
                <div class="form-group">
                  <div class="input-icon">
                    <i class="lni-unlock"></i>
                    <input
                      v-model="form.registerConfirmPwd"
                      type="password"
                      class="form-control"
                      placeholder="Confirm Password"
                    />
                  </div>
                </div>
              </form>
              <button class="btn btn-common log-btn mt-3" @click="userRegister">
                Register
              </button>
              <p class="text-center">
                Already have an account?<router-link to="/login">
                  Sign In</router-link
                >
              </p>
            </div>
          </div>
        </div>
      </div>
    </section>
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
  name: "Register",
  data() {
    return {
      form: {
        registerMail: "",
        registerUsername: "",
        registerPwd: "",
        registerConfirmPwd: ""
      }
    };
  },
  methods: {
    userRegister() {
      if (
        this.form.registerUsername.length <= 0 ||
        this.form.registerPwd.length <= 0 ||
        this.form.registerConfirmPwd.length <= 0 ||
        this.form.registerMail.length <= 0
      ) {
        this.$message({
          message: "Incomplete info",
          type: "error"
        });
        return;
      }
      if (this.form.registerPwd !== this.form.registerConfirmPwd) {
        this.$message({
          message: "Inconsistent password",
          type: "error"
        });
        return;
      }
      if (this.form.registerPwd.length <= 6) {
        this.$message({
          message: "Password length need to be at least 6 characters",
          type: "error"
        });
        return;
      }
      var reg = new RegExp(
        /^([a-zA-Z0-9._-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/
      );
      if (!reg.test(this.form.registerMail)) {
        this.$message({
          message: "Incorrect mail format",
          type: "error"
        });
        return;
      }
      user
        .register(
          this.form.registerMail,
          this.form.registerUsername,
          this.form.registerPwd
        )
        .then(res => {
          this.$router.push({
            path: "/login"
          });
          this.$message({
            message: "Registration successful",
            type: "success"
          });
        });
    }
  }
};
</script>
