package com.example.springboot.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="tbl_product")
@NamedQuery(name = "Product.findAll", query = "SELECT p FROM product p")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="product_id")
	private Integer id;
	
	@NotNull(message = "product name should not be empty")
	@Column(name="product_name")
	private String name;
	
	@Column(name="product_type")
	private ProductType type;
	
	@Min(0)
	@Max(200)
	@Column(name="product_price")
	private Double price;
	
	@Column(name="product_currency")
	private String currency;
	
	@Max(100)
	@Column(name="product_discount")
	private double discount;
	
	@Column (name="discount_description")
	private String discountDescription;

	@NotNull(message = "category should not be null")
	@Column(name="product_category")
	private Category category;
	
	@Column(name="image")
	private List<String> imageUrls;

	public Product() {
		super();
	}

	public Product(Integer id, String name, ProductType type, Double price, String currency, double discount,
			String discountDescription, Category category, List<String> imageUrls) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.price = price;
		this.currency = currency;
		this.discount = discount;
		this.discountDescription = discountDescription;
		this.category = category;
		this.imageUrls = imageUrls;
	}

	
	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public List<String> getImageUrls() {
		return imageUrls;
	}

	public void setImageUrls(List<String> imageUrls) {
		this.imageUrls = imageUrls;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ProductType getType() {
		return type;
	}

	public void setType(ProductType type) {
		this.type = type;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public String getDiscountDescription() {
		return discountDescription;
	}

	public void setDiscountDescription(String discountDescription) {
		this.discountDescription = discountDescription;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", type=" + type + ", price=" + price + ", currency=" + currency
				+ ", discount=" + discount + ", discountDescription=" + discountDescription + ", category=" + category
				+ ", imageUrls=" + imageUrls + "]";
	}

	
	
	 
}
