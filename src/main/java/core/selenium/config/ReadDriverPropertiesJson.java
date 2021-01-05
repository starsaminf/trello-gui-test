package core.selenium.config;

import com.fasterxml.jackson.core.type.TypeReference;
import core.selenium.entities.DriverEntities;
import core.selenium.utils.JsonParser;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * This class read a json file configuration.
 */
public final class ReadDriverPropertiesJson {
    /**
     * Constructor.
     */
    private ReadDriverPropertiesJson() {

    }

    /**
     * This class return a Map with all navigators of the json file.
     *
     * @return Map with key = navigator, value = DriverEntities
     */
    public static Map<String, DriverEntities> getDriversProperties() {
        List<DriverEntities> driverEntities = JsonParser.getEntityFromJSON(new TypeReference<List<DriverEntities>>() {
        }, EnvironmentCore.getInstance().getDrivePropertiesPath());
        return driverEntities.stream().collect(Collectors.toMap(DriverEntities::getNavigator, Driver -> Driver));
    }
}
