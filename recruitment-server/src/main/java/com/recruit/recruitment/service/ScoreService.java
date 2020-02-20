package com.recruit.recruitment.service;

import com.recruit.recruitment.model.pojo.Score;

import java.util.List;

public interface ScoreService {
  void addScoreRelation(Score score);

  void deleteScoreRelation(Score score);

  Score findApplicationScoreByMarker(Integer applicationid);
}
