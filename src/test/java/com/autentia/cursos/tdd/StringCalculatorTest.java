package com.autentia.cursos.tdd;



import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;


public class StringCalculatorTest {

    //Subject under test
    private StringCalculator stringCalculatorSUT;

    //Test doubles
    private StringSplitter stringSplitterTD;

    @Before
    public void init() {
        stringSplitterTD = mock(StringSplitter.class);
        stringCalculatorSUT = new StringCalculator(stringSplitterTD);

        when(stringSplitterTD.split("99")).thenReturn(new String[]{"99"});
        when(stringSplitterTD.split("1,2")).thenReturn(new String[]{"1","2"});
        when(stringSplitterTD.split("1,2,3,4")).thenReturn(new String[]{"1","2","3","4"});
    }

    @Test
    public void givenAnEmptyStringWhenAddingAStringThenReturnZero() {

        //given
        String emptyString = "";

        //when
        int sum = stringCalculatorSUT.add(emptyString);

        //then
        //assertThat(sum, is(equalTo(0)));
        assertThat(sum, is(0));

        verifyNoMoreInteractions(stringSplitterTD);
}

    @Test
    public void givenASingleNumberStringWhenAddingAStringThenReturnTheNumber() {

        //given
        String singleNumberString = "99";

        //when
        int sum = stringCalculatorSUT.add(singleNumberString);

        //then
        Assert.assertThat("Adding single number failed", sum, is(99));
        //verify(stringSplitterTD).split("99");
        verify(stringSplitterTD).split(anyString());
    }

    @Test
    public void givenTwoNumbersStringWhenAddingAStringThenReturnTheSum() {

        //given
        String twoNumbersString = "1,2";

        //when
        int sum = stringCalculatorSUT.add(twoNumbersString);

        //then
        assertEquals(3, sum);
        verify(stringSplitterTD).split(anyString());
    }

    @Test
    public void givenNNumbersStringWhenAddingAStringThenReturnTheSum() {

        //given
        String nNumbersString = "1,2,3,4";

        //when
        int sum = stringCalculatorSUT.add(nNumbersString);

        //then
        assertEquals(10, sum);
        verify(stringSplitterTD).split(anyString());
    }
}
