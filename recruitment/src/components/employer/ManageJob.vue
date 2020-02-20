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
              <h3>Manage Jobs</h3>
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
            <router-link to="/add-job" class="btn btn-common float-right mt-3 mr-3">Add</router-link>
            <div class="job-alerts-item candidates">
              <h3 class="alerts-title">Manage Jobs</h3>
              <div class="alerts-list">
                <div class="row">
                  <div class="col-lg-4 col-md-4 col-xs-12">
                    <p>Name</p>
                  </div>
                  <div class="col-lg-4 col-md-4 col-xs-12">
                    <p>Keywords</p>
                  </div>
                  <div class="col-lg-4 col-md-4 col-xs-12">
                    <p>Candidates</p>
                  </div>
                </div>
              </div>
              <div class="alerts-content">
                <div class="row">
                  <div class="col-lg-4 col-md-5 col-xs-12">
                    <h3>Web Designer</h3>
                    <span class="location"
                      ><i class="lni-map-marker"></i>Manhattan, NYC</span
                    >
                  </div>
                  <div class="col-lg-4 col-md-4 col-xs-12">
                    <p><span class="full-time">Full-Time</span></p>
                  </div>
                  <div class="col-lg-4 col-md-3 col-xs-12">
                    <div class="can-img">
                      <router-link to="/evaluate-application"
                        ><button type="button" class="btn btn-common">Applications</button></router-link>
                    </div>
                  </div>
                </div>
              </div>
              <div class="alerts-content">
                <div class="row">
                  <div class="col-lg-4 col-md-5 col-xs-12">
                    <h3>Web Designer</h3>
                    <span class="location"
                      ><i class="lni-map-marker"></i>Manhattan, NYC</span
                    >
                  </div>
                  <div class="col-lg-4 col-md-4 col-xs-12">
                    <p><span class="full-time">Full-Time</span></p>
                  </div>
                  <div class="col-lg-4 col-md-3 col-xs-12">
                    <div class="can-img">
                      <router-link to="/evaluate-application"
                        ><button type="button" class="btn btn-common">Applications</button></router-link>
                    </div>
                  </div>
                </div>
              </div>
              <div class="alerts-content">
                <div class="row">
                  <div class="col-lg-4 col-md-5 col-xs-12">
                    <h3>Web Designer</h3>
                    <span class="location"
                      ><i class="lni-map-marker"></i>Manhattan, NYC</span
                    >
                  </div>
                  <div class="col-lg-4 col-md-4 col-xs-12">
                    <p><span class="full-time">Full-Time</span></p>
                  </div>
                  <div class="col-lg-4 col-md-3 col-xs-12">
                    <div class="can-img">
                      <router-link to="/evaluate-application"
                        ><button type="button" class="btn btn-common">Applications</button></router-link>
                    </div>
                  </div>
                </div>
              </div>
              <div class="alerts-content">
                <div class="row">
                  <div class="col-lg-4 col-md-5 col-xs-12">
                    <h3>Web Designer</h3>
                    <span class="location"
                      ><i class="lni-map-marker"></i>Manhattan, NYC</span
                    >
                  </div>
                  <div class="col-lg-4 col-md-4 col-xs-12">
                    <p><span class="full-time">Full-Time</span></p>
                  </div>
                  <div class="col-lg-4 col-md-3 col-xs-12">
                    <div class="can-img">
                      <router-link to="/evaluate-application"
                        ><button type="button" class="btn btn-common">Applications</button></router-link>
                    </div>
                  </div>
                </div>
              </div>
              <br />
              <!-- Start Pagination -->
              <ul class="pagination">
                <li class="active">
                  <a href="#" class="btn-prev"
                    ><i class="lni-angle-left"></i>prev</a
                  >
                </li>
                <li><a href="#">1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
                <li class="active">
                  <a href="#" class="btn-next"
                    >Next <i class="lni-angle-right"></i
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
