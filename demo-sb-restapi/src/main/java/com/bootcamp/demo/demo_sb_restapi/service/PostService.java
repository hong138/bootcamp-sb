package com.bootcamp.demo.demo_sb_restapi.service;

import java.util.List;

import com.bootcamp.demo.demo_sb_restapi.entity.PostEntity;

public interface PostService {
  List<PostEntity> saveAll(List<PostEntity> postEntities);
}
