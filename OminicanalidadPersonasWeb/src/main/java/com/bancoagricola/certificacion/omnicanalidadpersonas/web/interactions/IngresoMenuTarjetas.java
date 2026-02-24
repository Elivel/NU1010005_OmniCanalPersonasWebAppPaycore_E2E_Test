package com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TarjetasPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class IngresoMenuTarjetas implements Interaction {
    private List<Transferencias> datosTransferencias;

    public IngresoMenuTarjetas(List<Transferencias> datosDCA) {
        this.datosTransferencias = datosDCA;
    }

    @Step("{0} 'ingresa al menú'")
    @Override
    public <T extends Actor> void performAs(T actor) {

        Transferencias ca = datosTransferencias.get(0);
        actor.attemptsTo(
                WaitUntil.the(MENU_VERTICAL, isEnabled()).forNoMoreThan(15).seconds(),
                WaitUntil.the(MENU_VERTICAL, isClickable()).forNoMoreThan(15).seconds(),
                WaitUntil.the(MENU_TARJETAS, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(MENU_TARJETAS, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(MENU_TARJETAS),
                WaitUntil.the(VER_MAS_CUENTA_TC.of(ca.getTarjetaDebito()), isEnabled()).forNoMoreThan(60).seconds(),
                Click.on(VER_MAS_CUENTA_TC.of(ca.getTarjetaDebito()))

        );

    }

    public static IngresoMenuTarjetas inicio(List<Transferencias> datosDCA) {
        return Instrumented.instanceOf(IngresoMenuTarjetas.class).withProperties(datosDCA);
    }
}
