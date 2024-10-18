package com.bootcamp.demo.bc_forum.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserCommentDTO {
  @JsonProperty(value = "id")
  private Long userId;
  private String username;
  private List<CommentDto> comments;

  @Getter
  @Builder
  public static class CommentDto {
    private String name;
    private String email;
    private String body;
  }

}
