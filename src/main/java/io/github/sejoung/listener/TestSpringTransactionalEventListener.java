package io.github.sejoung.listener;

import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import io.github.sejoung.event.TestSpringEvent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class TestSpringTransactionalEventListener {

  @TransactionalEventListener
  public void handleAfterCommit(TestSpringEvent event) {
    log.debug("AFTER COMMIT {}", event);
  }

  @TransactionalEventListener(phase = TransactionPhase.AFTER_COMPLETION)
  public void handleAfterCompletion(TestSpringEvent event) {
    log.debug("AFTER COMPLETION {}", event);
  }

  @TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK)
  public void handleAfterRollback(TestSpringEvent event) {
    log.debug("AFTER COMPLETION {}", event);
  }

  @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
  public void handleBeforeCommit(TestSpringEvent event) {
    log.debug("BEFORE COMMIT {}", event);
  }

}
