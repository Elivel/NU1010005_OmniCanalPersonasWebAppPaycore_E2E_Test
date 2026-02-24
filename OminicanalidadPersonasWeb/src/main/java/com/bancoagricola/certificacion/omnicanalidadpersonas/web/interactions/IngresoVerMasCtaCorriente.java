package com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class IngresoVerMasCtaCorriente implements Interaction {
    private String cuentaOrigen;

    public IngresoVerMasCtaCorriente(String cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }

    @Step("{0} 'ingresa al menú'")
    @Override
    public <T extends Actor> void performAs(T actor) {

        LeerArchivoProperties.esperar(3);
        actor.attemptsTo(
                WaitUntil.the(MENU_CUENTAS, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(MENU_CUENTAS, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(MENU_CUENTAS),
                WaitUntil.the(VER_MAS_CUENTA.of(cuentaOrigen), isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(VER_MAS_CUENTA.of(cuentaOrigen), isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(VER_MAS_CUENTA.of(cuentaOrigen), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(VER_MAS_CUENTA.of(cuentaOrigen)),
                WaitUntil.the(TTL_RESUMEN_CC, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(TTL_RESUMEN_CC, isEnabled()).forNoMoreThan(60).seconds());
    }

    public static IngresoVerMasCtaCorriente inicio(String cuentaOrigen){
        return Instrumented.instanceOf(IngresoVerMasCtaCorriente.class).withProperties(cuentaOrigen);
    }
}
