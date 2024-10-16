package com.bootcamp.demo.demo_sb_restapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.bootcamp.demo.demo_sb_restapi.entity.UserEntity;
import com.bootcamp.demo.demo_sb_restapi.model.dto.UserDTO;

// Restful -> read/ write resourse
public interface JPHOperation {
  @GetMapping("/jph/users")
  List<UserDTO> getUsers();

  /**
   * Server Layer call external JPH service directly to refresh the user list
   * @return
   */
  @PostMapping("/jph/users")
  List<UserEntity> createUsers();

  @DeleteMapping("/jph/users")
  Boolean deleteUsers(@RequestParam Long Id);

  @PutMapping("/jph/users/{id}") // by PK
  UserEntity updateUser(@RequestParam Long Id, @RequestBody UserEntity entity);

  @PatchMapping("/jph/users/{id}")
  UserEntity patchUserWebsite(@PathVariable Long id, @RequestParam String website);

  @PostMapping("/jph/users")
  UserEntity createUser(@RequestBody UserEntity userentity);

  @GetMapping("/jph/users/website/{website}")
  UserEntity getUserByWebsite(@PathVariable String website);

  @GetMapping("/jph/users/website/{website}{phone}")
  UserEntity getUserByWebsiteAndPhone(@PathVariable String website, @PathVariable String phone);
}
