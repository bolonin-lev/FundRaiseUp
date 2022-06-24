package com.fundraiseup.vo;

public class CreditCardData {
    private String number;
    private String expireDate;
    private String cvv;

    public CreditCardData(String number, String expireDate, String cvv) {
        this.number = number;
        this.expireDate = expireDate;
        this.cvv = cvv;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
}
