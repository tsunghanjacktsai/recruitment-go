package com.recruit.recruitment.serviceImpl;

import com.recruit.recruitment.mapper.ScoreMapper;
import com.recruit.recruitment.mapper.UserMapper;
import com.recruit.recruitment.model.pojo.Score;
import com.recruit.recruitment.service.ScoreService;
import com.recruit.recruitment.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {
  @Autowired
  private ScoreMapper scoreMapper;

  @Autowired
  private UserMapper userMapper;

  @Autowired
  JwtTokenUtil jwtTokenUtil;

  @Autowired
  HttpServletRequest request;

  @Override
  public void addScoreRelation(Score score) {
    scoreMapper.insertSelective(score);
  }

  @Override
  public void deleteScoreRelation(Score score) {
    scoreMapper.deleteByPrimaryKey(score.getApplicationid());
  }

  @Override
  public Score findApplicationScoreByMarker(Integer applicationid) {
    int markerid = userMapper.selectByUsername(
      jwtTokenUtil.getUsernameFromRequest(request)).getUserid();
    List<Score> applicationScores = scoreMapper.selectByApplicationid(applicationid);
    Score scoreByMarker = new Score();
    for (Score applicationScore : applicationScores) {
      if (applicationScore.getMarkerid() == markerid) {
        scoreByMarker.setScoreid(applicationScore.getScoreid());
        scoreByMarker.setScore(applicationScore.getScore());
      }
    }
    return scoreByMarker;
  }
}
