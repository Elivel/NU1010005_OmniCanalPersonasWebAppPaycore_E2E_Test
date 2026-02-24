package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.ClickEn;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.AhorrosPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.GeneralPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ProgramarTransferencia implements Task {
    private List<Transferencias> datosTransferencia;

    public ProgramarTransferencia(List<Transferencias> datosTransferencia) {
        this.datosTransferencia = datosTransferencia;
    }

    @Step("{0} 'programa una transferencia para el dia siguiente'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(OPCIONES_TRANSFERENCIAS.of(TRANSFERIR), isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPCIONES_TRANSFERENCIAS.of(TRANSFERIR), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(OPCIONES_TRANSFERENCIAS.of(TRANSFERIR)),
                WaitUntil.the(OPCIONES_TRANSFERIR_CTA_DES.of(datosTransferencia.get(0).getCuentaDestino()), isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPCIONES_TRANSFERIR_CTA_DES.of(datosTransferencia.get(0).getCuentaDestino()), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(OPCIONES_TRANSFERIR_CTA_DES.of(datosTransferencia.get(0).getCuentaDestino())),
                SendKeys.of(datosTransferencia.get(0).getMonto()).into(TXT_MONTO),
                SendKeys.of(datosTransferencia.get(0).getConcepto()).into(TXT_CONCEPTO),
                WaitUntil.the(ACTIVAR_FECHA_EJECUCION, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(ACTIVAR_FECHA_EJECUCION, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(ACTIVAR_FECHA_EJECUCION),
                Scroll.to(GUARDAR_COMO_PLANTILLA_FOR),
                ClickEn.elElementoConTexto("En una fecha futura"),
                WaitUntil.the(BTN_TRANSFERIR1, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_TRANSFERIR1, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_TRANSFERIR1));
        WaitUntil.the(CONFIRMACION_AGENDADA, isVisible()).forNoMoreThan(30).seconds().performAs(actor);
        actor.attemptsTo(
                ValidaTicketCreacionTransaccionProgramada.datosCorrectos(datosTransferencia),
                WaitUntil.the(MENU_PRINC, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(MENU_PRINC, isClickable()).forNoMoreThan(60).seconds(),
                Scroll.to(BTN_FINALIZAR).andAlignToTop(),
                WaitUntil.the(BTN_FINALIZAR, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(BTN_FINALIZAR, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(BTN_FINALIZAR));
    }

    public static ProgramarTransferencia diaSiguiente(List<Transferencias> datosTransferencia) {
        return Instrumented.instanceOf(ProgramarTransferencia.class).withProperties(datosTransferencia);
    }
}
