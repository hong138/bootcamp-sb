package com.bootcamp.bc_calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bootcamp.bc_calculator.model.CalculateRequest;
import com.bootcamp.bc_calculator.model.CalculateResponse;

public interface CalculatorOperation {
  // method 1 : calculate (String x, String y, String operation);
  // method 2 : calculate (String x, String y, String operation);
  // polymorphism -> method overloading
  // same method signature
  // 
  // 

  @GetMapping("/operation")
  CalculateResponse calculate(@RequestParam String x, @RequestParam String y, @RequestParam String operation);
  @PostMapping
  CalculateResponse calculate(CalculateRequest calculateRequest);

  @GetMapping("/operation/{x}/{y}/{operation")
  CalculateResponse calculate2(@PathVariable String x, @PathVariable String y, @PathVariable String operation);
  // @PostMapping
  // @GetMapping("/add/{x}/{y}")
  // public String add(int x, int y) {
  //   return String.valueOf(x + y);
  // }

  // @GetMapping("/sub/{x}/{y}")
  // public String sub(int x, int y) {
  //   return String.valueOf(x - y);
  // }

  // @GetMapping("/mul/{x}/{y}")
  // public String mul(int x, int y) {
  //   return String.valueOf(x * y);
  // }

  // @GetMapping("/div/{x}/{y}")
  // public String div(int x, int y) {
  //   return String.valueOf(x / y);
  // }
}
