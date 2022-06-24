package com.fundraiseup.page;

import com.fundraiseup.component.DivButton;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;


public class Main {
    private final String FRAME_LOCATOR = "//iframe[@title='Donate Button']";
    private final String DONATE_BUTTON_LOCATOR = "fun-element";
    private Page page;

    private DivButton button = new DivButton();

    public Main(Page page) {
        this.page = page;
    }

    @Step("Нажать кнопку 'Give Now'")
    public void donateButtonClick() {
        button.init(page.frameLocator(FRAME_LOCATOR), DONATE_BUTTON_LOCATOR).click();
    }

    @Step("Проверить надпись на кнопке: {label}")
    public void donationButtonCheckLabel(String label) {
        button.init(page.frameLocator(FRAME_LOCATOR), DONATE_BUTTON_LOCATOR).checkLabel(label);
    }
}
