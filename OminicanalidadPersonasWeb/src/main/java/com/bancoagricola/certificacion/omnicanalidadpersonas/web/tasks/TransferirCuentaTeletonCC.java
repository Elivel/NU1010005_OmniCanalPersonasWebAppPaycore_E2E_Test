package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoMenuCCOrigenMovBasico;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoVerMasCtaCBasico;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.AhorrosPage.MENU_PRINC;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.Comprobante365.LABEL_COMPROBANTE;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.GeneralPage.RESULTADOS;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TarjetasPage.SELECCIONAR_CUENTA_ORIGEN1;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TransferenciasLinksPage.lINK_APOYO_TELETON;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion.REFERENCIA_TICKET_VAR;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class TransferirCuentaTeletonCC implements Task {

    private String cuenta;
    private String monto;

    public TransferirCuentaTeletonCC(String cuenta, String monto) {
        this.cuenta = cuenta;
        this.monto = monto;
    }
    @Step("{0} 'realiza proceso de transferencia'")
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                IngresoVerMasCtaCBasico.inicio(cuenta),
                WaitUntil.the(lINK_APOYO_TELETON, isEnabled()).forNoMoreThan(20).seconds(),
                WaitUntil.the(lINK_APOYO_TELETON, isClickable()).forNoMoreThan(20).seconds(),
                Click.on(lINK_APOYO_TELETON),
                WaitUntil.the(TTL_SOLIC_TRANSF_TELETON, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(SELECCIONAR_CUENTA_ORIGEN1, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(SELECCIONAR_CUENTA_ORIGEN1, isClickable()).forNoMoreThan(60).seconds(),
                SendKeys.of(monto).into(TXT_MONTO_PAGO),
                SendKeys.of(AYUDA_TELETON).into(TXT_CONCEPTO),
                WaitUntil.the(BTN_CONTINUAR_PAGAR, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_CONTINUAR_PAGAR, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_CONTINUAR_PAGAR),
                WaitUntil.the(BTN_ACEPTAR_C, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_ACEPTAR_C, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_ACEPTAR_C),
                WaitUntil.the(MENU_PRINC, isEnabled()).forNoMoreThan(60).seconds());
        WaitUntil.the(RESULTADOS.of(TRANSFERENCIA_EXITOSA), isVisible()).forNoMoreThan(60).seconds().performAs(actor);

        actor.remember(REFERENCIA_TICKET_VAR.toString(), REFERENCIA_TICKET.resolveFor(actor).getAttribute(TEXT_CONTENT).substring(12).trim());
        System.out.println("Referencia: " + actor.recall(REFERENCIA_TICKET_VAR.toString()).toString());

        /* Capturar comprobante*/
        actor.attemptsTo(
                CapturarComprobanteTeleton.datosC(cuenta, monto),
                Scroll.to(LABEL_COMPROBANTE.of(BOTON_IMPRIMIR)).andAlignToTop());
        /*  */

        actor.attemptsTo(
                IngresoMenuCCOrigenMovBasico.inicio(cuenta),
                ValidaReferenciaTicketCuentaAhorro.conLaReferencia());

        actor.remember(VariablesSesion.MONTO_CUENTA_ORIGEN_FINAL.toString(), OBTENER_SALDO.resolveFor(actor).getText());
    }

    public static TransferirCuentaTeletonCC datosCompletos(String cuenta, String monto) {
        return Instrumented.instanceOf(TransferirCuentaTeletonCC.class).withProperties(cuenta, monto);
    }
}
