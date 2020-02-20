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
    <p style="display: none">{{ (postid = this.$route.params.postid) }}</p>
    <!-- Start Content -->
    <div id="content">
      <div class="container">
        <div class="row">
          <div class="col-lg-12 col-md-12 col-xs-12 align-items-center">
            <div class="job-alerts-item">
              <h3 class="alerts-title">Evaluate applications</h3>
              <div class="alerts-list">
                <div class="row">
                  <div class="col-lg-2 col-md-2 col-xs-12">
                    <p>Rank</p>
                  </div>
                  <div class="col-lg-4 col-md-4 col-xs-12">
                    <p>Resume</p>
                  </div>
                  <div class="col-lg-3 col-md-3 col-xs-12">
                    <p>Evaluation</p>
                  </div>
                  <div class="col-lg-3 col-md-3 col-xs-12">
                    <p>Average</p>
                  </div>
                </div>
              </div>
              <div v-for="(application, index) in applications" :key="index">
                <div class="mb-4" v-if="index === 0">
                  <hr data-content="Passed Candidates" class="hr-text" />
                </div>
                <div class="mb-4" v-if="index === picknum">
                  <hr data-content="Rejected Candidates" class="hr-text" />
                </div>
                <div class="applications-content">
                  <div class="row">
                    <div class="col-md-2">
                      <h3>#{{ index + 1 }}</h3>
                    </div>
                    <div class="col-md-4">
                      <a
                        href="#"
                        @click="viewCandidate(application.applicationid)"
                      >
                        <h3>{{ application.applicant }}</h3>
                      </a>
                    </div>
                    <div class="col-md-3">
                      <a
                        href="#"
                        class="btn btn-success btn-xs"
                        @click="viewCandidate(application.applicationid)"
                        >Evaluate</a
                      >
                    </div>
                    <div class="col-md-3">
                      <h3>{{ application.scoreavg | rounding }}</h3>
                    </div>
                  </div>
                </div>
                <br />
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- End Content -->
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
import NavBar from "@/components/utils/NavBar.vue";
import RightSideBar from "@/components/utils/RightSideBar.vue";
import application from "@/api/application";
import post from "@/api/post";
export default {
  name: "ViewApplication",
  components: { NavBar, RightSideBar },
  data() {
    return {
      postid: -1,
      applications: [],
      picknum: -1
    };
  },
  filters: {
    rounding(value) {
      return value.toFixed(2);
    }
  },
  mounted() {
    this.loadApplicationList(this.postid);
  },
  methods: {
    loadApplicationList(postid) {
      post.getPostByPostid(this.postid).then(res => {
        this.picknum = res.data.picknum;
      });
      application.getApplicationsByPostid(postid).then(res => {
        this.applications = res.data;
      });
    },
    viewCandidate(applicationid) {
      this.$router.push({
        name: "EvaluateApplication",
        params: {
          applicationid: applicationid
        }
      });
    }
  }
};
</script>
