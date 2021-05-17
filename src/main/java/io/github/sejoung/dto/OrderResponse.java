package io.github.sejoung.dto;

import io.github.sejoung.entity.Order;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class OrderResponse {

	private final Long id;
	private final Long userId;
	private final Order.OrderStatus orderStatus;

	public OrderResponse(Long id, Long userId, Order.OrderStatus orderStatus) {
		this.id = id;
		this.userId = userId;
		this.orderStatus = orderStatus;
	}
}
