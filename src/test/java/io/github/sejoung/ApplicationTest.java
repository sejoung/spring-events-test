package io.github.sejoung;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import io.github.sejoung.event.TestSpringEvent;
import io.github.sejoung.listener.TestSpringTransactionalEventListener;

@SpringBootTest
class ApplicationTest {

  @Autowired
  private TestSpringTransactionalEventListener listener;

  @Test
  void listener() {

    Assertions.assertThat(listener).isNotNull();
    listener.handleAfterCommit(new TestSpringEvent(this, "asd"));

  }
}