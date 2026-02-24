package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoVerMasCtaCorriente;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.TEXT_CONTENT;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion.REFERENCIA_TICKET_VAR;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class PagoPrestamoDesdeCC implements Task {
    private List<Transferencias> datosCAP;

    public PagoPrestamoDesdeCC(List<Transferencias> datosCAP) {
        this.datosCAP = datosCAP;
    }

    @Step("{0} 'realiza proceso para pago de préstamo'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias cap = datosCAP.get(0);

        actor.attemptsTo(IngresoVerMasCtaCorriente.inicio(cap.getCuentaOrigen()));
        LeerArchivoProperties.esperar2();
        actor.attemptsTo(
                WaitUntil.the(LINK_PAGO_PRESTAMO, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(LINK_PAGO_PRESTAMO, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(LINK_PAGO_PRESTAMO.of(cap.getCuentaOrigen())),
                WaitUntil.the(LBL_PAGO_PRESTAMO, isCurrentlyVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(SELECC_PRESTAMO.of(cap.getNumeroPrestamo()), isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(SELECC_PRESTAMO.of(cap.getNumeroPrestamo()), isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(SELECC_PRESTAMO.of(cap.getNumeroPrestamo()), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(SELECC_PRESTAMO.of(cap.getNumeroPrestamo())),
                WaitUntil.the(LBL_PAGO_PRESTAMO_PROP, isCurrentlyVisible()).forNoMoreThan(60).seconds(),
                Scroll.to(MONTO_DEL_PAGO_PP).andAlignToTop(),
                Clear.field(MONTO_DEL_PAGO_PP),
                SendKeys.of(cap.getMonto()).into(MONTO_DEL_PAGO_PP),
                SendKeys.of(cap.getConcepto()).into(DESCRIPCIÓN_PAGO_PP),
                WaitUntil.the(BOTON_PAGAR_PP.of(cap.getNumeroPrestamo()), isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BOTON_PAGAR_PP.of(cap.getNumeroPrestamo()), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BOTON_PAGAR_PP.of(cap.getNumeroPrestamo())));
        LeerArchivoProperties.esperar(1);
        actor.attemptsTo(
                WaitUntil.the(VTN_EMERG_PP, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BOTON_ACEPTAR_PP, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BOTON_ACEPTAR_PP, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BOTON_ACEPTAR_PP, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BOTON_ACEPTAR_PP.of(cap.getNumeroPrestamo())));
        WaitUntil.the(LBL_PAGO_PRESTAMO_EXITO, isVisible()).forNoMoreThan(60).seconds().performAs(actor);

        actor.remember(REFERENCIA_TICKET_VAR.toString(), REFERENCIA_TICKET.resolveFor(actor).getAttribute(TEXT_CONTENT).substring(12).trim());
        System.out.println("Referencia: " + actor.recall(REFERENCIA_TICKET_VAR.toString()).toString());

        actor.attemptsTo(
                WaitUntil.the(MENU_CUENTAS, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(MENU_CUENTAS, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(MENU_CUENTAS));
        LeerArchivoProperties.esperar(2);
        WaitUntil.the(TOTAL_CUENTAS, isVisible()).forNoMoreThan(60).seconds().performAs(actor);
        //WaitUntil.the(TOTAL_CUENTAS, isEnabled()).forNoMoreThan(60).seconds());

    }

    public static PagoPrestamoDesdeCC datosP(List<Transferencias> datosCAP) {
        return Instrumented.instanceOf(PagoPrestamoDesdeCC.class).withProperties(datosCAP);
    }
}
