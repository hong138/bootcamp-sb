package com.bootcamp.demo.demo_sb_restapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bootcamp.demo.demo_sb_restapi.entity.UserEntity;
import com.bootcamp.demo.demo_sb_restapi.model.dto.UserDTO;

public interface JPHOperation {
  @GetMapping("/jph/users")
  List<UserDTO> getUsers();

  @PostMapping("/jph/users")
  List<UserEntity> createUsers();
}
