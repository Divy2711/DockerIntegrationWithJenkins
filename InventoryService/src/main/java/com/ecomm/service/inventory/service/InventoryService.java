package com.ecomm.service.inventory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomm.service.inventory.dto.InventoryDTO;
import com.ecomm.service.inventory.dto.OrderDTO;
import com.ecomm.service.inventory.dto.ProductDTO;
import com.ecomm.service.inventory.feign.FeignClientforOrderandProduct;
import com.ecomm.service.inventory.models.Inventory;
import com.ecomm.service.inventory.repository.InventoryRepository;

@Service
public class InventoryService {
	
	@Autowired
	private InventoryRepository inventoryRepository;
	
	@Autowired
	private FeignClientforOrderandProduct productorderClient;
	
	public Inventory addItemsToInventory(Inventory inventory) {
		return inventoryRepository.save(inventory);
	}
	
	public InventoryDTO itemsInInventory(String id) {
		
		Inventory inventory=inventoryRepository.findById(id).get();
		OrderDTO orderDTO = productorderClient.getOrderByID(inventory.getOrderid());
		ProductDTO productDTO= productorderClient.getProductById(orderDTO.getProductId());
		
		InventoryDTO inventoryDTO= new InventoryDTO();
		
		inventoryDTO.setInventoryId(inventory.getId());
		inventoryDTO.setName(productDTO.getName());
		inventoryDTO.setQty(orderDTO.getQuantity());
		inventoryDTO.setPrice(productDTO.getPrice());
		inventoryDTO.setTotalprice(orderDTO.getQuantity()*productDTO.getPrice());
		
		return inventoryDTO;
		
	}

}
