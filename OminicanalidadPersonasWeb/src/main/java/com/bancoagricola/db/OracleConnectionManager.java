package com.bancoagricola.db;

import java.sql.Connection;
import java.sql.SQLException;

public class OracleConnectionManager {

    private final DatabaseConfig databaseConfig;

    public OracleConnectionManager() {
        this(DatabaseConfig.fromSerenityProperties());
    }

    public OracleConnectionManager(DatabaseConfig databaseConfig) {
        this.databaseConfig = databaseConfig;
    }

    public Connection openConnection() throws SQLException {
        return databaseConfig.createConnection();
    }

    public void closeQuietly(Connection connection) {
        if (connection == null) {
            return;
        }

        try {
            connection.close();
        } catch (SQLException ignored) {
            // Se omite para evitar romper el flujo de la prueba durante el cierre.
        }
    }
}
