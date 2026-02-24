package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Meta;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.AhorrosPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.Comprobante365.LABEL_COMPROBANTE;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.REFERENCIA_TICKET;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.BOTON_IMPRIMIR;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.TEXT_CONTENT;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion.REFERENCIA_TICKET_VAR;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class RetiraDeMeta implements Task {
    static double montoAcumuladoAntesRet = 0;
    static double montoAcumuladoDespuesRet = 0;
    static double montoAAdicReti = 0;
    static double resultado = 0;

    private List<Meta> datosmeta;

    public RetiraDeMeta(List<Meta> datosmeta) {
        this.datosmeta = datosmeta;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Meta arm = datosmeta.get(0);

        String montoAcumuladoAntesRet0 = LBL_MONTO_ACUM.of(arm.getNombreMeta()).resolveFor(theActorInTheSpotlight()).getAttribute("innerText");
        montoAcumuladoAntesRet = Double.parseDouble(montoAcumuladoAntesRet0);
        montoAAdicReti = Double.parseDouble(arm.getAporteRetiroMeta());

        actor.attemptsTo(
                Click.on(LNK_RETIRAR.of(arm.getNombreMeta(), ("Retirar"))),
                WaitUntil.the(LBL_RETIRO_META, isVisible()).forNoMoreThan(60).seconds(),
                Scroll.to(MONTO_RETIRAR),
                Clear.field(MONTO_RETIRAR),
                SendKeys.of(arm.getAporteRetiroMeta()).into(MONTO_RETIRAR),
                WaitUntil.the(BTN_RETIRAR, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_RETIRAR, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_RETIRAR),
                WaitUntil.the(BTN_ACEPTAR2, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_ACEPTAR2, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_ACEPTAR2));
        WaitUntil.the(LBL_RETIRO_EXITOSO, isVisible()).forNoMoreThan(60).seconds().performAs(actor);

        actor.remember(REFERENCIA_TICKET_VAR.toString(), REFERENCIA_TICKET.resolveFor(actor).getAttribute(TEXT_CONTENT).substring(12).trim());
        System.out.println("Referencia: " + actor.recall(REFERENCIA_TICKET_VAR.toString()).toString());

        /* Capturar comprobante */
        actor.attemptsTo(
                CapturaComprobanteAporteMeta.datosC(datosmeta),
                Scroll.to(LABEL_COMPROBANTE.of(BOTON_IMPRIMIR)).andAlignToTop());
        /* ------------------- */

        LeerArchivoProperties.esperar2();
        actor.attemptsTo(
                Scroll.to(LBL_IDTRANSACCION).andAlignToTop(),
                WaitUntil.the(LBL_IDTRANSACCION, isVisible()).forNoMoreThan(60).seconds(),
                Scroll.to(BTN_FINALIZAR),
                WaitUntil.the(BTN_FINALIZAR, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_FINALIZAR, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_FINALIZAR),
                WaitUntil.the(LBL_TOTAL_AHORROS_ACUM, isVisible()).forNoMoreThan(60).seconds(),
                Scroll.to(NOMBRE_META.of(arm.getNombreMeta())));
        WaitUntil.the(NOMBRE_META.of(arm.getNombreMeta()), isVisible()).forNoMoreThan(60).seconds().performAs(actor);

        String montoAcumuladoDespuesAdic0 = LBL_MONTO_ACUM.of(arm.getNombreMeta()).resolveFor(theActorInTheSpotlight()).getAttribute("innerText");
        montoAcumuladoDespuesRet = Double.parseDouble(montoAcumuladoDespuesAdic0);
        resultado = montoAcumuladoAntesRet - montoAAdicReti;
        actor.attemptsTo(
                Scroll.to(NOMBRE_META.of(arm.getNombreMeta())).andAlignToTop(),
                Ensure.that(montoAcumuladoDespuesRet).isEqualTo(resultado));
    }

    public static RetiraDeMeta datosMet(List<Meta> datosmeta) {
        return Instrumented.instanceOf(RetiraDeMeta.class).withProperties(datosmeta);
    }
}