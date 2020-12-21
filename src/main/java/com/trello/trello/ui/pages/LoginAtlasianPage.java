package com.trello.trello.ui.pages;

import core.selenium.WebDriverHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginAtlasian extends BasePage {

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-submit")
    private  WebElement loginSubmitBtn;

    public void setPassword(final String passw) {
        WebDriverWait webDriverWait = core.selenium.WebDriverManager.getInstance().getWebDriverWait();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(password));

        WebDriverHelper.setElement(this.password, passw);
        WebDriverHelper.clickElement(loginSubmitBtn);
    }
}
