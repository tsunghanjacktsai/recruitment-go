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
              <h3>Post Jobs</h3>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- Page Header End -->
    <!-- Content section Start -->
    <section class="section">
      <div class="container">
        <div class="row justify-content-center">
          <div class="col-lg-9 col-md-12 col-xs-12">
            <div class="post-job box">
              <h3 class="job-title">Post a new Job</h3>
              <form class="form-ad">
                <div class="form-group">
                  <label class="control-label">Job Title</label>
                  <input
                    type="text"
                    class="form-control"
                    placeholder="Write job title"
                  />
                </div>
                <div class="form-group">
                  <label class="control-label">Company</label>
                  <input
                    type="text"
                    class="form-control"
                    placeholder="Write company name"
                  />
                </div>
                <div class="form-group">
                  <label class="control-label">Location</label>
                  <input
                    type="text"
                    class="form-control"
                    placeholder="e.g.London"
                  />
                </div>
                <label class="control-label">Salary</label>
                <div class="input-group">
                  <input
                    type="text"
                    class="form-control"
                  />
                  <div class="input-group-append">
                    <select class="custom-select">
                      <option selected value="1">/Year</option>
                      <option value="2">/Month</option>
                      <option value="3">/Day</option>
                      <option value="4">/Hour</option>
                    </select>
                  </div>
                </div>
                <div class="form-group">
                  <label class="control-label">Category</label>
                  <div class="search-category-container">
                    <label class="styled-select">
                      <select class="dropdown-product selectpicker">
                        <option>Finance</option>
                        <option>IT & Engineering</option>
                        <option>Education/Training</option>
                        <option>Art/Design</option>
                        <option>Sale/Markting</option>
                        <option>Healthcare</option>
                        <option>Science</option>
                        <option>Food Services</option>
                      </select>
                    </label>
                  </div>
                </div>
                <div class="form-group">
                  <label class="control-label">Job Description</label>
                  <textarea
                    class="form-control"
                    id="jobDescription"
                    rows="5"
                  ></textarea>
                </div>
                <div class="form-group">
                  <label class="control-label">Job Criteria</label>
                  <textarea
                    class="form-control"
                    id="jobCriteria"
                    rows="5"
                  ></textarea>
                </div>
                <div class="form-group">
                  <label class="control-label"
                    >Deadline
                    <span>(send selection results to candidates)</span></label
                  >
                  <input class="form-control" type="date" />
                </div>
                <div class="form-group">
                  <label class="control-label">Target Picks</label>
                  <input
                    type="text"
                    class="form-control"
                    placeholder="Number of final picks"
                  />
                </div>
                <a href="#" class="btn btn-common">Submit your job</a>
              </form>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!-- Content section End -->
    <!-- Go To Top Link -->
    <a href="#" class="back-to-top">
      <i class="lni-arrow-up"></i>
    </a>

    <!-- Preloader -->
    <!-- <div id="preloader">
      <div class="loader" id="loader-1"></div>
    </div> -->
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
export default {
  name: "AddJob",
  components: { NavBar }
};
</script>
