package com.recruit.recruitment.controller;

import com.recruit.recruitment.model.entity.Result;
import com.recruit.recruitment.model.entity.StatusCode;
import com.recruit.recruitment.model.pojo.Post;
import com.recruit.recruitment.service.PostService;
import com.recruit.recruitment.utils.FormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/post")
public class PostController {
  @Autowired
  private PostService postService;

  @Autowired
  private FormatUtil formatUtil;

  @PreAuthorize("hasAuthority('USER')")
  @PutMapping("/post-job")
  public Result postJob(Post post, @RequestParam(value="evaluators", required = false) String evaluators) {
    if (!formatUtil.checkObjectNull(post)) {
      return Result.create(StatusCode.ERROR, "Incomplete info");
    }
    try {
      postService.addPost(post, evaluators);
      return Result.create(StatusCode.SUCCESS, "Add successful");
    } catch (RuntimeException e) {
      return Result.create(StatusCode.ERROR, "Add post failed");
    }
  }

  @PutMapping("/edit-job/{postid}")
  public Result editJob(@PathVariable Integer postid, Post post,
                        @RequestParam(value="evaluators", required = false) String evaluators) {
    if (!formatUtil.checkObjectNull(post)) {
      return Result.create(StatusCode.ERROR, "Incomplete info");
    }
    try {
      postService.updatePost(postid, post, evaluators);
      return Result.create(StatusCode.SUCCESS, "Update successful");
    } catch (RuntimeException e) {
      return Result.create(StatusCode.ERROR, "Update failed");
    }
  }

  @GetMapping("/get-posts-by-evaluator")
  public Result getPostsByEvaluator() {
    try {
      return Result.create(StatusCode.SUCCESS, "Query successful",
        postService.findPostsByEvaluator());
    } catch (RuntimeException e) {
      return Result.create(StatusCode.ERROR, "Query failed");
    }
  }

  @GetMapping("/get-posts-by-category/**")
  public Result getPostsByCategory(HttpServletRequest request) {
    try {
      String category = extractPath(request);
      return Result.create(StatusCode.SUCCESS, "Query successful",
        postService.findPostsByCategory(category));
    } catch (RuntimeException e) {
      return Result.create(StatusCode.ERROR, "Query failed");
    }
  }

  private String extractPath(HttpServletRequest request) {
    String path = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
    String pattern = (String) request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE);
    return new AntPathMatcher().extractPathWithinPattern(pattern, path);
  }

  @GetMapping("/get-post-by-postid/{postid}")
  public Result getPostByPostid(@PathVariable Integer postid) {
    try {
      return Result.create(StatusCode.SUCCESS, "Query successful",
        postService.findPostByPostid(postid));
    } catch (RuntimeException e) {
      return Result.create(StatusCode.ERROR, "Query failed");
    }
  }

  @GetMapping("/get-all-posts")
  public Result getAllPosts() {
    try {
      return Result.create(StatusCode.SUCCESS, "Query successful", postService.findAllPosts());
    } catch (RuntimeException e) {
      return Result.create(StatusCode.ERROR, "Query failed");
    }
  }

  @DeleteMapping("/delete-post/{postid}")
  public Result deletePost(@PathVariable Integer postid) {
    try {
      postService.deletePost(postid);
      return Result.create(StatusCode.SUCCESS, "Delete successful");
    } catch (RuntimeException e) {
      return Result.create(StatusCode.ERROR, "Delete failed");
    }
  }

  @GetMapping("/search-posts/{keyword}")
  public Result searchPost(@PathVariable String keyword) {
    try {
      return Result.create(StatusCode.SUCCESS, "Query successful", postService.searchPosts(keyword));
    } catch (RuntimeException e) {
      return Result.create(StatusCode.ERROR, "Query failed");
    }
  }
}
