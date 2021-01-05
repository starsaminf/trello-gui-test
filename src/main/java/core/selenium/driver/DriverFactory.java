package core.selenium.driver;

import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;
import static io.github.bonigarcia.wdm.DriverManagerType.FIREFOX;

import core.selenium.config.EnvironmentCore;
import org.openqa.selenium.WebDriver;
import java.util.HashMap;
import java.util.Map;

public final class DriverFactory {

    /**
     * Constructor.
     */
    private DriverFactory() {
    }

    /**
     * Gets the correct instance of IDriver according the name given by parameter.
     *
     * @return The instance of the web driver.
     */
    public static WebDriver getDriver() {
        Map<String, IDriver> strategyBrowser = new HashMap<>();
        strategyBrowser.put(FIREFOX.toString(), new Firefox());
        strategyBrowser.put(CHROME.toString(), new Chrome());
        return strategyBrowser.get(EnvironmentCore.getInstance().getBrowser()).initDriver();
    }
}
