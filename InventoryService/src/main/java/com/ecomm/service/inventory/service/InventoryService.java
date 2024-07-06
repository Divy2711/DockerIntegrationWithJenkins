package com.ecomm.service.inventory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomm.service.inventory.dto.InventoryDTO;
import com.ecomm.service.inventory.dto.OrderDTO;
import com.ecomm.service.inventory.dto.ProductDTO;
import com.ecomm.service.inventory.feign.OrderClient;
import com.ecomm.service.inventory.feign.ProductClient;
import com.ecomm.service.inventory.models.Inventory;
import com.ecomm.service.inventory.repository.InventoryRepository;

@Service
public class InventoryService {
	
	@Autowired
	private InventoryRepository inventoryRepository;
	
	@Autowired
	private OrderClient orderClient;
	
	@Autowired
	private ProductClient productClient;
	
	public Inventory addItemsToInventory(Inventory inventory) {
		return inventoryRepository.save(inventory);
	}
	
	public InventoryDTO itemsInInventory(String id) {
		
		Inventory inventory=inventoryRepository.findById(id).get();
		OrderDTO orderDTO = orderClient.getOrderByID(inventory.getOrderid());
		ProductDTO productDTO= productClient.getProductById(orderDTO.getProductId());
		
		InventoryDTO inventoryDTO= new InventoryDTO();
		
		inventoryDTO.setInventoryId(inventory.getId());
		inventoryDTO.setName(productDTO.getName());
		inventoryDTO.setQty(orderDTO.getQuantity());
		inventoryDTO.setPrice(productDTO.getPrice());
		inventoryDTO.setTotalprice(orderDTO.getQuantity()*productDTO.getPrice());
		
		return inventoryDTO;
		
	}

}
