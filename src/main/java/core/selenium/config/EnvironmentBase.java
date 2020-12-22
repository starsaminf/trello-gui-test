package core.selenium.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * PropertiesReader class.
 */
public class EnvironmentBase {

    private static final Logger LOGGER = LogManager.getLogger(EnvironmentBase.class);
    private Properties property;
    private FileReader reader;

    /**
     * Initializes an instance of properties files.
     * @param propertiesPath
     */
    public EnvironmentBase(final String propertiesPath) {
        try {
            reader = new FileReader(propertiesPath);
            property = new Properties();
            property.load(reader);
        } catch (FileNotFoundException e) {
            LOGGER.error("Error when reading file");
            LOGGER.error(e.getMessage());
        } catch (IOException e) {
            LOGGER.error("Error getting properties");
            LOGGER.error(e.getMessage());
        } finally {
            closeReader();
        }
    }

    /**
     * Gets a driver Path.
     * @return a driver ChromePath.
     */
    public String getDriverPath() {
        return getEnvProperty("driveChromePath");
    }

    /**
     * Gets a implicit time.
     * @return a implicitly wait.
     */
    public long getImplicitTime() {
        return Long.parseLong(getEnvProperty("implicitTime"));
    }

    /**
     * Gets a explicit time.
     * @return a explicitly wait.
     */
    public long getExplicitTime() {
        return Long.parseLong(getEnvProperty("explicitTime"));
    }

    /**
     * Gets environment property.
     * @param env
     * @return localProperty
     */
    protected String getEnvProperty(final String env) {
        String localProperty = System.getProperty(env);
        if (localProperty == null) {
            return this.property.getProperty(env);
        }
        return localProperty;
    }

    /**
     * Closes FileReader.
     */
    private void closeReader() {
        try {
            reader.close();
        } catch (IOException e) {
            LOGGER.error("Cannot close File Reader.");
        }
    }

}
