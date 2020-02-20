package com.recruit.recruitment.service;

import com.recruit.recruitment.model.pojo.Post;

import java.util.List;

public interface PostService {
  int addPost(Post post);

  int deletePost(Integer postid);

  int updatePost(Post post);

  Post findPost(Integer postid);

  List<Post> findAllPosts(int pageNum, int pageSize);
}
