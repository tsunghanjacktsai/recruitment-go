<template>
  <div>
    <!-- Header Section Start -->
    <header id="home" class="hero-area">
      <nav-bar></nav-bar>
      <div class="container">
        <div class="row space-100">
          <div class="col-lg-7 col-md-12 col-xs-12">
            <div class="contents">
              <h2 class="head-title">
                Welcome to<br />
                Recruitment Go
              </h2>
              <div class="job-search-form">
                <form>
                  <div class="row justify-content-center">
                    <div class="form-group">
                      <input
                        class="form-control"
                        type="text"
                        placeholder="Search jobs..."
                        v-model="keyword"
                      />
                    </div>
                    <button type="button" class="button" @click="searchJob">
                      <i class="lni-search"></i>
                    </button>
                  </div>
                </form>
              </div>
            </div>
          </div>
          <div class="col-lg-5 col-md-12 col-xs-12">
            <div class="intro-img">
              <img src="../../assets/img/intro.png" alt="" />
            </div>
          </div>
        </div>
      </div>
    </header>
    <!-- Header Section End -->

    <!-- Category Section Start -->
    <section class="category section bg-gray">
      <div class="container">
        <div class="row">
          <div class="col-lg-3 col-md-6 col-xs-12 f-category">
            <a href="#" @click="browseByCategory('Finance')">
              <div class="icon bg-color-1">
                <i class="lni-home"></i>
              </div>
              <h3>Finance</h3>
            </a>
          </div>
          <div class="col-lg-3 col-md-6 col-xs-12 f-category">
            <a href="#" @click="browseByCategory('Sale/Marketing')">
              <div class="icon bg-color-2">
                <i class="lni-world"></i>
              </div>
              <h3>Sale/Marketing</h3>
            </a>
          </div>
          <div class="col-lg-3 col-md-6 col-xs-12 f-category">
            <a href="#" @click="browseByCategory('Education/Training')">
              <div class="icon bg-color-3">
                <i class="lni-book"></i>
              </div>
              <h3>Education/Training</h3>
            </a>
          </div>
          <div class="col-lg-3 col-md-6 col-xs-12 f-category">
            <a href="#" @click="browseByCategory('IT/Engineering')">
              <div class="icon bg-color-4">
                <i class="lni-display"></i>
              </div>
              <h3>IT/Engineering</h3>
            </a>
          </div>
          <div class="col-lg-3 col-md-6 col-xs-12 f-category">
            <a href="#" @click="browseByCategory('Art/Design')">
              <div class="icon bg-color-5">
                <i class="lni-brush"></i>
              </div>
              <h3>Art/Design</h3>
            </a>
          </div>
          <div class="col-lg-3 col-md-6 col-xs-12 f-category">
            <a href="#" @click="browseByCategory('Healthcare')">
              <div class="icon bg-color-6">
                <i class="lni-heart"></i>
              </div>
              <h3>Healthcare</h3>
            </a>
          </div>
          <div class="col-lg-3 col-md-6 col-xs-12 f-category">
            <a href="#" @click="browseByCategory('Science')">
              <div class="icon bg-color-7">
                <i class="lni-funnel"></i>
              </div>
              <h3>Science</h3>
            </a>
          </div>
          <div class="col-lg-3 col-md-6 col-xs-12 f-category">
            <a href="#" @click="browseByCategory('Food/Service')">
              <div class="icon bg-color-8">
                <i class="lni-cup"></i>
              </div>
              <h3>Food/Service</h3>
            </a>
          </div>
        </div>
      </div>
    </section>
    <!-- Category Section End -->
    <!-- Post Section Start -->
    <section class="job-browse section">
      <div class="container">
        <div v-for="(post, index) in posts.slice(0, 4)" :key="index">
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
    <!-- Post Section End -->
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
  name: "Home",
  components: { NavBar },
  data() {
    return {
      keyword: "",
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
    searchJob() {
      if (this.keyword !== "") {
        this.$router.push({
          name: "SearchJob",
          params: {
            keyword: this.keyword
          }
        });
      } else {
        this.$message({
          message: "You have not entered the keyword",
          type: "error"
        });
        return;
      }
    },
    browseByCategory(category) {
      this.$router.push({
        name: "BrowseJobByCategory",
        params: {
          category: category
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
