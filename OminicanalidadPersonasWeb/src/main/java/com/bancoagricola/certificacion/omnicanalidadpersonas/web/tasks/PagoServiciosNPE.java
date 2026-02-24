package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

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

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.TEXT_CONTENT;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion.REFERENCIA_TICKET_VAR;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class PagoServiciosNPE implements Task {
    private List<Transferencias> datosDCA;

    public PagoServiciosNPE(List<Transferencias> datosDCA) {
        this.datosDCA = datosDCA;
    }

    @Step("{0} 'realiza proceso de pago de servicios con NPE'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias ca = datosDCA.get(0);

        actor.attemptsTo(
                WaitUntil.the(PAGOSERVICIOS, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(PAGOSERVICIOS, isClickable()).forNoMoreThan(60).seconds());
        LeerArchivoProperties.esperar(2);
        actor.attemptsTo(
                Click.on(PAGOSERVICIOS));
        LeerArchivoProperties.esperar(2);
        actor.attemptsTo(
                WaitUntil.the(TTL_PAGOSERV, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(PAGOCONFACTURA, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(PAGOCONFACTURA, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(PAGOCONFACTURA),
                WaitUntil.the(TTL_PTSMRS, isVisible()).forNoMoreThan(60).seconds(),
                SendKeys.of(ca.getNpe()).into(NPE_TXT),
                WaitUntil.the(BTN_CONTINUAR, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_CONTINUAR, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_CONTINUAR),
                WaitUntil.the(TTL_PAGOSERV, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(TTL_PAGOSERV, isEnabled()).forNoMoreThan(30).seconds());
        LeerArchivoProperties.esperar(1);
        actor.attemptsTo(
                //SendKeys.of(ca.getMonto()).into(MONTO_NPE),
                // Scroll.to(BOTON_PAGAR_PP).andAlignToTop(),
                //  WaitUntil.the(BOTON_PAGAR_PP, isEnabled()).forNoMoreThan(60).seconds(),
                // WaitUntil.the(BOTON_PAGAR_PP, isClickable()).forNoMoreThan(60).seconds(),
                //  Click.on(BOTON_PAGAR_PP),
                //WaitUntil.the(VTN_EMERG_PP, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_PAGAR, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_PAGAR, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_PAGAR, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_PAGAR),
                WaitUntil.the(BTN_ACEPTARNPE, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(BTN_ACEPTARNPE));
        LeerArchivoProperties.esperar(15);
        WaitUntil.the(CONFPAGOSERV, isVisible()).forNoMoreThan(60).seconds().performAs(actor);
        actor.remember(REFERENCIA_TICKET_VAR.toString(), REFERENCIA_TICKET.resolveFor(actor).getAttribute(TEXT_CONTENT).substring(12).trim());
        System.out.println("Referencia: " + actor.recall(REFERENCIA_TICKET_VAR.toString()).toString());

    }

    public static PagoServiciosNPE datosCA(List<Transferencias> datosDCA) {
        return Instrumented.instanceOf(PagoServiciosNPE.class).withProperties(datosDCA);
    }
}