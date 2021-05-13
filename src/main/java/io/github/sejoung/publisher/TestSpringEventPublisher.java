package io.github.sejoung.publisher;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import io.github.sejoung.event.TestSpringEvent;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class TestSpringEventPublisher {

  private final ApplicationEventPublisher applicationEventPublisher;

  public void publishCustomEvent(final String message) {
    System.out.println("Publishing custom event. ");
    TestSpringEvent testSpringEvent = new TestSpringEvent(this, message);
    applicationEventPublisher.publishEvent(testSpringEvent);
  }

}
