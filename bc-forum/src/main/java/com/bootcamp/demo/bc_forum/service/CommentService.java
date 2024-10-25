package com.bootcamp.demo.bc_forum.service;

import java.util.List;
import com.bootcamp.demo.bc_forum.entity.CommentEntity;

public interface CommentService {
  List<CommentEntity> saveAll(List<CommentEntity> commentEntities);
}
