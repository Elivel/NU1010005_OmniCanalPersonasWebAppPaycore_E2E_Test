package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.TEXT_CONTENT;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion.REFERENCIA_TICKET_VAR;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ValidaTicketPagoServicioNPECuentas implements Task {

    private List<Transferencias> transferencias;

    public ValidaTicketPagoServicioNPECuentas(List<Transferencias> transferencias) {
        this.transferencias = transferencias;
    }

    @Step("{0} 'realiza validacion de ticket'")
    @Override
    public <T extends Actor> void performAs(T actor) {

        Transferencias t = transferencias.get(0);

        Task.where(actor+" valida que 'No operación' sea igual a "+"'"+actor.recall(REFERENCIA_TICKET_VAR.toString()).toString()+"'",  Ensure.that(REFERENCIA_TICKET.resolveFor(actor).getAttribute(TEXT_CONTENT).substring(12).trim()).isEqualTo(actor.recall(REFERENCIA_TICKET_VAR.toString()).toString())).performAs(actor);
        actor.attemptsTo(Scroll.to(TICKET_PAGOSERVICIOSNPE_MONTO).andAlignToTop());
        LeerArchivoProperties.esperar2();
        Task.where(actor+" valida que 'Monto' sea igual a "+"'"+t.getMonto()+"'", Ensure.that(TICKET_PAGOSERVICIOSNPE_MONTO.resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(t.getMonto())).performAs(actor);
        actor.attemptsTo(Scroll.to(TICKET_PAGOSERVICIOSNPE_RECIBO).andAlignToTop());
        LeerArchivoProperties.esperar2();
        Task.where(actor+" valida que 'Recibo' se muestre", WaitUntil.the(TICKET_PAGOSERVICIOSNPE_RECIBO, isVisible()).forNoMoreThan(1).seconds()).performAs(actor);
        actor.attemptsTo(Scroll.to(TICKET_PAGOSERVICIOSNPE_NPE).andAlignToTop());
        LeerArchivoProperties.esperar2();
        Task.where(actor+" valida que 'NPE' sea igual a "+"'"+t.getNpe()+"'", Ensure.that(TICKET_PAGOSERVICIOSNPE_NPE.resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(t.getNpe())).performAs(actor);
        actor.attemptsTo(Scroll.to(TICKET_PAGOSERVICIOSNPE_DESDE).andAlignToTop());
        LeerArchivoProperties.esperar2();
        Task.where(actor+" valida que 'Desde' sea igual a "+"'"+t.getCuentaTicket()+"'", Ensure.that(TICKET_PAGOSERVICIOSNPE_DESDE.resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(t.getCuentaTicket())).performAs(actor);
        actor.attemptsTo(Scroll.to(TICKET_PAGOSERVICIOSNPE_ESTADO).andAlignToTop());
        LeerArchivoProperties.esperar2();
        Task.where(actor+" valida que 'Estado' se muestre", WaitUntil.the(TICKET_PAGOSERVICIOSNPE_ESTADO, isVisible()).forNoMoreThan(1).seconds()).performAs(actor);
        actor.attemptsTo(Scroll.to(TICKET_PAGOSERVICIOSNPE_FECHAORDENANZA).andAlignToTop());
        LeerArchivoProperties.esperar2();
        Task.where(actor+" valida que 'Fecha de ordenanza' se muestre", WaitUntil.the(TICKET_PAGOSERVICIOSNPE_FECHAORDENANZA, isVisible()).forNoMoreThan(1).seconds()).performAs(actor);
        Task.where(actor+" valida que 'Fecha programada' se muestre", WaitUntil.the(TICKET_PAGOSERVICIOSNPE_FECHA_APLICADA, isVisible()).forNoMoreThan(1).seconds()).performAs(actor);
        Task.where(actor+" valida que 'ID transacción' se muestre", WaitUntil.the(TICKET_PAGOSERVICIOSNPE_ID, isVisible()).forNoMoreThan(1).seconds()).performAs(actor);

    }

    public static ValidaTicketPagoServicioNPECuentas datosCorrectos(List<Transferencias> transferencias) {
        return Instrumented.instanceOf(ValidaTicketPagoServicioNPECuentas.class).withProperties(transferencias);
    }
}
