package com.numbertoenglish.converter;

public class NumberConverterException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	
	public NumberConverterException(String message) {
	      this.message = message;
	} 
	
	public String toString() {
		return message;
	}
}
