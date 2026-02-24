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

public class ValidaTicketRecargasTDC implements Task {

    private List<Transferencias> transferencias;

    public ValidaTicketRecargasTDC(List<Transferencias> transferencias) {
        this.transferencias = transferencias;
    }

    @Step("{0} 'realiza validacion de ticket'")
    @Override
    public <T extends Actor> void performAs(T actor) {

        Transferencias t = transferencias.get(0);

        Task.where(actor+" valida que 'No operación' sea igual a "+"'"+actor.recall(REFERENCIA_TICKET_VAR.toString()).toString()+"'",  Ensure.that(REFERENCIA_TICKET.resolveFor(actor).getAttribute(TEXT_CONTENT).substring(12).trim()).isEqualTo(actor.recall(REFERENCIA_TICKET_VAR.toString()).toString())).performAs(actor);
        actor.attemptsTo(Scroll.to(CELULAR_TICKET_CEL).andAlignToTop());
        LeerArchivoProperties.esperar2();
        Task.where(actor+" valida que 'Celular' sea igual a "+"'"+t.getCelular()+"'",  Ensure.that(CELULAR_TICKET_CEL.resolveFor(actor).getAttribute(TEXT_CONTENT)).isEqualTo(t.getCelular())).performAs(actor);
        actor.attemptsTo(Scroll.to(COMPANIA_TICKET_CEL).andAlignToTop());
        LeerArchivoProperties.esperar2();
        Task.where(actor+" valida que 'Compañía' sea igual a "+"'"+t.getCompania()+"'",  Ensure.that(COMPANIA_TICKET_CEL.resolveFor(actor).getAttribute(TEXT_CONTENT)).isEqualTo(t.getCompania())).performAs(actor);
        actor.attemptsTo(Scroll.to(PAQUETEMONTO_TICKET_CEL).andAlignToTop());
        LeerArchivoProperties.esperar2();
        Task.where(actor+" valida que 'Paquete/Monto' sea igual a "+"'"+t.getMontopaquete()+"'",  Ensure.that(PAQUETEMONTO_TICKET_CEL.resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(t.getMontopaquete())).performAs(actor);
        actor.attemptsTo(Scroll.to(CONCEPTO_TICKET_CEL).andAlignToTop());
        LeerArchivoProperties.esperar2();
        Task.where(actor+" valida que 'Concepto' sea igual a "+"'"+t.getConcepto()+"'",  Ensure.that(CONCEPTO_TICKET_CEL.resolveFor(actor).getAttribute(TEXT_CONTENT)).isEqualTo(t.getConcepto())).performAs(actor);
        actor.attemptsTo(Scroll.to(DESDE_TICKET_CEL).andAlignToTop());
        LeerArchivoProperties.esperar2();
        Task.where(actor+" valida que 'Desde' sea igual a "+"'"+t.getTarjetaCredito()+"'",  Ensure.that(DESDE_TICKET_CEL.resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(t.getTarjetaCredito())).performAs(actor);
        actor.attemptsTo(Scroll.to(ESTADO_TICKET_CEL).andAlignToTop());
        LeerArchivoProperties.esperar2();
        Task.where(actor+" valida que 'Estado' se muestre", WaitUntil.the(ESTADO_TICKET_CEL, isVisible()).forNoMoreThan(1).seconds()).performAs(actor);
        actor.attemptsTo(Scroll.to(FECHAORDENANZA_TICKET_CEL).andAlignToTop());
        LeerArchivoProperties.esperar2();
        Task.where(actor+" valida que 'Fecha de ordenanza' se muestre", WaitUntil.the(FECHAORDENANZA_TICKET_CEL, isVisible()).forNoMoreThan(1).seconds()).performAs(actor);
        actor.attemptsTo(Scroll.to(FECHAAPLICADA_TICKET_CEL).andAlignToTop());
        LeerArchivoProperties.esperar2();
        Task.where(actor+" valida que 'Fecha aplicada' se muestre", WaitUntil.the(FECHAAPLICADA_TICKET_CEL, isVisible()).forNoMoreThan(1).seconds()).performAs(actor);
        actor.attemptsTo(Scroll.to(IDTRANSACCION_TICKET_CEL).andAlignToTop());
        LeerArchivoProperties.esperar2();
        Task.where(actor+" valida que 'ID transacción' se muestre", WaitUntil.the(IDTRANSACCION_TICKET_CEL, isVisible()).forNoMoreThan(1).seconds()).performAs(actor);
    }

    public static ValidaTicketRecargasTDC datosCorrectos(List<Transferencias> transferencias) {
        return Instrumented.instanceOf(ValidaTicketRecargasTDC.class).withProperties(transferencias);
    }
}
