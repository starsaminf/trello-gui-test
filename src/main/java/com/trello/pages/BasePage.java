package com.trello.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    private WebDriver webDrive;
    private WebDriverWait webDriveWait;

    public BasePage(final WebDriver webDriver, final WebDriverWait webDriveWait) {
        this.webDrive = webDriver;
        this.webDriveWait = webDriveWait;
        PageFactory.initElements(this.webDrive, this);
    }
}
