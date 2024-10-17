package com.bootcamp.demo.bc_forum.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.bootcamp.demo.bc_forum.model.AllData;
import com.bootcamp.demo.bc_forum.model.CommentDTO;
import com.bootcamp.demo.bc_forum.model.PostDTO;
import com.bootcamp.demo.bc_forum.model.UserDTO;

public interface JPHOperation {

  @GetMapping("/jph/users") // Get all users
  List<UserDTO> getUsers();

  @GetMapping("/jph/users/{id}") // Get user by id
  UserDTO getUserById(@PathVariable Long id);

  // --------------------------------------

  @PutMapping("/jph/users/{id}") // Replace existing user by a whole user object
  UserDTO replaceUser(@PathVariable Long id, UserDTO user);

  // --------------------------------------

  @GetMapping("/jph/posts") // Get all posts
  List<PostDTO> getPosts();

  @GetMapping("/jph/posts/{userId}")
  List<PostDTO> getPostsByUserId(@PathVariable Long userId);

  @PostMapping("/jph/posts/{userId}") // Add a new post by user id
  PostDTO addPostByUserId(@PathVariable Long userId, PostDTO post);

  @DeleteMapping("/jph/posts/{postId}") // Delete a post by postId
  void deletePostByPostId(@PathVariable Long postId);

  // --------------------------------------

  @GetMapping("/jph/comments")
  List<CommentDTO> getComments();

  @GetMapping("/jph/comments/{postId}") // Get comments by postId
  List<CommentDTO> getCommentsByPostId(@PathVariable Long postId);

  @PostMapping("/jph/comments/{postId}") // Add a new comment by postId
  CommentDTO addCommentByPostId(@PathVariable Long postId, CommentDTO comment);

  @PatchMapping("/jph/comments/{commentId}") // Update a comment body by commentId
  CommentDTO updateCommentByCommentId(@PathVariable Long commentId, CommentDTO comment);
  
  // --------------------------------------

  @GetMapping("/jph/all/{id}")
  AllData getAllDataByUser(@PathVariable Long id);

  // @GetMapping("/jph/comments")
  // List<Comments> getCommentsByUserId(@RequestParam Long userId);
}
