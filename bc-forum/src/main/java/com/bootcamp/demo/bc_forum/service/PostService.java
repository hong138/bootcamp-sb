package com.bootcamp.demo.bc_forum.service;

import java.util.List;

import com.bootcamp.demo.bc_forum.entity.PostEntity;

public interface PostService {
  List<PostEntity> saveAll(List<PostEntity> postEntities);
}
