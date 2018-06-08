package com.rlutcavich;

public class FizzBuzzer {
    private FizzBuzzer() {}

    public static FizzBuzzer getInstance() {
        return new FizzBuzzer();
    }

    public String getValue(int input) {
        String output = String.valueOf(input);
        if (input % 3 == 0) {
            output = FIZZ;
        }
        return output;
    }

    // Constants
    public static final String FIZZ = "FIZZ";
}
