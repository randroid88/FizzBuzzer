package com.rlutcavich.utils;

public class ConsoleHelperFake extends ConsoleHelper {

    private String displayedMessage;

    @Override
    public void displayMessage(String input) {
        this.displayedMessage = input;
    }

    public String getDisplayedMessage() {
        return displayedMessage;
    }

    private ConsoleHelperFake() {}

    public static ConsoleHelperFake getInstance() {
        return new ConsoleHelperFake();
    }

}