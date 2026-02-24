package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.GeneralPage.RESULTADOS;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class SolicitarTransferenciaInternacionalCC implements Task {

    public static final String SOLICITUD_DE_TRANSFERENCIA_INTERNACIONAL = "Solicitud de transferencia internacional";

    @Step("{0} 'ingresa a Solicitud Transferencia Internacional'")
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(TTL_RESUMEN_CC, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(TTL_RESUMEN_CC, isEnabled()).forNoMoreThan(60).seconds(),
                Scroll.to(TRNSF_DINERO).andAlignToTop(),
                WaitUntil.the(TRNSF_INTERNACIONAL, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(TRNSF_INTERNACIONAL, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(TRNSF_INTERNACIONAL),
                WaitUntil.the(RESULTADOS.of(SOLICITUD_DE_TRANSFERENCIA_INTERNACIONAL), isEnabled()).forNoMoreThan(10).seconds());
    }

    public static SolicitarTransferenciaInternacionalCC inicio() {
    return Instrumented.instanceOf(SolicitarTransferenciaInternacionalCC.class).withProperties();
    }
}
