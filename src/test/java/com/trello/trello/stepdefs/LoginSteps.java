package com.trello.trello.stepdefs;

import com.trello.trello.constans.Constant;
import com.trello.trello.ui.PageTransporter;
import com.trello.trello.ui.pages.LoginAtlasian;
import core.selenium.WebDriverManager;
import com.trello.trello.config.EnvironmentTrello;
import com.trello.trello.ui.pages.Login;
import io.cucumber.java.Before;
import io.cucumber.java.After;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.net.MalformedURLException;

public class LoginSteps {

    private static final String EMPTY = "";
    private Login login;

    @Before
    public void setup() {
        login = new Login();
    }

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        try {
            PageTransporter.navigateToPage("LOGIN");
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new NullPointerException("This url is not valid :" + e.getMessage());
        }
    }

    @When("I set username and password")
    public void iSetUsernameAndPassword() {
        login.login();
        LoginAtlasian loginAtlasian = new LoginAtlasian();
        loginAtlasian.setPassword(EnvironmentTrello.getInstance().getPassword());
    }

    @Then("I should view the {string} suffix in the URL")
    public void iShouldViewTheSuffixInTheURL(final String suffix) {
        String actual = login.getCurrentUrl();
        Assert.assertTrue(actual.contains(suffix));
    }

    @When("I set username and password with fields empty")
    public void iSetUsernameAndPasswordWithFieldsEmpty() {
        login.login();
    }

    @Given("I am logged with valid credentials")
    public void iAmLoggedWithValidCredentials() {
        try {
            PageTransporter.navigateToPage(Constant.getLoginPageURL());
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new NullPointerException("This url is not valid :" + e.getMessage());
        }
        login.login();
        LoginAtlasian loginAtlasian = new LoginAtlasian();
        loginAtlasian.setPassword(EnvironmentTrello.getInstance().getPassword());
    }

    @After
    public void quit() {
        WebDriverManager.getInstance().quit();
    }
}
