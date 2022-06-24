package com.fundraiseup.component;

import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Checkbox {
    Locator checkboxLocator;

    public Checkbox init(FrameLocator frameLocator, String locator) {
        checkboxLocator = frameLocator.locator("//*[@data-qa='" + locator + "']");
        return this;
    }

    public void set() {
        assertThat(checkboxLocator).not().isChecked();
        checkboxLocator.check();
    }

    public void unset() {
        assertThat(checkboxLocator).isChecked();
        checkboxLocator.uncheck();
    }

    public void checkLabel(String label) {
        assertThat(checkboxLocator).hasText(label);
    }
}
