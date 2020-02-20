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
              <h3>Notifications</h3>
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
          <div class="col-md-8 col-sm-8 col-xs-12">
            <div class="job-alerts-item notification">
              <h3 class="alerts-title">Your Notifications</h3>
              <div class="notification-item">
                <div class="thums">
                  <img src="../../assets/img/jobs/img-4.jpg" alt="" />
                </div>
                <div class="text-left">
                  <p>
                    Your job "Software Engineer" from Banana Inc has been updated.
                  </p>
                  <span class="time"
                    ><i class="lni-alarm-clock"></i>3 Hours ago</span
                  >
                </div>
              </div>
              <div class="notification-item">
                <div class="thums">
                  <img src="../../assets/img/jobs/img-5.jpg" alt="" />
                </div>
                <div class="text-left">
                  <p>
                    Your job "Software Engineer" from Banana Inc has been updated.
                  </p>
                  <span class="time"
                    ><i class="lni-alarm-clock"></i>3 Hours ago</span
                  >
                </div>
              </div>
              <div class="notification-item">
                <div class="thums">
                  <img src="../../assets/img/jobs/img-6.jpg" alt="" />
                </div>
                <div class="text-left">
                  <p>
                    Your job "Software Engineer" from Banana Inc has been updated.
                  </p>
                  <span class="time"
                    ><i class="lni-alarm-clock"></i>3 Hours ago</span
                  >
                </div>
              </div>
              <!-- Start Pagination -->
              <ul class="pagination">
                <li class="active">
                  <a href="#" class="btn btn-common"
                    ><i class="ti-angle-left"></i> prev</a
                  >
                </li>
                <li><a href="#">1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
                <li class="active">
                  <a href="#" class="btn btn-common"
                    >Next <i class="ti-angle-right"></i
                  ></a>
                </li>
              </ul>
              <!-- End Pagination -->
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
import NavBar from '@/components/utils/NavBar.vue'
import RightSideBar from '@/components/utils/RightSideBar.vue'
export default {
  name: 'ChangePassword',
  components: { NavBar, RightSideBar }
};
</script>
