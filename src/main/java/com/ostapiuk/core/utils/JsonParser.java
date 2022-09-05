package com.ostapiuk.core.utils;

import com.google.gson.Gson;
import com.ostapiuk.business.model.JsonEntity;
import com.ostapiuk.core.logger.Log;
import com.ostapiuk.core.properties.ConfigProperties;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Objects;

public class JsonParser {

    private static final String PROPERTY_PATH = ConfigProperties.getDataSourceProperty();

    private JsonParser() {
        throw new IllegalStateException("Utility class");
    }

    public static JsonEntity getJsonEntity() {
        Gson gson = new Gson();
        try (InputStream inputStream = PropertySource.class.getClassLoader().getResourceAsStream(PROPERTY_PATH)) {
            Reader reader = new InputStreamReader(Objects.requireNonNull(inputStream));
            return gson.fromJson(reader, JsonEntity.class);
        } catch (IOException e) {
            Log.getLogger().trace(e);
            return null;
        }
    }
}
