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
              <h3>Browse Resume</h3>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- Page Header End -->
    <!-- Start Content -->
    <div id="content">
      <div class="container">
        <div
          v-for="(resumes, index) in groupedResumes"
          :key="index"
          class="row"
        >
          <div
            v-for="(resume, index) in resumes"
            :key="index"
            class="col-sm-6 col-md-6 col-xs-12"
          >
            <div class="manager-resumes-item">
              <div class="manager-content">
                <div class="manager-info">
                  <div class="manager-name">
                    <h4>
                      <a href="#" @click="resumeDetail(resume.resumeid)">
                        {{ resume.name }}
                      </a>
                    </h4>
                    <h5>{{ resume.intention }}</h5>
                  </div>
                  <div class="manager-meta">
                    <span class="location">
                      <i class="ti-location-pin"></i>
                      {{ resume.location }}
                    </span>
                  </div>
                </div>
              </div>
              <div class="item-body">
                <div class="content" id="statement">
                  <v-clamp autoresize :max-lines="4">
                    {{ resume.statement }}
                  </v-clamp>
                </div>
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
#statement {
  white-space: pre-line;
  margin-top: -30px;
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
import VClamp from "vue-clamp";
import resume from "@/api/resume";
import _ from "lodash";
export default {
  name: "BrowseResume",
  components: { NavBar, VClamp },
  data() {
    return {
      resumes: []
    };
  },
  mounted() {
    this.loadResumes();
  },
  computed: {
    groupedResumes() {
      return _.chunk(this.resumes, 2);
    }
  },
  methods: {
    loadResumes() {
      resume.getAllResumes().then(res => {
        this.resumes = res.data;
      });
    },
    resumeDetail(resumeid) {
      this.$router.push({
        name: "CandidateResume",
        params: {
          resumeid: resumeid
        }
      });
    }
  }
};
</script>
