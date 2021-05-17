package io.github.sejoung.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import io.github.sejoung.dto.OrderResponse;
import io.github.sejoung.entity.Order;

@Mapper
public interface OrderMapper {
  OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

  @Mapping(source = "id",target = "id")
  OrderResponse toOrderResponse(Order order);
}
