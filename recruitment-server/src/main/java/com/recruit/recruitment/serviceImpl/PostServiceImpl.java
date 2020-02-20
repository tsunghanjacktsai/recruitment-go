package com.recruit.recruitment.serviceImpl;

import com.recruit.recruitment.mapper.EvaluatorMapper;
import com.recruit.recruitment.mapper.PostMapper;
import com.recruit.recruitment.mapper.UserMapper;
import com.recruit.recruitment.model.pojo.Evaluator;
import com.recruit.recruitment.model.pojo.Post;
import com.recruit.recruitment.model.pojo.User;
import com.recruit.recruitment.model.repository.PostRepository;
import com.recruit.recruitment.service.EvaluatorService;
import com.recruit.recruitment.service.PostService;
import com.recruit.recruitment.utils.JwtTokenUtil;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
  @Autowired
  private PostMapper postMapper;

  @Autowired
  private UserMapper userMapper;

  @Autowired
  private EvaluatorMapper evaluatorMapper;

  @Autowired
  private EvaluatorService evaluatorService;

  @Autowired
  private PostRepository postRepository;

  @Autowired
  private JwtTokenUtil jwtTokenUtil;

  @Autowired
  private HttpServletRequest request;

  @Override
  public void addPost(Post post, String evaluators) {
    User user = userMapper.selectByUsername(jwtTokenUtil.getUsernameFromRequest(request));
    if (post.getDue() != null) {
      convertDateTimeFormat(post);
    }
    post.setAuthorid(user.getUserid());
    postMapper.insertSelective(post);
    try {
      postRepository.save(postMapper.selectByPrimaryKey(postMapper.selectByMaxPostid()));
    } catch (RuntimeException e) {
      e.printStackTrace();
    }
    addEvaluators(postMapper.selectByMaxPostid(), evaluators, user.getUsername());
  }

  @Override
  public void deletePost(Integer postid) {
    postMapper.deleteByPrimaryKey(postid);
    postRepository.deleteById(postid);
  }

  @Override
  public void updatePost(Integer postid, Post post, String evaluators) {
    post.setPostid(postid);
    if (post.getDue() != null) {
      convertDateTimeFormat(post);
    }
    postMapper.updateByPrimaryKeySelective(post);
    postRepository.deleteById(postid);
    postRepository.save(post);
    evaluatorMapper.deleteByPostid(postid);
    addEvaluators(postid, evaluators, userMapper.selectByUsername(
      jwtTokenUtil.getUsernameFromRequest(request)).getUsername());
  }

  private void convertDateTimeFormat(Post post) {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    SimpleDateFormat formatterWithSecond = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    try {
      post.setDue(formatterWithSecond.format(formatter.parse(post.getDue().replace("T", " "))));
    } catch (ParseException e) {
      e.printStackTrace();
    }
  }

  @Override
  public List<Post> searchPosts(String keyword) {
    QueryBuilder builder = new QueryStringQueryBuilder(keyword);
    Iterable<Post> result = postRepository.search(builder);
    List<Post> posts = new ArrayList<>();
    result.forEach(posts::add);
    return posts;
  }

  @Override
  public List<Post> findPostsByEvaluator() {
    User user = userMapper.selectByUsername(jwtTokenUtil.getUsernameFromRequest(request));
    List<Post> postsByEvaluator = new ArrayList<>();
    List<Evaluator> evaluators = evaluatorMapper.selectByEvaluatorName(user.getUsername());
    if (evaluators != null) {
      for (Evaluator evaluator : evaluators) {
        postsByEvaluator.add(postMapper.selectByPrimaryKey(evaluator.getPostid()));
      }
    }
    return postsByEvaluator;
  }

  @Override
  public List<Post> findPostsByCategory(String category) {
    return postMapper.selectByCategory(category);
  }

  @Override
  public Post findPostByPostid(Integer postid) {
    Post post = postMapper.selectByPrimaryKey(postid);
    if (post.getDue() != null) {
      post.setDue(post.getDue());
    }
    return post;
  }

  @Override
  public List<Post> findAllPosts() {
    return postMapper.selectAll();
  }

  private void addEvaluators(Integer postid, String evaluators, String username) {
    Evaluator author = new Evaluator();
    author.setPostid(postid);
    author.setEvaluatorname(username);
    evaluatorService.addEvaluator(author);
    if (evaluators != null && evaluators.contains("\"tiClasses\":[\"ti-valid\"]")) {
      try {
        JSONArray evalArr = new JSONArray(evaluators);
        int curPostid = 0;
        for (int i = 0; i < evalArr.length(); i++) {
          Evaluator evaluator = new Evaluator();
          JSONObject obj = evalArr.getJSONObject(i);
          String evaluatorName = obj.getString("text");
          if (i == 0) curPostid = postid;
          if (!evaluatorName.equals(username)) {
            evaluator.setEvaluatorname(evaluatorName);
          } else {
            continue;
          }
          evaluator.setPostid(curPostid);
          evaluatorService.addEvaluator(evaluator);
        }
      } catch (JSONException e) {
        e.printStackTrace();
      }
    } else {
      List<String> evaluatorList = new ArrayList<>(Arrays.asList(
        evaluators.substring(1, evaluators.length() - 1).split(",")));
      for (String evaluatorName : evaluatorList) {
        Evaluator evaluator = new Evaluator();
        evaluator.setPostid(postid);
        evaluator.setEvaluatorname(evaluatorName.replace("\"", ""));
        evaluatorService.addEvaluator(evaluator);
      }
    }
  }
}
