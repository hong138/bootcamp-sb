package com.bootcamp.demo.bc_forum.model;

import java.util.List;
import com.bootcamp.demo.bc_forum.model.WithData.UserWithData;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AllData {
  private Long userId;
  private List<Comments> comments;
  private List<UserWithData> users;
}
