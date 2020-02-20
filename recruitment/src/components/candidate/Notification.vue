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
              <h3>Notifications</h3>
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
          <div class="col-md-8 col-sm-8 col-xs-12">
            <div v-for="(notification, index) in notifications" :key="index">
              <div class="alerts-content">
                <div class="row">
                  <div
                    class="col-lg-8 col-md-8 col-xs-12"
                    style="text-align: left;"
                  >
                    <p>
                      {{ notification.content }}
                    </p>
                  </div>
                  <div class="col-lg-2 col-md-2 col-xs-12">
                    <div v-if="notification.ifDiscussion">
                      <button
                        class="btn btn-common log-btn"
                        @click="viewDiscussion(notification.notificationid)"
                      >
                        View
                      </button>
                    </div>
                  </div>
                  <div class="col-lg-2 col-md-2 col-xs-12">
                    <button
                      class="btn btn-danger log-btn"
                      @click="deleteNotification(notification.notificationid)"
                    >
                      Delete
                    </button>
                  </div>
                </div>
              </div>
              <br />
            </div>
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
#notification-content {
  display: inline-block;
  float: left;
}
#notification-delete-btn {
  display: inline-block;
  float: right;
}
#notification-view-btn {
  display: inline-block;
  float: right;
  margin-right: 2px;
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
import notification from "@/api/notification";
export default {
  name: "ChangePassword",
  components: { NavBar, RightSideBar },
  data() {
    return {
      notifications: []
    };
  },
  mounted() {
    this.loadNotifications();
  },
  methods: {
    loadNotifications() {
      notification.getNotificationsByUser().then(res => {
        this.notifications = res.data;
      });
    },
    viewDiscussion(notificationid) {
      this.$router.push({
        name: "DiscussionDetail",
        params: {
          notificationid: notificationid
        }
      });
    },
    deleteNotification(notificationid) {
      this.$alert("Are you sure to delete?", "Hint", {
        confirmButtonText: "Confirm",
        callback: action => {
          if (action == "confirm") {
            notification.deleteNotificationById(notificationid).then(res => {
              this.$message({
                message: "Delete successful",
                type: "success"
              });
              this.loadNotifications();
            });
          }
        }
      });
    }
  }
};
</script>
