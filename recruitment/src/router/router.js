import Vue from 'vue'
import Router from 'vue-router'
import Index from '@/components/home/Index.vue'
import Login from '@/components/security/Login.vue'
import Logout from '@/components/security/Logout.vue'
import ChangePassword from '@/components/security/ChangePassword.vue'
import ForgetPassword from '@/components/security/ForgetPassword.vue'
import Register from '@/components/security/Register.vue'
import NotFound from '@/components/utils/NotFound.vue'
import Resume from '@/components/candidate/Resume.vue'
import BrowseJob from '@/components/candidate/BrowseJob.vue'
import ManageResume from '@/components/candidate/ManageResume.vue'
import BrowseCategory from '@/components/candidate/BrowseCategory.vue'
import SearchJob from '@/components/candidate/SearchJob.vue'
import JobDetail from '@/components/candidate/JobDetail.vue'
import Notification from '@/components/candidate/Notification.vue'
import AddJob from '@/components/employer/AddJob.vue'
import ManageJob from '@/components/employer/ManageJob.vue'
import EvaluateApplication from '@/components/employer/EvaluateApplication.vue'
import BrowseResume from '@/components/employer/BrowseResume.vue'
import CandidateResume from '@/components/employer/CandidateResume.vue'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      redirect: '/login'
    },
    {
      path: '*',
      name: 'NotFound',
      component: NotFound
    },
    {
      path: '/logout',
      name: 'Logout',
      component: Logout
    },
    {
      path: '/index',
      name: 'Index',
      component: Index
    },
    {
      path: '/register',
      name: 'Register',
      component: Register
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/change-password',
      name: 'ChangePassword',
      component: ChangePassword
    },
    {
      path: '/forget-password',
      name: 'ForgetPassword',
      component: ForgetPassword
    },
    {
      path: '/resume',
      name: 'Resume',
      component: Resume
    },
    {
      path: '/browse-job',
      name: 'BrowseJob',
      component: BrowseJob
    },
    {
      path: '/manage-resume',
      name: 'ManageResume',
      component: ManageResume
    },
    {
      path: '/browse-category',
      name: 'BrowseCategory',
      component: BrowseCategory
    },
    {
      path: '/search-job',
      name: 'SearchJob',
      component: SearchJob
    },
    {
      path: '/job-detail/:postid',
      name: 'JobDetail',
      component: JobDetail
    },
    {
      path: '/notification',
      name: 'Notification',
      component: Notification
    },
    {
      path: '/add-job',
      name: 'AddJob',
      component: AddJob
    },
    {
      path: '/manage-job',
      name: 'ManageJob',
      component: ManageJob
    },
    {
      path: '/Evaluate-application',
      name: 'EvaluateApplication',
      component: EvaluateApplication
    },
    {
      path: '/browse-resume',
      name: 'BrowseResume',
      component: BrowseResume
    },
    {
      path: '/candidate-resume/:userid',
      name: 'CandidateResume',
      component: CandidateResume
    }
  ]
})
