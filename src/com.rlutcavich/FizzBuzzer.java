package com.rlutcavich;

public class FizzBuzzer {
    private FizzBuzzer() {}

    public static FizzBuzzer getInstance() {
        return new FizzBuzzer();
    }

    public String getValue(int input) {
        return String.valueOf(input);
    }
}
