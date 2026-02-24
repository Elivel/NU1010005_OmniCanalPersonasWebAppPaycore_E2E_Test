package com.bancoagricola.certificacion.omnicanalidadpersonas.web.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.MovimientosRangoFechas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.FiltrarExportarFondos;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.IngresoVerMasFondosInversion;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.TransformacionALista;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ConsultaMovimientosFondoInversionStepDefiniton {
    @Cuando("^ingresa al fondo de inversion (.*)$")
    public void ingresaAlFondoDeInversion(String fondo) {
        theActorInTheSpotlight().attemptsTo(
                IngresoVerMasFondosInversion.inicio(fondo));
    }

    @Entonces("^debe visualizar el listado de movimientos$")
    public void debeVisualizarElListadoDeMovimientos() {
        theActorInTheSpotlight().attemptsTo(
                MovimientosRangoFechas.datosCA());
    }

    @Y("^consulta los movimientos del fondo de inversion por fecha$")
    public void consultaLosMovimientosDelFondoDeInversionPorFecha(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                FiltrarExportarFondos.inversion(amortiTabla));
    }
}