import request from "@/utils/request";
import qs from "qs";

export default {
  editPost(
    postid,
    jobname,
    companyname,
    location,
    category,
    salary,
    salarytype,
    description,
    criteria,
    picknum,
    due,
    evaluators
  ) {
    return request({
      url: "/post/edit-job/" + postid,
      method: "put",
      data: qs.stringify(
        {
          jobname: jobname,
          companyname: companyname,
          location: location,
          category: category,
          salary: salary,
          salarytype: salarytype,
          description: description,
          criteria: criteria,
          picknum: picknum,
          due: due,
          evaluators: JSON.stringify(evaluators)
        },
        {
          indices: false
        }
      )
    });
  },
  submitPost(
    jobname,
    companyname,
    location,
    category,
    salary,
    salarytype,
    description,
    criteria,
    picknum,
    due,
    evaluators
  ) {
    return request({
      url: "/post/post-job",
      method: "put",
      data: qs.stringify(
        {
          jobname: jobname,
          companyname: companyname,
          location: location,
          category: category,
          salary: salary,
          salarytype: salarytype,
          description: description,
          criteria: criteria,
          picknum: picknum,
          due: due,
          evaluators: JSON.stringify(evaluators)
        },
        {
          indices: false
        }
      )
    });
  },
  getPostsByEvaluator() {
    return request({
      url: "/post/get-posts-by-evaluator",
      method: "get"
    });
  },
  getPostsByCategory(category) {
    return request({
      url: "/post/get-posts-by-category/" + category,
      method: "get"
    });
  },
  getPostByPostid(postid) {
    return request({
      url: "/post/get-post-by-postid/" + postid,
      method: "get"
    });
  },
  getAllPosts() {
    return request({
      url: "/post/get-all-posts",
      method: "get"
    });
  },
  deletePost(postid) {
    return request({
      url: "/post/delete-post/" + postid,
      method: "delete"
    });
  },
  searchPosts(keyword) {
    return request({
      url: "/post/search-posts/" + keyword,
      method: "get"
    });
  }
};
