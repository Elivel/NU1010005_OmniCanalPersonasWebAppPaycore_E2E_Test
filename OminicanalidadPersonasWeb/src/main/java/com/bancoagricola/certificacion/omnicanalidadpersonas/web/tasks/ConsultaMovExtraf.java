package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoMenuExtrafinanciamientoMovimientos;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.MovimientosRangoFechas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.annotations.Step;

import java.util.List;

public class ConsultaMovExtraf implements Task {
    private List<Transferencias> datosDCA;

    public ConsultaMovExtraf(List<Transferencias> datosDCA) {
        this.datosDCA = datosDCA;
    }

    @Step("{0} 'Consulta de movimientos extrafinanciamiento'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias ca = datosDCA.get(0);
        actor.attemptsTo(
                IngresoMenuExtrafinanciamientoMovimientos.con(datosDCA),
                ValidarMovimientosExtraFecha.datosCA(datosDCA),
                MovimientosRangoFechas.datosCA());
    }

    public static ConsultaMovExtraf datosCA(List<Transferencias> datosDCA) {
        return Instrumented.instanceOf(ConsultaMovExtraf.class).withProperties(datosDCA);
    }
}