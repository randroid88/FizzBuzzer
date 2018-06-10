package com.rlutcavich;

public class FizzBuzzer {

    private final int firstDivisor;
    private final int secondDivisor;
    private final String firstKeyword;
    private final String secondKeyword;

    private FizzBuzzer(int firstDivisor, int secondDivisor, String firstKeyword, String secondKeyword) {
        this.firstDivisor = firstDivisor;
        this.secondDivisor = secondDivisor;
        this.firstKeyword = firstKeyword;
        this.secondKeyword = secondKeyword;
    }

    public static FizzBuzzer getInstance() {
        return new FizzBuzzer(FIRST_DIVISOR, SECOND_DIVISOR, FIRST_KEYWORD, SECOND_KEYWORD);
    }

    public static FizzBuzzer getInstance(int firstDivisor, int secondDivisor, String firstKeyword, String secondKeyword) {
        return new FizzBuzzer(firstDivisor, secondDivisor, firstKeyword, secondKeyword);
    }

    public String getValue(int input) {
        String output = String.valueOf(input);

        if (input % firstDivisor == 0 && input % secondDivisor == 0) {
            output = firstKeyword + secondKeyword;
        } else if (input % firstDivisor == 0) {
            output = firstKeyword;
        } else if (input % secondDivisor == 0) {
            output = secondKeyword;
        }
        return output;
    }

    // Constants
    private static final int FIRST_DIVISOR = 3;
    private static final int SECOND_DIVISOR = 5;
    private static final String FIRST_KEYWORD = "Fizz";
    private static final String SECOND_KEYWORD = "Buzz";

}
