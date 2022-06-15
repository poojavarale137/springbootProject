package com.example.springboot.entity;

public class ProductType {
	
	
	private Integer id;
	private String brandType;

	public ProductType() {
		super();
	}

	public ProductType(Integer id, String brandType) {
		super();
		this.id = id;
		this.brandType = brandType;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBrandType() {
		return brandType;
	}

	public void setBrandType(String brandType) {
		this.brandType = brandType;
	}

	@Override
	public String toString() {
		return "ProductType [id=" + id + ", brandType=" + brandType + "]";
	}
		
}
