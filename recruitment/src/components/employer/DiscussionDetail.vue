<template>
  <div>
    <!-- Header Section Start -->
    <header id="home" class="hero-area">
      <nav-bar></nav-bar>
    </header>
    <!-- Header Section End -->

    <p style="display: none">
      {{ (notificationid = this.$route.params.notificationid) }}
    </p>

    <!-- Page Header Start -->
    <div class="page-header">
      <div class="container">
        <div class="row">
          <div class="col-lg-12">
            <div class="inner-header">
              <h3>Discussion Details</h3>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- Page Header End -->
    <section class="section">
      <div class="container">
        <div class="row">
          <div class="col-lg-4 col-md-12 col-xs-12">
            <right-side-bar></right-side-bar>
          </div>
          <div class="col-lg-8 col-md-8 col-xs-12">
            <div class="post-job box">
              <h3 class="job-title">{{ title }}</h3>
              <p id="disucssion-content">{{ content }}</p>
              <button
                class="btn btn-common log-btn mt-3"
                @click="replyDiscussion(senderid)"
              >
                Reply
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
#discussion-content {
  white-space: pre-line;
  margin-top: 0px;
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
import discussion from "@/api/discussion";
export default {
  name: "DiscussionDetail",
  components: { NavBar, RightSideBar },
  data() {
    return {
      notificationid: -1,
      senderid: -1,
      title: "",
      content: ""
    };
  },
  watch: {
    notificationid() {
      this.loadDiscussions();
    }
  },
  methods: {
    loadDiscussions() {
      discussion
        .getDiscussionByNotificationid(this.notificationid)
        .then(res => {
          this.title = res.data.title;
          this.content = res.data.content;
          this.senderid = res.data.senderid;
        });
    },
    replyDiscussion(replytoid) {
      this.$router.push({
        name: "AddDiscussion",
        params: {
          replytoid: replytoid
        }
      });
    }
  }
};
</script>
