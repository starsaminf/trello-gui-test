package core.selenium.driver;

import core.selenium.config.Environment;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public final class DriverFactory {
    private static final String FIREFOX = "firefox";
    private static final String CHROME = "chrome";

    /**
     * Constructor.
     */
    private DriverFactory() {
    }

    /**
     * Gets the correct instance of IDriver according the name given by parameter.
     * @return The instance of the web driver.
     */
    public static WebDriver getDriver() {
        Map<String, IDriver> strategyBrowser = new HashMap<>();
        strategyBrowser.put(FIREFOX, new Firefox());
        strategyBrowser.put(CHROME, new Chrome());
        return strategyBrowser.get(Environment.getInstance().getBrowser().toLowerCase()).initDriver();
    }
}
