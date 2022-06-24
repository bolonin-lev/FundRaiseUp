package com.fundraiseup.component;

import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class DivInput {
    private Locator divInputLocator;

    public DivInput init(FrameLocator frameLocator, String locator, String inputName) {
        divInputLocator = frameLocator.frameLocator("//div[@qa='" + locator + "']//iframe").locator("//input[@name='"+inputName+"']");
        return this;
    }

    public void checkValue(String value) {
        assertThat(divInputLocator).hasValue(value);
    }

    public void set(String value) {
        divInputLocator.fill(value);
    }
}
