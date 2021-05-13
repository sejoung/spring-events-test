package io.github.sejoung.event;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class TestSpringEvent extends ApplicationEvent {

  private final String message;

  public TestSpringEvent(Object source, String message) {
    super(source);
    this.message = message;
  }

}
