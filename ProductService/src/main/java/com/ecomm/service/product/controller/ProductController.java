package com.ecomm.service.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecomm.service.product.model.Product;
import com.ecomm.service.product.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	    @Autowired
	    private ProductService productService;
	    
	    @GetMapping("")
	    public String welcomeMessage() {
	    	return "Welcome to E-commerce website. Select your products!!!";
	    }
	    @GetMapping("/getAllProducts")
	    public List<Product> getAllProducts() {
	        return productService.getAllProducts();
	    }

	    @GetMapping("/getproductbyId/{id}")
	    public Product getProductById(@PathVariable String id) {
	        return productService.getProductById(id);
	    }

	    @PostMapping("/addProduct")
	    public Product addProduct(@RequestBody Product product) {
	        return productService.addProduct(product);
	    }

}
