package com.trello.trello.config;

/**
 * PropertiesReader class.
 */
public final class EnvironmentTrello {

    private static final String FILE_PROPERTIES = "gradle.properties";
    private static EnvironmentTrello environment = null;
    private ReaderPropertiesTrello readerProperties;

    /**
     * Initializes an instance of properties files.
     */
    private EnvironmentTrello() {
        readerProperties = new ReaderPropertiesTrello(FILE_PROPERTIES);
    }

    /**
     * get instance or create a new one.
     *
     * @return PropertiesReader instance.
     */
    public static EnvironmentTrello getInstance() {
        if (environment == null) {
            environment = new EnvironmentTrello();
        }
        return environment;
    }

    /**
     * get the BaseUrl from the file.properties.
     *
     * @return base url.
     */
    public String getBaseUrl() {
        return readerProperties.getEnvProperty("baseurl");
    }

    /**
     * Gets the User from the file.properties.
     *
     * @return User value.
     */
    public String getUsername() {
        return readerProperties.getEnvProperty("username");
    }

    /**
     * Gets the password from the file.properties.
     *
     * @return Password value.
     */
    public String getPassword() {
        return readerProperties.getEnvProperty("password");
    }

    /**
     * Gets driver Properties Path.
     * @return driverPropertiesPath
     */
    public String getDrivePropertiesPath() {
        return readerProperties.getEnvProperty("driverPropertiesPath");
    }

    /**
     * Gets browser fot the test.
     * @return browser
     */
    public String getBrowser() {
        return readerProperties.getEnvProperty("browser");
    }
}
