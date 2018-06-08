package com.rlutcavich;

import com.rlutcavich.utils.ConsoleHelper;
import com.rlutcavich.utils.ConsoleHelperImpl;

public class Main {

    public static void main(String[] args) {
        ConsoleHelper consoleHelper = ConsoleHelperImpl.getInstance();
        consoleHelper.displayMessage("FizzBuzzer Coming Soon");
    }
}
