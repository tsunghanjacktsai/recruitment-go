package com.recruit.recruitment.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.recruit.recruitment.model.pojo.Post;
import com.recruit.recruitment.mapper.PostMapper;
import com.recruit.recruitment.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "postService")
public class PostServiceImpl implements PostService {
  @Autowired
  private PostMapper postMapper;

  @Override
  public int addPost(Post post) {
    return postMapper.insertSelective(post);
  }

  @Override
  public int deletePost(Integer postid) {
    return postMapper.deleteByPrimaryKey(postid);
  }

  @Override
  public int updatePost(Post post) {
    return postMapper.updateByPrimaryKeySelective(post);
  }

  @Override
  public Post findPost(Integer postid) {
    return postMapper.selectByPrimaryKey(postid);
  }

  @Override
  public List<Post> findAllPosts(int pageNum, int pageSize) {
    PageHelper.startPage(pageNum, pageSize);
    return postMapper.selectAll();
  }
}
