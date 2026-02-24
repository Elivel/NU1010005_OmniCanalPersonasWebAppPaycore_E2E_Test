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

public class ValidaTicketTransferenciaAPTerCel implements Task {

    private List<Transferencias> transferencias;

    public ValidaTicketTransferenciaAPTerCel(List<Transferencias> transferencias) {
        this.transferencias = transferencias;
    }

    @Step("{0} 'realiza validacion de ticket'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias t = transferencias.get(0);

        Task.where(actor+" valida que 'No operación' sea igual a "+"'"+actor.recall(REFERENCIA_TICKET_VAR.toString()).toString()+"'",  Ensure.that(REFERENCIA_TICKET.resolveFor(actor).getAttribute(TEXT_CONTENT).substring(12).trim()).isEqualTo(actor.recall(REFERENCIA_TICKET_VAR.toString()).toString())).performAs(actor);
        actor.attemptsTo(Scroll.to(REFERENCIA_TICKET).andAlignToTop());
        LeerArchivoProperties.esperar2();
        Task.where(actor+" valida que 'Monto' sea igual a "+"'"+t.getMonto()+"'", Ensure.that(TICKET_TRANSFERENCIA_AP_MONTO_TER.resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(t.getMonto())).performAs(actor);
        actor.attemptsTo(Scroll.to(TICKET_TRANSFERENCIA_AP_MONTO_TER).andAlignToTop());
        LeerArchivoProperties.esperar2();
        Task.where(actor+" valida que 'Nombre del destinatario' se muestre", WaitUntil.the(TICKET_TRANSFERENCIA_AP_NOMDES_TER, isVisible()).forNoMoreThan(1).seconds()).performAs(actor);
        actor.attemptsTo(Scroll.to(TICKET_TRANSFERENCIA_AP_NOMDES_TER).andAlignToTop());
        LeerArchivoProperties.esperar2();
        Task.where(actor+" valida que 'Celular' sea igual a "+"'"+t.getCelular()+"'", Ensure.that(TICKET_TRANSFERENCIA_AP_CELULAR_TER.resolveFor(actor).getAttribute(TEXT_CONTENT)).isEqualTo(t.getCelular())).performAs(actor);
        actor.attemptsTo(Scroll.to(TICKET_TRANSFERENCIA_AP_CELULAR_TER).andAlignToTop());
        LeerArchivoProperties.esperar2();
        Task.where(actor+" valida que 'Correo electrónico' sea igual a "+"'"+t.getCorreo()+"'", Ensure.that(TICKET_TRANSFERENCIA_AP_CORREO_TER.resolveFor(actor).getAttribute(TEXT_CONTENT)).isEqualTo(t.getCorreo())).performAs(actor);
        actor.attemptsTo(Scroll.to(TICKET_TRANSFERENCIA_AP_CORREO_TER).andAlignToTop());
        LeerArchivoProperties.esperar2();
        Task.where(actor+" valida que 'Concepto' sea igual a "+"'"+t.getConcepto()+"'", Ensure.that(TICKET_TRANSFERENCIA_AP_CONCEPTO_TER.resolveFor(actor).getAttribute(TEXT_CONTENT)).isEqualTo(t.getConcepto())).performAs(actor);
        Task.where(actor+" valida que 'Impuesto de Operaciones Financieras' se muestre", WaitUntil.the(TICKET_TRANSFERENCIA_AP_IMPOF_TER, isVisible()).forNoMoreThan(1).seconds()).performAs(actor);
        Task.where(actor+" valida que 'Cuenta débito' sea igual a "+"'"+t.getCuentaOrigen()+"'", Ensure.that(TICKET_TRANSFERENCIA_AP_CUEDEB_TER.resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(t.getCuentaOrigen())).performAs(actor);
        Task.where(actor+" valida que 'Estado' se muestre", WaitUntil.the(TICKET_PAGOSERVICIOSNPE_ESTADO, isVisible()).forNoMoreThan(1).seconds()).performAs(actor);
        Task.where(actor+" valida que 'Fecha de ordenanza' se muestre", WaitUntil.the(TICKET_PAGOSERVICIOSNPE_FECHAORDENANZA, isVisible()).forNoMoreThan(1).seconds()).performAs(actor);
        Task.where(actor+" valida que 'Fecha programada' se muestre", WaitUntil.the(TICKET_PAGOSERVICIOSNPE_FECHA_APLICADA, isVisible()).forNoMoreThan(1).seconds()).performAs(actor);
        Task.where(actor+" valida que 'ID transacción' se muestre", WaitUntil.the(TICKET_PAGOSERVICIOSNPE_ID, isVisible()).forNoMoreThan(1).seconds()).performAs(actor);

    }

    public static ValidaTicketTransferenciaAPTerCel datosCorrectos(List<Transferencias> transferencias) {
        return Instrumented.instanceOf(ValidaTicketTransferenciaAPTerCel.class).withProperties(transferencias);
    }
}
