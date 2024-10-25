package com.bootcamp.demo.bc_forum.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.bootcamp.demo.bc_forum.dto.AllData;
import com.bootcamp.demo.bc_forum.dto.UserCommentDTO;
import com.bootcamp.demo.bc_forum.model.CommentDTO;
import com.bootcamp.demo.bc_forum.model.PostDTO;
import com.bootcamp.demo.bc_forum.model.UserDTO;

public interface JPHOperation {

  @GetMapping("/users") // (E3 T3 User a) Get all users 
  List<UserDTO> getUsers();

  @GetMapping("/users/{id}") // (E3 T3 User b) Get user by id 
  UserDTO getUserById(@PathVariable Long id);

  // --------------------------------------

  @PutMapping("/users/{id}") // (E3 T3 User put a) Replace existing user by a whole user object
  UserDTO replaceUser(@PathVariable Long id, UserDTO user);

  // --------------------------------------

  @GetMapping("/posts") // (E3 T3 Post a) Get all posts
  List<PostDTO> getPosts();

  @GetMapping("/posts/{userId}") // (E3 T3 Post b)
  List<PostDTO> getPostsByUserId(@PathVariable Long userId);

  @PostMapping("/posts/{userId}") // !!! (E3 T3 Post c) Add a new post by user id
  PostDTO addPostByUserId(@PathVariable Long userId, PostDTO post);

  @DeleteMapping("/posts/{postId}") // !!! (E3 T3 Post d) Delete a post by postId
  void deletePostByPostId(@PathVariable Long postId);

  // --------------------------------------

  @GetMapping("/comments") // (E3 T3 Comment a)
  List<CommentDTO> getComments();

  @GetMapping("/comments/{postId}") // (E3 T3 Comment b) Get comments by postId
  List<CommentDTO> getCommentsByPostId(@PathVariable Long postId);

  @GetMapping("/{userId}/comments") // !!!
  UserCommentDTO getCommentsByUserId(@PathVariable String userId);

  @PostMapping("/comments/{postId}") // !!! (E3 T3 Comment c) Add a new comment by postId
  CommentDTO addCommentByPostId(@PathVariable Long postId, CommentDTO comment);

  @PatchMapping("/comments/{commentId}") // !!! (E3 T3 Comment d) Update a comment body by commentId
  CommentDTO updateCommentByCommentId(@PathVariable Long commentId, CommentDTO comment);
  
  // --------------------------------------

  @GetMapping("/all")
  List<AllData> getAllData();

}
