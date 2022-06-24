package com.fundraiseup.page.form;

import com.fundraiseup.component.Button;
import com.fundraiseup.component.DivInput;
import com.fundraiseup.page.DonationWidget;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ScreenCreditCard extends DonationWidget {
    private final String FORM_LOCATOR = "//*[@data-qa='active-screen-credit-card']";

    private final String CREDIT_CARD = "card-number";
    private final String CREDIT_CARD_NAME = "cardnumber";
    private final String EXPIRE_DATE = "expire-date";
    private final String EXPIRE_DATE_NAME = "exp-date";
    private final String CARD_CVV = "card-cvv";
    private final String CARD_CVV_NAME = "cvc";

    private final String ERROR = "//*[@data-qa='card-continue-error-message']";

    private final String CONTINUE = "card-continue";

    DivInput divInput = new DivInput();
    Button button = new Button();

    public ScreenCreditCard(Page page) {
        this.page = page;
        frameLocator = page.frameLocator(FRAME_LOCATOR);
    }

    @Step("Ждем загрузку экрана 'Credit card'")
    public void waitLoad() {
        assertThat(frameLocator.locator(FORM_LOCATOR)).isEnabled();
    }

    @Step("Указать номер кредитной карты: {value}")
    public void setCreditCard(String value) {
        divInput.init(frameLocator, CREDIT_CARD, CREDIT_CARD_NAME).set(value);
    }

    @Step("Проверить номер кредитной карты: {value}")
    public void checkCreditCard(String value) {
        divInput.init(frameLocator, CREDIT_CARD, CREDIT_CARD_NAME).checkValue(value);
    }

    @Step("Указать срок действия: {value}")
    public void setExpireDate(String value) {
        divInput.init(frameLocator, EXPIRE_DATE, EXPIRE_DATE_NAME).set(value);
    }

    @Step("Проверить срок действия: {value}")
    public void checkExpireDate(String value) {
        divInput.init(frameLocator, EXPIRE_DATE, EXPIRE_DATE_NAME).checkValue(value);
    }

    @Step("Указать CVV: {value}")
    public void setCardCVV(String value) {
        divInput.init(frameLocator, CARD_CVV, CARD_CVV_NAME).set(value);
    }

    @Step("Проверить CVV: {value}")
    public void checkCardCVV(String value) {
        divInput.init(frameLocator, CARD_CVV, CARD_CVV_NAME).checkValue(value);
    }

    @Step("Продолжить")
    public void ContinueButtonClick() {
        button.init(frameLocator, CONTINUE).click();
    }

    @Step("Проверить надпись на кнопке: {label}")
    public void checkContinueButtonLabel(String label) {
        button.init(frameLocator, CONTINUE).checkLabel(label);
    }

    @Step("Проверить ошибку карты: {value}")
    public void checkCardError(String value) {
        assertThat(frameLocator.locator(ERROR)).hasText(value);
    }
}
