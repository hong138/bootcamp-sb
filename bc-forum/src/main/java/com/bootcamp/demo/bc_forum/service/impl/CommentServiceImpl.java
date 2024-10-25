package com.bootcamp.demo.bc_forum.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootcamp.demo.bc_forum.entity.CommentEntity;
import com.bootcamp.demo.bc_forum.repository.CommentRepository;
import com.bootcamp.demo.bc_forum.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{
  @Autowired
  private CommentRepository commentRepository;

  @Override
  public List<CommentEntity> saveAll(List<CommentEntity> commentEntities) {
    return commentRepository.saveAll(commentEntities);
  }
}
