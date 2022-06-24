package com.fundraiseup.component;

import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Button {
    private Locator buttonLocator;

    public Button init(FrameLocator frameLocator, String locator) {
        buttonLocator = frameLocator.locator("//button[@data-qa='" + locator + "']");
        return this;
    }

    public void click() {
        buttonLocator.click();
    }

    public void checkLabel(String label) {
        assertThat(buttonLocator).hasText(label);
    }
}
