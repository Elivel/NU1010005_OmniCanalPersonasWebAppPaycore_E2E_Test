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
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.GeneralPage.OPCION_MENU;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.CUENTAS;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class IngresoMenuCAOrigenMovimientos implements Interaction {

    private List<Transferencias> datosTransferencias;

    public IngresoMenuCAOrigenMovimientos(List<Transferencias> datosDCA) {
        this.datosTransferencias = datosDCA;
    }

    @Step("{0} 'ingresa al menú'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias t = datosTransferencias.get(0);
        LeerArchivoProperties.esperar(3);
        actor.attemptsTo(
                WaitUntil.the(OPCION_MENU.of(CUENTAS), isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPCION_MENU.of(CUENTAS), isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPCION_MENU.of(CUENTAS), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(OPCION_MENU.of(CUENTAS)),
                WaitUntil.the(VER_MAS_CUENTA.of(t.getCuentaOrigen()), isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(VER_MAS_CUENTA.of(t.getCuentaOrigen()), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(VER_MAS_CUENTA.of(t.getCuentaOrigen())),
                WaitUntil.the(TTL_RESUMEN_CA2, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(TTL_RESUMEN_CA2, isEnabled()).forNoMoreThan(60).seconds());
        LeerArchivoProperties.esperar(2);
        actor.attemptsTo(
                WaitUntil.the(LNK_MOVIMIENTOS, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(LNK_MOVIMIENTOS, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(LNK_MOVIMIENTOS, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(LNK_MOVIMIENTOS),
                WaitUntil.the(TTL_MOVIMIENTOS, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(TTL_MOVIMIENTOS, isEnabled()).forNoMoreThan(60).seconds());
    }

    public static IngresoMenuCAOrigenMovimientos inicio(List<Transferencias> datosTransferencias) {
        return Instrumented.instanceOf(IngresoMenuCAOrigenMovimientos.class).withProperties(datosTransferencias);
    }
}
