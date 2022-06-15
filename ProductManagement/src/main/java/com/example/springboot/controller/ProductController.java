package com.example.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.entity.Product;
import com.example.springboot.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	Logger logger =LoggerFactory.getLogger(ProductController.class);
	
	@PostMapping("/addproduct")
	 public Product addProduct(@RequestBody @Valid Product product){
		Product product1=productService.addProduct(product);
		logger.info("product added successfully");
		return product1;	 
	 }
	
	@PutMapping("/{id}")
	public Product updateProduct(@RequestBody Product product,@PathVariable Integer id) {
		Product productUpdated = productService.updateProduct(product, id);
		logger.info("product updated successfully");
		return productUpdated;	
	}
	
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable Integer id) {
		Product product =productService.getProductById(id);
		logger.info("retrieved one product successfully");
		return product;
	}
	
	@GetMapping("/list")
	public List<Product> getAllProduct() {
		List<Product> products =productService.getAllProduct();
		logger.info("getting al product...");
		return products;
		
	}
	
	@DeleteMapping("/{id}")
	public Product deleteById(@PathVariable Integer id) {
		Product deletedProduct = productService.deleteProduct(id); 
		logger.info("deleting product..");
		return deletedProduct;
		
	}
	
	@GetMapping("products/{category}")
	List<Product> productBycategory(@PathVariable String category){
		List<Product> productCategory=productService.getProductByCategory(category);
		return productCategory;
		
	}
	
}
