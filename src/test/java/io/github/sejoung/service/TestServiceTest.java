package io.github.sejoung.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestServiceTest {

  @Autowired
  private TestService service;

  @DisplayName("정상이벤트")
  @Test
  void event() {
    service.test();
  }

  @DisplayName("롤백이벤트")
  @Test
  void rollbackEvent() {
    Assertions.assertThatThrownBy(() -> service.testRollBack()).isInstanceOf(RuntimeException.class);
  }

}