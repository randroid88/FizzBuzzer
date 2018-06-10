package com.rlutcavich;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

public class FizzBuzzerTest {
    private FizzBuzzer fizzBuzzer;
    private ArrayList<Integer> numbersDivisibleByFirstButNotSecondDivisor;
    private ArrayList<Integer> numbersDivisibleBySecondButNotFirstDivisor;
    private ArrayList<Integer> numbersDivisibleByBothDivisor;
    private ArrayList<Integer> numbersDivisibleByNeitherDivisor;

    @Before
    public void setup() {
        setupGivenNumbers(FIRST_DIVISOR, SECOND_DIVISOR);

        fizzBuzzer = FizzBuzzer.getInstance(FIRST_DIVISOR, SECOND_DIVISOR, FIRST_KEYWORD, SECOND_KEYWORD);
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
        int givenInput = givenRandomNumberDivisibleByBoth(FIRST_DIVISOR, SECOND_DIVISOR);

        String output = whenGetValueCalledWith(givenInput);

        thenOutputShouldMatchExpectedString(output, FIRST_KEYWORD + SECOND_KEYWORD);
    }

    @Test
    public void getValue_defaultFizzBuzzerGiven_ShouldUseDefaultDivisorAndKeywords() {
        givenDefaultFizzBuzzer();
        int givenInput = givenRandomNumberDivisibleByBoth(FIRST_DIVISOR_DEFAULT, SECOND_DIVISOR_DEFAULT);

        String output = whenGetValueCalledWith(givenInput);

        thenOutputShouldMatchExpectedString(output, FIRST_KEYWORD_DEFAULT + SECOND_KEYWORD_DEFAULT);
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
        if (i == SECOND_DIVISOR) {
            givenNumber = numbersDivisibleBySecondButNotFirstDivisor.get(0);
        }
        return givenNumber;
    }

    private int givenRandomNumberDivisibleByBoth(int firstDivisor, int secondDivisor) {
        int givenNumber = numbersDivisibleByFirstButNotSecondDivisor.get(0);
        return givenNumber * secondDivisor;
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

    private ArrayList<Integer> givenNumbersDivisibleByBoth(ArrayList<Integer> numbersDivisibleByFirst, ArrayList<Integer> numbersDivisibleBySecond) {
        int countOfNumbers = MAX_NUMBER/(numbersDivisibleByFirst.size() * numbersDivisibleBySecond.size());

        ArrayList<Integer> numbersDivisibleByBoth = new ArrayList<>(countOfNumbers);
        for (int aNumberDivisibleByFirst : numbersDivisibleByFirst) {
            if (numbersDivisibleBySecond.contains(aNumberDivisibleByFirst)) {
                numbersDivisibleByBoth.add(aNumberDivisibleByFirst);
            }
        }

        return numbersDivisibleByBoth;
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
            if (!numbersDivisibleByFirstButNotSecondDivisor.contains(i)
                    && !numbersDivisibleBySecondButNotFirstDivisor.contains(i)
                    && !numbersDivisibleByBothDivisor.contains(i)) {
                numbersInNeither.add(i);
            }
        }

        return numbersInNeither;
    }

    private void givenDefaultFizzBuzzer() {
        setupGivenNumbers(FIRST_DIVISOR_DEFAULT, SECOND_DIVISOR_DEFAULT);
        fizzBuzzer = FizzBuzzer.getInstance();
    }

    private int getSizeOfNumbersInNeither() {
        return MAX_NUMBER - (numbersDivisibleByFirstButNotSecondDivisor.size() + numbersDivisibleBySecondButNotFirstDivisor.size());
    }

    private void setupGivenNumbers(int firstDivisor, int secondDivisor) {
        ArrayList<Integer> numbersDivisibleByFirstDivisor = givenNumbersDivisibleBy(firstDivisor);
        ArrayList<Integer> numbersDivisibleBySecondDivisor = givenNumbersDivisibleBy(secondDivisor);

        numbersDivisibleByFirstButNotSecondDivisor = givenNumbersInFirstListButNotSecond(numbersDivisibleByFirstDivisor, numbersDivisibleBySecondDivisor);
        numbersDivisibleBySecondButNotFirstDivisor = givenNumbersInFirstListButNotSecond(numbersDivisibleBySecondDivisor, numbersDivisibleByFirstDivisor);
        numbersDivisibleByBothDivisor = givenNumbersDivisibleByBoth(numbersDivisibleByFirstDivisor, numbersDivisibleBySecondDivisor);
        numbersDivisibleByNeitherDivisor = givenNumbersInNeither();

        randomizeGivenNumbers();
    }

    private void randomizeGivenNumbers() {
        Collections.shuffle(numbersDivisibleByFirstButNotSecondDivisor);
        Collections.shuffle(numbersDivisibleBySecondButNotFirstDivisor);
        Collections.shuffle(numbersDivisibleByNeitherDivisor);
    }


    private static final int FIRST_DIVISOR_DEFAULT = 3;
    private static final int SECOND_DIVISOR_DEFAULT = 5;
    private static final int FIRST_DIVISOR = 4;
    private static final int SECOND_DIVISOR = 6;
    private static final int MAX_NUMBER = 100;
    private static final String FIRST_KEYWORD_DEFAULT = "Fizz";
    private static final String SECOND_KEYWORD_DEFAULT = "Buzz";
    private static final String FIRST_KEYWORD = "Bizz";
    private static final String SECOND_KEYWORD = "Fuzz";
}
