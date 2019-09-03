package com.numbertoenglish.converter;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class NumberSplitter {

    private static final Integer SPLIT_SIZE = 3;
    private static final Integer SPLIT_FACTOR = (int) Math.pow(10, SPLIT_SIZE);

    public List<Integer> chunk(Integer value) {
        Deque<Integer> result = new ArrayDeque<Integer>();

        while (value > 0) {
            result.addFirst(value % SPLIT_FACTOR);
            value /= SPLIT_FACTOR;
        }

        return new ArrayList<Integer>(result);
    }
}
