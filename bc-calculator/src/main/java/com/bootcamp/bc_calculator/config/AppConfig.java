package com.bootcamp.bc_calculator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

public class AppConfig {
  @Bean
  RestTemplate restTemplate() {
    return new RestTemplate();
  }
}
