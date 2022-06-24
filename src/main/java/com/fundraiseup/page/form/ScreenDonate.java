package com.fundraiseup.page.form;

import com.fundraiseup.component.Button;
import com.fundraiseup.component.Input;
import com.fundraiseup.component.Selector;
import com.fundraiseup.enums.Currency;
import com.fundraiseup.page.DonationWidget;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ScreenDonate extends DonationWidget {
    private final String FORM_LOCATOR = "//*[@data-qa='active-screen-donate-form']";
    private final String GIVE_MONTHLY_BUTTON = "give-monthly";

    private final String AMOUNT_INPUT = "amount";
    private final String CURRENCY_SELECTOR = "currency-selector";
    private final String DONATE_BUTTON = "donate-button";

    private Button button = new Button();
    private Selector selector = new Selector();
    private Input input = new Input();


    public ScreenDonate(Page page) {
        this.page = page;
        frameLocator = page.frameLocator(FRAME_LOCATOR);
    }

    @Step("Ждем загрузку экрана 'Donate'")
    public void waitLoad() {
        assertThat(frameLocator.locator(FORM_LOCATOR)).isEnabled();
    }

    @Step("Нажать на 'Monthly'")
    public void monthlyButtonClick() {
        button.init(frameLocator, GIVE_MONTHLY_BUTTON).click();
    }

    @Step("Проверить надпись на кнопке: {label}")
    public void checkMonthlyButtonLabel(String label) {
        button.init(frameLocator, GIVE_MONTHLY_BUTTON).checkLabel(label);
    }

    @Step("Указать валюту: {currency}")
    public void setCurrency(Currency currency) {
        selector.init(frameLocator, CURRENCY_SELECTOR).set(currency.toString());
    }

    @Step("Проверить валюту: {currency}")
    public void checkCurrency(Currency currency) {
        selector.init(frameLocator, CURRENCY_SELECTOR).checkValue(currency.toString());
    }

    @Step("Указать сумму: {value}")
    public void setAmount(String value) {
        input.init(frameLocator, AMOUNT_INPUT).set(value);
    }

    @Step("Проверить сумму: {value}")
    public void checkAmount(String value) {
        input.init(frameLocator, AMOUNT_INPUT).checkValue(value);
    }

    @Step("Нажать Continue")
    public void donateButtonClick() {
        button.init(frameLocator, DONATE_BUTTON).click();
    }

    @Step("Проверить напись на кнопке: {label}")
    public void checkDonateButtonLabel(String label) {
        button.init(frameLocator, DONATE_BUTTON).checkLabel(label);
    }


}
