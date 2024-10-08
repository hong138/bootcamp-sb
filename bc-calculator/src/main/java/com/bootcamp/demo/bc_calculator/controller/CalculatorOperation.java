package com.bootcamp.demo.bc_calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class CalculatorOperation {
  @GetMapping("/add/{x}/{y}")
  public String add(int x, int y) {
    return String.valueOf(x + y);
  }

  @GetMapping("/sub/{x}/{y}")
  public String sub(int x, int y) {
    return String.valueOf(x - y);
  }

  @GetMapping("/mul/{x}/{y}")
  public String mul(int x, int y) {
    return String.valueOf(x * y);
  }

  @GetMapping("/div/{x}/{y}")
  public String div(int x, int y) {
    return String.valueOf(x / y);
  }
}
