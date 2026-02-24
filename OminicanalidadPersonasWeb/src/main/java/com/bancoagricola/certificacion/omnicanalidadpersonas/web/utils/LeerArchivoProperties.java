package com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils;


import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LeerArchivoProperties {

    private static final Logger LOGGER = Logger.getLogger(LeerArchivoProperties.class.getName());

    private LeerArchivoProperties() {
    }

    public static void esperar(int segundos) {
        try {
            Thread.sleep(1000 * segundos);
        } catch (InterruptedException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        }
    }

    public static void esperar2() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        }
    }

    public static String obtenerPropiedad(String propiedad) {


        EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
        return variables.getProperty(propiedad);
    }
}
