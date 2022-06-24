package com.fundraiseup.page;

import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;

public class DonationWidget {
    protected final String FRAME_LOCATOR = "//iframe[@title='Donation Widget']";

    protected Page page;
    protected FrameLocator frameLocator;

    public DonationWidget() { }

    public DonationWidget(Page page) {
        this.page = page;
        frameLocator = page.frameLocator(FRAME_LOCATOR);
    }
}
