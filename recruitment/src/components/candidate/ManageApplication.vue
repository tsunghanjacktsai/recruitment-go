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
              <h3>Manage Applications</h3>
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
          <div class="col-lg-4 col-md-12 col-xs-12">
            <right-side-bar></right-side-bar>
          </div>
          <div class="col-lg-8 col-md-8 col-xs-12">
            <router-link
              to="/browse-all-job"
              class="btn btn-common float-right mt-3 mr-3"
              >Discover</router-link
            >
            <div class="job-alerts-item candidates">
              <h3 class="alerts-title">Manage Applications</h3>
              <div class="alerts-list">
                <div class="row">
                  <div class="col-lg-4 col-md-4 col-xs-12">
                    <p>Name</p>
                  </div>
                  <div class="col-lg-4 col-md-4 col-xs-12">
                    <p>Category</p>
                  </div>
                  <div class="col-lg-4 col-md-4 col-xs-12">
                    <p>Operation</p>
                  </div>
                </div>
              </div>
              <div v-for="(application, index) in applications" :key="index">
                <div class="alerts-content">
                  <div class="row">
                    <div
                      class="col-lg-4 col-md-4 col-xs-12"
                      style="align-self: center;"
                    >
                      <h3>
                        <a href="#" @click="viewJobDetail(application.postid)">
                          {{ application.jobname }}
                        </a>
                      </h3>
                      <span class="location"
                        ><i class="lni-map-marker"></i
                        >{{ application.location }}</span
                      >
                    </div>
                    <div
                      class="col-lg-4 col-md-4 col-xs-12"
                      style="align-self: center;"
                    >
                      <p>
                        <span
                          class="full-time"
                          @click="browseByCategory(application.category)"
                          >{{ application.category }}</span
                        >
                      </p>
                    </div>
                    <div class="col-lg-4 col-md-4 col-xs-12">
                      <button
                        class="btn btn-danger log-btn"
                        @click="deleteApplication(application.applicationid)"
                      >
                        Delete
                      </button>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
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
import application from "@/api/application";
export default {
  name: "ManageApplication",
  components: { NavBar, RightSideBar },
  data() {
    return {
      applications: []
    };
  },
  mounted() {
    this.loadApplications();
  },
  methods: {
    loadApplications() {
      application.getApplicationsByUser().then(res => {
        this.applications = res.data;
      });
    },
    deleteApplication(applicationid) {
      this.$alert("Are you sure to delete?", "Hint", {
        confirmButtonText: "Confirm",
        callback: action => {
          if (action == "confirm") {
            application
              .deleteApplicationByApplicationid(applicationid)
              .then(res => {
                this.$message({
                  message: "Delete your application successful",
                  type: "success"
                });
                this.loadApplications();
              });
          }
        }
      });
    },
    viewJobDetail(postid) {
      this.$router.push({
        name: "JobDetail",
        params: {
          postid: postid
        }
      });
    },
    browseByCategory(category) {
      this.$router.push({
        name: "BrowseJobByCategory",
        params: {
          category: category
        }
      });
    }
  }
};
</script>
