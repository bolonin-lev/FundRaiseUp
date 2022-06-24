package com.fundraiseup.component;

import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Input {
    private Locator inputLocator;

    public Input init(FrameLocator frameLocator, String locator) {
        inputLocator = frameLocator.locator("//input[@data-qa='" + locator + "']");
        return this;
    }

    public void checkValue(String value) {
        assertThat(inputLocator).hasValue(value);
    }

    public void set(String value) {
        inputLocator.focus();
        inputLocator.fill(value);
    }
}
