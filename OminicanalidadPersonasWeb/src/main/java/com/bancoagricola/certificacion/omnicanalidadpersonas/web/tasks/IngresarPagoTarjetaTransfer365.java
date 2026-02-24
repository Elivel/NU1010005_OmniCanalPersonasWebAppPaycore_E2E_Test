package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.BOTON_PAGAR_OTRA_TARJETA;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.GeneralPage.RESULTADOS;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TransferenciasLinksPage.LINK_PAGO_TARJETA_TRANSFER365;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class IngresarPagoTarjetaTransfer365 implements Task {

    @Step("{0} 'ingresa a pago de tarjeta Transfer365'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(LINK_PAGO_TARJETA_TRANSFER365, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(LINK_PAGO_TARJETA_TRANSFER365, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(LINK_PAGO_TARJETA_TRANSFER365),
                WaitUntil.the(RESULTADOS.of("Pago de tarjeta Transfer365: Operaciones entre bancos"), isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(RESULTADOS.of("Pago de tarjeta Transfer365: Operaciones entre bancos"), isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(BOTON_PAGAR_OTRA_TARJETA, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(BOTON_PAGAR_OTRA_TARJETA, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(BOTON_PAGAR_OTRA_TARJETA),
                WaitUntil.the(RESULTADOS.of("Pago de tarjeta Transfer365: Operaciones entre bancos"), isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(RESULTADOS.of("Pago de tarjeta Transfer365: Operaciones entre bancos"), isVisible()).forNoMoreThan(30).seconds());
    }

    public static IngresarPagoTarjetaTransfer365 inicio() {
        return Instrumented.instanceOf(IngresarPagoTarjetaTransfer365.class).withProperties();
    }

}
