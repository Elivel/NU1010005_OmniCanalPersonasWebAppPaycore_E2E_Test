package com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.db;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Statement;
import java.util.stream.Collectors;

public class QueryResetExecutor {

    public static void executeResetQueries() {
        try {
            InputStream inputStream = QueryResetExecutor.class
                    .getClassLoader()
                    .getResourceAsStream("db/reset-queries.sql");

            if (inputStream == null) {
                throw new RuntimeException("No se encontró el archivo reset-queries.sql");
            }

            String sql = new BufferedReader(new InputStreamReader(inputStream))
                    .lines()
                    .collect(Collectors.joining("\n"));

            String[] statements = sql.split(";");

            Connection conn = OracleConnectionManager.getConnection();
            Statement stmt = conn.createStatement();

            for (String query : statements) {
                String trimmed = query.trim();
                if (!trimmed.isEmpty()) {
                    stmt.execute(trimmed);
                    System.out.println("✔ Ejecutado: " + trimmed);
                }
            }

            stmt.close();

        } catch (Exception e) {
            throw new RuntimeException("Error ejecutando reset de BD", e);
        } finally {
            try {
                OracleConnectionManager.close();
            } catch (Exception ignored) {}
        }

    }
}
