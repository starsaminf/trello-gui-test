package com.trello.trello.ui;

import com.trello.trello.config.EnvironmentTrello;
import core.selenium.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    protected WebDriver webDrive;
    protected WebDriverWait webDriveWait;
    protected final String BASE_URL = EnvironmentTrello.getInstance().getBaseUrl();

    public BasePage() {
        this.webDrive = WebDriverManager.getInstance().getWebDrive();
        this.webDriveWait = WebDriverManager.getInstance().getWebDriverWait();
        PageFactory.initElements(this.webDrive, this);
    }

    protected void waitUntil(WebElement webElement) {
        webDriveWait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    /**
     * Method to go to specific url
     * @param endPoint
     */
    public void goToURL(final String endPoint) {
        String url = String.format("%s%s", BASE_URL, endPoint);
        this.webDrive.get(url);
    }
}
