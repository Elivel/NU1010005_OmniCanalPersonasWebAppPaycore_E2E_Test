package com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;

import java.util.List;
import java.util.logging.Logger;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CalculosTranferencias {
    private static List<Transferencias> datostransferencias;

    public CalculosTranferencias(List<Transferencias> datostransferencias) {
        this.datostransferencias = datostransferencias;
    }
    private String monto;

    public CalculosTranferencias(String monto) {
        this.monto = monto;
    }

    private static final Logger LOGGER = Logger.getLogger(CalculosTranferencias.class.getName());

    private CalculosTranferencias() {
    }

    public static Double obtenerMontoOrigenInicio() {
        double startMontoOrigen = Double.parseDouble(theActorInTheSpotlight().
                recall(VariablesSesion.MONTO_CUENTA_ORIGEN.toString()).toString().replace(",", "").replace("$", "").trim());
        return startMontoOrigen;
    }

    public static Double obtenerMontoOrigenFinal() {
        double finalMontoOrigen = Double.parseDouble(theActorInTheSpotlight().
                recall(MONTO_CUENTA_ORIGEN_FINAL.toString()).toString().replace(",", "").replace("$", "").trim());
        return finalMontoOrigen;
    }


    public static Double obtenerMontoDestinoInicio() {
        double startMontoDestino = Double.parseDouble(theActorInTheSpotlight().
                recall(VariablesSesion.MONTO_CUENTA_DESTINO.toString()).toString().replace(",", "").replace("$", "").trim());
        return startMontoDestino;
    }

    public static Double obtenerMontoDestinoFinal() {
        double finalMontoDestino = Double.parseDouble(theActorInTheSpotlight().
                recall(VariablesSesion.MONTO_CUENTA_DESTINO_FINAL.toString()).toString().replace(",", "").replace("$", "").trim());
        return finalMontoDestino;
    }

    public static Double validarMontoDestinoFinal(String monto) {
        double montoDescontado=Double.parseDouble(monto);
        double validarMontoDestino =Math.round((obtenerMontoDestinoInicio() + montoDescontado)* 100.0) / 100.0;
        System.out.println("validador de monto destino final: " + validarMontoDestino);
        System.out.println("monto Descontado: " + montoDescontado);
        System.out.println("Saldo capturado en pantalla al inicio Des: " + obtenerMontoDestinoInicio());
        System.out.println("Saldo capturado en pantalla al final Des: " + obtenerMontoDestinoFinal());
        return validarMontoDestino;
    }

    public static Double validarMontoOrigenFinal(String monto) {
        double montoDescontado=Double.parseDouble(monto);
        double validarMontoOrigen =Math.round((obtenerMontoOrigenInicio() - montoDescontado)* 100.0) / 100.0;

        //System.out.println("validador de monto origen final: " + validarMontoOrigen);
        System.out.println("monto Descontado: " + montoDescontado);
        System.out.println("Saldo capturado en pantalla al inicio cta Ori: " + obtenerMontoOrigenInicio());
        System.out.println("Saldo capturado en pantalla al final cta Ori: " + obtenerMontoOrigenFinal());
        return validarMontoOrigen;
    }
    /*Calculos para la transferencia con Tarjeta antes y despues*/

    public static Double obtenerMontoTarjetaAlInicio() {
        double montoInicialTarjeta = Double.parseDouble(theActorInTheSpotlight().
                recall(VariablesSesion.MONTO_INICIAL_TC.toString()).toString().replace(",", "").replace("$", "").trim());
        return montoInicialTarjeta;
    }

    public static Double obtenerMontoTarjetaFinal() {
        double montoFinalTarjeta = Double.parseDouble(theActorInTheSpotlight().
                recall(MONTO_FINAL_TC.toString()).toString().replace(",", "").replace("$", "").trim());
        return montoFinalTarjeta;
    }

    public static Double validarMontoTarjetaFinal(List<Transferencias> datostransferencias) {
        double montoDescontado=Double.parseDouble(datostransferencias.get(0).getMonto());
        double validarMontoTarjeta = Math.round((obtenerMontoTarjetaAlInicio() - montoDescontado) * 100.0) / 100.0;

        //System.out.println("validador del saldo de la tarjeta al final: " + validarMontoTarjeta);
        System.out.println("Monto ingresado: " + montoDescontado);
        System.out.println("Saldo tarjeta al inicio en pantalla: " + obtenerMontoTarjetaAlInicio());
        System.out.println("Saldo tarjeta al final en pantalla: " + obtenerMontoTarjetaFinal());

        return validarMontoTarjeta;
    }

    /*Tarjeta Puntos*/
    public static Double obtenerMontoCashBacInicio() {
        String montoCashBac1 = theActorInTheSpotlight().
                recall(CASHBAC_DISPONIBLE.toString()).toString().replace(",", "").replace("$", "").trim();
        String montoCashBac2 = montoCashBac1.replace("$","");
        double MontoCashBac = Double.parseDouble(montoCashBac2);
        return MontoCashBac;
    }

    public static Double obtenerMontoCashBacFinal() {
        String montoCashBac1 = theActorInTheSpotlight().
                recall(CASHBAC_FINAL.toString()).toString().replace(",", "").replace("$", "").trim();
        String montoCashBac2 = montoCashBac1.replace("$","");
        double MontoCashBac = Double.parseDouble(montoCashBac2);
        return MontoCashBac;
    }

    public static Double validarMontoCashBacFinal(String monto) {
        double montoDescontado=Double.parseDouble(monto);
        double validarMontoCashBac =Math.round((obtenerMontoCashBacInicio() - montoDescontado)* 100.0) / 100.0;
        System.out.println("validador de monto CashBac final: " + validarMontoCashBac);
        System.out.println("Monto descontado: " + montoDescontado);
        System.out.println("CashBac capturado al inicio en pantalla: " + obtenerMontoCashBacInicio());
        System.out.println("CashBac capturado al final en pantalla: " + obtenerMontoCashBacFinal());
        return validarMontoCashBac;
    }
}