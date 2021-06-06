package com.edusol.product.controller;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edusol.product.model.Product;
import com.edusol.product.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/get-products")
	public Object getProducts(){
		@SuppressWarnings("unchecked")
		List<Product> products = (List<Product>) productService.getProducts();
		logger.info(products.toString());
		return products;
	}
	
	@PostMapping("/add-product")
	public Object addProduct(@RequestBody Product product){
		
		return productService.addProduct(product);
	}
	
	@GetMapping("/get-product-byid")
	public Object getProductById(@RequestParam int id){
		return productService.getProductById(id);
		
	}
	
	@GetMapping("/get-product-bycategory")
	public Object getProductByCategory(@RequestParam String category){
		return productService.getProductByCategory(category);
	}
	
	
	@GetMapping("/get-product-bypriceandcategory")
	public Object getProductsByPriceAndCategory(@RequestParam float price,@RequestParam String category){
		return productService.getProductsByPriceAndCategory(price,category);
	}
	
	@PutMapping("/update-product")
	public Object updateProduct(@RequestBody Product product){
		
		return productService.updateProduct(product);
		
	}
	
	@DeleteMapping("/delete-product")
	public Object deleteProduct(@RequestParam int id){
		return productService.deleteProduct(id);
	}
	

}
