package com.bootcamp.demo.demo_mtr.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Appcoonfig {
  
  @Bean
  RestTemplate restTemplate(){
    return new RestTemplate();
  }
}
