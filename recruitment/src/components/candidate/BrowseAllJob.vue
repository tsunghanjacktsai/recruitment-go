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
              <h3>Browse Jobs</h3>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- Page Header End -->

    <!-- Job Browse Section Start -->
    <section class="job-browse section">
      <div class="container">
        <div class="job-search-form job-featured-search">
          <form>
            <div class="row justify-content-center">
              <div class="form-group">
                <input
                  class="form-control"
                  type="text"
                  placeholder="Job Title or Company Name"
                  v-model="researchKeyword"
                />
              </div>
              <button type="button" class="button" @click="searchJob">
                <i class="lni-search"></i>
              </button>
            </div>
          </form>
        </div>
        <div v-for="(post, index) in posts" :key="index">
          <div class="row">
            <div class="col-lg-12 col-md-12 col-xs-12">
              <div class="job-listings">
                <div class="row">
                  <div class="col-lg-3 col-md-3 col-xs-12 text-center">
                    <div class="job-details">
                      <h3>
                        {{ post.jobname }}
                      </h3>
                      <span class="company-neme">
                        {{ post.companyname }}
                      </span>
                    </div>
                  </div>
                  <div class="col-lg-3 col-md-3 col-xs-12 text-center">
                    <div class="location">
                      <i class="lni-map-marker"></i> {{ post.location }}
                    </div>
                  </div>
                  <div class="col-lg-3 col-md-3 col-xs-12 text-center">
                    <span
                      class="btn-open"
                      @click="browseByCategory(post.category)"
                      >{{ post.category }}</span
                    >
                  </div>
                  <div class="col-lg-3 col-md-3 col-xs-12 text-center">
                    <button
                      class="btn btn-common"
                      @click="viewJobDetail(post.postid)"
                    >
                      Details
                    </button>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!-- Job Browse Section End -->
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
import post from "@/api/post";
export default {
  name: "BrowseAllJob",
  components: { NavBar },
  data() {
    return {
      researchKeyword: "",
      posts: []
    };
  },
  mounted() {
    this.loadPosts();
  },
  methods: {
    loadPosts() {
      post.getAllPosts().then(res => {
        this.posts = res.data;
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
    },
    searchJob() {
      if (this.researchKeyword.length > 0) {
        this.$router.push({
          name: "SearchJob",
          params: {
            keyword: this.researchKeyword
          }
        });
      } else {
        this.$message({
          message: "You have not entered the keyword",
          type: "error"
        });
        return;
      }
    }
  }
};
</script>
