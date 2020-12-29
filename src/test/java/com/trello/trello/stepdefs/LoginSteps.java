package com.trello.trello.stepdefs;

import com.trello.trello.ui.PageTransporter;
import com.trello.trello.ui.pages.LoginAtlasianPage;
import core.selenium.WebDriverHelper;
import core.selenium.WebDriverManager;
import com.trello.trello.config.EnvironmentTrello;
import com.trello.trello.ui.pages.LoginPage;
import io.cucumber.java.After;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

/**
 * LoginSteps class.
 */
public class LoginSteps {

    private LoginPage login;
    private LoginAtlasianPage loginAtlasian;
    /**
     * Create a new login instance.
     */
    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        System.out.println("111++++* " + WebDriverHelper.getCurrentUrl());
        PageTransporter.navigateToPage("LOGIN");
        System.out.println("111++++* " + WebDriverHelper.getCurrentUrl());
        login = new LoginPage();
    }

    /**
     * Login in the two steps.
     */
    @When("I set username and password")
    public void iSetUsernameAndPassword() {
        System.out.println("2 ********** " + WebDriverHelper.getCurrentUrl());
        login.login();
        loginAtlasian = new LoginAtlasianPage();
        loginAtlasian.setPassword(EnvironmentTrello.getInstance().getPassword());
        loginAtlasian.clickLoginButton();
        login.waitLoadPage();
        System.out.println(" 22 ********** " + WebDriverHelper.getCurrentUrl());
    }

    /**
     * I set username and password.
     */
    @Given("I am logged with valid credentials")
    public void iAmLoggedWithValidCredentials() {
        PageTransporter.navigateToPage("LOGIN");
        login = new LoginPage();
        login.login();
        loginAtlasian = new LoginAtlasianPage();
        loginAtlasian.setPassword(EnvironmentTrello.getInstance().getPassword());
        loginAtlasian.clickLoginButton();
    }

    /**
     * Login in the first step.
     */
    @When("I set username and password with fields empty")
    public void iSetUsernameAndPasswordWithFieldsEmpty() {
        PageTransporter.navigateToPage("LOGIN");
        login = new LoginPage();
        login.login();
        loginAtlasian = new LoginAtlasianPage();
        loginAtlasian.setPassword("");
        loginAtlasian.clickLoginButton();
    }

    /**
     * Verify if the current url contains the parameter.
     * @param suffix
     */
    @Then("I should view the {string} suffix in the URL")
    public void iShouldViewTheSuffixInTheURL(final String suffix) {
        String actual = WebDriverHelper.getCurrentUrl();
        Assert.assertTrue(actual.contains(suffix));
    }

    /**
     * Closes WebDriverManager instance.
     */
    @After
    public void quit() {
        WebDriverManager.getInstance().quit();
    }
}
