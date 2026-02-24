package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;


import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;


public class CambioAliasProducto implements Task {

    String CuentadeOrigen;

    public CambioAliasProducto(String cuentadeOrigen) {
        CuentadeOrigen = cuentadeOrigen;
    }

    String subname = "Cambio Alias Prueba";

    @Step("{0} 'Cambio Alias Producto'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(CAMBIO_ALIAS, isVisible()),
                Click.on(CAMBIO_ALIAS),
                WaitUntil.the(INPUT_NOMB_ALIAS, isEnabled()),
                SendKeys.of(subname).into(INPUT_NOMB_ALIAS),
                WaitUntil.the(BTN_CAMBIAR, isClickable()).forNoMoreThan(20).seconds(),
                Click.on(BTN_CAMBIAR),
                WaitUntil.the(NOMBRE_ALIAS_PRODUCTO.of(subname), isVisible()).forNoMoreThan(10).seconds(),
                Ensure.that(NOMBRE_ALIAS_PRODUCTO.of(subname)).isDisplayed(),
                WaitUntil.the(CAMBIO_ALIAS, isVisible()),
                Click.on(CAMBIO_ALIAS),
                WaitUntil.the(INPUT_NOMB_ALIAS, isEnabled()),
                SendKeys.of(CuentadeOrigen).into(INPUT_NOMB_ALIAS),
                WaitUntil.the(BTN_CAMBIAR, isClickable()).forNoMoreThan(20).seconds(),
                Click.on(BTN_CAMBIAR),
                Ensure.that(NOMBRE_ALIAS_PRODUCTO.of(CuentadeOrigen)).isDisplayed()


        );

    }

    public static CambioAliasProducto datos(String CuentaO) {
        return Instrumented.instanceOf(CambioAliasProducto.class).withProperties(CuentaO);
    }
}
