package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.ServiciosPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ProcesoConsultaPuntosSorteo implements Task {
    private String nombre;

    public ProcesoConsultaPuntosSorteo(String nombre) {
        this.nombre = nombre;
    }

    @Step("{0} realiza proceso para consultar puntos de sorteo")
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(LNK_CONSULTA_PUNTOS_SORTEO, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(LNK_CONSULTA_PUNTOS_SORTEO, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(LNK_CONSULTA_PUNTOS_SORTEO),
                WaitUntil.the(TTL_CONSULTA_PUNTOS_SORTEO, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(TTL_CONSULTA_PUNTOS_SORTEO, isEnabled()).forNoMoreThan(60).seconds(),
                Ensure.that(TABLA_PROMOCIONES).isDisplayed());
        actor.remember(VariablesSesion.NOMBRE.toString(), NOMBRE_PROMOCION1.of(nombre).resolveFor(actor).getText());
        actor.remember(VariablesSesion.PUNTOS.toString(), PUNTOS_ACUMULADOS1.of(nombre).resolveFor(actor).getText());
        actor.remember(VariablesSesion.FECHA_INI.toString(), FECHA_INIC_PROM1.of(nombre).resolveFor(actor).getText());
        actor.remember(VariablesSesion.FECHA_FIN.toString(), FECHA_FIN_PROM1.of(nombre).resolveFor(actor).getText());
    }

    public static ProcesoConsultaPuntosSorteo con(String nombre) {
        return Instrumented.instanceOf(ProcesoConsultaPuntosSorteo.class).withProperties(nombre);
    }
}

