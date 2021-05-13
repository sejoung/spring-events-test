package io.github.sejoung.service;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.transaction.TestTransaction;

@SpringBootTest
class TestServiceTest {

  @Autowired
  private TestService service;

  @Transactional
  @Test
  void event() {
    service.test();
    TestTransaction.flagForCommit();
    TestTransaction.end();
  }
}