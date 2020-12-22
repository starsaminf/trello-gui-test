package core.selenium;

import core.selenium.config.EnvironmentChrome;
import core.selenium.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * This class providers basics methods for WebDriver.
 */
public final class WebDriverManager {

    private static WebDriverManager webDriverManager;
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    private WebDriverManager() {
        long implicitTime = EnvironmentChrome.getInstance().getImplicitTime();
        long explicitTime = EnvironmentChrome.getInstance().getExplicitTime();

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
