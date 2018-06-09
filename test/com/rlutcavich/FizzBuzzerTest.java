package com.rlutcavich;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

public class FizzBuzzerTest {
    private FizzBuzzer fizzBuzzer = FizzBuzzer.getInstance();
    private ArrayList<Integer> numbersDivisibleByFirstButNotSecond;
    private ArrayList<Integer> numbersDivisibleBySecondButNotFirst;
    private ArrayList<Integer> numbersDivisibleByNeither;

    @Before
    public void setup() {
        numbersDivisibleByFirstButNotSecond = givenNumbersInFirstListButNotSecond(givenNumbersDivisibleBy(FIRST), givenNumbersDivisibleBy(SECOND));
        numbersDivisibleBySecondButNotFirst = givenNumbersInFirstListButNotSecond(givenNumbersDivisibleBy(SECOND), givenNumbersDivisibleBy(FIRST));
        numbersDivisibleByNeither = givenNumbersInNeither();

        randomizeGivenNumbers();
    }

    @Test
    public void getValue_NumberNotDivisibleBy3Or5Given_ShouldReturnNumber() {
        int givenInput = givenNumberNotDivisibleByEither();

        String output = whenGetValueCalledWith(givenInput);

        thenOutputShouldMatchExpectedString(output, String.valueOf(givenInput));
    }

    @Test
    public void getValue_NumberDivisibleBy3Given_ShouldReturnFIZZ() {
        int givenInput = givenRandomNumberDivisibleBy(FIRST);

        String output = whenGetValueCalledWith(givenInput);

        thenOutputShouldMatchExpectedString(output, FIZZ);
    }

    @Test
    public void getValue_NumberDivisibleBy5Given_ShouldReturnBUZZ() {
        int givenInput = givenRandomNumberDivisibleBy(SECOND);

        String output = whenGetValueCalledWith(givenInput);

        thenOutputShouldMatchExpectedString(output, BUZZ);
    }

    @Test
    public void getValue_NumberDivisibleBy3And5Given_ShouldReturnFIZZBUZZ() {
        int givenInput = givenRandomNumberDivisibleByBoth();

        String output = whenGetValueCalledWith(givenInput);

        thenOutputShouldMatchExpectedString(output, FIZZBUZZ);
    }

    private String whenGetValueCalledWith(int input) {
        return fizzBuzzer.getValue(input);
    }

    private void thenOutputShouldMatchExpectedString(String output, String expected) {
        Assert.assertEquals(expected, output);
    }

    private int givenNumberNotDivisibleByEither() {
        return numbersDivisibleByNeither.get(0);
    }

    private int givenRandomNumberDivisibleBy(int i) {
        int givenNumber = numbersDivisibleByFirstButNotSecond.get(0);
        if (i == 5) {
            givenNumber = numbersDivisibleBySecondButNotFirst.get(0);
        }
        return givenNumber;
    }

    private int givenRandomNumberDivisibleByBoth() {
        int givenNumber = numbersDivisibleByFirstButNotSecond.get(0);
        return givenNumber * SECOND;
    }

    private ArrayList<Integer> givenNumbersDivisibleBy(int num) {
        int countOfNumbers = MAX_NUMBER/num;

        ArrayList<Integer> numbersDivisibleByNum = new ArrayList<>(countOfNumbers);
        for (int i = num; i < MAX_NUMBER; i += num) {
            if (i % num == 0) {
                numbersDivisibleByNum.add(i);
            }
        }
        return numbersDivisibleByNum;
    }

    private ArrayList<Integer> givenNumbersInFirstListButNotSecond(ArrayList<Integer> firstNumbers, ArrayList<Integer> secondNumbers) {
        ArrayList<Integer> numbersInFirstListButNotSecond = new ArrayList<>(firstNumbers.size());
        for (int aNumFromFirstNumbers : firstNumbers) {
            if (!secondNumbers.contains(aNumFromFirstNumbers)) {
                numbersInFirstListButNotSecond.add(aNumFromFirstNumbers);
            }
        }
        return numbersInFirstListButNotSecond;
    }

    private ArrayList<Integer> givenNumbersInNeither() {
        int sizeOfNumbersInNeither = getSizeOfNumbersInNeither();
        ArrayList<Integer> numbersInNeither = new ArrayList<>(sizeOfNumbersInNeither);

        for (int i = 1; i < sizeOfNumbersInNeither; i++) {
            if (!numbersDivisibleByFirstButNotSecond.contains(i) && !numbersDivisibleBySecondButNotFirst.contains(i)) {
                numbersInNeither.add(i);
            }
        }

        return numbersInNeither;
    }

    private int getSizeOfNumbersInNeither() {
        return MAX_NUMBER - (numbersDivisibleByFirstButNotSecond.size() + numbersDivisibleBySecondButNotFirst.size());
    }

    private void randomizeGivenNumbers() {
        Collections.shuffle(numbersDivisibleByFirstButNotSecond);
        Collections.shuffle(numbersDivisibleBySecondButNotFirst);
        Collections.shuffle(numbersDivisibleByNeither);
    }

    private static final int FIRST = 3;
    private static final int SECOND = 5;
    private static final int MAX_NUMBER = 100;
    private static final String FIZZ = "FIZZ";
    private static final String BUZZ = "BUZZ";
    private static final String FIZZBUZZ = "FIZZBUZZ";
}
