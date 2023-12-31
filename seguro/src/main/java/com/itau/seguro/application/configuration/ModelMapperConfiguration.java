package com.itau.seguro.application.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfiguration {
  @Bean
  ModelMapper modelMapperConfig() {
    return new ModelMapper();
  }
}
