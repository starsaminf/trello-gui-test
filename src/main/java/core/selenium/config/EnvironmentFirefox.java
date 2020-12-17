package core.selenium.config;

/**
 * PropertiesReader class.
 */
public final class EnvironmentFirefox extends EnvironmentBase {

    private static final String PATH = "firefox.properties";
    private static EnvironmentFirefox environmentFirefox;

    /**
     * Initializes an instance of Environment Firefox
     */
    private EnvironmentFirefox() {
        super(PATH);
    }

    /**
     * get instance or create a new one.
     *
     * @return PropertiesReader instance.
     */
    public static EnvironmentFirefox getInstance() {
        if (environmentFirefox == null) {
            environmentFirefox = new EnvironmentFirefox();
        }
        return environmentFirefox;
    }
}
