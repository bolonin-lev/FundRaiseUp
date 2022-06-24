package com.fundraiseup.enums;

public enum Currency {
    USD("USD"),
    RUB("RUB");
    private String title;

    Currency(String title) {
        this.title = title;
    }

    public String toString() {
        return title;
    }
}
