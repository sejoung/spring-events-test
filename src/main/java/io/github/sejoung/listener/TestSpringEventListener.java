package io.github.sejoung.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import io.github.sejoung.event.TestSpringEvent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class TestSpringEventListener {

  @EventListener
  public <T> void handleTestSpringEvent(TestSpringEvent<T> event) {
    log.debug("event listener {}", event);
  }

}
