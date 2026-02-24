package com.bancoagricola.certificacion.omnicanalidadpersonas.web.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoVerMasPuntosBA;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.ValidarMovimientosPuntosBAFecha;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.TransformacionALista;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Dado;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ConsultaMovimientosPuntosBAStepDefinition {

    @Dado("^valida los movimientos de puntos BA para una fecha especifica$")
    public void validaLosMovimientosDePuntosBAEgresosParaUnaFechaEspecifica(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
    theActorInTheSpotlight().attemptsTo(
            IngresoVerMasPuntosBA.inicio(),
            ValidarMovimientosPuntosBAFecha.datosCA(amortiTabla));
    }
}