package com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.AhorrosPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TarjetasPage.MENU_VERTICAL;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class IngresoVerMasAhorroProgramado implements Interaction {

    private List<Transferencias> datosTransferencias;

    public IngresoVerMasAhorroProgramado(List<Transferencias> datosDCA) {
        this.datosTransferencias = datosDCA;
    }

    @Step("{0} 'ingresa al menú'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias t = datosTransferencias.get(0);
        LeerArchivoProperties.esperar(3);
        actor.attemptsTo(
                WaitUntil.the(MENU_VERTICAL, isEnabled()).forNoMoreThan(15).seconds(),
                WaitUntil.the(MENU_VERTICAL, isClickable()).forNoMoreThan(15).seconds(),
                WaitUntil.the(MENU_AHORROS, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(MENU_AHORROS, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(MENU_AHORROS),
                WaitUntil.the(TOTAL_AHORROS_ACUMULADOS, isCurrentlyVisible()).forNoMoreThan(60).seconds()
        );
    }

    public static IngresoVerMasAhorroProgramado inicio(List<Transferencias> datosDCA) {
        return Instrumented.instanceOf(IngresoVerMasAhorroProgramado.class).withProperties(datosDCA);
    }
}
