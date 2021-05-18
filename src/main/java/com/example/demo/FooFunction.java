package com.example.demo;

import java.util.function.Function;

import org.springframework.nativex.hint.TypeHint;
import org.springframework.stereotype.Component;

@Component
@TypeHint(types = Foo.class)
public class FooFunction implements Function<Foo, Foo> {

  @Override
  public Foo apply(Foo input) {
    System.err.println("HI: " + input.getName());
    return new Foo("hi " + input.getName() + "!");
  }
}