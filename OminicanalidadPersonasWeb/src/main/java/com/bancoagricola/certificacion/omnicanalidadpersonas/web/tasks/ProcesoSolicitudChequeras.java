package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.Comprobante365.LABEL_COMPROBANTE;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.Comprobante365.REFERENCIA_365;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.BOTON_IMPRIMIR;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.TEXT_CONTENT;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ProcesoSolicitudChequeras implements Task {
    private List<Transferencias> datosDCA;

    public ProcesoSolicitudChequeras(List<Transferencias> datosDCA) {
        this.datosDCA = datosDCA;
    }

    @Step("{0} 'realiza proceso para solicitud de chequeras'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias ca = datosDCA.get(0);
        actor.attemptsTo(
                Scroll.to(GESTION_CHEQUERAS).andAlignToTop());
        LeerArchivoProperties.esperar(1);
        actor.attemptsTo(
                WaitUntil.the(GESTION_CHEQUERAS, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(GESTION_CHEQUERAS, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(SOLICITUD_CHEQUERAS, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(SOLICITUD_CHEQUERAS, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(SOLICITUD_CHEQUERAS, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(SOLICITUD_CHEQUERAS),
                WaitUntil.the(TT_SOLICITUD_CHEQUERAS, isVisible()).forNoMoreThan(60).seconds());
        LeerArchivoProperties.esperar(2);
        actor.attemptsTo(
                WaitUntil.the(TIPO_CHEQ, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(TIPO_CHEQ, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(TIPO_CHEQ),
                WaitUntil.the(OPC_TIPO_CHEQ.of(ca.getTipoChequera()), isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPC_TIPO_CHEQ.of(ca.getTipoChequera()), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(OPC_TIPO_CHEQ.of(ca.getTipoChequera())));
        LeerArchivoProperties.esperar(2);
        actor.attemptsTo(
                WaitUntil.the(CANT_CHEQ, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(CANT_CHEQ, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(CANT_CHEQ),
                WaitUntil.the(OPC_CANT_CHEQ.of(ca.getCantidadCheques()), isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPC_CANT_CHEQ.of(ca.getCantidadCheques()), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(OPC_CANT_CHEQ.of(ca.getCantidadCheques())));
        LeerArchivoProperties.esperar(2);
        actor.attemptsTo(
                WaitUntil.the(DEPTO, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(DEPTO, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(DEPTO),
                WaitUntil.the(OPC_DEPTO.of(ca.getDepartamentoEntrega()), isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPC_DEPTO.of(ca.getDepartamentoEntrega()), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(OPC_DEPTO.of(ca.getDepartamentoEntrega())));
        LeerArchivoProperties.esperar(2);
        actor.attemptsTo(
                Scroll.to(AGENCIA).andAlignToTop(),
                WaitUntil.the(AGENCIA, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(AGENCIA, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(AGENCIA),
                WaitUntil.the(OPC_AGENCIA.of(ca.getAgenciaEntrega()), isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPC_AGENCIA.of(ca.getAgenciaEntrega()), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(OPC_AGENCIA.of(ca.getAgenciaEntrega())),
                WaitUntil.the(BTN_CONTINUAR, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_CONTINUAR, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_CONTINUAR),
                WaitUntil.the(VTN_EMERG_PP, isVisible()).forNoMoreThan(60).seconds(),
                Ensure.that(VTN_EMERG_PP).isDisplayed(),
                WaitUntil.the(BOTON_ACEPTAR_PP, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BOTON_ACEPTAR_PP, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BOTON_ACEPTAR_PP));
        WaitUntil.the(RESULT_SOLIC_CHEQ, isVisible()).forNoMoreThan(45).seconds().performAs(actor);

        /*Capturar comprobante*/
        actor.attemptsTo(
                CapturaComprobanteSolChequera.datosC(datosDCA),
                Scroll.to(LABEL_COMPROBANTE.of(BOTON_IMPRIMIR)).andAlignToTop());
        /* */
    }

    public static ProcesoSolicitudChequeras datosCA(List<Transferencias> datosDCA) {
        return Instrumented.instanceOf(ProcesoSolicitudChequeras.class).withProperties(datosDCA);
    }
}