package com.bootcamp.demo.bc_forum.model;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AllData {
  private Long userId;
  private List<CommentDTO> comments;

}
