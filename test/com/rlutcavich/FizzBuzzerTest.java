package com.rlutcavich;

import org.junit.Assert;
import org.junit.Test;

public class FizzBuzzerTest {
    private FizzBuzzer fizzBuzzer = FizzBuzzer.getInstance();

    @Test
    public void getValue_NumberNotDivisbleBy3Or5Given_ShouldReturnNumber() {
        int givenInput = givenNumberNotDivisibleByEither(3, 5);

        String output = whenGetValueCalledWith(givenInput);

        thenOutputShouldMatchExpectedString(output, String.valueOf(NUMBER_NOT_DIVISIBLE_BY_3_OR_5));
    }

    @Test
    public void getValue_NumberDivisibleBy3Given_ShouldReturnFIZZ() {
        int givenInput = givenNumberDivisibleBy(3);

        String output = whenGetValueCalledWith(givenInput);

        thenOutputShouldMatchExpectedString(output, FIZZ);
    }

    @Test
    public void getValue_NumberDivisibleBy5Given_ShouldReturnBUZZ() {
        int givenInput = givenNumberDivisibleBy(5);

        String output = whenGetValueCalledWith(givenInput);

        thenOutputShouldMatchExpectedString(output, BUZZ);
    }

    @Test
    public void getValue_NumberDivisibleBy3And5Given_ShouldReturnFIZZBUZZ() {
        int givenInput = NUMBER_DIVISIBLE_BY_3_AND_5;

        String output = whenGetValueCalledWith(givenInput);

        thenOutputShouldMatchExpectedString(output, FIZZBUZZ);
    }

    @Test
    public void getValue_LargestIntDivisibleBy3AND5Given_ShouldReturnFIZZBUZZ() {
        int givenInput = LARGEST_INT_DIVISIBLE_BY_3_AND_5;

        String output = whenGetValueCalledWith(givenInput);

        thenOutputShouldMatchExpectedString(output, FIZZBUZZ);
    }

    private String whenGetValueCalledWith(int input) {
        return fizzBuzzer.getValue(input);
    }

    private void thenOutputShouldMatchExpectedString(String output, String expected) {
        Assert.assertEquals(expected, output);
    }

    private int givenNumberNotDivisibleByEither(int i, int j) {
        return NUMBER_NOT_DIVISIBLE_BY_3_OR_5;
    }

    private int givenNumberDivisibleBy(int i) {
        if (i == 3) {
            return NUMBER_DIVISIBLE_BY_3;
        }
        return NUMBER_DIVISIBLE_BY_5;
    }

    private static final int NUMBER_NOT_DIVISIBLE_BY_3_OR_5 = 1;
    private static final int NUMBER_DIVISIBLE_BY_3 = 3;
    private static final int NUMBER_DIVISIBLE_BY_5 = 5;
    private static final int NUMBER_DIVISIBLE_BY_3_AND_5 = 15;
    private static final int LARGEST_INT_DIVISIBLE_BY_3_AND_5 = 2147483640;
    private static final String FIZZ = "FIZZ";
    private static final String BUZZ = "BUZZ";
    private static final String FIZZBUZZ = "FIZZBUZZ";
}
