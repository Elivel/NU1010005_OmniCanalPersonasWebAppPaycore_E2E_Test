package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.ClickEn;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.EsperarAClick;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.BTN_ACEPTAR_C;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.BTN_CONTINUAR;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.GeneralPage.RESULTADOS;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.ServiciosPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.INTEGRACION_CUENTAS;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class DesintegrarCuenta implements Task {
    private String ctaAsociar;

    public DesintegrarCuenta(String ctaAsociar) {
        this.ctaAsociar = ctaAsociar;
    }

    @Step("{0} 'Desasociar cuenta'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                EsperarAClick.elElementoConTexto(INTEGRACION_CUENTAS),
                ClickEn.elElementoConTexto(INTEGRACION_CUENTAS),
                WaitUntil.the(RESULTADOS.of(INTEGRACION_CUENTAS), isEnabled()).forNoMoreThan(10).seconds(),
                WaitUntil.the(RESULTADOS.of(INTEGRACION_CUENTAS), isClickable()).forNoMoreThan(10).seconds(),
                Click.on(SELECCIONAR_CTA_ASOCIAR.of(ctaAsociar)),
                WaitUntil.the(BTN_CONTINUAR, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(BTN_CONTINUAR, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(BTN_CONTINUAR),
                WaitUntil.the(VENT_EMERG, isVisible()),
                WaitUntil.the(BTN_ACEPTAR_C, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(BTN_ACEPTAR_C, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(BTN_ACEPTAR_C));
    }

    public static DesintegrarCuenta asociada(String ctaAsociar) {
        return Instrumented.instanceOf(DesintegrarCuenta.class).withProperties(ctaAsociar);
    }
}
