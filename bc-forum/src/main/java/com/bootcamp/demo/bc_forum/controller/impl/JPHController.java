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
import com.bootcamp.demo.bc_forum.model.CommentDTO;
import com.bootcamp.demo.bc_forum.model.PostDTO;
import com.bootcamp.demo.bc_forum.model.UserDTO;
import com.bootcamp.demo.bc_forum.service.JPHService;

@RestController
public class JPHController implements JPHOperation {
  @Autowired
  private JPHService jphService;

  // --------------------------------------

  @Override
  public List<UserDTO> getUsers() {
    return this.jphService.getUsers();
  }

  @Override
  public UserDTO getUserById(Long id) {
    return this.jphService.getUserById(id);
  }

  // --------------------------------------

  @Override
  public UserDTO replaceUser (Long id, UserDTO user) {
    return this.jphService.replaceUser(id, user);
  }

  // --------------------------------------

  @Override
  public List<PostDTO> getPosts() {
    return this.jphService.getPosts();
  }

  @Override
  public List<PostDTO> getPostsByUserId(Long userId) {
    return this.jphService.getPostsByUserId(userId);
  }

  @Override
  public PostDTO addPostByUserId(Long userId, PostDTO post) {
    return this.jphService.addPostByUserId(userId, post);
  }

  @Override
  public void deletePostByPostId(Long postId) {
    this.jphService.deletePostByPostId(postId);
  }

  // --------------------------------------

  @Override
  public List<CommentDTO> getComments() {
    return this.jphService.getComments();
  }

  @Override
  public List<CommentDTO> getCommentsByPostId(Long postId) {
    return this.jphService.getCommentsByPostId(postId);
  }

  @Override
  public CommentDTO addCommentByPostId(Long postId, CommentDTO comment) {
    return this.jphService.addCommentByPostId(postId, comment);
  }

  @Override
  public CommentDTO updateCommentByCommentId(Long commentId, CommentDTO comment) {
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
