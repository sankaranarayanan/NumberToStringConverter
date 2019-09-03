package com.numbertoenglish.converter;

import java.util.HashMap;
import java.util.Map;

public class NumberBuilder {
	private final Map<Integer, String> result = new HashMap<Integer, String>();
	
    public static NumberBuilder baseNumbersBuilder() {
        return new NumberBuilder();
    }

    public NumberBuilder put(Integer number, String forms) {
        result.put(number, forms);
        return this;
    }

    public Map<Integer, String> build() {
        return result;
    }

}
