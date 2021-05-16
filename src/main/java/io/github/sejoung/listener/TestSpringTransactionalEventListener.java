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
  public <T> void handleAfterCommit(TestSpringEvent<T> event) {
    log.debug("AFTER COMMIT {}", event);
  }

  @TransactionalEventListener(phase = TransactionPhase.AFTER_COMPLETION)
  public <T> void handleAfterCompletion(TestSpringEvent<T> event) {
    log.debug("AFTER COMPLETION {}", event);
  }

  @TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK)
  public <T> void handleAfterRollback(TestSpringEvent<T> event) {
    log.debug("AFTER ROLLBACK {}", event);
  }

  @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
  public <T> void handleBeforeCommit(TestSpringEvent<T> event) {
    log.debug("BEFORE COMMIT {}", event);
  }

}
