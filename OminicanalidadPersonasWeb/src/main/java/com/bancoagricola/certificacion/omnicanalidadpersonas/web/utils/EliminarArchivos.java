package com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils;

import io.cucumber.java.Before;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Objects;
import java.util.logging.Logger;

public class EliminarArchivos {
    private EliminarArchivos() {
    }

    private static final Logger LOGGER = Logger.getLogger(EliminarArchivos.class.getName());

    private static final String RUTA_DE_DESCARGA = System.getProperty("user.dir");
    private static final String ARCHIVO_MOVIMIENTOS = "Movimientos";
    private static final String ARCHIVO_AUDITORIA = "Auditoria";
    private static final String ARCHIVO_ESTADO_CTAC = "EstadoCuenta";
    private static final String ARCHIVO_NOMBRE_ESTCUETC = "EstadoDeCuenta";

    @Before("@excel,@pdf")

    public static void statementsDownloaded() {
        File downloadsDirectory = new File(RUTA_DE_DESCARGA);
        for (File file : Objects.requireNonNull(downloadsDirectory.listFiles())) {

            if (isAStatement(file.getName())) {
                try {
                    Files.delete(file.toPath());
                } catch (IOException e) {
                    LOGGER.severe(e.getMessage());
                }
            }
        }
    }

    private static boolean isAStatement(String fileName) {
        return fileName.contains(ARCHIVO_MOVIMIENTOS) || fileName.contains(ARCHIVO_AUDITORIA) || fileName.contains(ARCHIVO_ESTADO_CTAC) || fileName.contains(ARCHIVO_NOMBRE_ESTCUETC);
    }
}