package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.ClickEn;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoMenuCtaAhorroOrigenMovimientos;
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
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.Comprobante365.LABEL_COMPROBANTE;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.GeneralPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion.REFERENCIA_TICKET_VAR;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class RealizarPagoTarjeta implements Task {
    private List<Transferencias> datostransferencias;

    public RealizarPagoTarjeta(List<Transferencias> datostransferencias) {
        this.datostransferencias = datostransferencias;
    }
    @Step("{0} realiza proceso de pago de tarjeta de tercero")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias t = datostransferencias.get(0);

        actor.attemptsTo(
                IngresoVerMasCtaAhorro.inicio(datostransferencias),
                WaitUntil.the(OPCION_PAGO_TARJETA, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPCION_PAGO_TARJETA, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(OPCION_PAGO_TARJETA),
                WaitUntil.the(RESULTADOS.of(PAGAR_TARJETA_TERCEROS), isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(RESULTADOS.of(PAGAR_TARJETA_TERCEROS), isClickable()).forNoMoreThan(60).seconds(),
                ClickEn.elElementoConTexto(PAGAR_TARJETA_TERCEROS),
                WaitUntil.the(TTL_PAGO_TARJ_TER, isVisible()).forNoMoreThan(60).seconds(),
                SendKeys.of(t.getTarjetaCreditoTercero()).into(TXT_NUMERO_CUENTA),
                SendKeys.of(t.getCorreo()).into(TXT_CORREO),
                SendKeys.of(t.getMonto()).into(TXT_MONTO_PAGO),
                SendKeys.of(t.getConcepto()).into(TXT_CONCEPTO),
                WaitUntil.the(BTN_CONTINUAR_PAGAR, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_CONTINUAR_PAGAR, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_CONTINUAR_PAGAR),
                WaitUntil.the(BTN_ACEPTAR_C, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_ACEPTAR_C, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_ACEPTAR_C, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_ACEPTAR_C));
        LeerArchivoProperties.esperar(15);
        WaitUntil.the(RESULTADOS.of(PAGO_TARJETA_EXITOSO), isVisible()).forNoMoreThan(60).seconds().performAs(actor);
        LeerArchivoProperties.esperar(1);

        actor.remember(REFERENCIA_TICKET_VAR.toString(), REFERENCIA_TICKET.resolveFor(actor).getAttribute(TEXT_CONTENT).substring(12).trim());
        System.out.println("Referencia: " + actor.recall(REFERENCIA_TICKET_VAR.toString()).toString());

        /*Comprobante*/
        actor.attemptsTo(
                CapturaComprobanteTarjetaTercero.datosC(datostransferencias),
                Scroll.to(LABEL_COMPROBANTE.of(BOTON_IMPRIMIR)).andAlignToTop());
        /*          */
        LeerArchivoProperties.esperar(1);
        actor.attemptsTo(
                Scroll.to(BTN_FINALIZAR2).andAlignToTop(),
                WaitUntil.the(BTN_FINALIZAR2, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_FINALIZAR2, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_FINALIZAR2),
                EsperaInicial.inicio(),
                IngresoMenuCtaAhorroOrigenMovimientos.inicio(datostransferencias),
                ValidaReferenciaTicketCuentaAhorro.conLaReferencia());
        actor.remember(VariablesSesion.MONTO_CUENTA_ORIGEN_FINAL.toString(), OBTENER_SALDO.resolveFor(actor).getText());
    }

    public static RealizarPagoTarjeta datosCompletos(List<Transferencias> datostransferencias) {
        return Instrumented.instanceOf(RealizarPagoTarjeta.class).withProperties(datostransferencias);
    }

}
