package com.bancoagricola.certificacion.omnicanalidadpersonas.web.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.TransformacionALista;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ConsultaMovimientosADSStepDefinition {

    @Cuando("^realiza el traslado de saldo de la cuenta origen ADS a la cuenta destino$")
    public void realizaElTrasladoDeSaldoDeLaCuentaOrigenALaCuentaDestino(DataTable dataTable)  {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                IngresoVerMasADS.inicio(amortiTabla),
                RealizarTransferenciasEntreADS_CP.cuentasPropias(amortiTabla));
    }

    @Entonces("^valida los movimientos de ADS para semana actual$")
    public void validaLosMovimientosDeADSParaSemanaActual(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                IngresoMenuADSMovimientos.inicio(amortiTabla),
                ValidarMovimientosCuentasOpcion.datosCA(amortiTabla),
                MovimientosSemanaActual.datosCA());
    }
}