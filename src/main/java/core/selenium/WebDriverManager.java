package core.selenium;

import core.selenium.config.ReadDriverPropertiesJson;
import core.selenium.driver.DriverFactory;
import core.selenium.entities.DriverEntities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;

/**
 * This class providers basics methods for WebDriver.
 */
public final class WebDriverManager {

    private static WebDriverManager webDriverManager;
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    private WebDriverManager() {
        DriverEntities driver = ReadDriverPropertiesJson.getDriversProperties().get(CHROME.toString());

        long implicitTime = driver.getImplicitWaitingSeconds();
        long explicitTime = driver.getExplicitWaitingSeconds();

        webDriver = DriverFactory.getDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(implicitTime, TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(webDriver, explicitTime);
    }

    /**
     * Initializes a only instance of WebDriverManager.
     * @return a webDriverManager
     */
    public static WebDriverManager getInstance() {
        if (webDriverManager == null) {
            webDriverManager = new WebDriverManager();
        }
        return webDriverManager;
    }

    /**
     * Gets webDriver.
     * @return a webDriver
     */
    public WebDriver getWebDriver() {
        return webDriver;
    }

    /**
     * Gets webDriverWait.
     * @return webDriverWait.
     */
    public WebDriverWait getWebDriverWait() {
        return webDriverWait;
    }

    /**
     * Closes webDriver.
     */
    public void quit() {
        webDriver.quit();
        webDriverManager = null;
    }
}
