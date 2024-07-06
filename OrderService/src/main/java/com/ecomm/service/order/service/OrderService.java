package com.ecomm.service.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomm.service.order.dto.Product;
import com.ecomm.service.order.dto.orderDTO;
import com.ecomm.service.order.feign.ProductClient;
import com.ecomm.service.order.model.Order;
import com.ecomm.service.order.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductClient productClient;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(String id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Order addOrder(Order order) {
        Product product = productClient.getProductById(order.getProductId());
        if (product != null) {
            return orderRepository.save(order);
        } else {
            throw new RuntimeException("Product not found");
        }
    }
    
    public orderDTO showOrderDetails(String orderId) {
    	Order order = orderRepository.findById(orderId).get();
    	Product product=productClient.getProductById(order.getProductId());
    	
    	orderDTO orderdto=new orderDTO();
    	orderdto.setName(product.getName());
    	orderdto.setOrderId(order.getId());
    	orderdto.setProductId(order.getProductId());
    	orderdto.setQuantity(order.getQuantity());
    	
    	return orderdto;
    	
    }
}
