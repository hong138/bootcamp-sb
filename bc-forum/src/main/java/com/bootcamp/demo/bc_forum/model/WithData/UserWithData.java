package com.bootcamp.demo.bc_forum.model.WithData;

import java.util.List;
import com.bootcamp.demo.bc_forum.model.Users;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserWithData extends Users {
  private List<PostWithData> posts;

  
}
