package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Meta;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.AhorrosPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.AhorrosPage.BTN_ACEPTAR;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.Comprobante365.LABEL_COMPROBANTE;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.REFERENCIA_TICKET;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.BOTON_IMPRIMIR;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.TEXT_CONTENT;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion.REFERENCIA_TICKET_VAR;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class EliminaMeta implements Task {
    private List<Meta> datosmeta;

    public EliminaMeta(List<Meta> datosmeta) {
        this.datosmeta = datosmeta;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Meta em = datosmeta.get(0);
        actor.attemptsTo(
                WaitUntil.the(LNK_VER_MAS.of(em.getNombreMeta()), isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(LNK_VER_MAS.of(em.getNombreMeta()), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(LNK_VER_MAS.of(em.getNombreMeta())),
                WaitUntil.the(TITLE_RES_META, isVisible()).forNoMoreThan(60).seconds());
        LeerArchivoProperties.esperar(3);
        actor.attemptsTo(
                WaitUntil.the(LNK_ELIMINAR_M, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(LNK_ELIMINAR_M, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(LNK_ELIMINAR_M),
                WaitUntil.the(BTN_ACEPTAR2, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(BTN_ACEPTAR2, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_ACEPTAR2, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_ACEPTAR2));
        LeerArchivoProperties.esperar(7);
        WaitUntil.the(LBL_META_ELIMINADA, isVisible()).forNoMoreThan(60).seconds().performAs(actor);

        actor.remember(REFERENCIA_TICKET_VAR.toString(), REFERENCIA_TICKET.resolveFor(actor).getAttribute(TEXT_CONTENT).substring(12).trim());
        System.out.println("Referencia: " + actor.recall(REFERENCIA_TICKET_VAR.toString()).toString());

        /* Capturar comprobante */
        actor.attemptsTo(
                CapturaComprobanteModificarMeta.datosC(datosmeta),
                Scroll.to(LABEL_COMPROBANTE.of(BOTON_IMPRIMIR)).andAlignToTop());
        /* ------------------- */

        actor.attemptsTo(
                Scroll.to(LBL_IDTRANSACCION).andAlignToTop(),
                WaitUntil.the(LBL_IDTRANSACCION, isVisible()).forNoMoreThan(60).seconds(),
                Scroll.to(BTN_FINALIZAR),
                WaitUntil.the(BTN_FINALIZAR, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_FINALIZAR, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_FINALIZAR),
                WaitUntil.the(LBL_TOTAL_AHORROS_ACUM, isVisible()).forNoMoreThan(60).seconds());
    }

    public static EliminaMeta datosMet(List<Meta> datosmeta) {
        return Instrumented.instanceOf(EliminaMeta.class).withProperties(datosmeta);
    }
}