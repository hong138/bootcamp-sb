package com.bootcamp.demo.bc_forum.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp.demo.bc_forum.model.AllData;
import com.bootcamp.demo.bc_forum.model.Comments;
import com.bootcamp.demo.bc_forum.model.Posts;
import com.bootcamp.demo.bc_forum.model.Users;

public interface JPHOperation {

  @GetMapping("/jph/users")
  List<Users> getUsers();

  @GetMapping("/jph/posts")
  List<Posts> getPosts();

  @GetMapping("/jph/comments")
  List<Comments> getComments();

  @GetMapping("/jph/all/{id}")
  AllData getAllDataByUser(@PathVariable Long id);

  @GetMapping("/jph/comments")
  List<Comments> getCommentsByUserId(@RequestParam Long userId);
}
