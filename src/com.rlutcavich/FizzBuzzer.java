package com.rlutcavich;

public class FizzBuzzer {

    public static final String BUZZ = "BUZZ";

    private FizzBuzzer() {}

    public static FizzBuzzer getInstance() {
        return new FizzBuzzer();
    }

    public String getValue(int input) {
        String output = String.valueOf(input);
        if (input % 3 == 0) {
            output = FIZZ;
        } else if (input % 5 == 0) {
            output = BUZZ;
        }
        return output;
    }

    // Constants
    public static final String FIZZ = "FIZZ";
}
