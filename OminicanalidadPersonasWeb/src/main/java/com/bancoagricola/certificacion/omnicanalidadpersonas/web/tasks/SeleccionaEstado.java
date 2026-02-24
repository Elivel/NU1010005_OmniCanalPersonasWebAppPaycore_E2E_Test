package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.ServiciosPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class SeleccionaEstado implements Task {
    private List<Transferencias> datosAud;
    public SeleccionaEstado(List<Transferencias> datosAud) {
        this.datosAud = datosAud;
    }

    @Step("{0} 'selecciona estado'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias aud = datosAud.get(0);
        actor.attemptsTo(
                WaitUntil.the(OPC_ESTADO_CMB, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(OPC_ESTADO_CMB, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(OPC_ESTADO_CMB),
                WaitUntil.the(SELECCIONA_OPC.of(aud.getEstadoTRX()), isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(SELECCIONA_OPC.of(aud.getEstadoTRX()), isClickable()).forNoMoreThan(30).seconds(),
                Click.on(SELECCIONA_OPC.of(aud.getEstadoTRX())));
    }

    public static SeleccionaEstado datosAud(List<Transferencias> datosAud) {
        return Instrumented.instanceOf(SeleccionaEstado.class).withProperties(datosAud);
    }
}