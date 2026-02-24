package com.bancoagricola.certificacion.omnicanalidadpersonas.web.stepdefinitions;


import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.ServiciosPage.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CerrarSesion {

    @Cuando("^El Usuario se encuentre dentro de Ebanca Persona$")
    public void elUsuarioSeEncuentreDentroDeEbancaPersona() {
        WaitUntil.the(TITLE_INICIO, isVisible()).forNoMoreThan(10).seconds();
    }

    @Entonces("^Validar que el usuario puede Cerrar Sesión$")
    public void validarQueElUsuarioPuedeCerrarSesión() {
        WaitUntil.the(FNL_SESION, isVisible()).forNoMoreThan(10).seconds().performAs(theActorInTheSpotlight());
        theActorInTheSpotlight().attemptsTo(
                Click.on(FNL_SESION),
                WaitUntil.the(CONFIRMAR_FNLSESION, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(CONFIRMAR_FNLSESION)
        );
    }

}
