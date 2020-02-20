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
              <h3>Search Job</h3>
            </div>
            <div class="job-search-form bg-cyan job-featured-search">
              <form>
                <div class="row justify-content-center">
                  <div class="col-lg-5 col-md-5 col-xs-12">
                    <div class="form-group">
                      <input
                        class="form-control"
                        type="text"
                        placeholder="Job Title or Company Name"
                      />
                    </div>
                  </div>
                  <div class="col-lg-5 col-md-5 col-xs-12">
                    <div class="form-group">
                      <div class="search-category-container">
                        <label class="styled-select">
                          <select>
                            <option value="none">Locations</option>
                            <option value="none">New York</option>
                            <option value="none">California</option>
                            <option value="none">Washington</option>
                            <option value="none">Birmingham</option>
                            <option value="none">Chicago</option>
                            <option value="none">Phoenix</option>
                          </select>
                        </label>
                      </div>
                      <i class="lni-map-marker"></i>
                    </div>
                  </div>
                  <div class="col-lg-1 col-md-1 col-xs-12">
                    <button type="submit" class="button">
                      <i class="lni-search"></i>
                    </button>
                  </div>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- Page Header End -->

    <!-- Listings Section Start -->
    <section id="job-listings" class="section">
      <div class="container">
        <div class="row">
          <div class="col-lg-12 col-md-12 col-xs-12">
            <router-link class="job-listings" to="/job-detail">
              <div class="row">
                <div class="col-lg-4 col-md-4 col-xs-12">
                  <div class="job-company-logo">
                    <img src="../../assets/img/features/img1.png" alt="" />
                  </div>
                  <div class="job-details">
                    <h3>App Developer</h3>
                    <span class="company-neme">
                      AmazeSoft
                    </span>
                  </div>
                </div>
                <div class="col-lg-2 col-md-2 col-xs-12 text-center">
                  <span class="btn-open">
                    7 Open Jobs
                  </span>
                </div>
                <div class="col-lg-2 col-md-2 col-xs-12 text-right">
                  <div class="location">
                    <i class="lni-map-marker"></i> New York, US
                  </div>
                </div>
                <div class="col-lg-2 col-md-2 col-xs-12 text-right">
                  <span class="btn-full-time">Full Time</span>
                </div>
                <div class="col-lg-2 col-md-2 col-xs-12 text-right">
                  <span class="btn-apply">Apply Now</span>
                </div>
              </div>
            </router-link>
            <router-link class="job-listings" to="/job-detail">
              <div class="row">
                <div class="col-lg-4 col-md-4 col-xs-12">
                  <div class="job-company-logo">
                    <img src="../../assets/img/features/img2.png" alt="" />
                  </div>
                  <div class="job-details">
                    <h3>App Developer</h3>
                    <span class="company-neme">
                      AmazeSoft
                    </span>
                  </div>
                </div>
                <div class="col-lg-2 col-md-2 col-xs-12 text-center">
                  <span class="btn-open">
                    7 Open Jobs
                  </span>
                </div>
                <div class="col-lg-2 col-md-2 col-xs-12 text-right">
                  <div class="location">
                    <i class="lni-map-marker"></i> New York, US
                  </div>
                </div>
                <div class="col-lg-2 col-md-2 col-xs-12 text-right">
                  <span class="btn-full-time">Full Time</span>
                </div>
                <div class="col-lg-2 col-md-2 col-xs-12 text-right">
                  <span class="btn-apply">Apply Now</span>
                </div>
              </div>
            </router-link>
            <router-link class="job-listings" to="/job-detail">
              <div class="row">
                <div class="col-lg-4 col-md-4 col-xs-12">
                  <div class="job-company-logo">
                    <img src="../../assets/img/features/img3.png" alt="" />
                  </div>
                  <div class="job-details">
                    <h3>App Developer</h3>
                    <span class="company-neme">
                      AmazeSoft
                    </span>
                  </div>
                </div>
                <div class="col-lg-2 col-md-2 col-xs-12 text-center">
                  <span class="btn-open">
                    7 Open Jobs
                  </span>
                </div>
                <div class="col-lg-2 col-md-2 col-xs-12 text-right">
                  <div class="location">
                    <i class="lni-map-marker"></i> New Yourk, US
                  </div>
                </div>
                <div class="col-lg-2 col-md-2 col-xs-12 text-right">
                  <span class="btn-full-time">Full Time</span>
                </div>
                <div class="col-lg-2 col-md-2 col-xs-12 text-right">
                  <span class="btn-apply">Apply Now</span>
                </div>
              </div>
            </router-link>
            <router-link class="job-listings" to="/job-detail">
              <div class="row">
                <div class="col-lg-4 col-md-4 col-xs-12">
                  <div class="job-company-logo">
                    <img src="../../assets/img/features/img4.png" alt="" />
                  </div>
                  <div class="job-details">
                    <h3>App Developer</h3>
                    <span class="company-neme">
                      AmazeSoft
                    </span>
                  </div>
                </div>
                <div class="col-lg-2 col-md-2 col-xs-12 text-center">
                  <span class="btn-open">
                    7 Open Jobs
                  </span>
                </div>
                <div class="col-lg-2 col-md-2 col-xs-12 text-right">
                  <div class="location">
                    <i class="lni-map-marker"></i> New Yourk, US
                  </div>
                </div>
                <div class="col-lg-2 col-md-2 col-xs-12 text-right">
                  <span class="btn-full-time">Full Time</span>
                </div>
                <div class="col-lg-2 col-md-2 col-xs-12 text-right">
                  <span class="btn-apply">Apply Now</span>
                </div>
              </div>
            </router-link>
          </div>
        </div>
      </div>
    </section>
    <!-- Listings Section End -->
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
  name: 'SearchJob',
  components: { NavBar }
};
</script>
