package com.numbertoenglish.converter;

public enum NumberScale {
	EMPTY(""),
	Thousand("thousand"),
	Million("million");
	
	
	NumberScale(String value) {
        this.value = value;
    }
	
    private final String value;
	
    public String getValue() {
        return value;
    }
    public String toString() {
        return name();
    }
}
