package core.selenium.driver;

import core.selenium.config.EnvironmentChrome;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chrome implements IDriver {

    private static final String DRIVER_PATH = EnvironmentChrome.getInstance().getDriverPath();

    /**
     * This method is used for configure Chrome browser.
     * @return a WebDriver
     */
    public WebDriver initDriver() {
        System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--disable-gpu", "--no-sandbox", "--window-size=1920,1200");
        return new ChromeDriver(options);
    }
}
