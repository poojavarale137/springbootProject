package com.example.springboot.serviceImpl;

import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.Repository.ProductRepository;
import com.example.springboot.entity.Product;
import com.example.springboot.ProductConfiguration;
import com.example.springboot.Exception.CurrencyNotValidException;
import com.example.springboot.Exception.OfferNotValidException;
import com.example.springboot.Exception.ResourceNotFoundException;
import com.example.springboot.service.ProductService;


@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	ProductConfiguration productConfiguration;
	
	@Override
	public Product addProduct(Product product) {
		if(product.getPrice()==0 && product.getDiscount()>0) {
			throw new OfferNotValidException("No discount for 0price product");
		}
		
		
		
		if(!productConfiguration.getCurrencies().contains(product.getCurrency().toUpperCase())) {
			throw new CurrencyNotValidException("invalid currency" + productConfiguration.getCurrencies());
		}
		
	Product savedProduct=productRepository.save(product);
		return savedProduct;
	}

	@Override
	public Product updateProduct(Product product, Integer id) {
	Product updatedProduct=productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product","id",id));
	updatedProduct.setName(product.getName());
	updatedProduct.setType(product.getType());
	updatedProduct.setCategory(product.getCategory());
	updatedProduct.setDiscount(product.getDiscount());
	updatedProduct.setDiscountDescription(product.getDiscountDescription());
	updatedProduct.setPrice(product.getPrice());
	
	Product savedProduct =productRepository.save(updatedProduct);
		return savedProduct;
	}

	@Override
	public Product getProductById(Integer id) {
		Product product = productRepository.findById(id).get();
		return product;
	}
	
	@Override
	public List<Product> getAllProduct() {
		List<Product> product=productRepository.findAll();
		List<Product> newProduct = product.stream().map(product1 -> product1).collect(Collectors.toList());
		return newProduct;
	}

	@Override
	public Product deleteProduct(Integer id) {
		Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product","id", id));
		productRepository.delete(product);
		return product;
	}

	@Override
	public List<Product> getProductByCategory(String category) {
		List<Product> product=productRepository.findByCategory(category);
		return product.stream()
		.filter(products -> products.getCategory().getName().equalsIgnoreCase(category))
		.collect(Collectors.toList());
	
	}
	
}
