package com.rlutcavich;

public class FizzBuzzer {


    private FizzBuzzer() {}

    public static FizzBuzzer getInstance() {
        return new FizzBuzzer();
    }

    public String getValue(int input) {
        String output = String.valueOf(input);

        if (input % 3 == 0 && input % 5 == 0) {
            output = FIZZBUZZ;
        } else if (input % 3 == 0) {
            output = FIZZ;
        } else if (input % 5 == 0) {
            output = BUZZ;
        }
        return output;
    }

    // Constants
    private static final String FIZZ = "FIZZ";
    private static final String BUZZ = "BUZZ";
    private static final String FIZZBUZZ = "FIZZBUZZ";
}
