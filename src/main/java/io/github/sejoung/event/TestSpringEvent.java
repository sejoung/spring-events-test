package io.github.sejoung.event;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class TestSpringEvent<T> extends ApplicationEvent {

  private final T message;

  public TestSpringEvent(Object source, T message) {
    super(source);
    this.message = message;
  }

}
