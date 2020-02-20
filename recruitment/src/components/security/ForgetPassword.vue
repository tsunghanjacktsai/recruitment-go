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
              <h3>Forget Password</h3>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- Page Header End -->
    <!-- Start Content -->
    <section id="content" class="section-padding">
      <div class="container">
        <div class="row justify-content-center">
          <div class="col-lg-5 col-md-6 col-xs-12">
            <div class="page-login-form box">
              <h3 class="alerts-title">Forget Password</h3>
              <form class="form">
                <div class="form-group is-empty">
                  <input
                    class="form-control"
                    type="text"
                    placeholder="Username"
                  />
                  <span class="material-input"></span>
                </div>
                <div class="form-group is-empty">
                  <input
                    class="form-control"
                    type="text"
                    placeholder="New Password"
                  />
                  <span class="material-input"></span>
                </div>
                <div class="form-group is-empty">
                  <input
                    class="form-control"
                    type="text"
                    placeholder="Retype Password"
                  />
                  <span class="material-input"></span>
                </div>
                <div class="form-group is-empty">
                  <input class="form-control" type="text" placeholder="Mail" />
                  <span class="material-input"></span>
                </div>
                <div class="form-group is-empty">
                  <input
                    class="form-control"
                    type="text"
                    placeholder="Verification Code"
                  />
                  <span class="material-input"></span>
                </div>
                <button
                  @click="sendMail"
                  id="sendMail"
                  class="btn btn-primary"
                  type="button"
                >
                  <span v-if="!sendMailFlag">Send Verification Code</span>
                  <span
                    class="spinner-border spinner-border-sm"
                    role="status"
                    aria-hidden="true"
                    v-if="sendMailFlag"
                  ></span>
                  <span class="sr-only" v-if="sendMailFlag">Sending...</span>
                </button>
                <br /><br />
                <button
                  @click="savePwd"
                  id="submit"
                  class="btn btn-common"
                  type="button"
                >
                  Save Changes
                </button>
              </form>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!-- End Content -->
    <!-- Go To Top Link -->
    <a href="#" class="back-to-top">
      <i class="lni-arrow-up"></i>
    </a>

    <!-- Preloader -->
    <!-- <div id="preloader">
      <div class="loader" id="loader-1"></div>
    </div> -->
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
export default {
  name: "ForgetPassword"
};
</script>
