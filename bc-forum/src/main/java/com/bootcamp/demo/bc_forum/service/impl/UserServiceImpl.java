package com.bootcamp.demo.bc_forum.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.demo.bc_forum.entity.UserEntity;
import com.bootcamp.demo.bc_forum.exception.ErrorCode;
import com.bootcamp.demo.bc_forum.repository.UserRepository;
import com.bootcamp.demo.bc_forum.service.UserService;
import com.bootcamp.demo.bc_forum.util.BusinessException;

@Service
public class UserServiceImpl implements UserService{
  @Autowired
  private UserRepository userRepository;

  @Override
  public List<UserEntity> saveAll(List<UserEntity> userEntities) {
    return userRepository.saveAll(userEntities);
  }

  @Override
  public List<UserEntity> createAll(List<UserEntity> userEntity) {
    return userRepository.saveAll(userEntity);
  }

  @Override
  public List<UserEntity> getAll() {
    return userRepository.findAll();
  }

  @Override
  public UserEntity getById(Long id) {
    Optional<UserEntity> oEntity = this.userRepository.findById(id);
    if (oEntity.isPresent())
      return oEntity.get();
    throw BusinessException.of(ErrorCode.USER_NOT_FOUND_EX);
  }

  @Override
  public UserEntity updateById(Long id, UserEntity userEntity) {
    Optional<UserEntity> oEntity = this.userRepository.findById(id);
    if (oEntity.isPresent())
      return userRepository.save(userEntity);
    throw BusinessException.of(ErrorCode.USER_NOT_FOUND_EX);
  }
}
