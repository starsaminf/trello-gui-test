package core.selenium.driver;

import org.openqa.selenium.WebDriver;

/**
 * iDriver interface.
 */
public interface IDriver {
    /**
     * This method defines the behavior for browser.
     *
     * @return a iDriver
     */
    WebDriver initDriver();
}
