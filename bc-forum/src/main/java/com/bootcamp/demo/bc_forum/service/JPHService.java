package com.bootcamp.demo.bc_forum.service;

import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import com.bootcamp.demo.bc_forum.model.AllData;
import com.bootcamp.demo.bc_forum.model.CommentDTO;
import com.bootcamp.demo.bc_forum.model.PostDTO;
import com.bootcamp.demo.bc_forum.model.UserDTO;

public interface JPHService {
  List<UserDTO> getUsers();
  UserDTO getUserById(@PathVariable Long id);
  UserDTO replaceUser(@PathVariable Long id, UserDTO user);
  // --------------------------------------
  List<PostDTO> getPosts();
  List<PostDTO> getPostsByUserId(@PathVariable Long userId);
  PostDTO addPostByUserId(@PathVariable Long userId, PostDTO post);
  void deletePostByPostId(@PathVariable Long postId);
  // --------------------------------------
  List<CommentDTO> getComments();
  List<CommentDTO> getCommentsByPostId(@PathVariable Long postId);
  CommentDTO addCommentByPostId(@PathVariable Long postId, CommentDTO comment);
  CommentDTO updateCommentByCommentId(@PathVariable Long commentId, CommentDTO comment);
  // --------------------------------------
  // AllData getAllDataByUser(@PathVariable Long id);

}
