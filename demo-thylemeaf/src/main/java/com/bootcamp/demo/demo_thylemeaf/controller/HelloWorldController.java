package com.bootcamp.demo.demo_thylemeaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWorldController {

  @GetMapping("/hello")
  public String hello(Model model) {
    // return "hello"; // hello.html
    String s = readFromDB();
    model.addAttribute("message", "Hello World");
    model.addAttribute("123", "HiHi");
    return "hello";
  }

  public static String readFromDB() {
    return "Testing";
  }

}
