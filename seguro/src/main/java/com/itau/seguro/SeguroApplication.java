package com.itau.seguro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class SeguroApplication {

  public static void main(String[] args) {
    SpringApplication.run(SeguroApplication.class, args);
  }
}
