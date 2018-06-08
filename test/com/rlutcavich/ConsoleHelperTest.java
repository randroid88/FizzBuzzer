package com.rlutcavich;

import com.rlutcavich.utils.ConsoleHelperFake;
import org.junit.Assert;
import org.junit.Test;

public class ConsoleHelperTest {

    private ConsoleHelperFake consoleHelperFake = ConsoleHelperFake.getInstance();

    private static final String HELLO_WORLD_TEXT = "Hello, World!";
    private static final String FAKE_USER_RESPONSE = "Fake user input";

    @Test
    public void displayMessage_MessageGiven_ShouldOutputMessage() {
        String givenMessage = HELLO_WORLD_TEXT;

        String output = whenMessageDisplayed(givenMessage);

        thenMessageShouldMatchOutput(givenMessage, output);
    }

    @Test
    public void getStringResponse_FakeResponseGiven_ShouldReturnResponse() {
        String givenFakeResponse = FAKE_USER_RESPONSE;

        String returnedResponse = whenGetStringResponseWith(givenFakeResponse);

        thenFakeResponseShouldMatchReturnedResponse(givenFakeResponse, returnedResponse);
    }

    @Test
    public void promptAndGetResponse_MessageAndResponseGiven_ShouldOutputMessageAndReturnResponse() {
        String givenMessage = HELLO_WORLD_TEXT;
        String givenFakeResponse = FAKE_USER_RESPONSE;

        String returnedResponse = whenDisplayMessageAndGetResponseWith(givenMessage, givenFakeResponse);

        thenMessageShouldMatchOutputAndFakeResponseShouldMatchReturnedResponse(givenMessage, getMessageOutputted(), givenFakeResponse, returnedResponse);
    }

    private String whenMessageDisplayed(String givenInput) {
        consoleHelperFake.displayMessage(givenInput);
        return getMessageOutputted();
    }

    private String whenGetStringResponseWith(String givenFakeResponse) {
        consoleHelperFake.setResponse(givenFakeResponse);
        return consoleHelperFake.getStringResponse();
    }

    private String whenDisplayMessageAndGetResponseWith(String givenInput, String givenFakeResponse) {
        consoleHelperFake.setResponse(givenFakeResponse);
        return consoleHelperFake.displayMessageAndGetResponse(givenInput);
    }

    private void thenMessageShouldMatchOutput(String message, String output) {
        Assert.assertEquals(message, output);
    }

    private void thenFakeResponseShouldMatchReturnedResponse(String givenFakeResponse, String returnedResponse) {
        Assert.assertEquals(givenFakeResponse, returnedResponse);
    }

    private void thenMessageShouldMatchOutputAndFakeResponseShouldMatchReturnedResponse(String givenMessage, String output, String givenFakeResponse, String returnedResponse) {
        thenMessageShouldMatchOutput(givenMessage, output);
        thenFakeResponseShouldMatchReturnedResponse(givenFakeResponse, returnedResponse);
    }

    private String getMessageOutputted() {
        return consoleHelperFake.getDisplayedMessage();
    }

}
