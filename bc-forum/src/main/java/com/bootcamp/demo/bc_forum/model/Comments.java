package com.bootcamp.demo.bc_forum.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Comments {
  public int postId;
  public Long id;
  public String name;
  public String email;
  public String body;
}
