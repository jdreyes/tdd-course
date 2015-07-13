package com.autentia.cursos.tdd;

/**
 * String split based implementation
 */
public class StringSplitter {

    private static final String DEFAULT_SEPARATOR = ",";

    public String[] split(String stringToSplit) {
        return stringToSplit.split(DEFAULT_SEPARATOR);
    }
}
