package com.ecomm.service.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ecomm.service.order.dto.Product;

@FeignClient(name="api-gateway")
public interface ProductClient {

	@RequestMapping(value = "${product.getProductById}", method=RequestMethod.GET)
    public Product getProductById(@PathVariable String id);
}
