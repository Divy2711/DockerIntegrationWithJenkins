package com.ecomm.service.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecomm.service.order.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, String>{

}
