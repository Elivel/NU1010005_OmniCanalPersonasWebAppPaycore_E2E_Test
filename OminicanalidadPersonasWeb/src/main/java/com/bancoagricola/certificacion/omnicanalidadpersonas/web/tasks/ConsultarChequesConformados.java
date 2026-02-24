package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;


import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.AhorrosPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ConsultarChequesConformados implements Task {

    private String referencia;

    public ConsultarChequesConformados(String referencia) {
        this.referencia = referencia;
    }

    @Step("{0} 'valida que se muestre el cheque en base a la referencia #referencia'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(REGISTRO_MOV.of(referencia), isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(REGISTRO_MOV.of(referencia), isClickable()).forNoMoreThan(30).seconds(),
                Click.on(REGISTRO_MOV.of(referencia)),
                WaitUntil.the(DETALLE_MOV_CTA_CORRIENTE, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(DETALLE_MOV_CTA_CORRIENTE, isClickable()).forNoMoreThan(30).seconds(),
                Scroll.to(VER_DOCUMENTO),
                WaitUntil.the(VER_DOCUMENTO, isVisible()).forNoMoreThan(20).seconds(),
                WaitUntil.the(VER_DOCUMENTO, isClickable()).forNoMoreThan(20).seconds(),
                Click.on(VER_DOCUMENTO),
                WaitUntil.the(CERRAR, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(CERRAR, isClickable()).forNoMoreThan(30).seconds(),
                Scroll.to(CERRAR));
    }

    public static ConsultarChequesConformados desdeMovimientos(String referencia) {
        return Instrumented.instanceOf(ConsultarChequesConformados.class).withProperties(referencia);
    }
}
