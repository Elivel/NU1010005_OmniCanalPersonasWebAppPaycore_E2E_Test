package com.bancoagricola.certificacion.omnicanalidadpersonas.web.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.MovimientosRangoFechas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.FiltrarExportarFondos;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.IngresoVerMasFondosInversion;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.TransformacionALista;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ExportarMovimientosFondoInversionStepDefinition {

    @Cuando("^consulta los movimientos del fondo de inversion para una fecha especifica$")
    public void consultaLosMovimientosDelFondoDeInversionParaUnaFechaEspecifica(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                IngresoVerMasFondosInversion.inicio(amortiTabla.get(0).getFondoInversion()),
                FiltrarExportarFondos.inversion(amortiTabla),
                MovimientosRangoFechas.datosCA()
        );
    }
}