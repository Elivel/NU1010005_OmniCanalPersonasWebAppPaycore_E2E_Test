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

public class ValidaTicketPagoPrestamosUNI implements Task {
    private List<Transferencias> transferencias;

    public ValidaTicketPagoPrestamosUNI(List<Transferencias> transferencias) {
        this.transferencias = transferencias;
    }

    @Step("{0} 'realiza validacion de ticket'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias t = transferencias.get(0);

        Task.where(actor+" valida que 'No operación' sea igual a "+"'"+actor.recall(REFERENCIA_TICKET_VAR.toString()).toString()+"'",  Ensure.that(REFERENCIA_TICKET.resolveFor(actor).getAttribute(TEXT_CONTENT).substring(12).trim()).isEqualTo(actor.recall(REFERENCIA_TICKET_VAR.toString()).toString())).performAs(actor);
        Task.where(actor+" valida que 'Monto' sea igual a "+"'"+t.getMonto()+"'",  Ensure.that(TICKET_PREST_UNI_MONTO.resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(t.getMonto())).performAs(actor);
        actor.attemptsTo(Scroll.to(TICKET_PREST_UNI_MONTO).andAlignToBottom());
        LeerArchivoProperties.esperar2();
        Task.where(actor+" valida que 'Banco' sea igual a "+"'"+t.getBanco()+"'",  Ensure.that(TICKET_PREST_UNI_BANCO.resolveFor(actor).getAttribute(TEXT_CONTENT)).isEqualTo(t.getBanco())).performAs(actor);
        actor.attemptsTo(Scroll.to(TICKET_PREST_UNI_BANCO).andAlignToTop());
        LeerArchivoProperties.esperar2();
        Task.where(actor+" valida que 'Préstamo a abonar' sea igual a "+"'"+t.getNumeroPrestamo()+"'",  Ensure.that(TICKET_PREST_UNI_PRESTABO.resolveFor(actor).getAttribute(TEXT_CONTENT)).isEqualTo(t.getNumeroPrestamo())).performAs(actor);
        actor.attemptsTo(Scroll.to(TICKET_PREST_UNI_PRESTABO).andAlignToTop());
        LeerArchivoProperties.esperar2();
        Task.where(actor+" valida que 'Tipo de documento' sea igual a "+"'"+t.getTipoIdentificacion()+"'",  Ensure.that(TICKET_PREST_UNI_TIPODOC.resolveFor(actor).getAttribute(TEXT_CONTENT)).isEqualTo(t.getTipoIdentificacion())).performAs(actor);
        actor.attemptsTo(Scroll.to(TICKET_PREST_UNI_TIPODOC).andAlignToTop());
        LeerArchivoProperties.esperar2();
        Task.where(actor+" valida que 'Número de documento' sea igual a "+"'"+t.getNumeroIdentificacion()+"'",  Ensure.that(TICKET_PREST_UNI_NUMDOC.resolveFor(actor).getAttribute(TEXT_CONTENT)).isEqualTo(t.getNumeroIdentificacion())).performAs(actor);
        Task.where(actor+" valida que 'Nombre de recibidor' sea igual a "+"'"+t.getNombreRecibidor()+"'",  Ensure.that(TICKET_PREST_UNI_NOMREC.resolveFor(actor).getAttribute(TEXT_CONTENT)).isEqualTo(t.getNombreRecibidor())).performAs(actor);
        Task.where(actor+" valida que 'Correo electrónico' sea igual a "+"'"+t.getCorreo()+"'",  Ensure.that(TICKET_PREST_UNI_CORREO.resolveFor(actor).getAttribute(TEXT_CONTENT)).isEqualTo(t.getCorreo())).performAs(actor);
        Task.where(actor+" valida que 'Concepto' sea igual a "+"'"+t.getConcepto()+"'",  Ensure.that(TICKET_PREST_UNI_CONCEPTO.resolveFor(actor).getAttribute(TEXT_CONTENT)).isEqualTo(t.getConcepto())).performAs(actor);
        Task.where(actor+" valida que 'Comisión ACH' se muestre", WaitUntil.the(TICKET_PREST_UNI_COMISIONACH, isVisible()).forNoMoreThan(1).seconds()).performAs(actor);
        Task.where(actor+" valida que 'Cuenta' sea igual a "+"'"+t.getCuentaTicket()+"'",  Ensure.that(TICKET_PREST_UNI_CUENTA.resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(t.getCuentaTicket())).performAs(actor);
        Task.where(actor+" valida que 'Estado' se muestre", WaitUntil.the(TICKET_PREST_UNI_ESTADO, isVisible()).forNoMoreThan(1).seconds()).performAs(actor);
        Task.where(actor+" valida que 'Fecha de ordenanza' se muestre", WaitUntil.the(TICKET_PREST_UNI_FECORDE, isVisible()).forNoMoreThan(1).seconds()).performAs(actor);
        Task.where(actor+" valida que 'Fecha aplicada' se muestre", WaitUntil.the(TICKET_PREST_UNI_FECAPLI, isVisible()).forNoMoreThan(1).seconds()).performAs(actor);
        Task.where(actor+" valida que 'ID transacción' se muestre", WaitUntil.the(TICKET_PREST_UNI_ID, isVisible()).forNoMoreThan(1).seconds()).performAs(actor);
    }

    public static ValidaTicketPagoPrestamosUNI datosCorrectos(List<Transferencias> transferencias) {
        return Instrumented.instanceOf(ValidaTicketPagoPrestamosUNI.class).withProperties(transferencias);
    }
}
