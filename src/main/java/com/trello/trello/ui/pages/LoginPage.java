package com.trello.trello.ui.pages;

import com.trello.trello.config.EnvironmentTrello;
import core.selenium.WebDriverHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "user")
    private WebElement user;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login")
    private WebElement loginBtn;

    @FindBy(id = "trello-root")
    private  WebElement trelloRoot;

    /**
     * Constructor of the LoginPage.
     */
    public LoginPage() {
        WebDriverHelper.waitUntil(loginBtn);
    }

    /**
     * Sets username.
      * @param userName
     */
    private void setUser(final String userName) {
        WebDriverHelper.setElement(user, userName);
    }

    /**
     * Sets password.
     * @param passwd
     */
    public void setPassword(final String passwd) {
        WebDriverHelper.setElement(password, passwd);
    }

    /**
     * Method to login with username and password.
     */
    public void login() {
        String userName = EnvironmentTrello.getInstance().getUsername();
        String pass = EnvironmentTrello.getInstance().getPassword();
        WebDriverHelper.waitUntil(loginBtn);
        setUser(userName);
        setPassword(pass);
        WebDriverHelper.clickElement(loginBtn);
    }

    /**
     * Waits trelloRoot will be visible in DOM.
     */
    public void waitLoadPage() {
        WebDriverHelper.waitUntil(trelloRoot);
    }
}
