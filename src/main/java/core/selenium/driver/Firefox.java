package core.selenium.driver;

import static io.github.bonigarcia.wdm.DriverManagerType.FIREFOX;
import core.selenium.config.ReadDriverPropertiesJson;
import core.selenium.entities.DriverEntities;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Firefox implements IDriver {


    /**
     * This method is used for configure Firefox browser.
     * @return a WebDriver
     */
    public WebDriver initDriver() {
        DriverEntities driver = ReadDriverPropertiesJson.getDriversProperties().get(FIREFOX.toString());
        ChromeDriverManager.getInstance(FIREFOX).version(driver.getVersion()).setup();
        return new FirefoxDriver();
    }
}
