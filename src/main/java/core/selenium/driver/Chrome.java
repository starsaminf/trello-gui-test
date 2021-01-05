package core.selenium.driver;

import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;

import core.selenium.config.ReadDriverPropertiesJson;
import core.selenium.entities.DriverEntities;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chrome implements IDriver {


    /**
     * This method is used for configure Chrome browser.
     * @return a WebDriver
     */
    public WebDriver initDriver() {
        DriverEntities driver = ReadDriverPropertiesJson.getDriversProperties().get(CHROME.toString());
        ChromeDriverManager.getInstance(CHROME).version(driver.getVersion()).setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments(driver.getFlags());
        return new ChromeDriver(options);
    }
}
