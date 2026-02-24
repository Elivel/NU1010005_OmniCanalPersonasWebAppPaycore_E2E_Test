package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Meta;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.AhorrosPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.Comprobante365.LABEL_COMPROBANTE;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.REFERENCIA_TICKET;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.BOTON_IMPRIMIR;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.TEXT_CONTENT;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion.REFERENCIA_TICKET_VAR;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class AportaAMeta implements Task {
    static double montoAcumuladoAntesAdic = 0;
    static double montoAcumuladoDespuesAdic = 0;
    static double montoAAdicReti = 0;
    static double resultado = 0;

    private List<Meta> datosmeta;

    public AportaAMeta(List<Meta> datosmeta) {
        this.datosmeta = datosmeta;
    }

    @Step("{0} 'realiza proceso para aportar a meta'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Meta arm = datosmeta.get(0);

        String montoAcumuladoAntesAdic0 = LBL_MONTO_ACUM.of(arm.getNombreMeta()).resolveFor(theActorInTheSpotlight()).getAttribute("innerText");
        montoAcumuladoAntesAdic = Double.parseDouble(montoAcumuladoAntesAdic0);
        montoAAdicReti = Double.parseDouble(arm.getAporteRetiroMeta());

        actor.attemptsTo(
                Click.on(LNK_APORTAR.of(arm.getNombreMeta(), ("Aportar"))),
                WaitUntil.the(LBL_APORTE_META, isVisible()).forNoMoreThan(60).seconds(),
                Clear.field(MONTO_GUARDAR),
                SendKeys.of(arm.getAporteRetiroMeta()).into(MONTO_GUARDAR),
                Scroll.to(BTN_GUARDAR),
                WaitUntil.the(BTN_GUARDAR, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_GUARDAR, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_GUARDAR),
                WaitUntil.the(BTN_ACEPTAR2, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_ACEPTAR2, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_ACEPTAR2, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_ACEPTAR2));
        LeerArchivoProperties.esperar(5);
        WaitUntil.the(LBL_ADICION_EXITOSA, isVisible()).forNoMoreThan(60).seconds().performAs(actor);

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
                Scroll.to(NOMBRE_META.of(arm.getNombreMeta())).andAlignToBottom());
        WaitUntil.the(NOMBRE_META.of(arm.getNombreMeta()), isVisible()).forNoMoreThan(60).seconds().performAs(actor);
        String montoAcumuladoDespuesAdic0 = LBL_MONTO_ACUM.of(arm.getNombreMeta()).resolveFor(theActorInTheSpotlight()).getAttribute("innerText");
        montoAcumuladoDespuesAdic = Double.parseDouble(montoAcumuladoDespuesAdic0);
        resultado = montoAAdicReti + montoAcumuladoAntesAdic;
        Ensure.that(montoAcumuladoDespuesAdic).isEqualTo(resultado).performAs(actor);
        System.out.println("MontoAcum: " + montoAcumuladoDespuesAdic);
        System.out.println("Res: " + resultado);
        actor.attemptsTo(
                Scroll.to(NOMBRE_META.of(arm.getNombreMeta())).andAlignToTop(),
                Ensure.that(montoAcumuladoDespuesAdic).isEqualTo(resultado));

    }

    public static AportaAMeta datosMet(List<Meta> datosmeta) {
        return Instrumented.instanceOf(AportaAMeta.class).withProperties(datosmeta);
    }
}