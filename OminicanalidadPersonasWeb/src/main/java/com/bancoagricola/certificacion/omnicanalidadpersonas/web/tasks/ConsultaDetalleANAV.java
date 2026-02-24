package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoVerMasDetalleCtaAhorro;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.AhorrosPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.TEXT_CONTENT;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ConsultaDetalleANAV implements Task {
    private List<Transferencias> datosTransferencias;
    public ConsultaDetalleANAV(List<Transferencias> datosDCA) { this.datosTransferencias = datosDCA;}

    @Step("{0} 'ingresa al menú'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias t = datosTransferencias.get(0);
        LeerArchivoProperties.esperar(3);
        actor.attemptsTo(
                Ensure.that(REFERENCIA_AN1.of(t.getNumeroContrato())).isDisplayed(),
                Ensure.that(CONTRATO_AN1.of(t.getNumeroContrato())).isDisplayed(),
                Ensure.that(FECHA_CONTRAT_AN1.of(t.getNumeroContrato())).isDisplayed(),
                Ensure.that(ESTADO_AN1.of(t.getNumeroContrato())).isDisplayed());
        actor.remember(VariablesSesion.REF_AN1.toString(), REFERENCIA_AN1.of(t.getNumeroContrato()).resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.remember(VariablesSesion.CONTR_AN1.toString(), CONTRATO_AN1.of(t.getNumeroContrato()).resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.remember(VariablesSesion.FECON_AN1.toString(), FECHA_CONTRAT_AN1.of(t.getNumeroContrato()).resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.remember(VariablesSesion.EST_AN1.toString(), ESTADO_AN1.of(t.getNumeroContrato()).resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.attemptsTo(
                WaitUntil.the(REGISTRO.of(t.getNumeroContrato()), isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(REGISTRO.of(t.getNumeroContrato()), isClickable()).forNoMoreThan(30).seconds(),
                Click.on(REGISTRO.of(t.getNumeroContrato())),
                WaitUntil.the(RES_AHO_NAV, isEnabled()).forNoMoreThan(60).seconds(),
                Ensure.that(SERV_AHO_NAV).isDisplayed(),
                Ensure.that(ESTADO_AN1_2).textContent().isEqualTo(actor.recall(VariablesSesion.EST_AN1.toString())),
                Ensure.that(CONTRATO_AN1_2).textContent().isEqualTo(actor.recall(VariablesSesion.CONTR_AN1.toString())),
                Ensure.that(SALDO_AHO_NAV).isDisplayed(),
                Ensure.that(FECHA_CONTRAT_AN1_2).textContent().isEqualTo(actor.recall(VariablesSesion.FECON_AN1.toString())),
                Ensure.that(FECHA_ULT_REN_AN).isDisplayed(),
                Ensure.that(FECHA_PRO_CUO_AN).isDisplayed(),
                Ensure.that(FECHA_PRO_LIBFON_AN).isDisplayed(),
                Ensure.that(CUOTA_MENS_AHO_NAV).isDisplayed(),
                Ensure.that(DIA_RETENCION_AN).isDisplayed(),
                Ensure.that(CUENTA_AN).isDisplayed(),
                Ensure.that(AGEN_CONT_AN).isDisplayed(),
                Ensure.that(FECHA_CANC_AN).isDisplayed());
    }

    public static ConsultaDetalleANAV para(List<Transferencias> datosDCA) {
        return Instrumented.instanceOf(ConsultaDetalleANAV.class).withProperties(datosDCA);
    }
}