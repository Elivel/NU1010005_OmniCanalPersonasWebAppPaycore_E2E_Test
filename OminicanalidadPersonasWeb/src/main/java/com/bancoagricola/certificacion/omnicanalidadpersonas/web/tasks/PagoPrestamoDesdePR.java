package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoVerMasPrestamos;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.Comprobante365.LABEL_COMPROBANTE;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.BOTON_IMPRIMIR;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.TEXT_CONTENT;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion.REFERENCIA_TICKET_VAR;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class PagoPrestamoDesdePR implements Task {
    private List<Transferencias> datosCAP;

    public PagoPrestamoDesdePR(List<Transferencias> datosCAP) {
        this.datosCAP = datosCAP;
    }

    @Step("{0} realiza proceso para pago de préstamo")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias cap = datosCAP.get(0);

        actor.attemptsTo(IngresoVerMasPrestamos.inicio(datosCAP));
        LeerArchivoProperties.esperar2();
        actor.attemptsTo(
                WaitUntil.the(LINK_PAGO_PRESTAMO, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(LINK_PAGO_PRESTAMO, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(LINK_PAGO_PRESTAMO.of(cap.getCuentaOrigen())),
                WaitUntil.the(LBL_PAGO_PRESTAMO_PROP, isCurrentlyVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(SEL_CUENTAS, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(SEL_CUENTAS, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(SEL_CUENTAS),
                WaitUntil.the(SELECC_CUENTA.of(cap.getCuentaOrigen()), isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(SELECC_CUENTA.of(cap.getCuentaOrigen()), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(SELECC_CUENTA.of(cap.getCuentaOrigen())),
                Scroll.to(MONTO_DEL_PAGO_PP).andAlignToTop(),
                Clear.field(MONTO_DEL_PAGO_PP),
                SendKeys.of(cap.getMonto()).into(MONTO_DEL_PAGO_PP),
                SendKeys.of(cap.getConcepto()).into(DESCRIPCIÓN_PAGO_PP),
                WaitUntil.the(BOTON_PAGAR_PP, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BOTON_PAGAR_PP, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BOTON_PAGAR_PP));
        LeerArchivoProperties.esperar(1);
        actor.attemptsTo(
                WaitUntil.the(VTN_EMERG_PP, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BOTON_ACEPTAR_PP, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BOTON_ACEPTAR_PP, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BOTON_ACEPTAR_PP, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BOTON_ACEPTAR_PP),
                WaitUntil.the(LBL_PAGO_PRESTAMO_EXITO, isCurrentlyVisible()).forNoMoreThan(60).seconds(),
                Ensure.that(LBL_PAGO_PRESTAMO_EXITO).isDisplayed());

        actor.remember(REFERENCIA_TICKET_VAR.toString(), REFERENCIA_TICKET.resolveFor(actor).getAttribute(TEXT_CONTENT).substring(12).trim());
        System.out.println("Referencia: " + actor.recall(REFERENCIA_TICKET_VAR.toString()).toString());

        /*Comprobante*/
        actor.attemptsTo(
                CapturaComprobantePrestamoPropio.datosC(datosCAP),
                Scroll.to(LABEL_COMPROBANTE.of(BOTON_IMPRIMIR)).andAlignToTop());
        /*          */

        actor.attemptsTo(
                WaitUntil.the(MENU_CUENTAS, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(MENU_CUENTAS, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(MENU_CUENTAS),
                WaitUntil.the(TOTAL_CUENTAS, isCurrentlyVisible()).forNoMoreThan(60).seconds());
    }

    public static PagoPrestamoDesdePR datosP(List<Transferencias> datosCAP) {
        return Instrumented.instanceOf(PagoPrestamoDesdePR.class).withProperties(datosCAP);
    }
}
