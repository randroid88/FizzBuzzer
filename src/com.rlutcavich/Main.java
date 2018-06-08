package com.rlutcavich;

import com.rlutcavich.utils.ConsoleHelper;
import com.rlutcavich.utils.ConsoleHelperImpl;

public class Main {

    public static void main(String[] args) {
        showIntroMessage();

        int count = promptUserForCount();

        runFizzBuzzerFrom1To(count);
    }

    private static void showIntroMessage() {
        consoleHelper.displayMessage(FIZZBUZZ_DESCRIPTION);
    }

    private static int promptUserForCount() {
        String response = consoleHelper.displayMessageAndGetResponse(COUNT_PROMPT_MESSAGE);

        int count = 0;
        try {
            count = Integer.valueOf(response);
        } catch (NumberFormatException e) {
            consoleHelper.displayMessage(ERROR_MESSAGE_ENTER_NUMBERS_ONLY);
        }
        return count;
    }

    private static void runFizzBuzzerFrom1To(int count) {
        FizzBuzzer fizzBuzzer = FizzBuzzer.getInstance();
        for (int i = 1; i <= count; i++) {
            consoleHelper.displayMessage(fizzBuzzer.getValue(i));
        }
    }

    // Constants and Fields
    private static final String FIZZBUZZ_DESCRIPTION = "A program that prints the numbers from 1 to X. \nBut for multiples of three, \"FIZZ\" is printed instead of the number. \nFor the multiples of five, \"BUZZ\" is printed instead. \nFor numbers which are multiples of both three and five, \"FIZZBUZZ\" is printed.\n";
    private static final String COUNT_PROMPT_MESSAGE = "How high should the FizzBuzzer go? From 1 to: ";
    private static final String ERROR_MESSAGE_ENTER_NUMBERS_ONLY = "Enter numbers only.";

    private static ConsoleHelper consoleHelper = ConsoleHelperImpl.getInstance();
}
