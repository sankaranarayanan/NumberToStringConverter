package com.numbertoenglish.converter;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;	

public class NumberConverterTest {
	private NumberConverter converter;

	@Before
	public void setUp() throws NumberConverterException {
    	HundredsToWordsConverter  hundredsToWordsConverter = new HundredsToWordsConverter(new NumberToEnglishValues().baseNumbers(), NumberSeparator.AND.getValue());
    	converter = new NumberConverter(hundredsToWordsConverter, new NumberToEnglishValues().numberScales());
	}
	
	@Test		
    public void testShouldConvertSimplyValue() throws NumberConverterException {
		assertEquals("one", converter.asWords(1));
	}
	
	@Test		
    public void testShouldConvertComplexValue() throws NumberConverterException {
		assertEquals("one million two thousand three", converter.asWords(1002003));
	}

	@Test (expected = NumberConverterException.class)
    public void testShouldThrowNumberConverterException() throws NumberConverterException {
		converter.asWords(0);
	}

}
