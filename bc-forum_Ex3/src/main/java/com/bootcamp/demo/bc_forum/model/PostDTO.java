package com.bootcamp.demo.bc_forum.model;

import lombok.Getter;

@Getter
public class PostDTO {
  public Long userId;
  public Long id;
  public String title;
  public String body;
}
