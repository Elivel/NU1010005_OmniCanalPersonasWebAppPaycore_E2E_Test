package com.bancoagricola.certificacion.omnicanalidadpersonas.web.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoMenuServicios;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.ProcesoConsultaPuntosSorteo;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.ValidaPuntosSorteo;
import io.cucumber.java.es.Entonces;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ConsultaPuntosSorteoStepDefinition {

    @Entonces("^valida los puntos de la promocion \"([^\"]*)\"$")
    public void validaLosPuntosDeLaPromocion(String nombre) {
        theActorInTheSpotlight().attemptsTo(
                IngresoMenuServicios.inicio(),
                ProcesoConsultaPuntosSorteo.con(nombre)
               // ValidaPuntosSorteo.con(nombre));
        );
    }
}
