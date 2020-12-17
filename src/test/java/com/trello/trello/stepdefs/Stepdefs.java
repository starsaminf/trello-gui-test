package com.trello.stepdefs;

import com.trello.core.WebDriverManager;
import com.trello.core.config.drivers.Environment;
import com.trello.trello.config.EnvironmentTrello;
import com.trello.trello.pages.Login;
import io.cucumber.java.Before;
import io.cucumber.java.After;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Stepdefs {

    private Login login;

    @Before
    public void setup() {
        login = new Login();
    }

    @Given("I am on the login page {string}")
    public void iAmOnTheLoginPage(final String baseURl) {
       login.setBaseURL(baseURl);
    }

    @When("I set username and password")
    public void iSetUsernameAndPassword() {
        String user = EnvironmentTrello.getInstance().getUsername();
        String password = EnvironmentTrello.getInstance().getPassword();
        login.login(user, password);
    }

    @Then("I should view the {string} suffix in the URL")
    public void iShouldViewTheSuffixInTheURL(final String suffix) {
        String actual = login.getCurrentUrl();
        Assert.assertTrue(actual.contains(suffix));
    }

    @After
    public void quit() {
        WebDriverManager.getInstance().quit();
    }

}
