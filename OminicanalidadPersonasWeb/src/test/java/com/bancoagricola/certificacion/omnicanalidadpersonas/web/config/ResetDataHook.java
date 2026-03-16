package com.bancoagricola.certificacion.omnicanalidadpersonas.web.config;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.db.QueryResetExecutor;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public class ResetDataHook {
    @BeforeClass
    public static void globalSetup() {
        System.out.println("🔵 Iniciando suite de pruebas...");
        //QueryResetExecutor.executeResetQueries();
    }

    @AfterClass
    public static void globalTeardown() {
        System.out.println("🔴 Finalizando suite de pruebas...");
    }

}
