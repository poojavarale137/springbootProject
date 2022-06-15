package com.example.springboot.Exception;

public class CurrencyNotValidException extends RuntimeException {
	public CurrencyNotValidException(String s) {
		super(s);
	}

}
