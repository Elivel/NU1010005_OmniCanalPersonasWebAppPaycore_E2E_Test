package com.bancoagricola.certificacion.omnicanalidadpersonas.web.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.ConsultaDetallePuntosCashBac;
import io.cucumber.java.es.Entonces;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ConsultaDetallePuntosCashbacStepDefinition {

    @Entonces("^valida que se muestren de forma correcta los datos para (.*)$")
    public void validaQueSeMuestrenDeFormaCorrectaLosDatosPara(String Nombre) {
        theActorInTheSpotlight().attemptsTo(ConsultaDetallePuntosCashBac.datosPCB(Nombre));
    }
}
