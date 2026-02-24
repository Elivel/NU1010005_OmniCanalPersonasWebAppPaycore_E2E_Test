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
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ValidaTicketCreacionTransaccionProgramada implements Task {

    private List<Transferencias> transferencias;

    public ValidaTicketCreacionTransaccionProgramada(List<Transferencias> transferencias) {
        this.transferencias = transferencias;
    }

    @Step("{0} 'realiza validacion de ticket'")
    @Override
    public <T extends Actor> void performAs(T actor) {

        Transferencias t = transferencias.get(0);

        Task.where(actor+" valida que 'Monto' sea igual a "+"'"+t.getMonto()+"'", Ensure.that(TICKET_CREACION_TRX_PROGRAMADA_MONTO.resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(t.getMonto())).performAs(actor);
        Task.where(actor+" valida que 'Cuenta crédito' sea igual a "+"'"+t.getCuentaDestino()+"'",  Ensure.that(TICKET_CREACION_TRX_PROGRAMADA_CUENCRED.resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(t.getCuentaDestino())).performAs(actor);
        Task.where(actor+" valida que 'Concepto' sea igual a "+"'"+t.getConcepto()+"'", Ensure.that(TICKET_CREACION_TRX_PROGRAMADA_CONCEPTO.resolveFor(actor).getAttribute(TEXT_CONTENT)).isEqualTo(t.getConcepto())).performAs(actor);
        actor.attemptsTo(Scroll.to(TICKET_CREACION_TRX_PROGRAMADA_CUENDEB).andAlignToTop());
        LeerArchivoProperties.esperar2();
        Task.where(actor+" valida que 'Cuenta débito' sea igual a "+"'"+t.getCuentaOrigen()+"'", Ensure.that(TICKET_CREACION_TRX_PROGRAMADA_CUENDEB.resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(t.getCuentaOrigen())).performAs(actor);
        Task.where(actor+" valida que 'Estado' se muestre", WaitUntil.the(TICKET_SOLESTACUEEMAIL_ESTADO, isVisible()).forNoMoreThan(1).seconds()).performAs(actor);
        Task.where(actor+" valida que 'Fecha de ordenanza' se muestre", WaitUntil.the(TICKET_SOLESTACUEEMAIL_FECHORDEN, isVisible()).forNoMoreThan(1).seconds()).performAs(actor);
        Task.where(actor+" valida que 'Fecha programada' se muestre", WaitUntil.the(TICKET_CREACION_TRX_PROGRAMADA_FECHPROG, isVisible()).forNoMoreThan(1).seconds()).performAs(actor);
        Task.where(actor+" valida que 'ID transacción' se muestre", WaitUntil.the(ID_TRANSACCION_TICKET_DON_RED, isVisible()).forNoMoreThan(1).seconds()).performAs(actor);

    }

    public static ValidaTicketCreacionTransaccionProgramada datosCorrectos(List<Transferencias> transferencias) {
        return Instrumented.instanceOf(ValidaTicketCreacionTransaccionProgramada.class).withProperties(transferencias);
    }
}
