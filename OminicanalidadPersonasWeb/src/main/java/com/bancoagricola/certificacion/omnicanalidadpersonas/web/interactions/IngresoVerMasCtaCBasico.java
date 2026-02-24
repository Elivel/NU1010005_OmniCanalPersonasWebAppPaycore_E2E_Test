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

public class IngresoVerMasCtaCBasico implements Interaction {
    private String cuenta;

    public IngresoVerMasCtaCBasico(String cuenta) {
        this.cuenta = cuenta;
    }

    @Step("{0} 'ingresa al menú'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        LeerArchivoProperties.esperar(3);
        actor.attemptsTo(
                WaitUntil.the(MENU_CUENTAS, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(MENU_CUENTAS, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(MENU_CUENTAS),
                WaitUntil.the(VER_MAS_CUENTA.of(cuenta), isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(VER_MAS_CUENTA.of(cuenta), isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(VER_MAS_CUENTA.of(cuenta), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(VER_MAS_CUENTA.of(cuenta)),
                WaitUntil.the(TTL_RESUMEN_CC, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(TTL_RESUMEN_CC, isEnabled()).forNoMoreThan(60).seconds());
    }

    public static IngresoVerMasCtaCBasico inicio(String cuenta) {
        return Instrumented.instanceOf(IngresoVerMasCtaCBasico.class).withProperties(cuenta);
    }
}
