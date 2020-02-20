<template>
  <div>
    <!-- Header Section Start -->
    <header id="home" class="hero-area">
      <nav-bar></nav-bar>
    </header>
    <!-- Header Section End -->

    <p style="display: none">
      {{ (replytoid = this.$route.params.replytoid) }}
    </p>

    <!-- Page Header Start -->
    <div class="page-header">
      <div class="container">
        <div class="row">
          <div class="col-lg-12">
            <div class="inner-header">
              <h3>Electronic Discussion</h3>
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
              <h3 class="job-title">Electronic Discussion</h3>
              <form class="form-ad">
                <div class="form-group">
                  <label class="control-label">Subject</label>
                  <input
                    type="text"
                    class="form-control"
                    placeholder="Subject..."
                    v-model="title"
                  />
                </div>
                <div class="form-group">
                  <label class="control-label"
                    >Receivers (Username or Email)</label
                  >
                  <vue-tags-input
                    v-model="receiver"
                    :tags="receivers"
                    @tags-changed="newReceivers => (receivers = newReceivers)"
                  />
                </div>
                <div class="form-group">
                  <label class="control-label">Job Description</label>
                  <textarea
                    class="form-control"
                    rows="15"
                    placeholder="Message..."
                    v-model="content"
                  ></textarea>
                </div>
              </form>
              <button
                class="btn btn-common log-btn mt-3"
                @click="sendDiscussion()"
              >
                Send
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
import VueTagsInput from "@johmun/vue-tags-input";
import discussion from "@/api/discussion";
export default {
  name: "Discussion",
  components: { NavBar, RightSideBar, VueTagsInput },
  data() {
    return {
      replytoid: -1,
      title: "",
      receiver: "",
      receivers: [],
      content: ""
    };
  },
  watch: {
    replytoid() {
      if (typeof this.replytoid !== "undefined") {
        this.loadReceiverByReplytoid();
      }
    }
  },
  methods: {
    loadReceiverByReplytoid() {
      discussion.getReceiverByReplytoid(this.replytoid).then(res => {
        this.receivers = res.data;
      });
    },
    sendDiscussion() {
      if (
        this.title.length <= 0 ||
        this.content.length <= 0 ||
        this.receivers.length <= 0
      ) {
        this.$message({
          message: "Incomplete info",
          type: "error"
        });
        return;
      }
      discussion
        .sendDiscussion(this.title, this.receivers, this.content)
        .then(res => {
          this.$alert("Are you sure to send this message?", "Hint", {
            confirmButtonText: "Confirm",
            callback: action => {
              if (action == "confirm") {
                this.$router.push({
                  name: "AddDiscussion"
                });
                this.receivers = [];
                this.title = "";
                this.content = "";
              }
            }
          });
        });
    }
  }
};
</script>
