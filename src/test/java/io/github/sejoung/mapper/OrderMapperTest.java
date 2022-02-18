package io.github.sejoung.mapper;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import io.github.sejoung.entity.Order;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class OrderMapperTest {

  @Test
  void toOrderResponse() {
    var order = new Order(1L);
    var response = OrderMapper.INSTANCE.toOrderResponse(order);
    log.debug("response {}", response);
    assertThat(response).isNotNull();
    assertThat(response.getUserId()).isOne();
    assertThat(response.getId()).isNull();
    assertThat(response.getOrderStatus()).isEqualTo(Order.OrderStatus.ORDERED);
  }
}