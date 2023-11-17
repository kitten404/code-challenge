package com.itau.seguro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestSeguroApplication {

  public static void main(String[] args) {
    SpringApplication.from(SeguroApplication::main).with(TestSeguroApplication.class).run(args);
  }
}
