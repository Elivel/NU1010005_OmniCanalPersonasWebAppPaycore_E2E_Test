package com.bancoagricola.certificacion.omnicanalidadpersonas.web.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoAhorroNavidenoMovimientos;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoVerMasCtaAhorrobasico;
import io.cucumber.java.es.Cuando;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ExportarMovimientosAhorroNavidenoStepDefinition {
    @Cuando("^ingresa a los movimientos de la sección de ahorro navideño (.*) y contrato (.*)$")
    public void ingresaALosMovimientosDeLaSecciónDeAhorroNavideñoYContratoParaLaFecha(String cuenta, String contrato) {
        theActorInTheSpotlight().attemptsTo(
                IngresoVerMasCtaAhorrobasico.inicio(cuenta),
                IngresoAhorroNavidenoMovimientos.inicio(contrato));
    }
}