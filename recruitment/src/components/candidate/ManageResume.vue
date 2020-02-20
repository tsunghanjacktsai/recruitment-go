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
              <h3>Create Resume</h3>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- Page Header End -->
    <!-- Content section Start -->
    <section id="content">
      <div class="container">
        <div class="row">
          <div class="col-lg-4 col-md-12 col-xs-12">
            <right-side-bar></right-side-bar>
          </div>
          <div class="col-lg-8 col-md-8 col-xs-12">
            <div class="add-resume box">
              <form class="form-ad">
                <h3>Basic information</h3>
                <div class="form-group">
                  <label class="control-label">Name</label>
                  <input type="text" class="form-control" placeholder="Name" />
                </div>
                <div class="form-group">
                  <label class="control-label"></label>
                  <label class="control-label">Mail</label>
                  <input
                    type="text"
                    class="form-control"
                    placeholder="Your@domain.com"
                  />
                </div>
                <div class="form-group">
                  <label class="control-label"></label>
                  <label class="control-label">Phone</label>
                  <input
                    type="text"
                    class="form-control"
                    placeholder="+447123456789"
                  />
                </div>
                <div class="form-group">
                  <label class="control-label">Target Position</label>
                  <input
                    type="text"
                    class="form-control"
                    placeholder="Headline (e.g. Front-end developer)"
                  />
                </div>
                <div class="form-group">
                  <label class="control-label">Location</label>
                  <input
                    type="text"
                    class="form-control"
                    placeholder="Location, e.g"
                  />
                </div>
                <div class="form-group">
                  <label class="control-label">Website</label>
                  <input
                    type="text"
                    class="form-control"
                    placeholder="Website address"
                  />
                </div>
                <div class="form-group">
                  <label class="control-label">Age</label>
                  <input
                    type="text"
                    class="form-control"
                    placeholder="Years old"
                  />
                </div>
                <div class="form-group">
                  <label class="control-label">Personal Statement</label>
                  <textarea
                    class="form-control"
                    id="statement"
                    rows="7"
                  ></textarea>
                </div>
                <h3>Education</h3>
                <div class="form-group">
                  <label class="control-label">Highest Degree</label>
                  <input
                    type="text"
                    class="form-control"
                    placeholder="Degree, e.g. Bachelor"
                  />
                </div>
                <div class="form-group">
                  <label class="control-label">Major of Study</label>
                  <input
                    type="text"
                    class="form-control"
                    placeholder="Major, e.g Computer Science"
                  />
                </div>
                <div class="form-group">
                  <label class="control-label">School</label>
                  <input
                    type="text"
                    class="form-control"
                    placeholder="School name, e.g. Massachusetts Institute of Technology"
                  />
                </div>
                <div class="form-group">
                  <div class="row">
                    <div class="col-md-6">
                      <label class="control-label">Date From</label>
                      <input class="form-control" type="date" />
                    </div>
                    <div class="col-md-6">
                      <label class="control-label">Date To</label>
                      <input class="form-control" type="date" />
                    </div>
                  </div>
                </div>
                <div class="form-group">
                  <label class="control-label">Description</label>
                  <textarea class="form-control" rows="7"></textarea>
                </div>
                <div class="divider"><h3>Work Experience</h3></div>
                <div class="form-group">
                  <label class="control-label">Company Name</label>
                  <input
                    type="text"
                    class="form-control"
                    placeholder="Company name"
                  />
                </div>
                <div class="form-group">
                  <label class="control-label">Job Title</label>
                  <input
                    type="text"
                    class="form-control"
                    placeholder="e.g UI/UX Researcher"
                  />
                </div>
                <div class="form-group">
                  <div class="row">
                    <div class="col-md-6">
                      <label class="control-label">Date From</label>
                      <input class="form-control" type="date" />
                    </div>
                    <div class="col-md-6">
                      <label class="control-label">Date To</label>
                      <input class="form-control" type="date" />
                    </div>
                  </div>
                </div>
                <div class="form-group">
                  <label class="control-label">Description</label>
                  <textarea class="form-control" rows="7"></textarea>
                </div>
                <div class="form-check">
                  <input
                    type="checkbox"
                    class="form-check-input"
                    name="currentPos"
                  />
                  <label class="form-check-label"
                    >Current Position</label
                  >
                </div>
                <div class="add-post-btn">
                  <div class="float-left">
                    <a href="#" class="btn-added"
                      ><i class="ti-plus"></i> Add</a
                    >
                  </div>
                  <div class="float-right">
                    <a href="#" class="btn-delete"
                      ><i class="ti-trash"></i> Delete</a
                    >
                  </div>
                </div>
                <div class="divider"><h3>Skills</h3></div>
                <div class="form-group">
                  <div class="row">
                    <div class="col-md-6">
                      <label class="control-label">Skill Name</label>
                      <input
                        class="form-control"
                        placeholder="Skill name, e.g. HTML"
                        type="text"
                      />
                    </div>
                    <div class="col-md-6">
                      <label class="control-label">% (1-100)</label>
                      <input
                        class="form-control"
                        placeholder="Skill proficiency, e.g. 90"
                        type="text"
                      />
                    </div>
                  </div>
                </div>
                <div class="add-post-btn">
                  <div class="float-left">
                    <a href="#" class="btn-added"
                      ><i class="ti-plus"></i> Add</a
                    >
                  </div>
                  <div class="float-right">
                    <a href="#" class="btn-delete"
                      ><i class="ti-trash"></i> Delete</a
                    >
                  </div>
                </div>
              </form>
              <router-link to="/resume" class="btn btn-common"
                >Save</router-link
              >
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
import RightSideBar from "@/components/utils/RightSideBar.vue";
export default {
  name: "ChangePassword",
  components: { NavBar, RightSideBar }
};
</script>
