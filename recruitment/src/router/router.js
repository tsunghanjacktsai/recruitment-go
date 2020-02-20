import Vue from "vue";
import Router from "vue-router";
import Home from "@/components/home/Home.vue";
import Login from "@/components/security/Login.vue";
import Logout from "@/components/security/Logout.vue";
import ChangePassword from "@/components/security/ChangePassword.vue";
import ForgetPassword from "@/components/security/ForgetPassword.vue";
import Register from "@/components/security/Register.vue";
import NotFound from "@/components/utils/NotFound.vue";
import Resume from "@/components/candidate/Resume.vue";
import BrowseAllJob from "@/components/candidate/BrowseAllJob.vue";
import BrowseJobByCategory from "@/components/candidate/BrowseJobByCategory.vue";
import ManageResume from "@/components/candidate/ManageResume.vue";
import BrowseCategory from "@/components/candidate/BrowseCategory.vue";
import SearchJob from "@/components/candidate/SearchJob.vue";
import JobDetail from "@/components/candidate/JobDetail.vue";
import Notification from "@/components/candidate/Notification.vue";
import AddJob from "@/components/employer/AddJob.vue";
import EditJob from "@/components/employer/EditJob.vue";
import ManageJob from "@/components/employer/ManageJob.vue";
import ManageApplication from "@/components/candidate/ManageApplication.vue";
import ViewApplication from "@/components/employer/ViewApplication.vue";
import EvaluateApplication from "@/components/employer/EvaluateApplication.vue";
import BrowseResume from "@/components/employer/BrowseResume.vue";
import CandidateResume from "@/components/employer/CandidateResume.vue";
import AddDiscussion from "@/components/employer/AddDiscussion.vue";
import DiscussionDetail from "@/components/employer/DiscussionDetail.vue";

Vue.use(Router);

const routerPush = Router.prototype.push;
Router.prototype.push = function push(location) {
  return routerPush.call(this, location).catch(error => error);
};

export default new Router({
  routes: [
    {
      path: "/",
      redirect: "/login"
    },
    {
      path: "*",
      name: "NotFound",
      component: NotFound
    },
    {
      path: "/logout",
      name: "Logout",
      component: Logout
    },
    {
      path: "/home",
      name: "Home",
      component: Home
    },
    {
      path: "/register",
      name: "Register",
      component: Register
    },
    {
      path: "/login",
      name: "Login",
      component: Login
    },
    {
      path: "/change-password",
      name: "ChangePassword",
      component: ChangePassword
    },
    {
      path: "/forget-password",
      name: "ForgetPassword",
      component: ForgetPassword
    },
    {
      path: "/resume/:resumeid",
      name: "Resume",
      component: Resume
    },
    {
      path: "/browse-all-job",
      name: "BrowseAllJob",
      component: BrowseAllJob
    },
    {
      path: "/browse-job-by-category/:category",
      name: "BrowseJobByCategory",
      component: BrowseJobByCategory
    },
    {
      path: "/manage-resume/:resumeid",
      name: "ManageResume",
      component: ManageResume
    },
    {
      path: "/browse-category",
      name: "BrowseCategory",
      component: BrowseCategory
    },
    {
      path: "/search-job/:keyword",
      name: "SearchJob",
      component: SearchJob
    },
    {
      path: "/job-detail/:postid",
      name: "JobDetail",
      component: JobDetail
    },
    {
      path: "/notification",
      name: "Notification",
      component: Notification
    },
    {
      path: "/add-job",
      name: "AddJob",
      component: AddJob
    },
    {
      path: "/edit-job/:postid",
      name: "EditJob",
      component: EditJob
    },
    {
      path: "/manage-job",
      name: "ManageJob",
      component: ManageJob
    },
    {
      path: "/manage-application",
      name: "ManageApplication",
      component: ManageApplication
    },
    {
      path: "/view-application/:postid",
      name: "ViewApplication",
      component: ViewApplication
    },
    {
      path: "/evaluate-application/:resumeid",
      name: "EvaluateApplication",
      component: EvaluateApplication
    },
    {
      path: "/browse-resume",
      name: "BrowseResume",
      component: BrowseResume
    },
    {
      path: "/candidate-resume/:userid",
      name: "CandidateResume",
      component: CandidateResume
    },
    {
      path: "/add-discussion/:replytoid?",
      name: "AddDiscussion",
      component: AddDiscussion
    },
    {
      path: "/discussion-detail/:notificationid",
      name: "DiscussionDetail",
      component: DiscussionDetail
    }
  ]
});
