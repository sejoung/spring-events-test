package io.github.sejoung.listener;

import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

import io.github.sejoung.event.TestSpringEvent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class NewTransactionalEventListener {
  @TransactionalEventListener
  public void handleAfterCommit(TestSpringEvent event) {
    log.debug("new AFTER COMMIT {}", event);
  }

}
