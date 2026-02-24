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

public class ValidaTicketDonacionCashBac implements Task {

    private List<Transferencias> transferencias;

    public ValidaTicketDonacionCashBac(List<Transferencias> transferencias) {
        this.transferencias = transferencias;
    }

    @Step("{0} 'realiza validacion de ticket'")
    @Override
    public <T extends Actor> void performAs(T actor) {

        Transferencias t = transferencias.get(0);

        Task.where(actor+" valida que 'No operación' sea igual a "+"'"+actor.recall(REFERENCIA_TICKET_VAR.toString()).toString()+"'",  Ensure.that(REFERENCIA_TICKET.resolveFor(actor).getAttribute(TEXT_CONTENT).substring(12).trim()).isEqualTo(actor.recall(REFERENCIA_TICKET_VAR.toString()).toString())).performAs(actor);
        Task.where(actor+" valida que 'Monto' sea igual a "+"'"+t.getMonto()+"'",  Ensure.that(MONTO_TICKET_DON_RED.resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(t.getMonto())).performAs(actor);
        Task.where(actor+" valida que 'Tipo de operación' sea igual a "+"'"+t.getTipoOperacion()+"'",  Ensure.that(TIPOOPERACION_TICKET_DON_RED.resolveFor(actor).getAttribute(TEXT_CONTENT)).isEqualTo(t.getTipoOperacion())).performAs(actor);
        Task.where(actor+" valida que 'Institución de ONG' sea igual a "+"'"+t.getInstitucionOng()+"'",  Ensure.that(INSTITUCIONONG_TICKET_DON_RED.resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(t.getInstitucionOng())).performAs(actor);
        Task.where(actor+" valida que 'Tipo de cobro' sea igual a "+"'"+t.getTipoCobro()+"'",  Ensure.that(TIPOCOBRO_TICKET_DON_RED.resolveFor(actor).getAttribute(TEXT_CONTENT)).isEqualTo(t.getTipoCobro())).performAs(actor);
        Task.where(actor+" valida que 'Con abono a cuenta: LIBRAS DE AMOR por un monto' se muestre", WaitUntil.the(CABC_TICKET_DON_RED, isVisible()).forNoMoreThan(1).seconds()).performAs(actor);
        actor.attemptsTo(Scroll.to(CONCEPTO_TICKET_DON_RED).andAlignToTop());
        LeerArchivoProperties.esperar2();
        Task.where(actor+" valida que 'Concepto' sea igual a "+"'"+t.getConcepto()+"'",  Ensure.that(CONCEPTO_TICKET_DON_RED.resolveFor(actor).getAttribute(TEXT_CONTENT)).isEqualTo(t.getConcepto())).performAs(actor);
        Task.where(actor+" valida que 'Estado' se muestre", WaitUntil.the(ESTADO_TICKET_DON_RED, isVisible()).forNoMoreThan(1).seconds()).performAs(actor);
        Task.where(actor+" valida que 'Fecha de ordenanza' se muestre", WaitUntil.the(FECHA_ORDENANZA_TICKET_DON_RED, isVisible()).forNoMoreThan(1).seconds()).performAs(actor);
        Task.where(actor+" valida que 'Fecha aplicada' se muestre", WaitUntil.the(FECHA_APLICADA_TICKET_DON_RED, isVisible()).forNoMoreThan(1).seconds()).performAs(actor);
        Task.where(actor+" valida que 'ID transacción' se muestre", WaitUntil.the(ID_TRANSACCION_TICKET_DON_RED, isVisible()).forNoMoreThan(1).seconds()).performAs(actor);

    }

    public static ValidaTicketDonacionCashBac datosCorrectos(List<Transferencias> transferencias) {
        return Instrumented.instanceOf(ValidaTicketDonacionCashBac.class).withProperties(transferencias);
    }
}
