package com.example.springboot;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties( "product")
public class ProductConfiguration {
	private List<String> currencies;

	public List<String> getCurrencies() {
		return currencies;
	}

	public void setCurrencies(List<String> currencies) {
		this.currencies = currencies;
	}
	

}
