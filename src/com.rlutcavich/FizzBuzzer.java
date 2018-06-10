package com.rlutcavich;

public class FizzBuzzer {
    
    private FizzBuzzer() {}

    public static FizzBuzzer getInstance() {
        return new FizzBuzzer();
    }

    public String getValue(int input) {
        String output = String.valueOf(input);

        if (input % 3 == 0 && input % 5 == 0) {
            output = FIRST_KEYWORD + SECOND_KEYWORD;
        } else if (input % 3 == 0) {
            output = FIRST_KEYWORD;
        } else if (input % 5 == 0) {
            output = SECOND_KEYWORD;
        }
        return output;
    }

    // Constants
    private static final String FIRST_KEYWORD = "FIZZ";
    private static final String SECOND_KEYWORD = "BUZZ";
}
