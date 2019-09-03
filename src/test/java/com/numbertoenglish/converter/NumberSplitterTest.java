package com.numbertoenglish.converter;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;	

public class NumberSplitterTest {
	private NumberSplitter splitter;

	@Before
	public void setUp() throws NumberConverterException {
		splitter = new NumberSplitter();
	}
	
	@Test		
    public void testSplitNumberToThreeDigitParts() throws NumberConverterException {
		List<Integer> a = new ArrayList<Integer>();
		a.add(123);
		a.add(456);
		a.add(789);
		
		assertArrayEquals(a.toArray(), splitter.chunk(123456789).toArray());
	}
}
