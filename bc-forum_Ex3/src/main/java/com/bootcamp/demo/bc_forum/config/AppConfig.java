package com.bootcamp.demo.bc_forum.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
  
  @Bean(value = "JPHRestTemplate")
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }
}
