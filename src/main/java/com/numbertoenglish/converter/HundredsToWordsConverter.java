package com.numbertoenglish.converter;

import java.util.Map;

import static java.lang.String.format;

import com.google.common.collect.Range;


public class HundredsToWordsConverter {
    private final Map<Integer, String> baseValues;
    private final String wordSeparator;
	
    public HundredsToWordsConverter(Map<Integer, String> baseValues, String wordSeparator) {
        this.baseValues = baseValues;
        this.wordSeparator = wordSeparator;
    }

    public String asWords(Integer value, String form) {
        if (baseValues.containsKey(value)) {
            return baseValues.get(value);
        } else if (Range.closed(21, 99).contains(value)) {
        	return twoDigitsNumberAsString(value);
        } else if (Range.closed(101, 999).contains(value)) {
        	return threeDigitsNumberAsString(value,this.wordSeparator);        	
        }

        throw new IllegalArgumentException(format("Can't convert %d", value));
    }
    
    private String twoDigitsNumberAsString(Integer value) {
        Integer units = value % 10;
        Integer tens = value - units;
        return format("%s %s", asWords(tens, ""), asWords(units, ""));
    }

    private String threeDigitsNumberAsString(Integer value, String wordSeparator) {
        Integer tensWithUnits = value % 100;
        Integer hundreds = value - tensWithUnits;
        
        return format("%s %s %s", asWords(hundreds, ""), wordSeparator, asWords(tensWithUnits, ""));
    }

}
