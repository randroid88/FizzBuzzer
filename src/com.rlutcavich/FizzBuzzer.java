package com.rlutcavich;

public class FizzBuzzer {

    private final String firstKeyword;
    private final String secondKeyword;

    private FizzBuzzer(String firstKeyword, String secondKeyword) {
        this.firstKeyword = firstKeyword;
        this.secondKeyword = secondKeyword;
    }

    public static FizzBuzzer getInstance() {
        return new FizzBuzzer(FIRST_KEYWORD, SECOND_KEYWORD);
    }

    public static FizzBuzzer getInstance(String firstKeyword, String secondKeyword) {
        return new FizzBuzzer(firstKeyword, secondKeyword);
    }

    public String getValue(int input) {
        String output = String.valueOf(input);

        if (input % 3 == 0 && input % 5 == 0) {
            output = firstKeyword + secondKeyword;
        } else if (input % 3 == 0) {
            output = firstKeyword;
        } else if (input % 5 == 0) {
            output = secondKeyword;
        }
        return output;
    }

    // Constants
    private static final String FIRST_KEYWORD = "FIZZ";
    private static final String SECOND_KEYWORD = "BUZZ";
}
