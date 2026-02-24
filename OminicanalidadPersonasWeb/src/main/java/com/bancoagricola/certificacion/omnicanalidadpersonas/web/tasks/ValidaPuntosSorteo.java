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
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.INNER_TEXT;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.TEXT_CONTENT;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class ValidaPuntosSorteo implements Task {
    private String nombre;
    public ValidaPuntosSorteo(String nombre) {
        this.nombre = nombre;}

    @Step("{0} realiza validación de datos de promociones con respecto a la pantalla de selección")
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(PROMOCION_SELECCIONADO.of(nombre), isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(PROMOCION_SELECCIONADO.of(nombre), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(PROMOCION_SELECCIONADO.of(nombre)),
                WaitUntil.the(DETALLE_PUNTOS_SORTEO, isEnabled()).forNoMoreThan(60).seconds(),
                Ensure.that(NOMBRE_PROMOCION2).attribute(INNER_TEXT).isEqualTo(actor.recall(VariablesSesion.NOMBRE.toString())),
                Ensure.that(PUNTOS_ACUMULADOS2).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.PUNTOS.toString())),
                Ensure.that(FECHA_INIC_PROM2).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.FECHA_INI.toString())),
                Ensure.that(FECHA_FIN_PROM2).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.FECHA_FIN.toString())),
                Ensure.that(TABLA_FECHA_ASIGNACION_PUNTOS).isDisplayed());
    }

    public static ValidaPuntosSorteo con(String nombre) {
        return Instrumented.instanceOf(ValidaPuntosSorteo.class).withProperties(nombre);
    }
}

