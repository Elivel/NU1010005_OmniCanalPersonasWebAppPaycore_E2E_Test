package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;


import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TarjetasPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TarjetasPage.FE_TDD;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CapturaCVVyFVTDD implements Task {

    private List<Transferencias> datosTransferencias;

    public CapturaCVVyFVTDD(List<Transferencias> datosDCA) {
        this.datosTransferencias = datosDCA;
    }
    @Step("{0} 'Captura Datos'")
    @Override
    public <T extends Actor> void performAs(T actor) {

        Transferencias ca = datosTransferencias.get(0);
        actor.attemptsTo(
                WaitUntil.the(TTL_RES_DETALLE_TDD, isVisible()).forNoMoreThan(15).seconds(),
                WaitUntil.the(OPC_CVV2_FE, isVisible()).forNoMoreThan(15).seconds(),
                Click.on(OPC_CVV2_FE),
                WaitUntil.the(TTL_CVV2_FE, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(TTL_CVV2_FE, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_MOSTRAR_CVV, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(BTN_MOSTRAR_CVV),
                Ensure.that(CVV_TDD.of(ca.getCvv())).isDisplayed(),
                Ensure.that(FE_TDD.of(ca.getFechaVencimiento())).isDisplayed()
        );
    }

    public static CapturaCVVyFVTDD inicio(List<Transferencias> datosDCA) {
        return Instrumented.instanceOf(CapturaCVVyFVTDD.class).withProperties(datosDCA);
    }
}
