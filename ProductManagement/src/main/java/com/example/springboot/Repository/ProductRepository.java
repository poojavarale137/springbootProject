package com.example.springboot.Repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.springboot.entity.Category;
import com.example.springboot.entity.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	@Query("{'Category.name':?0}")
	List<Product> findByCategory(String category);

}
