package com.numbertoenglish.converter;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws NumberConverterException
    {
    	HundredsToWordsConverter a = new HundredsToWordsConverter(new NumberToEnglishValues().baseNumbers(), NumberSeparator.AND.getValue());
    	NumberConverter num = new NumberConverter(a, new NumberToEnglishValues().numberScales());
    	System.out.println(num.asWords(123));
    	System.out.println(num.asWords(100));
    	System.out.println(num.asWords(1000));
    	System.out.println(num.asWords(10000));
    	System.out.println(num.asWords(100000));
    	System.out.println(num.asWords(1000000));
    	System.out.println(num.asWords(223));
    	System.out.println(num.asWords(105));
    	System.out.println(num.asWords(21));
    	System.out.println(num.asWords(1));
    	System.out.println(num.asWords(56945781));
    }	
}
