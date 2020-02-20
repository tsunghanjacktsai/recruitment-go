package com.recruit.recruitment.model.repository;

import com.recruit.recruitment.model.pojo.Post;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface PostRepository extends ElasticsearchRepository<Post, Integer> {
}
