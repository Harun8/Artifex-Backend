package com.example.Artifex;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {
    private Properties properties;

    public ConfigLoader() {
        properties = new Properties();
        try (FileInputStream input = new FileInputStream("env.properties")) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getApiKey() {
        return properties.getProperty("API_KEY");
    }

    public String getDbUrl() {
        return properties.getProperty("DB_URL");
    }
}
