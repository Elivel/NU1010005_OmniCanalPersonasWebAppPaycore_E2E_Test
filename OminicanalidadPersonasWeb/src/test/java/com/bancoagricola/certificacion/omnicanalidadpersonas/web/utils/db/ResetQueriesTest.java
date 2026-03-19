package com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.db;

import org.junit.Test;

    public class ResetQueriesTest {

        @Test
        public void should_execute_reset_queries() {

            System.setProperty("db.url", "jdbc:oracle:thin:@//10.58.135.20:1521/PBAOMNI");
            System.setProperty("db.user", "ellvelas");
            System.setProperty("db.pass", "V3ls$2026");

            QueryResetExecutor.executeResetQueries();
            System.out.println("Archivo SQL cargado correctamente");
        }
    }

