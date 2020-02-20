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
              <h3>Create Resume</h3>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- Page Header End -->
    <!-- Content section Start -->
    <p style="display: none">{{ (resumeid = this.$route.params.resumeid) }}</p>
    <section id="content">
      <div class="container">
        <div class="row">
          <div class="col-lg-4 col-md-12 col-xs-12">
            <right-side-bar></right-side-bar>
          </div>
          <div class="col-lg-8 col-md-8 col-xs-12">
            <div class="add-resume box">
              <form class="form-ad">
                <h3>Basic information</h3>
                <div class="form-group">
                  <label class="control-label">Name</label>
                  <input
                    type="text"
                    class="form-control"
                    placeholder="Name"
                    v-model="name"
                  />
                </div>
                <div class="form-group">
                  <label class="control-label">Mail</label>
                  <input
                    type="text"
                    class="form-control"
                    placeholder="Your@domain.com"
                    v-model="mail"
                    @keydown.space.prevent
                  />
                </div>
                <div class="form-group">
                  <label class="control-label">Phone</label>
                  <input
                    type="text"
                    class="form-control"
                    placeholder="07123456789"
                    v-model="phone"
                    @keydown.space.prevent
                  />
                </div>
                <div class="form-group">
                  <label class="control-label">Target Position</label>
                  <input
                    type="text"
                    class="form-control"
                    placeholder="Headline (e.g. Front-end developer)"
                    v-model="intention"
                  />
                </div>
                <div class="form-group">
                  <label class="control-label">Location</label>
                  <input
                    type="text"
                    class="form-control"
                    placeholder="Location, e.g"
                    v-model="location"
                  />
                </div>
                <div class="form-group">
                  <label class="control-label">Website</label>
                  <input
                    type="text"
                    class="form-control"
                    placeholder="Website address"
                    v-model="website"
                    @keydown.space.prevent
                  />
                </div>
                <div class="form-group">
                  <label class="control-label">Personal Statement</label>
                  <textarea
                    class="form-control"
                    rows="7"
                    v-model="statement"
                  ></textarea>
                </div>
                <h3>Education (Highest Degree)</h3>
                <div class="form-group">
                  <label class="control-label">School</label>
                  <input
                    type="text"
                    class="form-control"
                    placeholder="School name"
                    v-model="school"
                  />
                </div>
                <div class="form-group">
                  <label class="control-label">Major of Study</label>
                  <input
                    type="text"
                    class="form-control"
                    placeholder="Major, e.g Computer Science"
                    v-model="major"
                  />
                </div>
                <div class="form-group">
                  <div class="row">
                    <div class="col-md-6">
                      <label class="control-label">Date From</label>
                      <input
                        class="form-control"
                        type="date"
                        v-model="edustart"
                      />
                    </div>
                    <div class="col-md-6">
                      <label class="control-label">Date To</label>
                      <input
                        class="form-control"
                        type="date"
                        v-model="eduend"
                      />
                    </div>
                  </div>
                </div>
                <div class="form-group">
                  <label class="control-label">Description</label>
                  <textarea
                    class="form-control"
                    rows="7"
                    v-model="edudescript"
                  ></textarea>
                </div>
                <div class="divider"><h3>Work Experience</h3></div>
                <div v-for="(job, index) in jobs" :key="index">
                  <div class="form-group">
                    <label class="control-label">Company Name</label>
                    <input
                      type="text"
                      class="form-control"
                      placeholder="Company name"
                      v-model="job.companyname"
                    />
                  </div>
                  <div class="form-group">
                    <label class="control-label">Job Title</label>
                    <input
                      type="text"
                      class="form-control"
                      placeholder="e.g UI/UX Researcher"
                      v-model="job.jobtitle"
                    />
                  </div>
                  <div class="form-group">
                    <div class="row">
                      <div class="col-md-6">
                        <label class="control-label">Date From</label>
                        <input
                          class="form-control"
                          type="date"
                          v-model="job.jobstart"
                        />
                      </div>
                      <div class="col-md-6">
                        <label class="control-label">Date To</label>
                        <input
                          class="form-control"
                          type="date"
                          v-model="job.jobend"
                        />
                      </div>
                    </div>
                  </div>
                  <div class="form-group">
                    <label class="control-label">Description</label>
                    <textarea
                      class="form-control"
                      rows="7"
                      v-model="job.jobdescript"
                    ></textarea>
                  </div>
                  <div class="add-post-btn">
                    <input
                      type="button"
                      class="btn btn-common log-btn mt-3 float-left"
                      @click="addNewJob"
                      value="Add"
                      v-show="index == jobs.length - 1"
                    />
                    <input
                      type="button"
                      class="btn btn-common log-btn mt-3 float-right"
                      @click="jobs.splice(1, index)"
                      value="Remove"
                      v-show="index || (!index && jobs.length > 1)"
                    />
                  </div>
                </div>
              </form>
              <button class="btn btn-common log-btn mt-3" @click="saveResume">
                Save
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
import RightSideBar from "@/components/utils/RightSideBar.vue";
import resume from "@/api/resume";
import job from "@/api/job";
export default {
  name: "ManageResume",
  components: { NavBar, RightSideBar },
  data() {
    return {
      resumeid: -1,
      mail: "",
      name: "",
      phone: "",
      location: "",
      intention: "",
      website: "",
      statement: "",
      school: "",
      major: "",
      edustart: "",
      eduend: "",
      edudescript: "",
      jobs: []
    };
  },
  watch: {
    resumeid() {
      job.getJob().then(res => {
        this.jobs = res.data;
      });
      resume.getResumeByResumeid(this.resumeid).then(res => {
        this.name = res.data.name;
        this.mail = res.data.mail;
        this.intention = res.data.intention;
        this.location = res.data.location;
        this.phone = res.data.phone;
        this.website = res.data.website;
        this.statement = res.data.statement;
        this.school = res.data.school;
        this.major = res.data.major;
        this.edustart = res.data.edustart;
        this.eduend = res.data.eduend;
        this.edudescript = res.data.edudescript;
      });
    }
  },
  methods: {
    addNewJob() {
      this.jobs.push({
        companyname: "",
        jobtitle: "",
        jobstart: "",
        jobend: "",
        jobdescript: ""
      });
    },
    saveResume() {
      if (this.mail.length <= 0) {
        this.$message({
          message: "Incomplete info",
          type: "error"
        });
        return;
      }
      var reg = new RegExp(
        /^([a-zA-Z0-9._-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/
      );
      if (!reg.test(this.mail)) {
        this.$message({
          message: "Incorrect mail format",
          type: "error"
        });
        return;
      }
      resume
        .manageResume(
          this.resumeid,
          this.mail,
          this.name,
          this.phone,
          this.location,
          this.intention,
          this.website,
          this.statement,
          this.school,
          this.major,
          this.edustart,
          this.eduend,
          this.edudescript,
          this.jobs
        )
        .then(res => {
          this.$alert("Edit successful", "Hint", {
            confirmButtonText: "Confirm",
            callback: action => {
              if (action == "confirm") {
                this.$router.push({
                  name: "Resume",
                  params: {
                    resumeid: this.resumeid
                  }
                });
              }
            }
          });
        });
    }
  }
};
</script>
