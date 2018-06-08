package com.rlutcavich.utils;

public class ConsoleHelperFake extends ConsoleHelper {

    private String displayedMessage;
    private String response;

    @Override
    public void displayMessage(String message) {
        this.displayedMessage = message;
    }

    @Override
    public String getStringResponse() {
        return response;
    }

    @Override
    public String displayMessageAndGetResponse(String message) {
        displayMessage(message);
        return getStringResponse();
    }

    public String getDisplayedMessage() {
        return displayedMessage;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    private ConsoleHelperFake() {}

    public static ConsoleHelperFake getInstance() {
        return new ConsoleHelperFake();
    }

}