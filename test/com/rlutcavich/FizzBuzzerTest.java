package com.rlutcavich;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

public class FizzBuzzerTest {
    private FizzBuzzer fizzBuzzer = FizzBuzzer.getInstance();
    private ArrayList<Integer> numbersDivisibleByFirstButNotSecondDivisor;
    private ArrayList<Integer> numbersDivisibleBySecondButNotFirstDivisor;
    private ArrayList<Integer> numbersDivisibleByNeitherDivisor;

    @Before
    public void setup() {
        numbersDivisibleByFirstButNotSecondDivisor = givenNumbersInFirstListButNotSecond(givenNumbersDivisibleBy(FIRST_DIVISOR), givenNumbersDivisibleBy(SECOND_DIVISOR));
        numbersDivisibleBySecondButNotFirstDivisor = givenNumbersInFirstListButNotSecond(givenNumbersDivisibleBy(SECOND_DIVISOR), givenNumbersDivisibleBy(FIRST_DIVISOR));
        numbersDivisibleByNeitherDivisor = givenNumbersInNeither();

        randomizeGivenNumbers();
    }

    @Test
    public void getValue_NumberNotDivisibleByFirstOrSecondDivisorGiven_ShouldReturnNumber() {
        int givenInput = givenNumberNotDivisibleByEither();

        String output = whenGetValueCalledWith(givenInput);

        thenOutputShouldMatchExpectedString(output, String.valueOf(givenInput));
    }

    @Test
    public void getValue_NumberDivisibleByFirstDivisorGiven_ShouldReturnFirstKeyword() {
        int givenInput = givenRandomNumberDivisibleBy(FIRST_DIVISOR);

        String output = whenGetValueCalledWith(givenInput);

        thenOutputShouldMatchExpectedString(output, FIRST_KEYWORD);
    }

    @Test
    public void getValue_NumberDivisibleBySecondDivisorGiven_ShouldReturnSecondKeyword() {
        int givenInput = givenRandomNumberDivisibleBy(SECOND_DIVISOR);

        String output = whenGetValueCalledWith(givenInput);

        thenOutputShouldMatchExpectedString(output, SECOND_KEYWORD);
    }

    @Test
    public void getValue_NumberDivisibleByFirstAndSecondDivisorGiven_ShouldReturnCombinedKeyword() {
        int givenInput = givenRandomNumberDivisibleByBoth();

        String output = whenGetValueCalledWith(givenInput);

        thenOutputShouldMatchExpectedString(output, FIRST_KEYWORD + SECOND_KEYWORD);
    }

    private String whenGetValueCalledWith(int input) {
        return fizzBuzzer.getValue(input);
    }

    private void thenOutputShouldMatchExpectedString(String output, String expected) {
        Assert.assertEquals(expected, output);
    }

    private int givenNumberNotDivisibleByEither() {
        return numbersDivisibleByNeitherDivisor.get(0);
    }

    private int givenRandomNumberDivisibleBy(int i) {
        int givenNumber = numbersDivisibleByFirstButNotSecondDivisor.get(0);
        if (i == 5) {
            givenNumber = numbersDivisibleBySecondButNotFirstDivisor.get(0);
        }
        return givenNumber;
    }

    private int givenRandomNumberDivisibleByBoth() {
        int givenNumber = numbersDivisibleByFirstButNotSecondDivisor.get(0);
        return givenNumber * SECOND_DIVISOR;
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
            if (!numbersDivisibleByFirstButNotSecondDivisor.contains(i) && !numbersDivisibleBySecondButNotFirstDivisor.contains(i)) {
                numbersInNeither.add(i);
            }
        }

        return numbersInNeither;
    }

    private int getSizeOfNumbersInNeither() {
        return MAX_NUMBER - (numbersDivisibleByFirstButNotSecondDivisor.size() + numbersDivisibleBySecondButNotFirstDivisor.size());
    }

    private void randomizeGivenNumbers() {
        Collections.shuffle(numbersDivisibleByFirstButNotSecondDivisor);
        Collections.shuffle(numbersDivisibleBySecondButNotFirstDivisor);
        Collections.shuffle(numbersDivisibleByNeitherDivisor);
    }

    private static final int FIRST_DIVISOR = 3;
    private static final int SECOND_DIVISOR = 5;
    private static final int MAX_NUMBER = 100;
    private static final String FIRST_KEYWORD = "FIZZ";
    private static final String SECOND_KEYWORD = "BUZZ";
}
