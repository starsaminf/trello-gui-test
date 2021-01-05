package core.selenium;

import core.selenium.config.EnvironmentCore;
import core.selenium.config.ReadDriverPropertiesJson;
import core.selenium.entities.DriverEntities;

/**
 * This class providers basics methods for WebDriver.
 */
public final class WebDriverConfig {

    private static WebDriverConfig webDriverConfig = null;
    private DriverEntities driverEntities;

    /**
     * Constructor.
     */
    private WebDriverConfig() {
        driverEntities = ReadDriverPropertiesJson.getDriversProperties()
                .get(EnvironmentCore.getInstance().getBrowser());
    }

    /**
     * Initializes a only instance of WebDriverManager.
     *
     * @return a webDriverManager
     */
    public static WebDriverConfig getInstance() {
        if (webDriverConfig == null) {
            webDriverConfig = new WebDriverConfig();
        }
        return webDriverConfig;
    }

    /**
     * Gets implicit waiting time.
     *
     * @return long implicit time
     */
    public long getImplicitWaitTime() {
        return driverEntities.getImplicitWaitingSeconds();
    }

    /**
     * Gets explicit wait time.
     *
     * @return long explicit time
     */
    public long getExplicitWaitTime() {
        return driverEntities.getExplicitWaitingSeconds();
    }

    /**
     * Gets sleep time.
     *
     * @return long sleep time
     */
    public long getSleepWait() {
        return driverEntities.getSleepingTime();
    }
}
