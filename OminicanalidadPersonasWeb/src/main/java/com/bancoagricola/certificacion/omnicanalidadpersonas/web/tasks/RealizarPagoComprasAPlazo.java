package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoVerMasCtaAhorro;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.Comprobante365.LABEL_COMPROBANTE;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.Comprobante365.REFERENCIA_365;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TarjetasPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.BOTON_IMPRIMIR;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.TEXT_CONTENT;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion.REFERENCIA_TICKET_VAR;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class RealizarPagoComprasAPlazo implements Task {
    private List<Transferencias> datosCAP;

    public RealizarPagoComprasAPlazo(List<Transferencias> datosCAP) {
        this.datosCAP = datosCAP;
    }

    @Step("{0} realiza proceso de pago de compras a plazo")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias cap = datosCAP.get(0);

        actor.attemptsTo(
                IngresoVerMasCtaAhorro.inicio(datosCAP),
                WaitUntil.the(PAGO_TAR_PROP, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(PAGO_TAR_PROP, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(PAGO_TAR_PROP),
                WaitUntil.the(TTL_PAGO_TAR, isEnabled()).forNoMoreThan(60).seconds());
        LeerArchivoProperties.esperar(2);
        actor.attemptsTo(
                WaitUntil.the(SELECC_TARJ.of(cap.getTarjetaCredito()), isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(SELECC_TARJ.of(cap.getTarjetaCredito()), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(SELECC_TARJ.of(cap.getTarjetaCredito())),
                WaitUntil.the(TTL_PAGO_TAR_PROP, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(RADIO_CP, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(RADIO_CP),
                WaitUntil.the(SELECTOR_CP, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(SELECTOR_CP, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(SELECTOR_CP),
                WaitUntil.the(SELEC_CP.of(cap.getCompraPlazo()), isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(SELEC_CP.of(cap.getCompraPlazo()), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(SELEC_CP.of(cap.getCompraPlazo())),
                Scroll.to(LABEL_ULTIMA_FECHA_PAGO).andAlignToTop(),
                WaitUntil.the(SELECTOR_TPAGO, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(SELECTOR_TPAGO, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(SELECTOR_TPAGO),
                WaitUntil.the(SELEC_TPAGO, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(SELEC_TPAGO, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(SELEC_TPAGO),
                SendKeys.of(cap.getMonto()).into(TXT_MONTO),
                SendKeys.of(cap.getConcepto()).into(TXT_CONCEPTO),
                WaitUntil.the(BTN_CONTINUAR_PAGAR, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_CONTINUAR_PAGAR, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_CONTINUAR_PAGAR),
                WaitUntil.the(VTN_EMERG_PP, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BOTON_ACEPTAR_PP, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BOTON_ACEPTAR_PP, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BOTON_ACEPTAR_PP, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BOTON_ACEPTAR_PP));
        LeerArchivoProperties.esperar(5);
        WaitUntil.the(MSG_PAGO_EXITOSO_COMPRA_A_PLAZO, isVisible()).forNoMoreThan(60).seconds().performAs(actor);

        actor.remember(REFERENCIA_TICKET_VAR.toString(), REFERENCIA_TICKET.resolveFor(actor).getAttribute(TEXT_CONTENT).substring(12).trim());
        System.out.println("Referencia: " + actor.recall(REFERENCIA_TICKET_VAR.toString()).toString());

        /*Capturar Comprobante*/
        actor.attemptsTo(
                CapturaComprobanteComprasPlazo.datosC(datosCAP),
                Scroll.to(LABEL_COMPROBANTE.of(BOTON_IMPRIMIR)).andAlignToTop());
        /*      */
        actor.attemptsTo(
                Scroll.to(BTN_FINALIZAR2).andAlignToTop(),
                WaitUntil.the(BTN_FINALIZAR2, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_FINALIZAR2, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_FINALIZAR2),
                EsperaInicial.inicio());
        WaitUntil.the(TOTAL_CUENTAS, isVisible()).forNoMoreThan(60).seconds().performAs(actor);

    }

    public static RealizarPagoComprasAPlazo datosP(List<Transferencias> datosCAP) {
        return Instrumented.instanceOf(RealizarPagoComprasAPlazo.class).withProperties(datosCAP);
    }
}
