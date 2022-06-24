package com.fundraiseup.page.form;

import com.fundraiseup.component.Button;
import com.fundraiseup.component.Checkbox;
import com.fundraiseup.page.DonationWidget;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ScreenPaymentMethod extends DonationWidget {
    private final String FORM_LOCATOR = "//*[@data-qa='active-screen-payment-method']";

    private final String COVER_FEE_CHECKBOX = "cover-fee-checkbox";
    private final String CREDIT_CARD_BUTTON = "cc-button";

    private Button button = new Button();
    private Checkbox checkbox = new Checkbox();

    public ScreenPaymentMethod(Page page) {
        this.page = page;
        frameLocator = page.frameLocator(FRAME_LOCATOR);
    }

    @Step("Ждем загрузку экрана 'Payment method'")
    public void waitLoad() {
        assertThat(frameLocator.locator(FORM_LOCATOR)).isEnabled();
    }

    @Step("Проверить напись на кнопке: {label}")
    public void checkCCButtonLabel(String label) {
        button.init(frameLocator, CREDIT_CARD_BUTTON).checkLabel(label);
    }

    @Step("Нажать кнопку 'Credit card'")
    public void CCButtonClick() {
        button.init(frameLocator, CREDIT_CARD_BUTTON).click();
    }

    @Step("Снять чекбокс")
    public void unsetCoverFeeCheckbox() {
        checkbox.init(frameLocator, COVER_FEE_CHECKBOX).unset();
    }

    @Step("Проверить напись на кнопке чекбоксе: {label}")
    public void checkCoverFeeCheckboxLabel(String label) {
        checkbox.init(frameLocator, COVER_FEE_CHECKBOX).checkLabel(label);
    }
}
