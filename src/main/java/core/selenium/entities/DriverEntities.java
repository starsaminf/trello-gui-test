package core.selenium.entities;

import java.util.List;

/**
 * This class is a entities from DriverProperties.json file.
 */
public class DriverEntities {

    private String navigator;
    private String version;
    private String driverPath;
    private long implicitWaitingSeconds;
    private long explicitWaitingSeconds;
    private long sleepingTimeMills;
    private List<String> flags;

    /**
     * Gets the name of the navigator.
     * @return name of the navigator.
     */
    public String getNavigator() {
        return navigator;
    }

    /**
     * Sets a name of the navigator.
     * @param navigatorName the name of the navigator defines in DriverProperties.json file
     */
    public void setNavigator(final String navigatorName) {
        this.navigator = navigatorName;
    }

    /**
     * Gets the version of the navigator.
     * @return the version of the navigator
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets a version of the navigator.
     * @param driverVersion version of the navigator
     */
    public void setVersion(final String driverVersion) {
        this.version = driverVersion;
    }

    /**
     * Gets the driver location.
     * @return the driver location
     */
    public String getDriverPath() {
        return driverPath;
    }

    /**
     * Sets driver path.
     * @param jsonDriverPath
     */
    public void setDriverPath(final String jsonDriverPath) {
        this.driverPath = jsonDriverPath;
    }

    /**
     * Gets implicit wait.
     * @return implicitWaitingSeconds
     */
    public long getImplicitWaitingSeconds() {
        return implicitWaitingSeconds;
    }

    /**
     * Sets implicit wait.
     * @param implicitWaiting
     */
    public void setImplicitWaitingSeconds(final long implicitWaiting) {
        this.implicitWaitingSeconds = implicitWaiting;
    }

    /**
     * Gets Explicit wait.
     * @return explicitWaitingSeconds
     */
    public long getExplicitWaitingSeconds() {
        return explicitWaitingSeconds;
    }

    /**
     * Sets Explicit wait.
     * @param explicitWaiting
     */
    public void setExplicitWaitingSeconds(final long explicitWaiting) {
        this.explicitWaitingSeconds = explicitWaiting;
    }

    /**
     * Gets sleep time.
     * @return sleepingTimeMills
     */
    public long getSleepingTime() {
        return sleepingTimeMills;
    }

    /**
     * Sets sleep time.
     * @param sleepingTime
     */
    public void setSleepingTimeMills(final long sleepingTime) {
        this.sleepingTimeMills = sleepingTime;
    }

    /**
     * Gets a list of arguments of the driver.
     * @return  the arguments of the web driver
     */
    public List<String> getFlags() {
        return flags;
    }

    /**
     * Sets a list of arguments of the driver.
     * @param flagList
     */
    public void setFlags(final List<String> flagList) {
        this.flags = flagList;
    }
}
