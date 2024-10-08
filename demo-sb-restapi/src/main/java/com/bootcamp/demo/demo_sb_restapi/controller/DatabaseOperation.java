package com.bootcamp.demo.demo_sb_restapi.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

// ! What is Restful API
  // URI -> resource
  // Get, Post, Put, Delete, Patch
@Controller
@ResponseBody
public interface DatabaseOperation {
  @PostMapping("/integer/put/{index}/{value}")
  public int put(@PathVariable int index,@PathVariable int value);

  @GetMapping("/integer/get/{index}")
  public int get(@PathVariable int index);

  @GetMapping("/integers")
  public int get2(@RequestParam(value = "idx") int index);

  @GetMapping("/integer/getall")
  public List<Integer> getAll(); 

  // @DeleteMapping -> SQL: delete from
  // @PutMapping -> SQL: update
  // @GetMapping -> SQL: select
  // @PostMapping -> SQL: insert into
}
