package io.github.sejoung.event;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class TestSpringEventTest {

  @Test
  void jsonConfig() throws JsonProcessingException {
    var objectMapper = new ObjectMapper();
    objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    var message = new TestMessage("beni", 1L);
    var event = new TestSpringEvent<>(this, message);
    var json = objectMapper.writeValueAsString(event);
    log.debug("json {} ", json);
  }

  @Test
  void jsonNoConfig() throws JsonProcessingException {
    var objectMapper = new ObjectMapper();
    var message = new TestMessage("beni", 4L);
    var event = new TestSpringEvent<>(TestSpringEventTest.class, message);
    var json = objectMapper.writeValueAsString(event);
    log.debug("json {} ", json);
  }

  @Test
  void jsonError() {
    var objectMapper = new ObjectMapper();
    var message = new TestMessage("beni", 2L);
    var event = new TestSpringEvent<>(this, message);
    Assertions.assertThatThrownBy(() -> objectMapper.writeValueAsString(event))
      .isInstanceOf(InvalidDefinitionException.class);
  }

  private class TestMessage {
    private final String name;
    private final Long id;

    public TestMessage(String name, Long id) {
      this.name = name;
      this.id = id;
    }

    public String getName() {
      return name;
    }

    public Long getId() {
      return id;
    }
  }
}