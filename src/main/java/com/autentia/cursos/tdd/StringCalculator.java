package com.autentia.cursos.tdd;


public class StringCalculator {

    private StringSplitter stringSplitter;

    public StringCalculator(StringSplitter stringSplitter) {
        this.stringSplitter = stringSplitter;
    }

    public int add(String numbers) {

        int sum = 0;
        String s = null; //NOSONAR
        if("".equals(numbers)) {
            return sum;
        }

        final String[] numberParts = stringSplitter.split(numbers);

        for(String part : numberParts) {
            sum += Integer.valueOf(part);
        }

        return sum;
    }
}
