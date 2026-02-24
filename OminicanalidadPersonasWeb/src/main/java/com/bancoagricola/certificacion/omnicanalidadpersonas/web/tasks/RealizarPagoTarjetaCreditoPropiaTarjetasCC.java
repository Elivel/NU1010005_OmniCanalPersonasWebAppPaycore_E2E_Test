package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoMenuCtaAhorroOrigenMovimientos;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoMenuCtaCorrienteOrigenMovimientos;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoVerMasTarjetas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
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

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.AhorrosPage.MENU_PRINC;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.Comprobante365.LABEL_COMPROBANTE;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.GeneralPage.RESULTADOS;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TarjetasPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion.REFERENCIA_TICKET_VAR;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class RealizarPagoTarjetaCreditoPropiaTarjetasCC implements Task {
    private List<Transferencias> datostransferencias;

    public RealizarPagoTarjetaCreditoPropiaTarjetasCC(List<Transferencias> datostransferencias) {
        this.datostransferencias = datostransferencias;
    }
    @Step("{0} 'realiza proceso de pago de tarjeta'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias t = datostransferencias.get(0);
        actor.attemptsTo(
                IngresoVerMasTarjetas.inicio(datostransferencias),
                WaitUntil.the(OPCION_PAGO_TARJETA1, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPCION_PAGO_TARJETA1, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(OPCION_PAGO_TARJETA1),
                WaitUntil.the(SELECCIONAR_CUENTA_ORIGEN1, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(SELECCIONAR_CUENTA_ORIGEN1, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(SELECCIONAR_CUENTA_ORIGEN1),
                WaitUntil.the(SELECCIONAR_CUENTA_ORIGEN.of(t.getCuentaOrigen()), isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(SELECCIONAR_CUENTA_ORIGEN.of(t.getCuentaOrigen()), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(SELECCIONAR_CUENTA_ORIGEN.of(t.getCuentaOrigen())),
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
                Click.on(BTN_ACEPTAR_C),
                WaitUntil.the(MENU_PRINC, isEnabled()).forNoMoreThan(60).seconds());
                WaitUntil.the(RESULTADOS.of(PAGO_TARJETA_CREDITO_EXITOSO), isVisible()).forNoMoreThan(60).seconds().performAs(actor);

        actor.remember(REFERENCIA_TICKET_VAR.toString(), REFERENCIA_TICKET.resolveFor(actor).getAttribute(TEXT_CONTENT).substring(12).trim());
        System.out.println("Referencia: " + actor.recall(REFERENCIA_TICKET_VAR.toString()).toString());

        actor.attemptsTo(
                CapturaComprobanteTarjetaPropiaCuenta.datosC(datostransferencias),
                Scroll.to(LABEL_COMPROBANTE.of(BOTON_IMPRIMIR)).andAlignToTop());


        actor.attemptsTo(
                IngresoMenuCtaCorrienteOrigenMovimientos.inicio(datostransferencias),
                ValidaReferenciaTicketCuentaAhorro.conLaReferencia());
        actor.remember(VariablesSesion.MONTO_CUENTA_ORIGEN_FINAL.toString(), OBTENER_SALDO.resolveFor(actor).getText());
   }

    public static RealizarPagoTarjetaCreditoPropiaTarjetasCC datosCompletos(List<Transferencias> datosTransferencias) {
        return Instrumented.instanceOf(RealizarPagoTarjetaCreditoPropiaTarjetasCC.class).withProperties(datosTransferencias);
    }
}
