package core.selenium.config;

/**
 * PropertiesReader class.
 */
public final class EnvironmentChrome extends EnvironmentBase {

    private static final String PATH = "chrome.properties";
    private static EnvironmentChrome environmentChrome;

    /**
     * Initializes an instance of Environment Chrome.
     */
    private EnvironmentChrome() {
        super(PATH);
    }

    /**
     * get instance or create a new one.
     *
     * @return PropertiesReader instance.
     */
    public static EnvironmentChrome getInstance() {
        if (environmentChrome == null) {
            environmentChrome = new EnvironmentChrome();
        }
        return environmentChrome;
    }
}
