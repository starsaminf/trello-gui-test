package com.trello.stepdefs;

import com.trello.config.Environment;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class Stepdefs {

    private WebDriver webDriver;
    private WebDriverWait wait;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", Environment.getInstance().getDriveChromePath());
        webDriver = new ChromeDriver();
        //webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(webDriver, 15);

    }

    @Given("I am on the login page {string}")
    public void iAmOnTheLoginPage(final String baseURl) {
        webDriver.get(baseURl);
    }

    @After
    public void end() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

    @When("I set username and password")
    public void iSetUsernameAndPassword() {
        WebElement userName = webDriver.findElement(By.id("user"));
        userName.sendKeys(Environment.getInstance().getUsername());
        userName.click();

        webDriver.findElement(By.id("login")).click();

        WebElement password = webDriver.findElement(By.id("password"));
        password.sendKeys(Environment.getInstance().getPassword());

        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("password")));
        element.click();

        password = webDriver.findElement(By.id("password"));
        password.sendKeys(Environment.getInstance().getPassword());

        element = wait.until(ExpectedConditions.elementToBeClickable(By.id("login-submit")));
        element.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("trello-root")));
    }

    @Then("I should view the {string} suffix in the URL")
    public void iShouldViewTheSuffixInTheURL(final String suffix) {
        String actual = webDriver.getCurrentUrl();
        Assert.assertTrue(actual.contains(suffix));
    }
}
