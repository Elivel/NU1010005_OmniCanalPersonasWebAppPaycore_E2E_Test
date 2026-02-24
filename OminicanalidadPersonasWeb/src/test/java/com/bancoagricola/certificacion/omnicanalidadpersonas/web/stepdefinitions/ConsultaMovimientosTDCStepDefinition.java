package com.bancoagricola.certificacion.omnicanalidadpersonas.web.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.ValidarMovimientosTDCFecha;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.TransformacionALista;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ConsultaMovimientosTDCStepDefinition {

    @Dado("^valida los movimientos de tarjeta de crédito para una fecha especifica$")
    public void validaLosMovimientosDeTarjetaDeCréditoParaUnaFechaEspecifica(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                IngresoMenuTarjetasMovimentos.inicio(amortiTabla),
                ValidarMovimientosTDCFecha.datosCA(amortiTabla),
                MovimientosRangoFechas.datosCA());
    }

    @Entonces("^valida que se muestre el detalle de movimientos de tarjeta de crédito para un registro$")
    public void validaQueSeMuestreElDetalleDeMovimientosDeTarjetaDeCréditoParaUnRegistro(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                ValidaDetalleMovimientoTDC.inicio(amortiTabla));
    }
}