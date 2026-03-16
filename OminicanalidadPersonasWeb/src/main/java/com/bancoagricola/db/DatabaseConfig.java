package com.bancoagricola.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public final class DatabaseConfig {

    private static final String SERENITY_PROPERTIES = "serenity.properties";
    private static final String ORACLE_DRIVER = "oracle.jdbc.OracleDriver";
    private static final String KEY_URL = "db.url";
    private static final String KEY_USERNAME = "db.username";
    private static final String KEY_PASSWORD = "db.password";

    private final String url;
    private final String username;
    private final String password;

    private DatabaseConfig(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public static DatabaseConfig fromSerenityProperties() {
        Properties properties = new Properties();
        try (InputStream inputStream = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream(SERENITY_PROPERTIES)) {
            if (inputStream == null) {
                throw new IllegalStateException("No se encontro el archivo serenity.properties en el classpath");
            }
            properties.load(inputStream);
        } catch (IOException exception) {
            throw new IllegalStateException("No fue posible leer serenity.properties", exception);
        }

        String url = resolveProperty(properties, KEY_URL);
        String username = resolveProperty(properties, KEY_USERNAME);
        String password = resolveProperty(properties, KEY_PASSWORD);

        return new DatabaseConfig(url, username, password);
    }

    public Connection createConnection() throws SQLException {
        try {
            Class.forName(ORACLE_DRIVER);
        } catch (ClassNotFoundException exception) {
            throw new SQLException("No se encontro el driver de Oracle: " + ORACLE_DRIVER, exception);
        }
        return DriverManager.getConnection(url, username, password);
    }

    private static String resolveProperty(Properties properties, String key) {
        String rawValue = properties.getProperty(key);
        if (rawValue == null || rawValue.isBlank()) {
            throw new IllegalStateException("La propiedad requerida no esta definida: " + key);
        }

        String trimmedValue = rawValue.trim();
        if (trimmedValue.startsWith("${") && trimmedValue.endsWith("}")) {
            String variable = trimmedValue.substring(2, trimmedValue.length() - 1);
            String fromSystem = System.getProperty(variable);
            if (fromSystem != null && !fromSystem.isBlank()) {
                return fromSystem;
            }

            String fromEnvironment = System.getenv(variable);
            if (fromEnvironment != null && !fromEnvironment.isBlank()) {
                return fromEnvironment;
            }

            throw new IllegalStateException("No se encontro valor para la variable: " + variable);
        }

        return trimmedValue;
    }
}
