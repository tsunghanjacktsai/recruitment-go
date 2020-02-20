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
              <h3>Browse Categories</h3>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- Page Header End -->

    <!-- Category Section Start -->
    <section class="category section bg-gray">
      <div class="container">
        <div class="row">
          <div class="col-lg-3 col-md-6 col-xs-12 f-category">
            <router-link to="/browse-job">
              <div class="icon bg-color-1">
                <i class="lni-home"></i>
              </div>
              <h3>Finance</h3>
              <p>(4286 jobs)</p>
            </router-link>
          </div>
          <div class="col-lg-3 col-md-6 col-xs-12 f-category">
            <router-link to="/browse-job">
              <div class="icon bg-color-2">
                <i class="lni-world"></i>
              </div>
              <h3>Sale/Markting</h3>
              <p>(2000 jobs)</p>
            </router-link>
          </div>
          <div class="col-lg-3 col-md-6 col-xs-12 f-category">
            <router-link to="/browse-job">
              <div class="icon bg-color-3">
                <i class="lni-book"></i>
              </div>
              <h3>Education/Training</h3>
              <p>(1450 jobs)</p>
            </router-link>
          </div>
          <div class="col-lg-3 col-md-6 col-xs-12 f-category">
            <router-link to="/browse-jobs">
              <div class="icon bg-color-4">
                <i class="lni-display"></i>
              </div>
              <h3>Technologies</h3>
              <p>(5100 jobs)</p>
            </router-link>
          </div>
          <div class="col-lg-3 col-md-6 col-xs-12 f-category">
            <router-link to="/browse-job">
              <div class="icon bg-color-5">
                <i class="lni-brush"></i>
              </div>
              <h3>Art/Design</h3>
              <p>(5079 jobs)</p>
            </router-link>
          </div>
          <div class="col-lg-3 col-md-6 col-xs-12 f-category">
            <router-link to="/browse-job">
              <div class="icon bg-color-6">
                <i class="lni-heart"></i>
              </div>
              <h3>Healthcare</h3>
              <p>(3235 jobs)</p>
            </router-link>
          </div>
          <div class="col-lg-3 col-md-6 col-xs-12 f-category">
            <router-link to="/browse-job">
              <div class="icon bg-color-7">
                <i class="lni-funnel"></i>
              </div>
              <h3>Science</h3>
              <p>(1800 jobs)</p>
            </router-link>
          </div>
          <div class="col-lg-3 col-md-6 col-xs-12 f-category">
            <router-link to="/browse-job">
              <div class="icon bg-color-8">
                <i class="lni-cup"></i>
              </div>
              <h3>Food Services</h3>
              <p>(4286 jobs)</p>
            </router-link>
          </div>
        </div>
      </div>
    </section>
    <!-- Category Section End -->
    
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
export default {
  name: 'BrowseCategory',
  components: { NavBar }
};
</script>
