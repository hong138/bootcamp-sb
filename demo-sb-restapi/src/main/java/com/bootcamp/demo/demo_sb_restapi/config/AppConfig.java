package com.bootcamp.demo.demo_sb_restapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.bootcamp.demo.demo_sb_restapi.model.Cat;
import com.bootcamp.demo.demo_sb_restapi.model.Color;

// Component Scan -> @Controller, @Service, @Configuration

// @Configuration + @Bean
@Configuration
public class AppConfig {

  // !!! Usually we use "@Configuration + @Bean" , when we use external libraries/class

  @Bean(name = "JPHRestTemplate")
  RestTemplate restTemplateForJPH() {
    return new RestTemplate();
  }

  @Bean(name = "ABCRestTemplate")
  RestTemplate restTemplateForABC() {
    return new RestTemplate();
  }

  @Bean
  Cat cat() {
    return new Cat("Vincent", 20, Color.BLUE, 3.0);
  }

  // Beans ....

}
