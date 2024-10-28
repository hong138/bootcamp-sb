package com.bootcamp.demo.bc_forum.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDTO {
  public Long userId;
  public Long id;
  public String title;
  public String body;
}
