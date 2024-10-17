package com.bootcamp.demo.bc_forum.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.bootcamp.demo.bc_forum.model.AllData;
import com.bootcamp.demo.bc_forum.model.Comments;
import com.bootcamp.demo.bc_forum.model.Posts;
import com.bootcamp.demo.bc_forum.model.Users;

public interface JPHOperation {

  @GetMapping("/jph/users") // Get all users
  List<Users> getUsers();

  @GetMapping("/jph/users/{id}") // Get user by id
  Users getUserById(@PathVariable Long id);

  // --------------------------------------

  @PutMapping("/jph/users/{id}") // Replace existing user by a whole user object
  Users replaceUser(@PathVariable Long id, Users user);

  // --------------------------------------

  @GetMapping("/jph/posts") // Get all posts
  List<Posts> getPosts();

  @GetMapping("/jph/posts/{userId}")
  List<Posts> getPostsByUserId(@PathVariable Long userId);

  @PostMapping("/jph/posts/{userId}") // Add a new post by user id
  Posts addPostByUserId(@PathVariable Long userId, Posts post);

  @DeleteMapping("/jph/posts/{postId}") // Delete a post by postId
  void deletePostByPostId(@PathVariable Long postId);

  // --------------------------------------

  @GetMapping("/jph/comments")
  List<Comments> getComments();

  @GetMapping("/jph/comments/{postId}") // Get comments by postId
  List<Comments> getCommentsByPostId(@PathVariable Long postId);

  @PostMapping("/jph/comments/{postId}") // Add a new comment by postId
  Comments addCommentByPostId(@PathVariable Long postId, Comments comment);

  @PatchMapping("/jph/comments/{commentId}") // Update a comment body by commentId
  Comments updateCommentByCommentId(@PathVariable Long commentId, Comments comment);
  
  // --------------------------------------

  @GetMapping("/jph/all/{id}")
  AllData getAllDataByUser(@PathVariable Long id);

  // @GetMapping("/jph/comments")
  // List<Comments> getCommentsByUserId(@RequestParam Long userId);
}
