package io.github.sejoung.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import io.github.sejoung.event.TestSpringEvent;

@Component
public class TestSpringEventApplicationListener implements ApplicationListener<TestSpringEvent> {
  @Override
  public void onApplicationEvent(TestSpringEvent event) {
    System.out.println("Received spring custom event - " + event);
  }

}
