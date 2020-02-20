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
              <h3>My Resume</h3>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- Page Header End -->

    <!-- Start Content -->
    <div class="section">
      <div class="container">
        <div class="row">
          <div class="col-lg-4 col-md-12 col-xs-12">
            <right-side-bar></right-side-bar>
          </div>   
          <div class="col-lg-8 col-md-8 col-xs-12">
            <router-link to="/manage-resume" class="btn btn-common float-right mt-3 mr-3">Edit</router-link>
            <div class="inner-box my-resume">
              <div class="author-resume">
                <div class="thumb">
                  <img src="../../assets/img/resume/img-1.png" alt="" />
                </div>
                <div class="author-info">
                  <h3>Mark Anderson</h3>
                  <p class="sub-title">UI/UX Designer</p>
                  <p>
                    <span class="address"
                      ><i class="lni-map-marker"></i>Mahattan, NYC, USA</span
                    >
                    <span><i class="ti-phone"></i>(+01) 211-123-5678</span>
                  </p>
                  <div class="social-link">
                    <a href="#" class="website">www.google.com</a>
                  </div>
                </div>
              </div>
              <div class="about-me item">
                <h3>About Me</h3>
                <p>
                  Nullam semper erat arcu, ac tincidunt sem venenatis vel.
                  Curabitur a dolor ac ligula fermentum eusmod ac ullamcorper
                  nulla. Integer blandit uitricies aliquam. Pellentesque quis
                  dui varius, dapibus vilit id, ipsum. Morbi ac eros feugiat,
                  lacinia elit ut, elementum turpis. Curabitur justo sapien,
                  tempus sit amet ruturm eu, commodo eu lacus. Morbi in ligula
                  nibh. Maecenas ut mi at odio hendririt eleif end tempor vitae
                  augue. Fusce eget arcu et nibh dapibus maximus consectetur in
                  est. Sed iaculis Luctus nibh sed veneatis.
                </p>
              </div>
              <div class="work-experence item">
                <h3>Work Experience</h3>
                <h4>UI/UX Designer</h4>
                <h5>Bannana INC.</h5>
                <span class="date">Fab 2017-Present(5year)</span>
                <p>
                  Lorem ipsum dolor sit amet, consectetur adipisicing elit.
                  Libero vero, dolores, officia quibusdam architecto sapiente
                  eos voluptas odit ab veniam porro quae possimus itaque, quas!
                  Tempora sequi nobis, atque incidunt!
                </p>
                <p><a href="#">4 Projects</a></p>
                <br />
                <h4>UI Designer</h4>
                <h5>Whale Creative</h5>
                <span class="date">Fab 2017-Present(2year)</span>
                <p>
                  Lorem ipsum dolor sit amet, consectetur adipisicing elit.
                  Libero vero, dolores, officia quibusdam architecto sapiente
                  eos voluptas odit ab veniam porro quae possimus itaque, quas!
                  Tempora sequi nobis, atque incidunt!
                </p>
                <p><a href="#">4 Projects</a></p>
              </div>
              <div class="education item">
                <h3>Education</h3>
                <h4>Massachusetts Institute Of Technology</h4>
                <p>Bachelor of Computer Science</p>
                <span class="date">2010-2014</span>
                <br />
                <h4>Massachusetts Institute Of Technology</h4>
                <p>Bachelor of Computer Science</p>
                <span class="date">2010-2014</span>
              </div>
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
  name: 'Resume',
  components: { NavBar, RightSideBar }
};
</script>
