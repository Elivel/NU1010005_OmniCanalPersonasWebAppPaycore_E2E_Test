package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.ServiciosPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class SeleccionaCanal implements Task {
    private List<Transferencias> datosAud;
    public SeleccionaCanal(List<Transferencias> datosAud) {
        this.datosAud = datosAud;
    }

    @Step("{0} 'selecciona canal y realiza validación'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias aud = datosAud.get(0);
        actor.attemptsTo(
                WaitUntil.the(OP_CANAL_CMB, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(OP_CANAL_CMB, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(OP_CANAL_CMB),
                WaitUntil.the(SELECCIONA_OPC.of(aud.getCanal()), isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(SELECCIONA_OPC.of(aud.getCanal()), isClickable()).forNoMoreThan(30).seconds(),
                Click.on(SELECCIONA_OPC.of(aud.getCanal())),
                WaitUntil.the(BTN_BUSCAR, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(BTN_BUSCAR, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(BTN_BUSCAR),
                Scroll.to(BTN_FILTRAR).andAlignToTop());
    }

    public static SeleccionaCanal datosAud(List<Transferencias> datosAud) {
        return Instrumented.instanceOf(SeleccionaCanal.class).withProperties(datosAud);
    }
}