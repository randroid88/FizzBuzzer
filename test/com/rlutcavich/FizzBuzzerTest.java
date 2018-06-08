package com.rlutcavich;

import org.junit.Assert;
import org.junit.Test;

public class FizzBuzzerTest {
    private FizzBuzzer fizzBuzzer = FizzBuzzer.getInstance();

    @Test
    public void getValue_NumberNotDivisbleBy3Or5Given_ShouldReturnNumber() {
        int givenInput = NUMBER_NOT_DIVISIBLE_BY_3_OR_5;

        String output = whenGetValueCalledWith(givenInput);

        thenOutputShouldMatchExpectedString(output, String.valueOf(NUMBER_NOT_DIVISIBLE_BY_3_OR_5));
    }

    private String whenGetValueCalledWith(int input) {
        return fizzBuzzer.getValue(input);
    }

    private void thenOutputShouldMatchExpectedString(String output, String expected) {
        Assert.assertEquals(expected, output);
    }

    private static final int NUMBER_NOT_DIVISIBLE_BY_3_OR_5 = 1;
}
