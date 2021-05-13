package io.github.sejoung.listener;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

import io.github.sejoung.event.TestSpringEvent;

@Component
public class TestSpringTransactionalEventListener {

  @Order(Ordered.HIGHEST_PRECEDENCE)
  @TransactionalEventListener
  public void handleTestSpringEvent(TestSpringEvent event) {
    System.out.println("Transactional Event Listener " + event);
  }
}
