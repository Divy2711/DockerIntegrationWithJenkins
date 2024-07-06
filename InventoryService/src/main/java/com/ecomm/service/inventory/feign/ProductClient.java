package com.ecomm.service.inventory.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ecomm.service.inventory.dto.ProductDTO;

@FeignClient(name="app.feign.config.product.name",url="app.feign.config.product.url")
public interface ProductClient {

	@GetMapping("/products/getproductbyId/{id}")
	public ProductDTO getProductById(@PathVariable String id);
}
