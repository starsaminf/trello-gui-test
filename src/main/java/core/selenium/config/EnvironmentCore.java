package core.selenium.config;

/**
 * PropertiesReader class.
 */
public final class EnvironmentCore {

    private static final String FILE_PROPERTIES = "gradle.properties";
    private static EnvironmentCore environment = null;
    private ReaderPropertiesCore readerPropertiesCore;

    /**
     * Initializes an instance of properties files.
     */
    private EnvironmentCore() {
        readerPropertiesCore = new ReaderPropertiesCore(FILE_PROPERTIES);
    }

    /**
     * get instance or create a new one.
     *
     * @return PropertiesReader instance.
     */
    public static EnvironmentCore getInstance() {
        if (environment == null) {
            environment = new EnvironmentCore();
        }
        return environment;
    }

    /**
     * get the BaseUrl from the file.properties.
     *
     * @return base url.
     */
    public String getBaseUrl() {
        return readerPropertiesCore.getEnvProperty("baseurl");
    }

    /**
     * Gets the User from the file.properties.
     *
     * @return User value.
     */
    public String getUsername() {
        return readerPropertiesCore.getEnvProperty("username");
    }

    /**
     * Gets the password from the file.properties.
     *
     * @return Password value.
     */
    public String getPassword() {
        return readerPropertiesCore.getEnvProperty("password");
    }

    /**
     * Gets driver Properties Path.
     * @return driverPropertiesPath
     */
    public String getDrivePropertiesPath() {
        return readerPropertiesCore.getEnvProperty("driverPropertiesPath");
    }

    /**
     * Gets browser fot the test.
     * @return browser
     */
    public String getBrowser() {
        return readerPropertiesCore.getEnvProperty("browser");
    }
}
