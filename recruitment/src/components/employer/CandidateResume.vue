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
              <h3>Candidate Resume</h3>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- Page Header End -->

    <p style="display: none">{{ (resumeid = this.$route.params.resumeid) }}</p>

    <!-- Start Content -->
    <div class="section">
      <div class="container">
        <div class="row">
          <div class="col-lg-12 col-md-12 col-xs-12">
            <div class="inner-box my-resume">
              <div class="item author-resume">
                <h3>{{ name }}</h3>
                <p class="sub-title">{{ intention }}</p>
                <p>
                  <span class="address"
                    ><i class="lni-map-marker"></i>{{ location }}</span
                  >
                  <span><i class="ti-phone"></i>{{ phone }}</span>
                  <span>{{ mail }}</span>
                </p>
                <div class="social-link">
                  <a href="#" class="website">{{ website }}</a>
                </div>
              </div>
              <div class="about-me item">
                <h3>About Me</h3>
                <p id="statement">
                  {{ statement }}
                </p>
              </div>
              <div class="education item">
                <h3>Education (Highest Degree)</h3>
                <h4>{{ school }}</h4>
                <p>{{ major }}</p>
                <span class="date">{{ edustart }}</span>
                <span class="date">{{ eduend }}</span>
                <p id="statement">
                  {{ edudescript }}
                </p>
              </div>
              <h3 id="work-experience">Work Experience</h3>
              <div class="item" v-for="(job, index) in jobs" :key="index">
                <h4>{{ job.companyname }}</h4>
                <h5>{{ job.jobtitle }}</h5>
                <span class="date">{{ job.jobstart }}</span>
                <span class="date">{{ job.jobend }}</span>
                <p id="statement">
                  {{ job.jobdescript }}
                </p>
                <br />
              </div>
              <div
                style="text-align:right;text-decoration: bold;font-weight: bold;"
              >
                Username: {{ username }}
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
#work-experience {
  font-size: 20px;
  letter-spacing: 0.5px;
  text-align: left;
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
import resume from "@/api/resume";
import job from "@/api/job";
export default {
  name: "Resume",
  components: { NavBar, RightSideBar },
  data() {
    return {
      resumeid: -1,
      name: "",
      intention: "",
      location: "",
      phone: "",
      mail: "",
      website: "",
      statement: "",
      school: "",
      major: "",
      edustart: "",
      eduend: "",
      edudescript: "",
      jobs: [],
      username: ""
    };
  },
  watch: {
    resumeid() {
      job.getJob().then(res => {
        this.jobs = res.data;
      });
      this.loadResume();
    }
  },
  methods: {
    loadResume() {
      resume.getResumeByResumeid(this.resumeid).then(res => {
        this.name = res.data.name;
        this.intention = res.data.intention;
        this.location = res.data.location;
        this.phone = res.data.phone;
        this.mail = res.data.mail;
        this.website = res.data.website;
        this.statement = res.data.statement;
        this.school = res.data.school;
        this.major = res.data.major;
        this.edustart = res.data.edustart;
        this.eduend = res.data.eduend;
        this.edudescript = res.data.edudescript;
        this.username = res.data.username;
      });
    }
  }
};
</script>
