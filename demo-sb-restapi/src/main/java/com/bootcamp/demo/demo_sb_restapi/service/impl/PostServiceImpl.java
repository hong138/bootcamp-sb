package com.bootcamp.demo.demo_sb_restapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootcamp.demo.demo_sb_restapi.entity.PostEntity;
import com.bootcamp.demo.demo_sb_restapi.repository.PostRepository;
import com.bootcamp.demo.demo_sb_restapi.service.PostService;

@Service
public class PostServiceImpl implements PostService {
  @Autowired
  private PostRepository postRepository;

  @Override
  public List<PostEntity> saveAll(List<PostEntity> postEntities) {
    return postRepository.saveAll(postEntities);
  
  }
}
