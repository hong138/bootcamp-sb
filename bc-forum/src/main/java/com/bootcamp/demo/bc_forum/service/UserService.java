package com.bootcamp.demo.bc_forum.service;

import java.util.List;

import com.bootcamp.demo.bc_forum.entity.UserEntity;

public interface UserService {
  List<UserEntity> saveAll(List<UserEntity> userEntities);
  List<UserEntity> createAll(List<UserEntity> commentEntity);
  List<UserEntity> getAll();
  UserEntity getById(Long id);
  UserEntity updateById(Long id, UserEntity userEntity);
}
