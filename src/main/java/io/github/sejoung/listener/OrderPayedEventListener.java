package io.github.sejoung.listener;

import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.sejoung.event.OrderPayedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderPayedEventListener {
  private final ObjectMapper objectMapper;

  @TransactionalEventListener
  public void handleAfterCommit(OrderPayedEvent event) throws JsonProcessingException {
    var json = objectMapper.writeValueAsString(event);
    log.debug("OrderPayedEvent {}", json);
  }
}
