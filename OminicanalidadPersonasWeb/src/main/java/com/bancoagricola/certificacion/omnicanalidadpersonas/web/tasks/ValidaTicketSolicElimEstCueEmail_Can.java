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

public class ValidaTicketSolicElimEstCueEmail_Can implements Task {

    private List<Transferencias> transferencias;

    public ValidaTicketSolicElimEstCueEmail_Can(List<Transferencias> transferencias) {
        this.transferencias = transferencias;
    }

    @Step("{0} 'realiza validacion de ticket'")
    @Override
    public <T extends Actor> void performAs(T actor) {

        Transferencias t = transferencias.get(0);

        Task.where(actor+" valida que 'No operación' sea igual a "+"'"+actor.recall(REFERENCIA_TICKET_VAR.toString()).toString()+"'",  Ensure.that(REFERENCIA_TICKET.resolveFor(actor).getAttribute(TEXT_CONTENT).substring(12).trim()).isEqualTo(actor.recall(REFERENCIA_TICKET_VAR.toString()).toString())).performAs(actor);
        Task.where(actor+" valida que 'Estados de cuenta que dejarás de recibir' sea igual a "+"'"+t.getTarjetaCreditoLista()+"'",  Ensure.that(TICKET_SOLESTACUEEMAIL2.resolveFor(actor).getAttribute(TEXT_CONTENT)).containsIgnoringCase(t.getTarjetaCreditoLista())).performAs(actor);
        Task.where(actor+" valida que 'Correo electrónico en el cual recibirás los estados de cuenta' se muestre",  Ensure.that(TICKET_SOLESTACUEEMAIL_CORREO).isDisplayed()).performAs(actor);
        actor.attemptsTo(Scroll.to(TICKET_SOLESTACUEEMAIL_CORREO).andAlignToTop());
        LeerArchivoProperties.esperar2();
        Task.where(actor+" valida que 'Condiciones del servicio' se muestre", WaitUntil.the(TICKET_SOLESTACUEEMAIL_CONDICIONES, isVisible()).forNoMoreThan(1).seconds()).performAs(actor);
        actor.attemptsTo(Scroll.to(TICKET_SOLESTACUEEMAIL_ESTADO).andAlignToTop());
        LeerArchivoProperties.esperar2();
        Task.where(actor+" valida que 'Estado' se muestre", WaitUntil.the(TICKET_SOLESTACUEEMAIL_ESTADO, isVisible()).forNoMoreThan(1).seconds()).performAs(actor);
        Task.where(actor+" valida que 'Fecha de ordenanza' se muestre", WaitUntil.the(TICKET_SOLESTACUEEMAIL_FECHORDEN, isVisible()).forNoMoreThan(1).seconds()).performAs(actor);
        Task.where(actor+" valida que 'Fecha aplicada' se muestre", WaitUntil.the(TICKET_SOLESTACUEEMAIL_FECHAAPLICADA, isVisible()).forNoMoreThan(1).seconds()).performAs(actor);
        Task.where(actor+" valida que 'ID transacción' se muestre", WaitUntil.the(TICKET_SOLESTACUEEMAIL_IDTRANSACCION, isVisible()).forNoMoreThan(1).seconds()).performAs(actor);
    }

    public static ValidaTicketSolicElimEstCueEmail_Can datosCorrectos(List<Transferencias> transferencias) {
        return Instrumented.instanceOf(ValidaTicketSolicElimEstCueEmail_Can.class).withProperties(transferencias);
    }
}
