package io.github.sejoung.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.sejoung.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
