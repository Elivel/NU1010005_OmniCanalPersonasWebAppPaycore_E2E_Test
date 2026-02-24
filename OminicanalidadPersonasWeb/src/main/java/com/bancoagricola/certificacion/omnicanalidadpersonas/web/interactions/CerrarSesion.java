package com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.LoginPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class CerrarSesion implements Interaction {

    @Step("{0} 'realiza proceso para cerrar sesión'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(OPCION_SALIR, isEnabled()).forNoMoreThan(10).seconds(),
                WaitUntil.the(OPCION_SALIR, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(OPCION_SALIR),
                WaitUntil.the(CERRAR_SESION, isVisible()).forNoMoreThan(10).seconds(),
                WaitUntil.the(BOTON_CERRAR_SESION, isEnabled()).forNoMoreThan(10).seconds(),
                WaitUntil.the(BOTON_CERRAR_SESION, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(BOTON_CERRAR_SESION));
        WaitUntil.the(TTL_BIENVENIDO, isVisible()).forNoMoreThan(15).seconds().performAs(actor);
    }

    public static CerrarSesion usuario() {
        return Instrumented.instanceOf(CerrarSesion.class).withProperties();
    }
}
