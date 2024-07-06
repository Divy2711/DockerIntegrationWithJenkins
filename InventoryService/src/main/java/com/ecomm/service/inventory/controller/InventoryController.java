package com.ecomm.service.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecomm.service.inventory.dto.InventoryDTO;
import com.ecomm.service.inventory.models.Inventory;
import com.ecomm.service.inventory.service.InventoryService;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

	@Autowired
	private InventoryService inventoryService;
	
	@PostMapping("/addItemsInInventory")
	public Inventory addItemsInInventory(@RequestBody Inventory inventory) {
		return inventoryService.addItemsToInventory(inventory);
	}
	
	@GetMapping("/viewItemsInInventory/{id}")
	public InventoryDTO viewItemsInInventory(@PathVariable String id) {
		return inventoryService.itemsInInventory(id);
	}
}
