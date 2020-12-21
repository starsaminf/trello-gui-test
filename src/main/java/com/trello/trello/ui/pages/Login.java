package com.trello.trello.ui.pages;

import com.trello.trello.config.EnvironmentTrello;
import core.selenium.WebDriverHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login extends BasePage {

    @FindBy(id = "user")
    private WebElement user;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login")
    private WebElement loginBtn;

    public Login() {

    }

    private void setUser(final String userName) {
        WebDriverHelper.setElement(user, userName);
    }

    public void setPassword(final String password) {
        WebDriverHelper.setElement(this.password, password);
    }

    public static void clickElement(final WebElement webElement) {
        WebDriverWait webDriverWait = core.selenium.WebDriverManager.getInstance().getWebDriverWait();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
        webElement.click();
    }

    public void login() {
        String user = EnvironmentTrello.getInstance().getUsername();
        String password = EnvironmentTrello.getInstance().getPassword();
        setUser(user);
        setPassword(password);
        waitUntil(loginBtn);
        clickElement(loginBtn);
    }

    public String getCurrentUrl() {
        return webDrive.getCurrentUrl();
    }
}
