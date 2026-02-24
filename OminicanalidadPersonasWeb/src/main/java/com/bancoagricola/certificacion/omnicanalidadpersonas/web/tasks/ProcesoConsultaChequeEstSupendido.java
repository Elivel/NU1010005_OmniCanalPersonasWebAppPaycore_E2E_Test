package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ProcesoConsultaChequeEstSupendido implements Task {
    private List<Transferencias> datosCheque;
    public ProcesoConsultaChequeEstSupendido(List<Transferencias> datosCheque) {
        this.datosCheque = datosCheque;
    }

    @Step("{0} 'consulta cheque en estado suspendido'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(GESTION_CHEQUERAS).andAlignToTop(),
                WaitUntil.the(GESTION_CHEQUERAS, isCurrentlyVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(CONSULTA_CHEQUERAS, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(CONSULTA_CHEQUERAS, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(CONSULTA_CHEQUERAS),
                WaitUntil.the(TT_CONSULTA_CHEQUERAS, isCurrentlyVisible()).forNoMoreThan(60).seconds(),
                Scroll.to(SELECCIONA_CHEQUERA.of(datosCheque.get(0).getChequera())).andAlignToBottom(),
                WaitUntil.the(SELECCIONA_CHEQUERA.of(datosCheque.get(0).getChequera()), isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(SELECCIONA_CHEQUERA.of(datosCheque.get(0).getChequera()), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(SELECCIONA_CHEQUERA.of(datosCheque.get(0).getChequera())),
                WaitUntil.the(CONSUL_CHQUES, isVisible()).forNoMoreThan(60).seconds(),
                Scroll.to(ESTADO_CHEQ).andAlignToBottom(),
                WaitUntil.the(ESTADO_CHEQ, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(ESTADO_CHEQ, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(ESTADO_CHEQ),
                WaitUntil.the(ESTADO_LIST.of(datosCheque.get(0).getEstadoCheques()), isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(ESTADO_LIST.of(datosCheque.get(0).getEstadoCheques()), isClickable()).forNoMoreThan(30).seconds(),
                Click.on(ESTADO_LIST.of(datosCheque.get(0).getEstadoCheques())),
                Scroll.to(N_CHEQUE).andAlignToTop(),
                WaitUntil.the(N_CHEQUE, isVisible()));

        System.out.println("total resultado cheques Revocados: " + REG_TAB_CHEQ.resolveAllFor(actor).size());

    }

    public static ProcesoConsultaChequeEstSupendido lote(List<Transferencias> datosCheque) {
        return Instrumented.instanceOf(ProcesoConsultaChequeEstSupendido.class).withProperties(datosCheque);
    }

}