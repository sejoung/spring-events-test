package io.github.sejoung.publisher;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import io.github.sejoung.event.TestSpringEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Component
public class TestSpringEventPublisher {

  private final ApplicationEventPublisher applicationEventPublisher;

  public void publishCustomEvent(final String message) {
    log.debug("Publishing custom event. ");
    applicationEventPublisher.publishEvent(new TestSpringEvent<>(this, message));
  }

}
