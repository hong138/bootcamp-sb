package com.bootcamp.demo.bc_forum.model.WithData;

import java.util.List;
import com.bootcamp.demo.bc_forum.model.Comments;
import com.bootcamp.demo.bc_forum.model.Posts;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostWithData extends Posts {
  private List<Comments> comments;
}
