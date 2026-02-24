package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoVerMasCtaAhorro;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoVerMasCtaCorriente;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.Comprobante365.LABEL_COMPROBANTE;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.GeneralPage.OPCIONES_TRANSFERIR_CTA_DES;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.GeneralPage.RESULTADOS;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion.REFERENCIA_TICKET_VAR;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class RealizarPagoTarjetaCreditoPropiaCuentasCC implements Task {
    private List<Transferencias> datostransferencias;

    public RealizarPagoTarjetaCreditoPropiaCuentasCC(List<Transferencias> datostransferencias) {
        this.datostransferencias = datostransferencias;
    }

    @Step("{0} 'realiza proceso de pago de tarjeta'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias t = datostransferencias.get(0);

        actor.attemptsTo(
                IngresoVerMasCtaCorriente.inicio(datostransferencias.get(0).getCuentaOrigen()),
                WaitUntil.the(OPCION_PAGO_TARJETA, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPCION_PAGO_TARJETA, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(OPCION_PAGO_TARJETA),
                WaitUntil.the(OPCIONES_TRANSFERIR_CTA_DES.of(t.getTarjetaCredito()), isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPCIONES_TRANSFERIR_CTA_DES.of(t.getTarjetaCredito()), isClickable()).forNoMoreThan(80).seconds());
        LeerArchivoProperties.esperar(2);
        actor.attemptsTo(
                Click.on(OPCIONES_TRANSFERIR_CTA_DES.of(t.getTarjetaCredito())),
                WaitUntil.the(TTL_PAGO_TARJ_PROP, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(OPCION_TIPO_PAGO, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPCION_TIPO_PAGO, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(OPCION_TIPO_PAGO),
                WaitUntil.the(OPCION_OTRO_MONTO, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPCION_OTRO_MONTO, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(OPCION_OTRO_MONTO),
                SendKeys.of(t.getMonto()).into(TXT_MONTO_PAGO),
                SendKeys.of(t.getConcepto()).into(TXT_CONCEPTO),
                WaitUntil.the(BTN_CONTINUAR_PAGAR, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_CONTINUAR_PAGAR, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_CONTINUAR_PAGAR),
                WaitUntil.the(BTN_ACEPTAR_C, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_ACEPTAR_C, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_ACEPTAR_C, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_ACEPTAR_C));
        WaitUntil.the(RESULTADOS.of(PAGO_TARJETA_CREDITO_EXITOSO), isVisible()).forNoMoreThan(60).seconds().performAs(actor);

        actor.remember(REFERENCIA_TICKET_VAR.toString(), REFERENCIA_TICKET.resolveFor(actor).getAttribute(TEXT_CONTENT).substring(12).trim());
        System.out.println("Referencia: " + actor.recall(REFERENCIA_TICKET_VAR.toString()).toString());

        /*Comprobante*/
        actor.attemptsTo(
                CapturaComprobanteTarjetaPropiaCuenta.datosC(datostransferencias),
                Scroll.to(LABEL_COMPROBANTE.of(BOTON_IMPRIMIR)).andAlignToTop());
        /*          */
    }

    public static RealizarPagoTarjetaCreditoPropiaCuentasCC datosCompletos(List<Transferencias> datosTransferencias) {
        return Instrumented.instanceOf(RealizarPagoTarjetaCreditoPropiaCuentasCC.class).withProperties(datosTransferencias);
    }
}
