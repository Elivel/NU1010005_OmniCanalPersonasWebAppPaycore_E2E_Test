package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.ServiciosPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class EliminarTransferencia implements Task {

    private String estado;
    private String concepto;

    public EliminarTransferencia(String estado, String concepto) {
        this.estado = estado;
        this.concepto = concepto;
    }

    @Step("{0} 'realiza proceso para eliminación de transferencias'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(AUDITORIATRX, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(AUDITORIATRX, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(AUDITORIATRX),
                WaitUntil.the(TTL_AUDITORIATRX, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(TTL_AUDITORIATRX, isEnabled()).forNoMoreThan(30).seconds()
        );
        LeerArchivoProperties.esperar(3);
        actor.attemptsTo(
                WaitUntil.the(TABLA_MOV_CA, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(TABLA_MOV_CA, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(ESTADO_CONCEPTO_TRANSACCION_PROGRAMADA.of(estado, concepto), isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(ESTADO_CONCEPTO_TRANSACCION_PROGRAMADA.of(estado, concepto), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(ESTADO_CONCEPTO_TRANSACCION_PROGRAMADA.of(estado, concepto)),
                WaitUntil.the(VTN_EMERG_PP2, isVisible()).forNoMoreThan(10).seconds(),
                WaitUntil.the(VTN_EMERG_PP2, isEnabled()).forNoMoreThan(10).seconds());
        LeerArchivoProperties.esperar(2);
        actor.attemptsTo(
                WaitUntil.the(BTN_ACEPTAR_C, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_ACEPTAR_C, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_ACEPTAR_C));
        WaitUntil.the(MSG_ELIMINACION_TRX, isVisible()).forNoMoreThan(30).seconds().performAs(actor);
        WaitUntil.the(TABLA_MOV_CA, isVisible()).forNoMoreThan(60).seconds().performAs(actor);
    }

    public static EliminarTransferencia programada(String estado, String concepto) {
        return Instrumented.instanceOf(EliminarTransferencia.class).withProperties(estado, concepto);
    }

}
