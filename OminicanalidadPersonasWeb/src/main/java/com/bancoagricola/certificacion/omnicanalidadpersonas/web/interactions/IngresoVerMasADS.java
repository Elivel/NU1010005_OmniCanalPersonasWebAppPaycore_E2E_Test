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

public class IngresoVerMasADS implements Interaction {

    private List<Transferencias> datosTransferencias;
    public IngresoVerMasADS(List<Transferencias> datosDCA) { this.datosTransferencias = datosDCA;}

    @Step("{0} 'ingresa al menú'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias t = datosTransferencias.get(0);
        LeerArchivoProperties.esperar(3);
        actor.attemptsTo(
                WaitUntil.the(MENU_CUENTAS, isEnabled()).forNoMoreThan(80).seconds(),
                WaitUntil.the(MENU_CUENTAS, isClickable()).forNoMoreThan(80).seconds(),
                Click.on(MENU_CUENTAS),
                WaitUntil.the(VER_MAS_CUENTA.of(t.getCuentaOrigen()), isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(VER_MAS_CUENTA.of(t.getCuentaOrigen()), isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(VER_MAS_CUENTA.of(t.getCuentaOrigen()), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(VER_MAS_CUENTA.of(t.getCuentaOrigen())),
                WaitUntil.the(TTL_RESUMEN_ADS, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(TTL_RESUMEN_ADS, isEnabled()).forNoMoreThan(60).seconds());
    }

    public static IngresoVerMasADS inicio(List<Transferencias> datosDCA){
        return Instrumented.instanceOf(IngresoVerMasADS.class).withProperties(datosDCA);
    }
}
