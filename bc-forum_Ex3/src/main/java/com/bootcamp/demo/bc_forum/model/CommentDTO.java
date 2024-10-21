package com.bootcamp.demo.bc_forum.model;

import lombok.Getter;

@Getter
public class CommentDTO {
  public Long postId;
  public Long id;
  public String name;
  public String email;
  public String body;
}
