package com.fundraiseup.page.form;

import com.fundraiseup.component.Button;
import com.fundraiseup.component.Input;
import com.fundraiseup.page.DonationWidget;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ScreenPrivacy extends DonationWidget {
    private final String FORM_LOCATOR = "//*[@data-qa='active-screen-privacy']";

    private final String FIRST_NAME = "personal-first-name";
    private final String LAST_NAME = "personal-last-name";
    private final String EMAIL = "personal-email";
    private final String CONTINUE = "privacy-continue";

    private Input input = new Input();
    private Button button = new Button();

    public ScreenPrivacy(Page page) {
        this.page = page;
        frameLocator = page.frameLocator(FRAME_LOCATOR);
    }

    @Step("Ждем загрузку экрана 'Privacy'")
    public void waitLoad() {
        assertThat(frameLocator.locator(FORM_LOCATOR)).isEnabled();
    }

    @Step("Указать FirsName: {value}")
    public void setFirsName(String value) {
        input.init(frameLocator, FIRST_NAME).set(value);
    }

    @Step("Проверить FirsName: {value}")
    public void checkFirsName(String value) {
        input.init(frameLocator, FIRST_NAME).checkValue(value);
    }

    @Step("Указать LastName: {value}")
    public void setLastName(String value) {
        input.init(frameLocator, LAST_NAME).set(value);
    }

    @Step("Проверить LastName: {value}")
    public void checkLastName(String value) {
        input.init(frameLocator, LAST_NAME).checkValue(value);
    }

    @Step("Указать Email: {value}")
    public void setEMail(String value) {
        input.init(frameLocator, EMAIL).set(value);
    }

    @Step("Проверить Email: {value}")
    public void checkEMail(String value) {
        input.init(frameLocator, EMAIL).checkValue(value);
    }

    @Step("Нажать кнопку 'Continue'")
    public void ContinueButtonClick() {
        button.init(frameLocator, CONTINUE).click();
    }

    @Step("Проверить надпись на кнопке: {label}")
    public void checkContinueButtonLabel(String label) {
        button.init(frameLocator, CONTINUE).checkLabel(label);
    }
}
