package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoMenuServicios;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.SeleccEnCalendFechLista;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.SeleccionarEnCalendarioFechaLista;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.ServiciosPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class SeleccionaRangoFechasTipoTransaccionAudTrx implements Task {
    private List<Transferencias> datosAud;
    public SeleccionaRangoFechasTipoTransaccionAudTrx(List<Transferencias> datosAud) {
        this.datosAud = datosAud;
    }

    @Step("{0} 'selecciona rango de fechas y tipo de transacción'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias aud = datosAud.get(0);

                IngresoMenuServicios.inicio().performAs(actor);
                WaitUntil.the(AUDITORIATRX, isEnabled()).forNoMoreThan(60).seconds().performAs(actor);
                WaitUntil.the(AUDITORIATRX, isClickable()).forNoMoreThan(60).seconds().performAs(actor);
                Click.on(AUDITORIATRX).performAs(actor);
                WaitUntil.the(TABLA_RES, isVisible()).forNoMoreThan(60).seconds().performAs(actor);
                WaitUntil.the(TABLA_RES, isEnabled()).forNoMoreThan(60).seconds().performAs(actor);
                WaitUntil.the(BTN_FILTRAR, isVisible()).forNoMoreThan(60).seconds().performAs(actor);
                WaitUntil.the(BTN_FILTRAR, isEnabled()).forNoMoreThan(30).seconds().performAs(actor);
                WaitUntil.the(BTN_FILTRAR, isClickable()).forNoMoreThan(30).seconds().performAs(actor);
                Click.on(BTN_FILTRAR).performAs(actor);
                SeleccionarEnCalendarioFechaLista.laFecha(datosAud).performAs(actor);
                Scroll.to(PERIODO_TIEMPO).andAlignToTop().performAs(actor);
        LeerArchivoProperties.esperar2();
                WaitUntil.the(FILTROS_ADICIONALES, isEnabled()).forNoMoreThan(30).seconds().performAs(actor);
                WaitUntil.the(FILTROS_ADICIONALES, isClickable()).forNoMoreThan(30).seconds().performAs(actor);
                Click.on(FILTROS_ADICIONALES).performAs(actor);
                WaitUntil.the(TIPO_TRX, isEnabled()).forNoMoreThan(30).seconds().performAs(actor);
                WaitUntil.the(TIPO_TRX, isClickable()).forNoMoreThan(30).seconds().performAs(actor);
                Click.on(OPC_TIPO_CMB).performAs(actor);
                WaitUntil.the(SELECCIONA_OPC.of(aud.getTipoTRX()), isEnabled()).forNoMoreThan(30).seconds().performAs(actor);
                WaitUntil.the(SELECCIONA_OPC.of(aud.getTipoTRX()), isClickable()).forNoMoreThan(30).seconds().performAs(actor);
                Click.on(SELECCIONA_OPC.of(aud.getTipoTRX())).performAs(actor);
    }

    public static SeleccionaRangoFechasTipoTransaccionAudTrx datosAud(List<Transferencias> datosAud) {
        return Instrumented.instanceOf(SeleccionaRangoFechasTipoTransaccionAudTrx.class).withProperties(datosAud);
    }
}