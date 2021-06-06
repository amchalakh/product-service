package com.edusol.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edusol.product.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	List<Product> findByCategory(String category);
	List<Product> findByPriceAndCategory(float price, String categoty);

}
