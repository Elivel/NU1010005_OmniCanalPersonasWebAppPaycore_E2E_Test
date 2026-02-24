package com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.questions.CantidadRegistrosTablaMovimientos;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.questions.ExisteTablaMovimientos;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Scroll;

import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.TABLA_MOV_CA;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.*;

public class MovimientosRangoFechas implements Interaction {

    @Step("{0} 'valida datos en la tabla para 'Rango de fechas seleccionado'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        WaitUntil.the(TABLA_MOV_CA, isVisible()).forNoMoreThan(60).seconds().performAs(actor);
        theActorInTheSpotlight().attemptsTo(
                Scroll.to(TABLA_MOV_CA).andAlignToTop());
        LeerArchivoProperties.esperar(3);
        actor.should(seeThat(ExisteTablaMovimientos.quelatabla(), is(true)).because("Valida que se muestre la tabla de movimientos"));
        actor.should(seeThat(CantidadRegistrosTablaMovimientos.tiene(), greaterThanOrEqualTo(1)).because("La cantidad de registros sea mayor o igual a 1"));
    }

    public static MovimientosRangoFechas datosCA() {
        return Instrumented.instanceOf(MovimientosRangoFechas.class).withProperties();
    }
}

