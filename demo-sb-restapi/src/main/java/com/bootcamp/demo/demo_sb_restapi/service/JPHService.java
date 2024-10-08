package com.bootcamp.demo.demo_sb_restapi.service;

// https://jsonplaceholder.typicode.com/

import java.util.List;

import com.bootcamp.demo.demo_sb_restapi.entity.UserEntity;
import com.bootcamp.demo.demo_sb_restapi.model.dto.UserDTO;

public interface JPHService {
  List<UserDTO> getUsers();
  List<UserEntity> saveUsers();
}
