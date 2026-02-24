package com.bancoagricola.certificacion.omnicanalidadpersonas.web.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoMenuServicios;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.ConsultaSolicitudesCredito;
import io.cucumber.java.es.Entonces;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ConsultaSolicitudesCreditosStepDefinition {

    @Entonces("^valida los datos de la solicitud de credito (.*)$")
    public void validaLosDatosDeLaSolicitudDeCredito(String numero) {
        theActorInTheSpotlight().attemptsTo(
                //IngresoMenuServicios.inicio(),
        );           //ConsultaSolicitudesCredito.con(numero));
    }
}
