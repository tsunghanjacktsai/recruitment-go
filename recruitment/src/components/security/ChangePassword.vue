<template>
  <div>
    <!-- Header Section Start -->
    <header id="home" class="hero-area">
      <nav-bar></nav-bar>
    </header>
    <!-- Header Section End -->

    <!-- Page Header Start -->
    <div class="page-header">
      <div class="container">
        <div class="row">
          <div class="col-lg-12">
            <div class="inner-header">
              <h3>Change Password</h3>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- Page Header End -->
    <!-- Start Content -->
    <div id="content">
      <div class="container">
        <div class="row">
          <div class="col-lg-4 col-md-12 col-xs-12">
            <right-side-bar></right-side-bar>
          </div>   
          <div class="col-lg-8 col-md-8 col-xs-12">
            <div class="job-alerts-item">
              <h3 class="alerts-title">Change Password</h3>
              <form class="form">
                <div class="form-group is-empty">
                  <input class="form-control" type="text" placeholder="Old Password"/>
                  <span class="material-input"></span>
                </div>
                <div class="form-group is-empty">
                  <input class="form-control" type="text" placeholder="New Password"/>
                  <span class="material-input"></span>
                </div>
                <div class="form-group is-empty">
                  <input class="form-control" type="text" placeholder="Retype Password"/>
                  <span class="material-input"></span>
                </div>
                <a href="#" id="submit" class="btn btn-common">Save Change</a>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
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
import NavBar from "@/components/utils/NavBar.vue";
import RightSideBar from "@/components/utils/RightSideBar.vue"
export default {
  name: "ChangePassword",
  components: { NavBar, RightSideBar }
};
</script>
