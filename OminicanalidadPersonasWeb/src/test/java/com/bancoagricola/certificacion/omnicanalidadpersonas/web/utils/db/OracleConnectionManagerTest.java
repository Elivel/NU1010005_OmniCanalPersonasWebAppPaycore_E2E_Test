package com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.db;

import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.assertNotNull;

public class OracleConnectionManagerTest {

    @Test
    public void should_connect_to_oracle_successfully() {
        System.setProperty("db.url", "jdbc:oracle:thin:@//10.58.135.20:1521/PBAOMNI");
        System.setProperty("db.user", "ellvelas");
        System.setProperty("db.pass", "V3ls$2026");

        OracleConnectionManager.connect();
        Connection connection = OracleConnectionManager.getConnection();

        assertNotNull("La conexión no debería ser null", connection);

        OracleConnectionManager.close();
    }
}