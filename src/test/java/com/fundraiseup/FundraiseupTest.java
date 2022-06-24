package com.fundraiseup;

import com.fundraiseup.enums.Currency;
import com.fundraiseup.page.DonationWidget;
import com.fundraiseup.page.Main;
import com.fundraiseup.page.form.ScreenCreditCard;
import com.fundraiseup.page.form.ScreenDonate;
import com.fundraiseup.page.form.ScreenPaymentMethod;
import com.fundraiseup.page.form.ScreenPrivacy;
import com.fundraiseup.vo.CreditCardData;
import com.fundraiseup.vo.DonorData;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FundraiseupTest extends BaseTest{
    private Main mainPage;
    private DonationWidget donationWidget;
    private ScreenDonate screenDonate;
    private ScreenPaymentMethod screenPaymentMethod;
    private ScreenCreditCard screenCreditCard;
    private ScreenPrivacy screenPrivacy;

    private String testURL;
    private DonorData donor;
    private CreditCardData creditCard;

    private void prepareData() {
        testURL = "https://data.fundraiseup.com/qa-test-7R58U3/";
        donor = new DonorData("FName", "LName", "test@mail.ru");
        creditCard = new CreditCardData("4242 4242 4242 4242", "04 / 24", "000");
    }

    @Epic("Fundraiseup")
    @Feature("Форма приема пожертвований")
    @DisplayName("Тест формы приема пожертвований")
    @Test
    public void test() {
        prepareData();

        page.navigate(testURL);
        mainPage = new Main(page);
        mainPage.donationButtonCheckLabel("Give Now");
        mainPage.donateButtonClick();

        donationWidget = new DonationWidget(page);
        screenDonate = new ScreenDonate(page);

        screenDonate.waitLoad();

        screenDonate.checkMonthlyButtonLabel("Monthly");
        screenDonate.monthlyButtonClick();
        screenDonate.setCurrency(Currency.USD);
        screenDonate.checkCurrency(Currency.USD);
        screenDonate.setAmount("100");
        screenDonate.checkAmount("100");
        screenDonate.checkDonateButtonLabel("Donate monthly");
        screenDonate.donateButtonClick();

        screenPaymentMethod = new ScreenPaymentMethod(page);
        screenPaymentMethod.waitLoad();
        screenPaymentMethod.checkCoverFeeCheckboxLabel("Cover transaction costs");
        screenPaymentMethod.unsetCoverFeeCheckbox();

        screenPaymentMethod.checkCCButtonLabel("Credit card");
        screenPaymentMethod.CCButtonClick();

        screenCreditCard = new ScreenCreditCard(page);
        screenCreditCard.waitLoad();
        screenCreditCard.setCreditCard(creditCard.getNumber());
        screenCreditCard.checkCreditCard(creditCard.getNumber());
        screenCreditCard.setExpireDate(creditCard.getExpireDate());
        screenCreditCard.checkExpireDate(creditCard.getExpireDate());
        screenCreditCard.setCardCVV(creditCard.getCvv());
        screenCreditCard.checkCardCVV(creditCard.getCvv());
        screenCreditCard.ContinueButtonClick();

        screenPrivacy = new ScreenPrivacy(page);
        screenPrivacy.waitLoad();
        screenPrivacy.setFirsName(donor.getFirstName());
        screenPrivacy.checkFirsName(donor.getFirstName());
        screenPrivacy.setLastName(donor.getLastName());
        screenPrivacy.checkLastName(donor.getLastName());
        screenPrivacy.setEMail(donor.getEmail());
        screenPrivacy.checkEMail(donor.getEmail());
        screenPrivacy.checkContinueButtonLabel("Donate $100/month");
        screenPrivacy.ContinueButtonClick();

        screenCreditCard.waitLoad();
        screenCreditCard.checkCardError("This could be due to any of several reasons: incorrect security code, insufficient funds, card limit, card disabled, etc.");

    }
}
