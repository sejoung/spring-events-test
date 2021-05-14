package io.github.sejoung.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import io.github.sejoung.event.TestSpringEvent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class TestSpringEventApplicationListener implements ApplicationListener<TestSpringEvent> {
  @Override
  public void onApplicationEvent(TestSpringEvent event) {
    log.debug("Received spring custom event - {}", event);
  }
}
