package com.bancoagricola.certificacion.omnicanalidadpersonas.web.config;

import org.junit.AfterClass;
import org.junit.BeforeClass;

public class ResetDataHook {
    @BeforeClass
    public static void globalSetup() {
        System.out.println("🔵 Iniciando suite de pruebas...");
    }

    @AfterClass
    public static void globalTeardown() {
        System.out.println("🔴 Finalizando suite de pruebas...");
    }

}
