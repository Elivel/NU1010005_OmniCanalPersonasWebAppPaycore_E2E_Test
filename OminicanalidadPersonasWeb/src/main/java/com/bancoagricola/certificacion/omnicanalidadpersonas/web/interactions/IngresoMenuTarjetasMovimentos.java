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

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TarjetasPage.*;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class IngresoMenuTarjetasMovimentos implements Interaction {

    private List<Transferencias> datosTransferencias;

    public IngresoMenuTarjetasMovimentos(List<Transferencias> datostransferencias) {
        this.datosTransferencias = datostransferencias;
    }

    @Step("{0} 'ingresa al menú'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias t = datosTransferencias.get(0);
        LeerArchivoProperties.esperar(3);
        actor.attemptsTo(
                WaitUntil.the(MENU_VERTICAL, isEnabled()).forNoMoreThan(15).seconds(),
                WaitUntil.the(MENU_VERTICAL,isClickable()).forNoMoreThan(15).seconds(),
                WaitUntil.the(MENU_TARJETAS, isEnabled()).forNoMoreThan(80).seconds(),
                WaitUntil.the(MENU_TARJETAS, isClickable()).forNoMoreThan(80).seconds(),
                Click.on(MENU_TARJETAS),
                WaitUntil.the(VER_MAS_CUENTA_TC.of(t.getTarjetaCredito()), isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(VER_MAS_CUENTA_TC.of(t.getTarjetaCredito()), isClickable()).forNoMoreThan(400).seconds(),
                Click.on(VER_MAS_CUENTA_TC.of(t.getTarjetaCredito())),
                WaitUntil.the(TTL_RESUMEN_TC, isCurrentlyVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(LNK_MOVIMIENTOS, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(LNK_MOVIMIENTOS, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(LNK_MOVIMIENTOS, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(LNK_MOVIMIENTOS),
                WaitUntil.the(TTL_MOVIMIENTOS, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(TTL_MOVIMIENTOS, isEnabled()).forNoMoreThan(60).seconds());
    }

    public static IngresoMenuTarjetasMovimentos inicio(List<Transferencias> datostransferencias) {
        return Instrumented.instanceOf(IngresoMenuTarjetasMovimentos.class).withProperties(datostransferencias);
    }
}
