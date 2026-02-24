package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.ClickEn;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.EsperarAClick;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.BTN_ACEPTAR_C;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.BTN_CONTINUAR;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.GeneralPage.RESULTADOS;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.ServiciosPage.SELECCIONAR_CTA_ASOCIAR;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.ServiciosPage.VENT_EMERG;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.INTEGRACION_CUENTAS;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class DesintegrarCuentaTDD implements Task {
    private List<Transferencias> datosTransferencias;

    public DesintegrarCuentaTDD(List<Transferencias> datosTransferencias) {
        this.datosTransferencias = datosTransferencias;
    }

    @Step("{0} 'Desasociar cuenta'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias ca = datosTransferencias.get(0);
        actor.attemptsTo(
                EsperarAClick.elElementoConTexto(INTEGRACION_CUENTAS),
                ClickEn.elElementoConTexto(INTEGRACION_CUENTAS),
                WaitUntil.the(RESULTADOS.of(INTEGRACION_CUENTAS), isEnabled()).forNoMoreThan(10).seconds(),
                WaitUntil.the(RESULTADOS.of(INTEGRACION_CUENTAS), isClickable()).forNoMoreThan(10).seconds(),
                Click.on(SELECCIONAR_CTA_ASOCIAR.of(ca.getCuentaOrigen())),
                WaitUntil.the(BTN_CONTINUAR, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(BTN_CONTINUAR, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(BTN_CONTINUAR),
                WaitUntil.the(VENT_EMERG, isVisible()),
                WaitUntil.the(BTN_ACEPTAR_C, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(BTN_ACEPTAR_C, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(BTN_ACEPTAR_C));
    }

    public static DesintegrarCuentaTDD asociada(List<Transferencias> datosDCA) {
        return Instrumented.instanceOf(DesintegrarCuentaTDD.class).withProperties(datosDCA);
    }
}
