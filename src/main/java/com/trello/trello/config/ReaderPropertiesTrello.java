package com.trello.trello.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * This class read the properties file.
 */
public final class ReaderPropertiesTrello {

    private static ReaderPropertiesTrello environment;
    private static final Logger LOGGER = LogManager.getLogger(ReaderPropertiesTrello.class);
    private Properties property;
    private FileReader reader;

    /**
     * Initializes an instance of properties files.
     *
     * @param propertiesPath path of the properties file
     */
    public ReaderPropertiesTrello(final String propertiesPath) {
        try {
            reader = new FileReader(propertiesPath);
            property = new Properties();
            property.load(reader);
        } catch (IOException e) {
            LOGGER.error("Error getting properties");
            LOGGER.error(e.getMessage());
            throw new RuntimeException(e);
        } finally {
            closeReader();
        }
    }

    /**
     * Gets environment property.
     *
     * @param  env String
     * @return localProperty
     */
    public String getEnvProperty(final String env) {
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
