package com.ostapiuk.core.utils;

import com.google.gson.Gson;
import com.ostapiuk.business.model.JsonEntity;
import com.ostapiuk.core.logger.Log;
import com.ostapiuk.core.properties.ConfigProperties;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class JsonParser {

    private JsonParser() {
        throw new IllegalStateException("Utility class");
    }

    public static JsonEntity getJsonEntity() {
        Gson gson = new Gson();
        try (Reader reader = new FileReader(ConfigProperties.getDataSourceProperty())) {
            return gson.fromJson(reader, JsonEntity.class);
        } catch (IOException e) {
            Log.getLogger().trace(e);
            return null;
        }
    }
}
