package com.bootcamp.demo.bc_forum.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.bc_forum.controller.JPHOperation;
import com.bootcamp.demo.bc_forum.model.AllData;
import com.bootcamp.demo.bc_forum.model.Comments;
import com.bootcamp.demo.bc_forum.model.Posts;
import com.bootcamp.demo.bc_forum.model.Users;
import com.bootcamp.demo.bc_forum.model.WithData.UserWithData;
import com.bootcamp.demo.bc_forum.service.JPHService;

@RestController
public class JPHController implements JPHOperation {
  @Autowired
  private JPHService jphService;

  @Override
  public List<Users> getUsers() {
    return this.jphService.getUsers();
  }

  @Override
  public List<Posts> getPosts() {
    return this.jphService.getPosts();
  }

  @Override
  public List<Comments> getComments() {
    return this.jphService.getComments();
  }

  @Override
  public AllData getAllDataByUser(Long id) {
    return this.jphService.getAllDataByUser(id);

  @Override
  public List<Comments> getCommentsByUserId(Long userId) {
    return this.jphService.getCommentsByUserId(userId);
    }
  }
}
