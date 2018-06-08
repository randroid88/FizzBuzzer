package com.rlutcavich.utils;

import java.util.Scanner;

public class ConsoleHelperImpl extends ConsoleHelper {

    private static Scanner scanner;

    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

    @Override
    public String getStringResponse() {
        return scanner.nextLine();
    }

    @Override
    public String displayMessageAndGetResponse(String message) {
        displayMessage(message);
        return getStringResponse();
    }

    private ConsoleHelperImpl() {}

    public static ConsoleHelper getInstance() {
        scanner = new Scanner(System.in);
        return new ConsoleHelperImpl();
    }
}
