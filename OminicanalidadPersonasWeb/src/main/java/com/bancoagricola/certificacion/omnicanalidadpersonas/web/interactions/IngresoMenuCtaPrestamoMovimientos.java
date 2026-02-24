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
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class IngresoMenuCtaPrestamoMovimientos implements Interaction {

    private List<Transferencias> datosTransferencias;
    public IngresoMenuCtaPrestamoMovimientos(List<Transferencias> datosDCA) { this.datosTransferencias = datosDCA;}

    @Step("{0} 'ingresa al menú'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias t = datosTransferencias.get(0);
        LeerArchivoProperties.esperar(3);
        actor.attemptsTo(
                WaitUntil.the(MENU_CUENTAS, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(MENU_CUENTAS, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(MENU_CUENTAS),
                WaitUntil.the(VER_MAS_PRODUCTOS.of(t.getNumeroPrestamo()), isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(VER_MAS_PRODUCTOS.of(t.getNumeroPrestamo()), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(VER_MAS_PRODUCTOS.of(t.getNumeroPrestamo())),
                WaitUntil.the(TTL_RESUMEN_PR, isEnabled()).forNoMoreThan(60).seconds());
        LeerArchivoProperties.esperar(2);
        actor.attemptsTo(
                WaitUntil.the(LNK_MOVIMIENTOS, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(LNK_MOVIMIENTOS, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(LNK_MOVIMIENTOS),
                WaitUntil.the(OPC_FILTRAR, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPC_FILTRAR, isEnabled()).forNoMoreThan(60).seconds());
    }

    public static IngresoMenuCtaPrestamoMovimientos inicio(List<Transferencias> datosDCA){
        return Instrumented.instanceOf(IngresoMenuCtaPrestamoMovimientos.class).withProperties(datosDCA);
    }
}