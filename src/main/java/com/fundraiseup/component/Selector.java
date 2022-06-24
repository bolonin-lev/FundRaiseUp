package com.fundraiseup.component;

import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Selector {
    private Locator selectorLocator;

    public Selector init(FrameLocator frameLocator, String locator) {
        selectorLocator = frameLocator.locator("//select[@data-qa='" + locator + "']");
        return this;
    }

    public void checkValue(String value) {
        assertThat(selectorLocator).containsText(value);
    }

    public void set(String value) {
        selectorLocator.selectOption(value);
    }
}
