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
              <h3>Manage Jobs</h3>
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
              to="/add-job"
              class="btn btn-common float-right mt-3 mr-3"
              >Add</router-link
            >
            <div class="job-alerts-item candidates">
              <h3 class="alerts-title">Manage Jobs</h3>
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
              <div v-for="(post, index) in posts" :key="index">
                <div class="alerts-content">
                  <div class="row">
                    <div
                      class="col-lg-4 col-md-4 col-xs-12"
                      style="align-self: center;"
                    >
                      <h3>
                        <a href="#" @click="viewJobDetail(post.postid)">
                          {{ post.jobname }}
                        </a>
                      </h3>
                      <span class="location"
                        ><i class="lni-map-marker"></i>{{ post.location }}</span
                      >
                    </div>
                    <div
                      class="col-lg-4 col-md-4 col-xs-12"
                      style="align-self: center;"
                    >
                      <p>
                        <span
                          class="full-time"
                          @click="browseByCategory(post.category)"
                          >{{ post.category }}</span
                        >
                      </p>
                    </div>
                    <div class="col-lg-4 col-md-4 col-xs-12">
                      <button
                        class="btn btn-common log-btn"
                        @click="viewApplications(post.postid)"
                      >
                        Applications
                      </button>
                      <button
                        class="btn btn-common log-btn mt-3"
                        @click="editPost(post.postid)"
                      >
                        Edit
                      </button>
                      <button
                        class="btn btn-danger log-btn mt-3"
                        @click="deletePost(post.postid)"
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
import post from "@/api/post";
export default {
  name: "ManageJob",
  components: { NavBar, RightSideBar },
  data() {
    return {
      posts: []
    };
  },
  mounted() {
    this.loadPosts();
  },
  methods: {
    loadPosts() {
      post.getPostsByEvaluator().then(res => {
        this.posts = res.data;
      });
    },
    deletePost(postid) {
      this.$alert("Are you sure to delete?", "Hint", {
        confirmButtonText: "Confirm",
        callback: action => {
          if (action == "confirm") {
            post.deletePost(postid).then(res => {
              this.$message({
                message: "Delete successful",
                type: "success"
              });
              this.loadPosts();
            });
          }
        }
      });
    },
    viewApplications(postid) {
      this.$router.push({
        name: "ViewApplication",
        params: {
          postid: postid
        }
      });
    },
    editPost(postid) {
      this.$router.push({
        name: "EditJob",
        params: {
          postid: postid
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
