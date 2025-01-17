package com.ecomm.service.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecomm.service.order.dto.orderDTO;
import com.ecomm.service.order.model.Order;
import com.ecomm.service.order.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	    @Autowired
	    private OrderService orderService;
	    
	    @GetMapping("")
	    public String welcome() {
	    	return "Here are all your orders. Please confirm and proceed for payment.";
	    }

	    @GetMapping("/getAllOrders")
	    public List<Order> getAllOrders() {
	        return orderService.getAllOrders();
	    }

	    @GetMapping("/getOrderDetailsById/{id}")
	    public orderDTO getOrderDetailsById(@PathVariable String id) {
	        return orderService.showOrderDetails(id);
	    }

	    @PostMapping("/addOrder")
	    public Order addOrder(@RequestBody Order order) {
	        return orderService.addOrder(order);
	    }
	    
	    @GetMapping("/getOrderById/{id}")
	    public Order getOrderById(@PathVariable String id) {
	    	return orderService.getOrderById(id);
	    }
	    
	    
}
