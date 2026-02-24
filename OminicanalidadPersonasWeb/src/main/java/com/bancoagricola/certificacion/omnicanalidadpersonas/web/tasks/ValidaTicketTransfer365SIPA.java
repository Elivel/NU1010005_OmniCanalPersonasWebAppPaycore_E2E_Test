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

public class ValidaTicketTransfer365SIPA implements Task {
    private List<Transferencias> transferencias;

    public ValidaTicketTransfer365SIPA(List<Transferencias> transferencias) {
        this.transferencias = transferencias;
    }


    public static ValidaTicketTransfer365SIPA datosCorrectos(List<Transferencias> transferencias) {
        return Instrumented.instanceOf(ValidaTicketTransfer365SIPA.class).withProperties(transferencias);
    }
    @Step("{0} 'realiza validacion de ticket'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias t = transferencias.get(0);

        Task.where(actor + " valida que 'Monto' sea igual a " + "'" + t.getMonto() + "'", Ensure.that(MONT_T365M.resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(t.getMonto())).performAs(actor);
        //Task.where(actor + " valida que 'Institución de destino' sea igual a " + "'" + t.getBanco() + "'", Ensure.that(INSTITUC_DEST_T365M.resolveFor(actor).getAttribute(TEXT_CONTENT)).isEqualTo(t.getBanco())).performAs(actor);
       actor.attemptsTo(Scroll.to(COMISION_T365_SIPA).andAlignToTop());
       LeerArchivoProperties.esperar2();
        Task.where(actor + " valida que 'Monto' sea igual a " + "'" + t.getMontoComision() + "'", Ensure.that(COMISION_T365_SIPA.resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(t.getMontoComision())).performAs(actor);
      actor.attemptsTo(Scroll.to(CUENTA_ORIGEN_T365_SIPA).andAlignToTop());
        LeerArchivoProperties.esperar2();
        Task.where(actor + " valida que 'Cuenta' sea igual a " + "'" + t.getCuentaCorta() + "'", Ensure.that(CUENTA_ORIGEN_T365_SIPA.resolveFor(actor).getAttribute(TEXT_CONTENT)).isEqualTo(t.getCuentaCorta())).performAs(actor);
        actor.attemptsTo(Scroll.to(TIPO_PAGO_T365_SIPA).andAlignToTop());
        LeerArchivoProperties.esperar2();
        Task.where(actor + " valida que 'Tipo de pago' sea igual a " + "'" + t.getTipoDePago()+ "'", Ensure.that(TIPO_PAGO_T365_SIPA.resolveFor(actor).getAttribute(TEXT_CONTENT)).isEqualTo(t.getTipoDePago())).performAs(actor);
        actor.attemptsTo(Scroll.to(DESCRIP_T365_SIPA).andAlignToTop());
        LeerArchivoProperties.esperar2();
        Task.where(actor + " valida que 'Descripción' sea igual a " + "'" + t.getDescripcion()+ "'", Ensure.that(DESCRIP_T365_SIPA.resolveFor(actor).getAttribute(TEXT_CONTENT)).isEqualTo(t.getDescripcion())).performAs(actor);
        actor.attemptsTo(Scroll.to(PAIS_BANCO_BENEF_T365_SIPA).andAlignToTop());
        LeerArchivoProperties.esperar2();
        Task.where(actor + " valida que 'País del banco beneficiario' sea igual a " + "'" + t.getPaisBancoBeneficiario()+ "'", Ensure.that(PAIS_BANCO_BENEF_T365_SIPA.resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(t.getPaisBancoBeneficiario())).performAs(actor);
        actor.attemptsTo(Scroll.to(BANCO_BENEF_T365_SIPA).andAlignToTop());
        LeerArchivoProperties.esperar2();
        Task.where(actor + " valida que 'Banco beneficiario' sea igual a " + "'" + t.getBancoBeneficiario()+ "'", Ensure.that(BANCO_BENEF_T365_SIPA.resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(t.getBancoBeneficiario())).performAs(actor);
        actor.attemptsTo(Scroll.to(NUM_IBAN_T365_SIPA).andAlignToTop());
        LeerArchivoProperties.esperar2();
        Task.where(actor + " valida que 'Número de Cuenta o IBAN' sea igual a " + "'" + t.getNumeroCuentaIban()+ "'", Ensure.that(NUM_IBAN_T365_SIPA.resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(t.getNumeroCuentaIban())).performAs(actor);
        actor.attemptsTo(Scroll.to(NOMBRE_BENEF_T365_SIPA).andAlignToTop());
        LeerArchivoProperties.esperar2();
        Task.where(actor + " valida que 'Nombre completo de la persona que recibirá la transferencia.' sea igual a " + "'" + t.getNombreBeneficiario()+ "'", Ensure.that(NOMBRE_BENEF_T365_SIPA.resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(t.getNombreBeneficiario())).performAs(actor);
        actor.attemptsTo(Scroll.to(NUM_DOCUMENT_BENEF_T365_SIPA).andAlignToTop());
        LeerArchivoProperties.esperar2();
        Task.where(actor + " valida que 'Número de documento de identificación de la persona que recibirá la transferencia.' sea igual a " + "'" + t.getNumeroDocumentoBeneficiario()+ "'", Ensure.that(NUM_DOCUMENT_BENEF_T365_SIPA.resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(t.getNumeroDocumentoBeneficiario())).performAs(actor);
        actor.attemptsTo(Scroll.to(CIUDAD_BENEF_T365_SIPA).andAlignToTop());
        LeerArchivoProperties.esperar2();
        Task.where(actor + " valida que 'Cuidad donde se encuentra la persona que recibirá la transferencia.' sea igual a " + "'" + t.getCiudad()+ "'", Ensure.that(CIUDAD_BENEF_T365_SIPA.resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(t.getCiudad())).performAs(actor);
        actor.attemptsTo(Scroll.to(DIRECCIOPN_BENEF_T365_SIPA).andAlignToTop());
        LeerArchivoProperties.esperar2();
        Task.where(actor + " valida que 'Dirección' sea igual a " + "'" + t.getDireccion()+ "'", Ensure.that(DIRECCIOPN_BENEF_T365_SIPA.resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(t.getDireccion())).performAs(actor);

        actor.attemptsTo(Scroll.to(ESTADO_TICKET_UNI).andAlignToTop());
        LeerArchivoProperties.esperar2();
        Task.where(actor + " valida que 'Estado' se muestre", WaitUntil.the(ESTADO_TICKET_UNI, isVisible()).forNoMoreThan(1).seconds()).performAs(actor);
        Task.where(actor + " valida que 'Fecha de ordenanza' se muestre", WaitUntil.the(FECHA_ORDENANZA_TICKET_UNI, isVisible()).forNoMoreThan(1).seconds()).performAs(actor);
        Task.where(actor + " valida que 'Fecha aplicada' se muestre", WaitUntil.the(FECHA_APLICADA_T365M, isVisible()).forNoMoreThan(1).seconds()).performAs(actor);
        Task.where(actor + " valida que 'ID transacción' se muestre", WaitUntil.the(ID_TRANSACCION_TICKET_UNI, isVisible()).forNoMoreThan(1).seconds()).performAs(actor);


    }
}
