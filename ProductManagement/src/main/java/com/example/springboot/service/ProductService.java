package com.example.springboot.service;

import java.util.List;

import com.example.springboot.entity.Product;

public interface ProductService {
	
	Product addProduct(Product product);
	
	Product updateProduct(Product product,Integer id);
	
	Product getProductById(Integer id);
	
	List<Product> getAllProduct();
	
	Product deleteProduct(Integer id);

	List<Product> getProductByCategory(String category);

}
