package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.TransferenciaInternacional;
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

public class ValidaTicketTransferenciaInternacional implements Task {

    private List<TransferenciaInternacional> datos;

    public ValidaTicketTransferenciaInternacional(List<TransferenciaInternacional> datos) {
        this.datos = datos;
    }

    @Step("{0} 'realiza validacion de ticket'")
    @Override
    public <T extends Actor> void performAs(T actor) {

        TransferenciaInternacional t = datos.get(0);

        Task.where(actor+" valida que 'No operación' sea igual a "+"'"+actor.recall(REFERENCIA_TICKET_VAR.toString()).toString()+"'",  Ensure.that(REFERENCIA_TICKET.resolveFor(actor).getAttribute(TEXT_CONTENT).substring(12).trim()).isEqualTo(actor.recall(REFERENCIA_TICKET_VAR.toString()).toString())).performAs(actor);
        Task.where(actor+" valida que 'NÚMERO DE CUENTA, IBAN O CLABE' sea igual a "+"'"+t.getNroCuenta()+"'",  Ensure.that(NUMERO_CUENTA_TICKET_TI.resolveFor(actor).getAttribute(TEXT_CONTENT)).isEqualTo(t.getNroCuenta())).performAs(actor);
        Task.where(actor+" valida que 'Nombre del beneficiario' sea igual a "+"'"+t.getNombreBeneficiario()+"'",  Ensure.that(NOMBRE_BENEFICIARIO_TICKET_TI.resolveFor(actor).getAttribute(TEXT_CONTENT)).isEqualTo(t.getNombreBeneficiario())).performAs(actor);
        actor.attemptsTo(Scroll.to(NOMBRE_BENEFICIARIO_TICKET_TI).andAlignToTop());
        LeerArchivoProperties.esperar2();
        Task.where(actor+" valida que 'Dirección del beneficiario' sea igual a "+"'"+t.getDireccionBeneficiario()+"'",  Ensure.that(DIR_BEN_TICKET_TI.resolveFor(actor).getAttribute(TEXT_CONTENT)).isEqualTo(t.getDireccionBeneficiario())).performAs(actor);
        actor.attemptsTo(Scroll.to(DIR_BEN_TICKET_TI).andAlignToTop());
        LeerArchivoProperties.esperar2();
        Task.where(actor+" valida que 'País/Región' sea igual a "+"'"+t.getPais()+"'",  Ensure.that(PAIS_REG_TICKET_TI.resolveFor(actor).getAttribute(TEXT_CONTENT)).isEqualTo(t.getPais())).performAs(actor);
        actor.attemptsTo(Scroll.to(PAIS_REG_TICKET_TI).andAlignToTop());
        LeerArchivoProperties.esperar2();
        Task.where(actor+" valida que 'Tipo de red' sea igual a "+"'"+t.getTipoRed()+"'",  Ensure.that(TIP_RED_TICKET_TI.resolveFor(actor).getAttribute(TEXT_CONTENT)).isEqualTo(t.getTipoRed())).performAs(actor);
        Task.where(actor+" valida que 'Código de ruteo del banco beneficiario' sea igual a "+"'"+t.getCodigoBan2()+"'",  Ensure.that(COD_RUTEO_BEN_TICKET_TI.resolveFor(actor).getAttribute(TEXT_CONTENT)).isEqualTo(t.getCodigoBan2())).performAs(actor);
        Task.where(actor+" valida que 'Nombre del banco beneficiario (banco pagador)' se muestre", WaitUntil.the(NOM_BAN_BEN_TICKET_TI, isVisible()).forNoMoreThan(1).seconds()).performAs(actor);
        Task.where(actor+" valida que 'Dirección del banco beneficiario' se muestre", WaitUntil.the(DIR_BAN_BEN_TICKET_TI, isVisible()).forNoMoreThan(1).seconds()).performAs(actor);
        Task.where(actor+" valida que 'País/Región' se muestre", WaitUntil.the(PAIS_BAN_BEN_TICKET_TI, isVisible()).forNoMoreThan(1).seconds()).performAs(actor);
        actor.attemptsTo(Scroll.to(SBTTL_INF2_TI).andAlignToTop());
        LeerArchivoProperties.esperar2();
        Task.where(actor+" valida que 'Cuenta a debitar' sea igual a "+"'"+t.getCuentaOrigen()+"'",  Ensure.that(CUENTA_DEBITAR_TICKET_TI.resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(t.getCuentaOrigen())).performAs(actor);
        Task.where(actor+" valida que 'Nombre' se muestre", WaitUntil.the(NOMBRE_TICKET_TI, isVisible()).forNoMoreThan(1).seconds()).performAs(actor);
        Task.where(actor+" valida que 'Dirección' se muestre", WaitUntil.the(DIRECCION_TICKET_TI, isVisible()).forNoMoreThan(1).seconds()).performAs(actor);
        Task.where(actor+" valida que 'Teléfono 1' se muestre", WaitUntil.the(TELEFONO1_TICKET_TI, isVisible()).forNoMoreThan(1).seconds()).performAs(actor);
        actor.attemptsTo(Scroll.to(SBTTL_INF3_TI).andAlignToTop());
        LeerArchivoProperties.esperar2();
        Task.where(actor+" valida que 'Moneda' sea igual a "+"'"+t.getMoneda()+"'",  Ensure.that(MONEDA_TICKET_TI.resolveFor(actor).getAttribute(TEXT_CONTENT)).isEqualTo(t.getMoneda())).performAs(actor);
        Task.where(actor+" valida que 'Monto de la transacción' sea igual a "+"'"+t.getMonto()+"'",  Ensure.that(MONTO_TRANSACCION_TICKET_TI.resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(t.getMonto())).performAs(actor);
        Task.where(actor+" valida que 'Equivalente en dólares' se muestre", WaitUntil.the(EQUIVALENTE_DOL_TICKET_TI, isVisible()).forNoMoreThan(1).seconds()).performAs(actor);
        actor.attemptsTo(Scroll.to(SBTTL_INF4_TI).andAlignToTop());
        LeerArchivoProperties.esperar2();
        Task.where(actor+" valida que 'Nivel 1' sea igual a "+"'"+t.getNivel1()+"'",  Ensure.that(NIVEL1_TICKET_TI.resolveFor(actor).getAttribute(TEXT_CONTENT)).isEqualTo(t.getNivel1())).performAs(actor);
        Task.where(actor+" valida que 'Nivel 2' sea igual a "+"'"+t.getNivel2()+"'",  Ensure.that(NIVEL2_TICKET_TI.resolveFor(actor).getAttribute(TEXT_CONTENT)).isEqualTo(t.getNivel2())).performAs(actor);
        Task.where(actor+" valida que 'Detalle regulatorio' sea igual a "+"'"+t.getDetalle()+"'",  Ensure.that(DETALLE_REGULA_TICKET_TI.resolveFor(actor).getAttribute(TEXT_CONTENT)).isEqualTo(t.getDetalle())).performAs(actor);
        Task.where(actor+" valida que 'Número de formulario' se muestre", WaitUntil.the(NUMERO_FORMULARIO_TICKET_TI, isVisible()).forNoMoreThan(1).seconds()).performAs(actor);
        Task.where(actor+" valida que 'Estado' se muestre", WaitUntil.the(ESTADO_TICKET_UNI, isVisible()).forNoMoreThan(1).seconds()).performAs(actor);
        Task.where(actor+" valida que 'Fecha de ordenanza' se muestre", WaitUntil.the(FECHA_ORDENANZA_TICKET_UNI, isVisible()).forNoMoreThan(1).seconds()).performAs(actor);
        Task.where(actor+" valida que 'Fecha aplicada' se muestre", WaitUntil.the(FECHA_APLICADA_TICKET_TI, isVisible()).forNoMoreThan(1).seconds()).performAs(actor);
        Task.where(actor+" valida que 'ID transacción' se muestre", WaitUntil.the(ID_TRANSACCION_TICKET_UNI, isVisible()).forNoMoreThan(1).seconds()).performAs(actor);

    }

    public static ValidaTicketTransferenciaInternacional datosCorrectos(List<TransferenciaInternacional> datos) {
        return Instrumented.instanceOf(ValidaTicketTransferenciaInternacional.class).withProperties(datos);
    }
}
