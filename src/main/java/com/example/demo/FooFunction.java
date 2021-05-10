package com.example.demo;

import java.util.function.Function;
import org.springframework.stereotype.Component;

@Component
public class FooFunction implements Function<Foo, Foo> {

  @Override
  public Foo apply(Foo input) {
    System.err.println("HI: " + input.getName());
    return new Foo("hi " + input.getName() + "!");
  }
}