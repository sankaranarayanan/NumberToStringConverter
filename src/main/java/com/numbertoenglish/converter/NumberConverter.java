package com.numbertoenglish.converter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.google.common.base.Joiner;
import static java.lang.String.format;
import static com.google.common.collect.Lists.reverse;



public class NumberConverter {
    private final NumberSplitter numberSplitter = new NumberSplitter();
    protected final HundredsToWordsConverter hundredsToWordsConverter;
    private final List<NumberScale> forms;
	
    public NumberConverter(HundredsToWordsConverter hundredsToWordsConverter, List<NumberScale> forms) {
    	this.hundredsToWordsConverter = hundredsToWordsConverter;
    	this.forms = forms;
	}
    
    public String asWords(Integer value) throws NumberConverterException {
        checkArgument(value > 0, "can't convert negative numbers for value %d", value);
        checkArgument(value < 999999999, "can't convert numbers for value %d", value);
        
        List<Integer> valueChunks = numberSplitter.chunk(value);
        
        List<NumberScale> formsToUse = reverse(forms.subList(0, valueChunks.size()));

        return joinValue(valueChunks.iterator(), formsToUse.iterator());
    }

    protected String joinValue(Iterator<Integer> chunks, Iterator<NumberScale> formsToUse) {
        List<String> result = new ArrayList<String>();
        while (chunks.hasNext() && formsToUse.hasNext()) {

            Integer currentChunkValue = chunks.next();
            NumberScale currentForms = formsToUse.next();
            if (currentChunkValue > 0) {
                result.add(hundredsToWordsConverter.asWords(currentChunkValue, currentForms.getValue()));
                result.add(currentForms.getValue());
            }
        }

        return mergeResult(result);
    }
    
    protected String mergeResult(List<String> result) {
        if (result.size() == 0) {
            return hundredsToWordsConverter.asWords(0, forms.get(0).getValue());
        }

        return Joiner.on(" ").join(result).trim();
    }


	public static void checkArgument(boolean expression, String errorMessage, Integer value) throws NumberConverterException {
		if (!expression) {
			throw new NumberConverterException(format(errorMessage, value));
		}	
	}
}
