package core.selenium.driver;

import core.selenium.config.EnvironmentChrome;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Firefox implements IDriver {

    private static final String DRIVER_PATH = EnvironmentChrome.getInstance().getDriverPath();

    /**
     * This method is used for configure Firefox browser.
     * @return a WebDriver
     */
    public WebDriver initDriver() {
        System.setProperty("webdriver.gecko.driver", DRIVER_PATH);
        return new ChromeDriver();
    }
}
