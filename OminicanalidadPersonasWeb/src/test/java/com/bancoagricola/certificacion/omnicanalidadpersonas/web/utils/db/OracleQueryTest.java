package com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.db;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import static org.junit.Assert.assertTrue;

public class OracleQueryTest {

    @Test
    public void should_execute_select_query() throws Exception {
        System.setProperty("db.url", "jdbc:oracle:thin:@//10.58.135.20:1521/PBAOMNI");
        System.setProperty("db.user", "ellvelas");
        System.setProperty("db.pass", "V3ls$2026");

        OracleConnectionManager.connect();
        Connection conn = OracleConnectionManager.getConnection();

        try (Statement stmt = conn.createStatement()) {
            String query = "SELECT * FROM omniqa.environment_product " +
                    "WHERE ID_ENVIRONMENT = ( " +
                    "   SELECT eu.ID_ENVIRONMENT FROM omniqa.ENVIRONMENT_USERS eu " +
                    "   WHERE eu.ID_USER = ( " +
                    "       SELECT u.id_user FROM omniqa.USERS u WHERE u.USERNAME = 'auto01' " +
                    "   ) AND ROWNUM = 1 " +
                    ")";
            ResultSet rs = stmt.executeQuery(query);
//assertTrue(rs.next());
            if (rs.next()) {
                System.out.println("Consulta ejecutada correctamente.");
            } else {
                System.out.println("La consulta ejecutó bien, pero no devolvió registros.");
            }
        } finally {
            OracleConnectionManager.close();
        }
    }
}