package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TarjetasPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ProcesoEstadoCuentaTC implements Task {
    private List<Transferencias> datosDCA;

    public ProcesoEstadoCuentaTC(List<Transferencias> datosDCA) {
        this.datosDCA = datosDCA;
    }

    @Step("{0} 'realiza proceso para generar estado de cuenta para tarjeta de crédito'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias ca = datosDCA.get(0);
        actor.attemptsTo(
                Scroll.to(OPERACIONES).andAlignToTop(),
                WaitUntil.the(ESTA_CUENTA_TC, isCurrentlyVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(ESTA_CUENTA_TC, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(ESTA_CUENTA_TC, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(ESTA_CUENTA_TC),
                WaitUntil.the(TTL_ESTA_CUENTA_TC, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(MES_ANO, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(MES_ANO, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(MES_ANO),
                WaitUntil.the(OPC_MES_ANO.of(ca.getPeriodo()), isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPC_MES_ANO.of(ca.getPeriodo()), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(OPC_MES_ANO.of(ca.getPeriodo())),
                WaitUntil.the(BTN_CONSULTAR, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_CONSULTAR, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_CONSULTAR),
                WaitUntil.the(PDF_ESTADO_CUENTA, isClickable()).forNoMoreThan(60).seconds(),
                Ensure.that(PDF_ESTADO_CUENTA).isDisplayed(),
                Scroll.to(DESCARGAR).andAlignToTop(),
                WaitUntil.the(DESCARGAR, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(DESCARGAR, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(DESCARGAR));
    }

    public static ProcesoEstadoCuentaTC datosCA(List<Transferencias> datosDCA) {
        return Instrumented.instanceOf(ProcesoEstadoCuentaTC.class).withProperties(datosDCA);
    }
}