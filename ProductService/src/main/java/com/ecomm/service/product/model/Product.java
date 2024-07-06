package com.ecomm.service.product.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;



@Entity
public class Product {

	    @Id
	    private String id;
	    private String name;
	    private double price;
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
	    
	    
}
