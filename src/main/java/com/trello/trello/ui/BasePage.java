package com.trello.trello.pages;

import core.selenium.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    protected WebDriver webDrive;
    protected WebDriverWait webDriveWait;

    public BasePage() {
        this.webDrive = WebDriverManager.getInstance().getWebDrive();
        this.webDriveWait = WebDriverManager.getInstance().getWebDriverWait();
        PageFactory.initElements(this.webDrive, this);
        waitUntil();
    }

    protected abstract void waitUntil();
}
