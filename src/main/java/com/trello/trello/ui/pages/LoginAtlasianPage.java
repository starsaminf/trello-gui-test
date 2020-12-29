package com.trello.trello.ui.pages;

import core.selenium.WebDriverHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * LoginAtlasianPage Class.
 */
public class LoginAtlasianPage extends BasePage {

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-submit")
    private  WebElement loginSubmitBtn;

    /**
     * Constructor of LoginAtlasianPage.
     */
    public LoginAtlasianPage() {
        WebDriverHelper.waitUntil(loginSubmitBtn);
    }

    /**
     * Sets Password.
     * @param pass
     */
    public void setPassword(final String pass) {
        WebDriverHelper.setElement(password, pass);
    }

    /**
     * Clicks a submit button.
     */
    public void clickLoginButton() {
        WebDriverHelper.clickElement(loginSubmitBtn);
    }
}
