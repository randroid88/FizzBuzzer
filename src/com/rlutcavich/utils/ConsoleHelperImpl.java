package com.rlutcavich.utils;

public class ConsoleHelperImpl extends ConsoleHelper {

    @Override
    public void displayMessage(String input) {
        System.out.print(input);
    }

    private ConsoleHelperImpl() {}

    public static ConsoleHelper getInstance() {
        return new ConsoleHelperImpl();
    }
}
