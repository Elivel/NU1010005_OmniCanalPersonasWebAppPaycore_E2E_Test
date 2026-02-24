package com.bancoagricola.certificacion.omnicanalidadpersonas.web.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.TransferirCuentaTeleton;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.TransferirCuentaTeletonCC;
import io.cucumber.java.es.Y;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class TransferenciaCuentaTeletonStepDefinition {

    @Y("^realiza la transferencia desde su cuenta (.*) a una cuenta teleton por un monto de (.*) dolares$")
    public void realizaLaTransferenciaDesdeSuCuentaAUnaCuentaTeletonPorUnMontoDeDolares(String cuenta, String monto) {
        theActorInTheSpotlight().attemptsTo(
                TransferirCuentaTeleton.datosCompletos(cuenta, monto));
    }

    @Y("^realiza la transferencia desde su cuenta (.*) a una cuenta teleton por un monto de (.*) dolares desde CC$")
    public void realizaLaTransferenciaDesdeSuCuentaAUnaCuentaTeletonPorUnMontoDeDolaresDesdeCC(String cuenta, String monto) {
        theActorInTheSpotlight().attemptsTo(
                TransferirCuentaTeletonCC.datosCompletos(cuenta, monto));
    }
}