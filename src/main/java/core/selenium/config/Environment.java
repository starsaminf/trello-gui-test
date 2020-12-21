package core.selenium.config;

/**
 * PropertiesReader class.
 */
public final class Environment extends EnvironmentBase {

    private static final String PATH = "gradle.properties";
    private static Environment environment;

    /**
     * Initializes an instance of Environment Chrome.
     */
    private Environment() {
        super(PATH);
    }

    /**
     * get instance or create a new one.
     *
     * @return PropertiesReader instance.
     */
    public static Environment getInstance() {
        if (environment == null) {
            environment = new Environment();
        }
        return environment;
    }

    /**
     * get the cucumberThreadCount from the file.properties.
     * @return cucumberThreadCount value.
     */
    public String getCucumberThreadCount() {
        return getEnvProperty("cucumberThreadCount");
    }
}
