package com.ecomm.service.inventory.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ecomm.service.inventory.dto.OrderDTO;
import com.ecomm.service.inventory.dto.ProductDTO;

@FeignClient(name="api-gateway")
public interface FeignClientforOrderandProduct {
	
	@GetMapping("${order.getOrderById}")
	public OrderDTO getOrderByID(@PathVariable String id);
	
	@GetMapping("${product.getProductById}")
	public ProductDTO getProductById(@PathVariable String id);

}
