package com.github.macwlodarczak.api.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {
    private static Properties properties = new Properties();

    static {
        // Pobieramy środowisko z parametrów systemowych (domyślnie 'local')
        // Możemy je zmienić komendą w Mavenie: mvn test -Denv=qa
        String env = System.getProperty("env", "local");
        String path = "src/test/resources/config-" + env + ".properties";

        try (FileInputStream input = new FileInputStream(path)) {
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Nie udało się załadować pliku konfiguracyjnego dla środowiska: " + env, e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
