package com.bancoagricola.certificacion.omnicanalidadpersonas.web.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.ValidarMovimientosCuentasFecha;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.ValidarMovimientosCuentasOpcion;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.TransformacionALista;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Entonces;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ConsultaMovimientosAhorroProgramadoStepDefinition {

    @Entonces("^valida los movimientos de la cuenta de ahorro programado para semana actual$")
    public void validaLosMovimientosDeLaCuentaDeAhorroProgramadoParaSemanaActual(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                IngrsoMenAhorrosAPMovmts.inicio(amortiTabla),
                ValidarMovimientosCuentasOpcion.datosCA(amortiTabla),
                MovimientosSemanaActual.datosCA());
    }

    @Entonces("^valida los movimientos de la cuenta de ahorro programado para mes actual$")
    public void validaLosMovimientosDeLaCuentaDeAhorroProgramadoParaMesActual(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                IngrsoMenAhorrosAPMovmts.inicio(amortiTabla),
                ValidarMovimientosCuentasOpcion.datosCA(amortiTabla),
                MovimientosMesActual.datosCA());
    }

    @Entonces("^valida los movimientos de la cuenta de ahorro programado para Últimos seis meses$")
    public void validaLosMovimientosDeLaCuentaDeAhorroProgramadoParaÚltimosSeisMeses(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                IngrsoMenAhorrosAPMovmts.inicio(amortiTabla),
                ValidarMovimientosCuentasOpcion.datosCA(amortiTabla),
                MovimntosUltimsSeisM.datosCA());
    }

    @Entonces("^valida los movimientos de la cuenta de ahorro programado para una fecha especifica$")
    public void validaLosMovimientosDeLaCuentaDeAhorroProgramadoParaUnaFechaEspecifica(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                IngrsoMenAhorrosAPMovmts.inicio(amortiTabla),
                ValidarMovimientosCuentasFecha.datosCA(amortiTabla),
                MovimientosRangoFechas.datosCA());
    }
}
