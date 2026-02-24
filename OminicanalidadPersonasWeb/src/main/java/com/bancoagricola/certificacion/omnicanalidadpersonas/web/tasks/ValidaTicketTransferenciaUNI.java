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

public class ValidaTicketTransferenciaUNI implements Task {

    private List<Transferencias> transferencias;

    public ValidaTicketTransferenciaUNI(List<Transferencias> transferencias) {
        this.transferencias = transferencias;
    }

    @Step("{0} 'realiza validacion de ticket'")
    @Override
    public <T extends Actor> void performAs(T actor) {

        Transferencias t = transferencias.get(0);

        Task.where(actor + " valida que 'Monto' sea igual a " + "'" + t.getMonto() + "'", Ensure.that(MONTO_TICKET_UNI.resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(t.getMonto())).performAs(actor);
        Task.where(actor + " valida que 'No operación' se muestre", Ensure.that(TIPO_CUENTA_TICKET_UNI).isDisplayed()).performAs(actor);
        actor.attemptsTo(Scroll.to(TIPO_CUENTA_TICKET_UNI).andAlignToTop());
        LeerArchivoProperties.esperar2();
        Task.where(actor + " valida que 'Tipo de cuenta' sea igual a " + "'" + t.getTipoCuenta() + "'", Ensure.that(TIPO_CUENTA_TICKET_UNI.resolveFor(actor).getAttribute(TEXT_CONTENT)).isEqualTo(t.getTipoCuenta())).performAs(actor);
        actor.attemptsTo(Scroll.to(TIPO_CUENTA_TICKET_UNI).andAlignToTop());
        LeerArchivoProperties.esperar2();
        Task.where(actor + " valida que 'Banco' sea igual a " + "'" + t.getBanco() + "'", Ensure.that(BANCO_TICKET_UNI.resolveFor(actor).getAttribute(TEXT_CONTENT)).isEqualTo(t.getBanco())).performAs(actor);
        actor.attemptsTo(Scroll.to(BANCO_TICKET_UNI).andAlignToTop());
        LeerArchivoProperties.esperar2();
        Task.where(actor + " valida que 'Cuenta a transferir' sea igual a " + "'" + t.getCuentaDestino() + "'", Ensure.that(CUENTA_A_TRANSFERIR_TICKET_UNI.resolveFor(actor).getAttribute(TEXT_CONTENT)).isEqualTo(t.getCuentaDestino())).performAs(actor);
        actor.attemptsTo(Scroll.to(CUENTA_A_TRANSFERIR_TICKET_UNI).andAlignToTop());
        LeerArchivoProperties.esperar2();
        Task.where(actor + " valida que 'Tipo de documento' sea igual a " + "'" + t.getTipoIdentificacion() + "'", Ensure.that(TIPO_DOCUMENTO_TICKET_UNI.resolveFor(actor).getAttribute(TEXT_CONTENT)).isEqualTo(t.getTipoIdentificacion())).performAs(actor);
        actor.attemptsTo(Scroll.to(TIPO_DOCUMENTO_TICKET_UNI).andAlignToTop());
        LeerArchivoProperties.esperar2();
        Task.where(actor + " valida que 'Número de documento' sea igual a " + "'" + t.getNumeroIdentificacion() + "'", Ensure.that(NUMERO_DOCUMENTO_TICKET_UNI.resolveFor(actor).getAttribute(TEXT_CONTENT)).isEqualTo(t.getNumeroIdentificacion())).performAs(actor);
        Task.where(actor + " valida que 'Nombre de recibidor' sea igual a " + "'" + t.getNombreRecibidor() + "'", Ensure.that(NOMBRE_RECIBIDOR_TICKET_UNI.resolveFor(actor).getAttribute(TEXT_CONTENT)).isEqualTo(t.getNombreRecibidor())).performAs(actor);
        Task.where(actor + " valida que 'Correo electrónico' sea igual a " + "'" + t.getCorreo() + "'", Ensure.that(CORREO_ELECTRONICO_TICKET_UNI.resolveFor(actor).getAttribute(TEXT_CONTENT)).isEqualTo(t.getCorreo())).performAs(actor);
        Task.where(actor + " valida que 'Comisión ACH' se muestre", WaitUntil.the(COMISION_ACH_TICKET_UNI, isVisible()).forNoMoreThan(1).seconds()).performAs(actor);
        Task.where(actor + " valida que 'Cuenta' sea igual a " + "'" + t.getCuentaTicket() + "'", Ensure.that(CUENTA_TICKET_UNI.resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(t.getCuentaTicket())).performAs(actor);
        Task.where(actor + " valida que 'Estado' se muestre", WaitUntil.the(ESTADO_TICKET_UNI, isVisible()).forNoMoreThan(1).seconds()).performAs(actor);
        Task.where(actor + " valida que 'Fecha de ordenanza' se muestre", WaitUntil.the(FECHA_ORDENANZA_TICKET_UNI, isVisible()).forNoMoreThan(1).seconds()).performAs(actor);
        Task.where(actor + " valida que 'Fecha aplicada' se muestre", WaitUntil.the(FECHA_APLICADA_TICKET_UNI, isVisible()).forNoMoreThan(1).seconds()).performAs(actor);
        Task.where(actor + " valida que 'ID transacción' se muestre", WaitUntil.the(ID_TRANSACCION_TICKET_UNI, isVisible()).forNoMoreThan(1).seconds()).performAs(actor);

    }

    public static ValidaTicketTransferenciaUNI datosCorrectos(List<Transferencias> transferencias) {
        return Instrumented.instanceOf(ValidaTicketTransferenciaUNI.class).withProperties(transferencias);
    }
}
