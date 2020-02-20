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
              <h3>Evaluate Application</h3>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- Page Header End -->

    <p style="display: none">
      {{ (applicationid = this.$route.params.applicationid) }}
    </p>

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
              <div class="item" v-for="(job, index) in jobs" :key="index">
                <h3>Work Experience</h3>
                <h4>{{ job.companyname }}</h4>
                <h5>{{ job.jobtitle }}</h5>
                <span class="date">{{ job.jobstart }}</span>
                <span class="date">{{ job.jobend }}</span>
                <p id="statement">
                  {{ job.jobdescript }}
                </p>
                <br />
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
            </div>
          </div>
          <br />
          <br />
          <div class="col-lg-12 col-md-12 col-xs-12">
            <h3 id="score">Score</h3>
            <form>
              <div class="form-group">
                <div align="center">
                  <select
                    id="resume-score"
                    class="custom-select mr-sm-2"
                    v-model="selectedScore"
                  >
                    <option disabled value="">Please select</option>
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                    <option value="6">6</option>
                    <option value="7">7</option>
                    <option value="8">8</option>
                    <option value="9">9</option>
                    <option value="10">10</option>
                  </select>
                </div>
                <a
                  href="#"
                  class="btn btn-success btn-xs"
                  @click="submitScore()"
                  id="score-btn"
                >
                  Submit
                </a>
              </div>
            </form>
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
#score {
  font-size: 25px;
  margin-top: 10px;
}
#score-btn {
  margin-top: 15px;
}
#resume-score {
  width: 40%;
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
import application from "@/api/application";
import score from "@/api/score";
export default {
  name: "Resume",
  components: { NavBar, RightSideBar },
  data() {
    return {
      applicationid: -1,
      postid: -1,
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
      selectedScore: ""
    };
  },
  watch: {
    applicationid() {
      this.loadEvaluationPage();
    }
  },
  methods: {
    loadEvaluationPage() {
      job.getJob().then(res => {
        this.jobs = res.data;
      });
      resume.getResumeByApplicationid(this.applicationid).then(res => {
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
      });
      application
        .getApplicationByApplicationid(this.applicationid)
        .then(res => {
          this.postid = res.data.postid;
        });
      score.getApplicationScoreByMarker(this.applicationid).then(res => {
        this.selectedScore = res.data.score;
      });
    },
    submitScore() {
      if (this.selectedScore.length <= 0) {
        this.$message({
          message: "You haven't score the candidate",
          type: "error"
        });
        return;
      }
      application
        .scoreApplication(this.applicationid, this.selectedScore)
        .then(res => {
          this.$message({
            message: "You had scored the candidate",
            type: "success"
          });
          this.$router.push({
            name: "ViewApplication",
            params: {
              postid: this.postid
            }
          });
        });
    }
  }
};
</script>
