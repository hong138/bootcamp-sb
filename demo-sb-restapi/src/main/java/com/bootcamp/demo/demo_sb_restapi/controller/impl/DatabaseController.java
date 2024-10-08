package com.bootcamp.demo.demo_sb_restapi.controller.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.demo.demo_sb_restapi.controller.DatabaseOperation;
import com.bootcamp.demo.demo_sb_restapi.model.Database;

// @Controller
// @ResponseBody // JSON format
@RestController // @Controller + @ResponseBody
public class DatabaseController implements DatabaseOperation{
  // APIs
  // 1. put(Integern integer, int index);
  public int put( int index, int value) {
    if (value < 0 || value > Database.integers.length) 
      return -1;
    Database.integers[value] = index;
    return index;
  }

  // 2. int get(int index);
  public int get(int index) {
    return Database.integers[index];
  }

  public int get2(int index) {
    return Database.integers[index];
  }

  // 3. List<Integer> getAll();
  public List<Integer> getAll() {
    return Arrays.stream(Database.integers).boxed().collect(Collectors.toList());
  }
}