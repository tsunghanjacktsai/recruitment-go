package com.recruit.recruitment.serviceImpl;

import com.recruit.recruitment.mapper.EvaluatorMapper;
import com.recruit.recruitment.mapper.UserMapper;
import com.recruit.recruitment.model.pojo.Evaluator;
import com.recruit.recruitment.model.pojo.User;
import com.recruit.recruitment.service.EvaluatorService;
import com.recruit.recruitment.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class EvaluatorServiceImpl implements EvaluatorService {
  @Autowired
  private EvaluatorMapper evaluatorMapper;

  @Autowired
  private UserMapper userMapper;

  @Autowired
  private JwtTokenUtil jwtTokenUtil;

  @Autowired
  private HttpServletRequest request;

  @Override
  public void addEvaluator(Evaluator evaluator) {
    evaluatorMapper.insertSelective(evaluator);
  }

  @Override
  public List<String> findEvaluatorsByPostid(Integer postid) {
    User user = userMapper.selectByUsername(jwtTokenUtil.getUsernameFromRequest(request));
    List<String> evaluators = evaluatorMapper.selectEvaluatorNameByPostid(postid);
    for (int i = 0; i < evaluators.size(); i++) {
      if (evaluators.get(i).equals(user.getUsername())) {
        evaluators.remove(i);
      }
    }
    return evaluators;
  }
}
