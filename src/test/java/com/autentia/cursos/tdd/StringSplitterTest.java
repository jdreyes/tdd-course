package com.autentia.cursos.tdd;


import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.fail;

public class StringSplitterTest {

    private StringSplitter stringSplitterSUT = new StringSplitter();

    @Test(expected = NullPointerException.class)
    public void shouldNotSplitStringsWithNullArgument() {

        //given
        String nullString = null;

        //when
        final String[] stringParts = stringSplitterSUT.split(nullString);

        //then
        fail("Not expected. String split arguments should throw exception if it's null");

    }


    @Test
    public void shouldSplitStringsWithEmptyArgumentAndReturnArrayWithEmptyString() {

        //given
        String emptyString = "";

        //when
        final String[] stringParts = stringSplitterSUT.split(emptyString);

        //then
        assertThat(stringParts.length, is(1));
        assertThat(stringParts[0], is(""));
    }

    @Test
    public void shouldSplitStringsWithSingleArgument() {

        //given
        String singlePartString = "a";

        //when
        final String[] stringParts = stringSplitterSUT.split(singlePartString);

        //then
        assertThat(stringParts.length, is(1));
        assertThat(stringParts[0], is("a"));
    }


    @Test
    public void shouldSplitStringsWhenAStringWithCommasIsGiven() {

        //given
        String letterString = "a,b,c";

        //when
        final String[] stringParts = stringSplitterSUT.split(letterString);

        //then
        assertThat(stringParts.length, is(3));
        assertThat(stringParts, is(new String[]{"a","b","c"}));
    }
}
