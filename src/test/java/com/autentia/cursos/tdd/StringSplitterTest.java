package com.autentia.cursos.tdd;


import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class StringSplitterTest {

    private StringSplitter stringSplitterSUT = new StringSplitter();

    //Prueba con null

    //Prueba base ""

    //Prueba base "a"

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
