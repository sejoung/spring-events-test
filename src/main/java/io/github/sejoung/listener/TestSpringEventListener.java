package io.github.sejoung.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import io.github.sejoung.event.TestSpringEvent;

@Component
public class TestSpringEventListener {

  @EventListener
  public void handleTestSpringEvent(TestSpringEvent event) {
    System.out.println("event listener " + event);
  }

}
