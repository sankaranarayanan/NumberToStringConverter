package com.numbertoenglish.converter;

public enum NumberSeparator {
	AND("and");
	
	NumberSeparator(String value) {
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
