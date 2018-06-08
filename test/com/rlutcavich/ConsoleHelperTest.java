package com.rlutcavich;

import com.rlutcavich.utils.ConsoleHelperFake;
import org.junit.Assert;
import org.junit.Test;

public class ConsoleHelperTest {

    private ConsoleHelperFake consoleHelperFake = ConsoleHelperFake.getInstance();

    private static final String HELLO_WORLD_TEXT = "Hello, World!";

    @Test
    public void displayMessage_TextGiven_ShouldOutputText() {
        String givenInput = HELLO_WORLD_TEXT;

        String output = whenMessageDisplayed(givenInput);

        thenOutputShouldMatchInput(givenInput, output);
    }

    private String whenMessageDisplayed(String givenInput) {
        consoleHelperFake.displayMessage(givenInput);
        return consoleHelperFake.getDisplayedMessage();
    }

    private void thenOutputShouldMatchInput(String givenInput, String output) {
        Assert.assertEquals(givenInput, output);
    }
}
