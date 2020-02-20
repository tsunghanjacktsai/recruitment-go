<template>
  <div>
    <!-- Header Section Start -->
    <header id="home" class="hero-area">
      <nav-bar></nav-bar>
      <div class="container">
        <div class="row space-100">
          <div class="col-lg-7 col-md-12 col-xs-12">
            <div class="contents">
              <h2 class="head-title">
                Find the <br />
                job that fits your life
              </h2>
              <div class="job-search-form">
                <form>
                  <div class="row">
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
                    <div class="col-lg-2 col-md-2 col-xs-12">
                      <button type="submit" class="button">
                        <i class="lni-search"></i>
                      </button>
                    </div>
                  </div>
                </form>
              </div>
            </div>
          </div>
          <div class="col-lg-5 col-md-12 col-xs-12">
            <div class="intro-img">
              <img src="../../assets/img/intro.png" alt="" />
            </div>
          </div>
        </div>
      </div>
    </header>
    <!-- Header Section End -->

    <!-- Category Section Start -->
    <section class="category section bg-gray">
      <div class="container">
        <div class="section-header">
          <h2 class="section-title">Browse Categories</h2>
          <p>Most popular categories of portal, sorted by popularity</p>
        </div>
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
            <router-link to="/browse-job">
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
  name: 'Index',
  components: { NavBar }
};
</script>
