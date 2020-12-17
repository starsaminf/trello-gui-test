package core.selenium;

import core.selenium.config.EnvironmentChrome;
import core.selenium.driver.Chrome;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * This class providers basics methods for WebDriver
 */
public final class WebDriverManager {

    private static WebDriverManager webDriverManager;
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    private WebDriverManager() {
        webDriver = new Chrome().initDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(EnvironmentChrome.getInstance().getImplicitTime(),TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(webDriver, EnvironmentChrome.getInstance().getExplicitTime());
    }

    /**
     * Initializes a only instance of WebDriverManager
     */
    public static WebDriverManager getInstance() {
        if(webDriverManager == null) {
            webDriverManager = new WebDriverManager();
        }
        return webDriverManager;
    }

    /**
     * Gets webDriver
     * @return
     */
    public WebDriver getWebDrive() {
        return webDriver;
    }

    /**
     * Gets
     * @return webDriverWait
     */
    public WebDriverWait getWebDriverWait() {
        return webDriverWait;
    }

    /**
     * Closes webDriver
     */
    public void quit() {
        webDriver.quit();
        webDriverManager = null;
    }
}
