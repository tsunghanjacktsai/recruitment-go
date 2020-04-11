<template>
  <div>
    <!-- Header Section Start -->
    <header id="home" class="hero-area">
      <nav-bar></nav-bar>
    </header>
    <!-- Header Section End -->

    <p style="display: none">{{ (postid = this.$route.params.postid) }}</p>

    <!-- Page Header Start -->
    <div class="page-header">
      <div class="container">
        <div class="row">
          <div class="col-lg-11 col-md-6 col-xs-12">
            <div class="breadcrumb-wrapper">
              <div class="content">
                <h3 class="product-title">{{ jobname }}</h3>
                <p class="brand">{{ companyname }}</p>
                <div class="tags">
                  <span><i class="lni-map-marker"></i>{{ location }}</span>
                </div>
                <p class="brand">Deadline: {{ due }}</p>
              </div>
            </div>
          </div>
          <div class="col-lg-1 col-md-6 col-xs-12">
            <div class="month-price">
              <span class="year">{{ salarytype }}</span>
              <div class="price">{{ salary }}￡</div>
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
          <div class="col-lg-12 col-md-12 col-xs-12">
            <div class="content-area">
              <h4>Job Description</h4>
              <p id="statement">
                {{ description }}
              </p>
              <h4>Job Criteria</h4>
              <p id="statement">
                {{ criteria }}
              </p>
              <button
                v-if="!disApply"
                class="btn btn-common"
                @click="applyJob()"
              >
                Apply job
              </button>
              <button v-else class="btn btn-common" disabled>
                Apply job
              </button>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!-- Job Detail Section End -->
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
<script src="../../assets/js/color-switcher.js"></script>
<script src="../../assets/js/owl.carousel.min.js"></script>
<script src="../../assets/js/jquery.slicknav.js"></script>
<script src="../../assets/js/jquery.counterup.min.js"></script>
<script src="../../assets/js/waypoints.min.js"></script>
<script src="../../assets/js/form-validator.min.js"></script>
<script src="../../assets/js/contact-form-script.js"></script>
<script src="../../assets/js/main.js"></script>
<script>
import NavBar from "@/components/utils/NavBar.vue";
import post from "@/api/post";
import application from "@/api/application";
export default {
  name: "JobDetail",
  components: { NavBar },
  data() {
    return {
      postid: -1,
      jobname: "",
      companyname: "",
      due: "",
      location: "",
      salary: "",
      salarytype: "",
      description: "",
      criteria: "",
      disApply: false
    };
  },
  watch: {
    postid() {
      this.loadPost();
    }
  },
  methods: {
    loadPost() {
      application.checkIfEvaluators(this.postid).then(res => {
        this.disApply = res.data;
      });
      application.checkIfApplied(this.postid).then(res => {
        this.disApply = res.data;
      });
      post.getPostByPostid(this.postid).then(res => {
        this.jobname = res.data.jobname;
        this.companyname = res.data.companyname;
        this.due = res.data.due;
        this.location = res.data.location;
        this.category = res.data.category;
        this.salary = res.data.salary;
        this.salarytype = res.data.salarytype;
        this.description = res.data.description;
        this.criteria = res.data.criteria;
      });
    },
    applyJob() {
      if (this.disApply == true) {
        this.$message({
          message: "You have already applied to this job",
          type: "error"
        });
        return;
      }
      this.$alert("Are you sure to apply?", "Hint", {
        confirmButtonText: "Confirm",
        callback: action => {
          if (action == "confirm") {
            application.applyToJob(this.postid).then(res => {
              this.$message({
                message: "Apply successful",
                type: "success"
              });
              this.disApply = true;
            });
          }
        }
      });
    }
  }
};
</script>
