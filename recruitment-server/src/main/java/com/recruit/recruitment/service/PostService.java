package com.recruit.recruitment.service;

import com.recruit.recruitment.model.pojo.Post;

import java.util.List;

public interface PostService {
  void addPost(Post post, String evaluators);

  void deletePost(Integer postid);

  void updatePost(Integer postid, Post post, String evaluators);

  List<Post> searchPosts(String keyword);

  List<Post> findPostsByEvaluator();

  List<Post> findPostsByCategory(String category);

  Post findPostByPostid(Integer postid);

  List<Post> findAllPosts();
}
