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
          <div class="col-lg-8 col-md-6 col-xs-12">
            <div class="breadcrumb-wrapper">
              <div class="img-wrapper">
                <img src="../../assets/img/about/company-logo.png" alt="" />
              </div>
              <div class="content">
                <h3 class="product-title">Hiring UI Designer</h3>
                <p class="brand">UIDeck Inc.</p>
                <div class="tags">
                  <span><i class="lni-map-marker"></i> New York</span>
                  <span><i class="lni-calendar"></i> Posted 26 June, 2020</span>
                </div>
              </div>
            </div>
          </div>
          <div class="col-lg-4 col-md-6 col-xs-12">
            <div class="month-price">
              <span class="year">Yearly</span>
              <div class="price">$65,000</div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- Page Header End -->
    <!-- Job Detail Section Start -->
    <section class="job-detail section">
      <div class="container">
        <div class="row justify-content-between">
          <div class="col-lg-8 col-md-12 col-xs-12">
            <div class="content-area">
              <h4>Job Description</h4>
              <p>
                Proin gravida nibh vel velit auctor aliquet. Aenean
                sollicitudin, lorem quis bibendum auctor, nisi elit consequat
                ipsum, nec sagittis sem nibh id elit. Duis sed odio sit amet
                nibh vulputate cursus a sit amet mauris. Morbi umsan ipsum
                velit. Nam nec tellus a odio tincidunt auctor a ornare odio. Sed
                non mauris vitae erat consequat auctor eu in elit. Class aptent
                taciti sociosqu ad litora torquent per conubia nostra, per
                inceptos himenaeos. Mauris in erat justo. Nullam ac urna eu
                felis dapibus condimentum sit amet a augue. Sed non neque elit
              </p>
              <p>
                Proin gravida nibh vel velit auctor aliquet. Aenean
                sollicitudin, lorem quis bibendum auctor, nisi elit consequat
                ipsum, nec sagittis sem nibh id elit. Duis sed odio sit amet
                nibh vulputate cursus a sit amet mauris. Morbi umsan ipsum
                velit. Nam nec tellus a odio tincidunt auctor a ornare odio.
              </p>
              <h5>Job Criteria</h5>
              <ul>
                <li>- Objective-C</li>
                <li>- iOS SDK</li>
                <li>- XCode</li>
                <li>- Cocoa</li>
                <li>- ClojureScript</li>
              </ul>
              <a href="#" class="btn btn-common">Apply job</a>
            </div>
          </div>
          <div class="col-lg-4 col-md-12 col-xs-12">
            <div class="sideber">
              <div class="widghet">
                <h3>Job Location</h3>
                <div class="maps">
                  <div id="map" class="map-full">
                    <iframe
                      src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d405691.57240383344!2d-122.3212843181106!3d37.40247298383319!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x808fb68ad0cfc739%3A0x7eb356b66bd4b50e!2sSilicon+Valley%2C+CA%2C+USA!5e0!3m2!1sen!2sbd!4v1538319316724"
                      allowfullscreen=""
                    ></iframe>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!-- Job Detail Section End -->

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
<script src="../../assets/js/color-switcher.js"></script>
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
  name: 'JobDetail',
  components: { NavBar }
};
</script>
