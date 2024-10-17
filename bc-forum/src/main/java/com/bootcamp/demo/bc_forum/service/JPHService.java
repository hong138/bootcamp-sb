package com.bootcamp.demo.bc_forum.service;

import java.util.List;

import com.bootcamp.demo.bc_forum.mapper.UserPostComment;
import com.bootcamp.demo.bc_forum.model.Comments;
import com.bootcamp.demo.bc_forum.model.Posts;
import com.bootcamp.demo.bc_forum.model.Users;
import com.bootcamp.demo.bc_forum.model.WithData.UserWithData;

public interface JPHService {
  List<Users> getUsers();
  List<UserWithData> getUsersWithData();
  Users getUserById(Long id);
  List<Posts> getPosts();
  List<Posts> getPostsById(Long Id);
  List<Comments> getComments();
  List<Comments> getCommentsById(Long Id);
  List<Comments> getCommentsByUserId(Long userId);
  UserPostComment getAllDataByUser(Long id);
}
