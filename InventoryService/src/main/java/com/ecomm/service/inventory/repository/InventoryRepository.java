package com.ecomm.service.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecomm.service.inventory.models.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, String>{
	
}
