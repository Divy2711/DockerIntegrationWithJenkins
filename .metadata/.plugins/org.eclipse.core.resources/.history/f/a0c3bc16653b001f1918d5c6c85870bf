package com.ecomm.service.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ecomm.service.order.dto.Product;

@FeignClient(name="${app.feign.config.name}",url="${app.feign.config.url}")
public interface ProductClient {

	@GetMapping("/products/getproductbyId/{id}")
    public Product getProductById(@PathVariable String id);
}
