package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.BTN_PAGAR_OTRO_PRESTAMO;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.GeneralPage.RESULTADOS;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TransferenciasLinksPage.LINK_PAGO_PRESTAMO_TRANSFER365;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class IngresarPagoPrestamoTransfer365 implements Task {

    @Step("{0} 'ingresa a pago de préstamo Transfer365'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(LINK_PAGO_PRESTAMO_TRANSFER365, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(LINK_PAGO_PRESTAMO_TRANSFER365, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(LINK_PAGO_PRESTAMO_TRANSFER365),
                WaitUntil.the(RESULTADOS.of("Pago de préstamo Transfer365: Operaciones entre bancos"), isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(RESULTADOS.of("Pago de préstamo Transfer365: Operaciones entre bancos"), isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_PAGAR_OTRO_PRESTAMO, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(BTN_PAGAR_OTRO_PRESTAMO),
                WaitUntil.the(RESULTADOS.of("Pago de préstamo Transfer365: Operaciones entre bancos"), isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(RESULTADOS.of("Pago de préstamo Transfer365: Operaciones entre bancos"), isEnabled()).forNoMoreThan(60).seconds());
    }

    public static IngresarPagoPrestamoTransfer365 inicio() {
        return Instrumented.instanceOf(IngresarPagoPrestamoTransfer365.class).withProperties();
    }
}
