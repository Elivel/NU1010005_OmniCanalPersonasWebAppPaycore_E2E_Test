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

public class ValidaTicketTransfer365Movil implements Task {

    private List<Transferencias> transferencias;

    public ValidaTicketTransfer365Movil(List<Transferencias> transferencias) {
        this.transferencias = transferencias;
    }

    @Step("{0} 'realiza validacion de ticket'")
    @Override
    public <T extends Actor> void performAs(T actor) {

        Transferencias t = transferencias.get(0);

        Task.where(actor + " valida que 'No operación' se muestre", Ensure.that(REFERENCIA_TICKET).isDisplayed()).performAs(actor);
        Task.where(actor + " valida que 'Monto' sea igual a " + "'" + t.getMonto() + "'", Ensure.that(MONT_T365M.resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(t.getMonto())).performAs(actor);
        Task.where(actor + " valida que 'Institución de destino' sea igual a " + "'" + t.getBanco() + "'", Ensure.that(INSTITUC_DEST_T365M.resolveFor(actor).getAttribute(TEXT_CONTENT)).isEqualTo(t.getBanco())).performAs(actor);
        actor.attemptsTo(Scroll.to(CEL_T365M).andAlignToTop());
        LeerArchivoProperties.esperar2();
        Task.where(actor + " valida que 'Celular' sea igual a " + "'" + t.getCelular() + "'", Ensure.that(CEL_T365M.resolveFor(actor).getAttribute(TEXT_CONTENT)).isEqualTo(t.getCelular())).performAs(actor);
        actor.attemptsTo(Scroll.to(NOMBR_RECIB_T365M).andAlignToTop());
        LeerArchivoProperties.esperar2();
        Task.where(actor + " valida que 'Nombre del recibidor' sea igual a " + "'" + t.getNombreRecibidor() + "'", Ensure.that(NOMBR_RECIB_T365M.resolveFor(actor).getAttribute(TEXT_CONTENT)).isEqualTo(t.getNombreRecibidor())).performAs(actor);
        actor.attemptsTo(Scroll.to(CORREO_T365M).andAlignToTop());
        LeerArchivoProperties.esperar2();
        Task.where(actor + " valida que 'Correo electrónico (opcional)' sea igual a " + "'" + t.getCorreo()+ "'", Ensure.that(CORREO_T365M.resolveFor(actor).getAttribute(TEXT_CONTENT)).isEqualTo(t.getCorreo())).performAs(actor);
        actor.attemptsTo(Scroll.to(CONCEP_T365M).andAlignToTop());
        LeerArchivoProperties.esperar2();
        Task.where(actor + " valida que 'Concepto' sea igual a " + "'" + t.getConcepto()+ "'", Ensure.that(CONCEP_T365M.resolveFor(actor).getAttribute(TEXT_CONTENT)).isEqualTo(t.getConcepto())).performAs(actor);
        actor.attemptsTo(Scroll.to(CUENT_T365M).andAlignToTop());
        LeerArchivoProperties.esperar2();
        Task.where(actor + " valida que 'Cuenta' sea igual a " + "'" + t.getCuentaTicket()+ "'", Ensure.that(CUENT_T365M.resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(t.getCuentaTicket())).performAs(actor);
        actor.attemptsTo(Scroll.to(ESTADO_TICKET_UNI).andAlignToTop());
        LeerArchivoProperties.esperar2();
        Task.where(actor + " valida que 'Estado' se muestre", WaitUntil.the(ESTADO_TICKET_UNI, isVisible()).forNoMoreThan(1).seconds()).performAs(actor);
        Task.where(actor + " valida que 'Fecha de ordenanza' se muestre", WaitUntil.the(FECHA_ORDENANZA_TICKET_UNI, isVisible()).forNoMoreThan(1).seconds()).performAs(actor);
        Task.where(actor + " valida que 'Fecha aplicada' se muestre", WaitUntil.the(FECHA_APLICADA_T365M, isVisible()).forNoMoreThan(1).seconds()).performAs(actor);
        Task.where(actor + " valida que 'ID transacción' se muestre", WaitUntil.the(ID_TRANSACCION_TICKET_UNI, isVisible()).forNoMoreThan(1).seconds()).performAs(actor);

    }

    public static ValidaTicketTransfer365Movil datosCorrectos(List<Transferencias> transferencias) {
        return Instrumented.instanceOf(ValidaTicketTransfer365Movil.class).withProperties(transferencias);
    }
}
