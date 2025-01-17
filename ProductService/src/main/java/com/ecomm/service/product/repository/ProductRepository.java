package com.ecomm.service.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecomm.service.product.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

}
