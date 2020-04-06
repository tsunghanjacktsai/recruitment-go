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
              <h3>Post Jobs</h3>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- Page Header End -->
    <!-- Content section Start -->
    <section class="section">
      <div class="container">
        <div class="row justify-content-center">
          <div class="col-lg-9 col-md-12 col-xs-12">
            <div class="post-job box">
              <h3 class="job-title">Post a new Job</h3>
              <form class="form-ad">
                <div class="form-group">
                  <label class="control-label">Job Title</label>
                  <input
                    type="text"
                    class="form-control"
                    placeholder="Write job title"
                    v-model="jobname"
                  />
                </div>
                <div class="form-group">
                  <label class="control-label">Company</label>
                  <input
                    type="text"
                    class="form-control"
                    placeholder="Write company name"
                    v-model="companyname"
                  />
                </div>
                <div class="form-group">
                  <label class="control-label">Location</label>
                  <input
                    type="text"
                    class="form-control"
                    placeholder="e.g.London"
                    v-model="location"
                  />
                </div>
                <label class="control-label">Salary</label>
                <div class="input-group">
                  <div class="input-group-prepend">
                    <span class="input-group-text">￡</span>
                  </div>
                  <input
                    type="text"
                    class="form-control"
                    placeholder="Salary"
                    v-model="salary"
                    @keydown.space.prevent
                  />
                  <select
                    class="dropdown-product selectpicker"
                    id="salaryType"
                    v-model="salarytype"
                  >
                    <option value="Per Year">/Year</option>
                    <option value="Per Month">/Month</option>
                    <option value="Per Day">/Day</option>
                    <option value="Per Hour">/Hour</option>
                  </select>
                </div>
                <div class="form-group">
                  <label class="control-label">Category</label>
                  <div class="search-category-container">
                    <label class="styled-select">
                      <select
                        class="dropdown-product selectpicker"
                        v-model="category"
                      >
                        <option value="Finance">Finance</option>
                        <option value="IT/Engineering">IT/Engineering</option>
                        <option value="Education/Training"
                          >Education/Training</option
                        >
                        <option value="Art/Design">Art/Design</option>
                        <option value="Sale/Marketing">Sale/Marketing</option>
                        <option value="Healthcare">Healthcare</option>
                        <option value="Science">Science</option>
                        <option value="Food/Service">Food/Service</option>
                      </select>
                    </label>
                  </div>
                </div>
                <div class="form-group">
                  <label class="control-label">Job Description</label>
                  <textarea
                    class="form-control"
                    rows="5"
                    placeholder="Describe about the job responsibility..."
                    v-model="description"
                  ></textarea>
                </div>
                <div class="form-group">
                  <label class="control-label">Job Criteria</label>
                  <textarea
                    class="form-control"
                    rows="5"
                    placeholder="Desribe about the job criteria"
                    v-model="criteria"
                  ></textarea>
                </div>
                <div class="form-group">
                  <label class="control-label"
                    >Deadline
                    <span>(send selection results to candidates)</span></label
                  >
                  <input
                    class="form-control"
                    type="datetime-local"
                    v-model="due"
                  />
                </div>
                <div class="form-group">
                  <label class="control-label">Target Picks</label>
                  <input
                    type="text"
                    class="form-control"
                    placeholder="Number of final picks"
                    v-model="picknum"
                    @keydown.space.prevent
                  />
                </div>
                <div class="form-group">
                  <label class="control-label">Invite Evaluators</label>
                  <vue-tags-input
                    v-model="evaluator"
                    :tags="evaluators"
                    @tags-changed="
                      (newEvaluators) => (evaluators = newEvaluators)
                    "
                  />
                </div>
              </form>
              <button class="btn btn-common log-btn mt-3" @click="submitPost">
                Submit
              </button>
            </div>
          </div>
        </div>
      </div>
    </section>
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
import NavBar from "@/components/utils/NavBar.vue";
import VueTagsInput from "@johmun/vue-tags-input";
import post from "@/api/post";
export default {
  name: "AddJob",
  components: { NavBar, VueTagsInput },
  data() {
    return {
      jobname: "",
      companyname: "",
      location: "",
      category: "Finance",
      salary: "",
      salarytype: "Per Year",
      description: "",
      criteria: "",
      picknum: "",
      due: "",
      evaluator: "",
      evaluators: [],
    };
  },
  methods: {
    submitPost() {
      if (
        this.jobname.length <= 0 ||
        this.companyname.length <= 0 ||
        this.location.length <= 0 ||
        this.category.length <= 0 ||
        this.salary.length <= 0 ||
        this.salarytype.length <= 0 ||
        this.description.length <= 0 ||
        this.criteria.length <= 0 ||
        this.picknum.length <= 0 ||
        this.due.length <= 0
      ) {
        this.$message({
          message: "Incomplete info",
          type: "error",
        });
        return;
      }
      post
        .submitPost(
          this.jobname,
          this.companyname,
          this.location,
          this.category,
          this.salary,
          this.salarytype,
          this.description,
          this.criteria,
          this.picknum,
          this.due,
          this.evaluators
        )
        .then((res) => {
          this.$alert("Add job successful", "Hint", {
            confirmButtonText: "Confirm",
            callback: (action) => {
              if (action == "confirm") {
                this.$router.push({
                  path: "/manage-job",
                });
              }
            },
          });
        });
    },
  },
};
</script>
