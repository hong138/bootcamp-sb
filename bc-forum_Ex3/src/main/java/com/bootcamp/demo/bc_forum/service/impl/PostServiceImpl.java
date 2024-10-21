package com.bootcamp.demo.bc_forum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bootcamp.demo.bc_forum.entity.PostEntity;
import com.bootcamp.demo.bc_forum.repository.PostRepository;
import com.bootcamp.demo.bc_forum.service.PostService;

public class PostServiceImpl implements PostService{
  @Autowired
  private PostRepository postRepository;

  @Override
  public List<PostEntity> saveAll(List<PostEntity> postEntities) {
    return postRepository.saveAll(postEntities);
  }
}
