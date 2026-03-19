package com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnectionManager {

    private static Connection connection;

    public static void connect() {
        if (connection != null) {
            return;
        }

        try {
            String url = System.getProperty("db.url");
            String user = System.getProperty("db.user");
            String pass = System.getProperty("db.pass");

            connection = DriverManager.getConnection(url, user, pass);
            System.out.println("🔗 Conexión Oracle establecida correctamente.");

        } catch (SQLException e) {
            throw new RuntimeException("❌ Error al conectar a Oracle: " + e.getMessage(), e);
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void close() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("🔌 Conexión Oracle cerrada.");
            }
            connection = null;
        } catch (SQLException e) {
            throw new RuntimeException("❌ Error al cerrar la conexión Oracle", e);
        }
    }
}
