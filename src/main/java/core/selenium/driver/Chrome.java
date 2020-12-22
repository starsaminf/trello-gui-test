package core.selenium.driver;

import core.selenium.config.EnvironmentChrome;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chrome implements IDriver {

    private static final String DRIVER_PATH = EnvironmentChrome.getInstance().getDriverPath();

    /**
     * This method is used for configure Chrome browser.
     * @return a WebDriver
     */
    public WebDriver initDriver() {
        System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
        return new ChromeDriver();
    }
}
