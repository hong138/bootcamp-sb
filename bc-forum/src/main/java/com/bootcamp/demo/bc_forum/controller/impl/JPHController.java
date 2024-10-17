package com.bootcamp.demo.bc_forum.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.demo.bc_forum.controller.JPHOperation;
import com.bootcamp.demo.bc_forum.model.AllData;
import com.bootcamp.demo.bc_forum.model.Comments;
import com.bootcamp.demo.bc_forum.model.Posts;
import com.bootcamp.demo.bc_forum.model.Users;
import com.bootcamp.demo.bc_forum.service.JPHService;

@RestController
public class JPHController implements JPHOperation {
  @Autowired
  private JPHService jphService;

  // --------------------------------------

  @Override
  public List<Users> getUsers() {
    return this.jphService.getUsers();
  }

  @Override
  public Users getUserById(Long id) {
    return this.jphService.getUserById(id);
  }

  // --------------------------------------

  @Override
  public Users replaceUser (Long id, Users user) {
    return this.jphService.replaceUser(id, user);
  }

  // --------------------------------------

  @Override
  public List<Posts> getPosts() {
    return this.jphService.getPosts();
  }

  @Override
  public List<Posts> getPostsByUserId(Long userId) {
    return this.jphService.getPostsByUserId(userId);
  }

  @Override
  public Posts addPostByUserId(Long userId, Posts post) {
    return this.jphService.addPostByUserId(userId, post);
  }

  @Override
  public void deletePostByPostId(Long postId) {
    this.jphService.deletePostByPostId(postId);
  }

  // --------------------------------------

  @Override
  public List<Comments> getComments() {
    return this.jphService.getComments();
  }

  @Override
  public List<Comments> getCommentsByPostId(Long postId) {
    return this.jphService.getCommentsByPostId(postId);
  }

  @Override
  public Comments addCommentByPostId(Long postId, Comments comment) {
    return this.jphService.addCommentByPostId(postId, comment);
  }

  @Override
  public Comments updateCommentByCommentId(Long commentId, Comments comment) {
    return this.jphService.updateCommentByCommentId(commentId, comment);
  }

  // --------------------------------------

  @Override
  public AllData getAllDataByUser(Long id) {
    return this.jphService.getAllDataByUser(id);

  // @Override
  // public List<Comments> getCommentsByUserId(Long userId) {
  //   return this.jphService.getCommentsByUserId(userId);
  //   }
  }
}
