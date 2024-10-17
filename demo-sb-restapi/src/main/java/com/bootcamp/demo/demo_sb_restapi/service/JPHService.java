package com.bootcamp.demo.demo_sb_restapi.service;

// https://jsonplaceholder.typicode.com/

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestBody;

import com.bootcamp.demo.demo_sb_restapi.entity.UserEntity;
import com.bootcamp.demo.demo_sb_restapi.model.dto.CommentDTO;
import com.bootcamp.demo.demo_sb_restapi.model.dto.PostDTO;
import com.bootcamp.demo.demo_sb_restapi.model.dto.UserDTO;

public interface JPHService {
  List<UserDTO> getUsers();

  List<UserEntity> saveUsers();

  Boolean deleteUser(Long id);

  UserEntity updateUser(Long id, UserEntity entity);
  
  UserEntity patchUserWebsite(Long id, String website);
  
  UserEntity createUser(@RequestBody UserEntity userentity);
  
  Optional<UserEntity> findByWebsite(String website);
  
  Optional<UserEntity> findByWebsiteAndPhone(String website, String phone);

  List<PostDTO> getPosts();
  
  List<CommentDTO> getComments();
}
