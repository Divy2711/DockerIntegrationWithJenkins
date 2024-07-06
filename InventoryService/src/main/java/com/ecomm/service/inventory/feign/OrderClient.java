package com.ecomm.service.inventory.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ecomm.service.inventory.dto.OrderDTO;

@FeignClient(name="app.feign.config.order.name",url="app.feign.config.order.url")
public interface OrderClient {
	
	@GetMapping("/orders/getOrderById/{id}")
	public OrderDTO getOrderByID(@PathVariable String id);

}