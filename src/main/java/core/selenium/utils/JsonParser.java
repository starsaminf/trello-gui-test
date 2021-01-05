package core.selenium.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import core.selenium.entities.DriverEntities;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * JsonParser class.
 */
public final class JsonParser {
    /**
     * Constructor.
     */
    private JsonParser() {

    }
    /**
     * Gets an entity instance with the information populated from a JSON file.
     *
     * @param <T>        the type of entity obtained by the method.
     * @param entityType - Entity class.
     * @param path       - JSON file path.
     * @return entity populated with the information from the JSON file.
     */
    public static <T> T getEntityFromJSON(final TypeReference<List<DriverEntities>> entityType, final String path) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return (T) mapper.readValue(new File(path), entityType);
        } catch (IOException e) {
            throw new IllegalArgumentException("The json path is not correct", e);
        }
    }
}
