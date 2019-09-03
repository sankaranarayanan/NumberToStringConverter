package com.numbertoenglish.converter;

import static org.junit.Assert.*;

import org.junit.Test;	

public class HundredsToWordsConverterTest {
	private NumberConverter converter;
	
	@Test		
    public void testShouldConvertBaseValue() throws NumberConverterException {
		HundredsToWordsConverter  hundredsToWordsConverter = 
				new HundredsToWordsConverter(new NumberToEnglishValues().baseNumbers(), 
						NumberSeparator.AND.getValue());
		assertEquals("one", hundredsToWordsConverter.asWords(1, NumberScale.EMPTY.getValue()));
	}
	
	@Test		
    public void testShouldConvertTwoDigitValue() throws NumberConverterException {
		HundredsToWordsConverter  hundredsToWordsConverter = 
				new HundredsToWordsConverter(new NumberToEnglishValues().baseNumbers(), 
						NumberSeparator.AND.getValue());
		assertEquals("twenty one", hundredsToWordsConverter.asWords(21, NumberScale.EMPTY.getValue()));
	}

	@Test		
    public void testShouldConvertThreeDigitValue() throws NumberConverterException {
		HundredsToWordsConverter  hundredsToWordsConverter = 
				new HundredsToWordsConverter(new NumberToEnglishValues().baseNumbers(), 
						NumberSeparator.AND.getValue());
		assertEquals("six hundred sixty six", hundredsToWordsConverter.asWords(666, NumberScale.EMPTY.getValue()));
	}

	@Test(expected = NumberConverterException.class)
    public void testShouldThrowNumberConverterExceptionWhenNumberIsNotSupport() throws NumberConverterException {
		HundredsToWordsConverter  hundredsToWordsConverter = 
				new HundredsToWordsConverter(new NumberToEnglishValues().baseNumbers(), 
						NumberSeparator.AND.getValue());
		hundredsToWordsConverter.asWords(0, NumberScale.EMPTY.getValue());
	}
}
