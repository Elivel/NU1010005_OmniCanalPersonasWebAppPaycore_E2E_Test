package com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils;

import net.serenitybdd.screenplay.ensure.Ensure;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class AbrirExcel {

    private static final Logger LOGGER = Logger.getLogger(AbrirExcel.class.getName());


    public static void validarSaldosPantallayExcel(String path) throws IOException {

        try (FileInputStream file = new FileInputStream(new File(path))) {
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);

            /*valores indetificados en el archivo de excel*/
            Double saldoInicial = Math.round(Float.parseFloat(sheet.getRow(3).getCell(0).toString())) * 100.0 / 100.0;
            Double saldoDisponible = Math.round(Float.parseFloat(sheet.getRow(3).getCell(1).toString())) * 100.0 / 100.0;
            Double saldoContable = Math.round(Float.parseFloat(sheet.getRow(3).getCell(3).toString())) * 100.0 / 100.0;
            Double promedioContable = Math.round(Float.parseFloat(sheet.getRow(6).getCell(0).toString())) * 100.0 / 100.0;
            LOGGER.log(Level.INFO, "saldoInicial: \"{0}\"", saldoInicial);
            LOGGER.log(Level.INFO, "saldoDisponible: \"{0}\"", saldoDisponible);
            LOGGER.log(Level.INFO, "saldoContable: \"{0}\"", saldoContable);
            LOGGER.log(Level.INFO, "promedioContable: \"{0}\"", promedioContable);

            /*valores capturados en pantalla*/
            Double pantallaSaldoInicial = Math.round(Float.parseFloat(theActorInTheSpotlight().recall(SALDO_INICIAL.toString()).toString().replace(",", ""))) * 100.0 / 100.0;
            Double pantallaSaldoDisponible = Math.round(Float.parseFloat(theActorInTheSpotlight().recall(SALDO_DISPONIBLE.toString()).toString().replace(",", ""))) * 100.0 / 100.0;
            Double pantallaSaldoContable = Math.round(Float.parseFloat(theActorInTheSpotlight().recall(SALDO_CONTABLE.toString()).toString().replace(",", ""))) * 100.0 / 100.0;
            Double pantallaPromedioContable =Math.round(Float.parseFloat(theActorInTheSpotlight().recall(PROMEDIO_CONTABLE.toString()).toString().replace(",", ""))) * 100.0 / 100.0;
            LOGGER.log(Level.INFO, "pantallaSaldoInicial: \"{0}\"", pantallaSaldoInicial);
            LOGGER.log(Level.INFO, "pantallaSaldoDisponible: \"{0}\"", pantallaSaldoDisponible);
            LOGGER.log(Level.INFO, "pantallaSaldoContable: \"{0}\"", pantallaSaldoContable);
            LOGGER.log(Level.INFO, "pantallaPromedioContable: \"{0}\"", pantallaPromedioContable);

            theActorInTheSpotlight().attemptsTo(
                    Ensure.that(saldoInicial).isEqualTo(pantallaSaldoInicial),
                    Ensure.that(saldoDisponible).isEqualTo(pantallaSaldoDisponible),
                    Ensure.that(saldoContable).isEqualTo(pantallaSaldoContable),
                    Ensure.that(promedioContable).isEqualTo(pantallaPromedioContable));
        } catch (Exception e) {
            LOGGER.severe(e.getMessage());
        }
    }

    public static void validarSaldosPantallayExcelTarjetas(String path) throws IOException {

        try (FileInputStream file = new FileInputStream(new File(path))) {
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            XSSFSheet sheet = workbook.getSheetAt(0);

            /*valores indetificados en el archivo de excel*/
            double limiteCredito = Math.round(Float.parseFloat(sheet.getRow(2).getCell(0).toString())) * 100.0 / 100.0;
            double disponible = Math.round(Float.parseFloat(sheet.getRow(4).getCell(5).toString())) * 100.0 / 100.0;
            LOGGER.log(Level.INFO, "limiteCredito: \"{0}\"", limiteCredito);
            LOGGER.log(Level.INFO, "disponible: \"{0}\"", disponible);



            /*valores capturados en pantalla*/
            Double pantallaLimiteCredito = Math.round(Float.parseFloat(theActorInTheSpotlight().recall(V_LIMITE_CREDITO.toString()).toString().replace(",", ""))) * 100.0 / 100.0;
            Double pantallaDisponible = Math.round(Float.parseFloat(theActorInTheSpotlight().recall(MONTO_INICIAL_TC.toString()).toString().replace(",", ""))) * 100.0 / 100.0;
            LOGGER.log(Level.INFO, "pantallaLimiteCredito: \"{0}\"", pantallaLimiteCredito);
            LOGGER.log(Level.INFO, "pantallaDisponible: \"{0}\"", pantallaDisponible);

            theActorInTheSpotlight().attemptsTo(
                    Ensure.that(limiteCredito).isEqualTo(pantallaLimiteCredito),
                    Ensure.that(disponible).isEqualTo(pantallaDisponible));
        } catch (Exception e) {
            LOGGER.severe(e.getMessage());
        }
    }
}