package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.TEXT_CONTENT;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ProcesoConsultaTodosLosCheques implements Task {
    private List<Transferencias> datosDCA;

    public ProcesoConsultaTodosLosCheques(List<Transferencias> datosDCA) {
        this.datosDCA = datosDCA;
    }

    @Step("{0} 'realiza proceso para consulta de todos los cheques'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias ca = datosDCA.get(0);
        actor.attemptsTo(
                Scroll.to(GESTION_CHEQUERAS));
        LeerArchivoProperties.esperar(1);
        actor.attemptsTo(
                WaitUntil.the(GESTION_CHEQUERAS, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(GESTION_CHEQUERAS, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(CONSULTA_CHEQUERAS, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(CONSULTA_CHEQUERAS, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(CONSULTA_CHEQUERAS),
                WaitUntil.the(TT_CONSULTA_CHEQUERAS, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(TT_CONSULTA_CHEQUERAS, isEnabled()).forNoMoreThan(60).seconds());
        LeerArchivoProperties.esperar(1);
        actor.attemptsTo(
                WaitUntil.the(SELECCIONA_CHEQUERA.of(ca.getChequera()), isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(SELECCIONA_CHEQUERA.of(ca.getChequera()), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(SELECCIONA_CHEQUERA.of(ca.getChequera())),
                WaitUntil.the(CONSUL_CHQUES, isVisible()).forNoMoreThan(60).seconds());
        actor.remember(VariablesSesion.TOTALCHEQUES.toString(), TOTAL_CHEQ.resolveFor(actor).getAttribute(TEXT_CONTENT));
        LeerArchivoProperties.esperar(1);
        actor.attemptsTo(
                WaitUntil.the(ESTADO_CHEQ, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(ESTADO_CHEQ, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(ESTADO_CHEQ, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(ESTADO_CHEQ),
                WaitUntil.the(ESTADO_LIST.of(ca.getEstadoCheques()), isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(ESTADO_LIST.of(ca.getEstadoCheques()), isClickable()).forNoMoreThan(30).seconds(),
                Click.on(ESTADO_LIST.of(ca.getEstadoCheques())),
                Scroll.to(LBL_ESTADO_CHEQ).andAlignToTop());
        WaitUntil.the(N_CHEQUE, isVisible()).forNoMoreThan(30).seconds().performAs(actor);
        System.out.println("total: " + Integer.parseInt(actor.recall(VariablesSesion.TOTALCHEQUES.toString())));
        System.out.println("total tabla: " + REG_TAB_CHEQ.resolveAllFor(actor).size());
    }

    public static ProcesoConsultaTodosLosCheques datosCA(List<Transferencias> datosDCA) {
        return Instrumented.instanceOf(ProcesoConsultaTodosLosCheques.class).withProperties(datosDCA);
    }
}