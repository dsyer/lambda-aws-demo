package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.function.context.FunctionRegistry;
import java.util.function.Function;

@SpringBootApplication
public class DemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

  @Bean
  public CommandLineRunner runner(FunctionRegistry functions) {
    return args -> {
      System.err.println(System.getenv());
      System.err.println(functions.getNames(Function.class));
    };
  }
}
