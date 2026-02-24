package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.ClickEn;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.EsperarAClick;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.EsperarVisibilidad;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ProcesoConsultaChequeSuspendido implements Task {

    private List<Transferencias> datosCheque;

    public ProcesoConsultaChequeSuspendido(List<Transferencias> datosCheque) {
        this.datosCheque = datosCheque;
    }

    @Step("{0} 'realiza proceso de consulta'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias ca = datosCheque.get(0);
        actor.attemptsTo(
                Scroll.to(CONSULTA_CHEQUERAS).andAlignToBottom(),
                WaitUntil.the(CONSULTA_CHEQUERAS, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(CONSULTA_CHEQUERAS, isEnabled()).forNoMoreThan(60).seconds(),
                EsperarAClick.elElementoConTexto("Cheques suspendidos"),
                ClickEn.elElementoConTexto("Cheques suspendidos"),
                EsperarVisibilidad.elElementoConTexto("Consulta de cheques suspendidos"));
        WaitUntil.the(MOV_CONS_CHEQ_SUSPENDIDOS, isVisible()).forNoMoreThan(30).seconds().performAs(actor);
        actor.remember(VariablesSesion.REFERENCIA.toString(), REFERENCIA_CHEQ.of(ca.getReferenciaCheque()).resolveAllFor(actor).size());
        int ReferenciaCheque = Integer.parseInt(actor.recall(VariablesSesion.REFERENCIA.toString()).toString());
        System.out.println("Cantidad cheques suspendidos: " + ReferenciaCheque);
    }

    public static ProcesoConsultaChequeSuspendido lote(List<Transferencias> datosCheque) {
        return Instrumented.instanceOf(ProcesoConsultaChequeSuspendido.class).withProperties(datosCheque);
    }
}