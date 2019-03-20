package com.greetings.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class HelloServiceRestConfig {

  @Bean("helloRestTemplate")
  public RestTemplate getRestTemplate() {
    RestTemplate restTemplate = new RestTemplate();
    return restTemplate;
  }

}