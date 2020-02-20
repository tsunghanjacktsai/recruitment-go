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
              <h3>Evaluate Applications</h3>
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
          <div class="col-lg-12 col-md-12 col-xs-12 align-items-center">
            <div class="job-alerts-item">
              <h3 class="alerts-title">Evaluate applications</h3>
              <div class="alerts-list">
                <div class="row">
                  <div class="col-lg-4 col-md-4 col-xs-12">
                    <p>Resume</p>
                  </div>
                  <div class="col-lg-3 col-md-3 col-xs-12">
                    <p>Score</p>
                  </div>
                  <div class="col-lg-3 col-md-3 col-xs-12">
                    <p>Average</p>
                  </div>
                  <div class="col-lg-2 col-md-2 col-xs-12">
                    <p>Rank</p>
                  </div>
                </div>
              </div>
              <application-component v-for="application in applications" :key="application.id" :application="application" />
              <br />
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

.btn-group-xs > .btn,
.btn-xs {
  padding: 0.5rem 0.6rem;
  font-size: 0.75rem;
  line-height: 0.8;
  border-radius: 0.2rem;
}
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
import Vue from 'vue'
import NavBar from "@/components/utils/NavBar.vue";
import RightSideBar from "@/components/utils/RightSideBar.vue";
const applications = [
  {
    id: 1,
    img: "../../assets/img/jobs/img-1.jpg",
    name: "Jack",
    score: 7.0,
    rank: 1
  },
  {
    id: 2,
    img: "../../assets/img/jobs/img-1.jpg",
    name: "Vivian",
    score: 6.5,
    rank: 2
  },
  {
    id: 3,
    img: "../../assets/img/jobs/img-1.jpg",
    name: "Jervis",
    score: 5.0,
    rank: 3
  }
];
Vue.component("application-component", {
  template: `<div class="applications-content">
                <div class="row">
                  <div class="col-md-4">
                    <router-link to="/candidate-resume">
                      <div class="thums">
                        <img :src="application.img" alt="" />
                      </div>
                      <br />
                      <h3>{{ application.name }}</h3>
                    </router-link>
                  </div>
                  <div class="col-md-3">
                    <div class="form-group">
                      <select class="form-control">
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                        <option>5</option>
                        <option>6</option>
                        <option>7</option>
                        <option>8</option>
                        <option>9</option>
                        <option>10</option>
                      </select>
                    </div>
                    <a href="#" class="btn btn-success btn-xs">Submit</a>
                  </div>
                  <div class="col-md-3">
                    <br />
                    <h3>{{ application.score }}</h3>
                  </div>
                  <div class="col-md-2">
                    <br />
                    <h3>#{{ application.rank }}</h3>
                  </div>
                </div>
              </div>`,
  props: {
    application: Object
  }
});
export default {
  name: "EvaluateApplication",
  components: { NavBar, RightSideBar },
  data() {
    return {
      applications
    }
  }
};
</script>
