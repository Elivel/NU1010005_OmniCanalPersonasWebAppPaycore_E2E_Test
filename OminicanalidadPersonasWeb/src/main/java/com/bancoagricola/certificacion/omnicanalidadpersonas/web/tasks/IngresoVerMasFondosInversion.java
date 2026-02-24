package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.EsperarVisibilidad;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.AhorrosPage.MENU_PRINC;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class IngresoVerMasFondosInversion implements Task {
    private String fondoInversion;

    public IngresoVerMasFondosInversion(String fondoInversion) {
        this.fondoInversion = fondoInversion;
    }

    @Step("{0} 'ingresa al menú'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(MENU_PRINC, isEnabled()).forNoMoreThan(80).seconds(),
                WaitUntil.the(MENU_CUENTAS, isEnabled()).forNoMoreThan(80).seconds(),
                WaitUntil.the(MENU_CUENTAS, isClickable()).forNoMoreThan(80).seconds(),
                Click.on(MENU_CUENTAS),
                WaitUntil.the(VER_MAS_FONDO.of(fondoInversion), isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(VER_MAS_FONDO.of(fondoInversion), isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(VER_MAS_FONDO.of(fondoInversion), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(VER_MAS_FONDO.of(fondoInversion)),
                EsperarVisibilidad.elElementoConTexto("Resumen de fondo de inversión"));
    }

    public static IngresoVerMasFondosInversion inicio(String fondoInversion) {
        return Instrumented.instanceOf(IngresoVerMasFondosInversion.class).withProperties(fondoInversion);

    }
}
