package com.bootcamp.demo.demo_sb_restapi.model.dto;

import lombok.Getter;

@Getter
public class CommentDTO {
  public Long postId;
  public Long id;
  public String name;
  public String email;
  public String body;
}
