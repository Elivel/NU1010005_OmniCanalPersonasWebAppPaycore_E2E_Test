package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.AgregaFavorito;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoMenuServicios;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoVerMasCtaAhorro;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.AhorrosPage.MENU_PRINC;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.Comprobante365.LABEL_COMPROBANTE;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.GeneralPage.OPCIONES_TRANSFERENCIAS;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.GeneralPage.RESULTADOS;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.ServiciosPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.ServiciosPage.PERIODO_TIEMPO;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.ServiciosPage.TABLA_RES;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion.REFERENCIA_TICKET_VAR;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class RealizarConsultaTrxProgramadas implements Task {

    private List<Transferencias> datostransferencias;

    public RealizarConsultaTrxProgramadas(List<Transferencias> datostransferencias) {
        this.datostransferencias = datostransferencias;
    }

    @Step("{0} realiza consulta de transacciones programadas")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias t = datostransferencias.get(0);

        actor.attemptsTo(
                IngresoMenuServicios.inicio(),
                WaitUntil.the(AUDITORIATRX, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(AUDITORIATRX, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(AUDITORIATRX),
                WaitUntil.the(TABLA_RES, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(TABLA_RES, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPC_FILTRAR, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPC_FILTRAR, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPC_FILTRAR, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(OPC_FILTRAR),
                WaitUntil.the(PERIODO_TIEMPO, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(PERIODO_TIEMPO, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPC_PERIODO.of(t.getPeriodo()), isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPC_PERIODO.of(t.getPeriodo()), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(OPC_PERIODO.of(t.getPeriodo())));
        LeerArchivoProperties.esperar(1);
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(FILTROS_ADICIONALES, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(FILTROS_ADICIONALES, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(FILTROS_ADICIONALES),
                SeleccionaEstado.datosAud(datostransferencias),
                Click.on(OP_CANAL_CMB),
                WaitUntil.the(SELECCIONA_OPC.of(t.getCanal()), isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(SELECCIONA_OPC.of(t.getCanal()), isClickable()).forNoMoreThan(30).seconds(),
                Click.on(SELECCIONA_OPC.of(t.getCanal())),
                WaitUntil.the(BTN_BUSCAR, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(BTN_BUSCAR, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(BTN_BUSCAR),
                Scroll.to(BTN_FILTRAR).andAlignToTop(),
                WaitUntil.the(TABLA_MOV_CA, isVisible()).forNoMoreThan(60).seconds());
    }

    public static RealizarConsultaTrxProgramadas nuevo(List<Transferencias> datostransferencias) {
        return Instrumented.instanceOf(RealizarConsultaTrxProgramadas.class).withProperties(datostransferencias);
    }
}
