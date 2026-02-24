package com.bancoagricola.certificacion.omnicanalidadpersonas.web.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Meta;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.AportaAMeta;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.ValidarExportarMovimientosMeta;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.ValidarImprimirMovimientosMeta;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.TransformacionALista;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ImprimirExportarMovimientosMeta {
    @Y("^realiza un aporte para generar movimientos$")
    public void realizaUnAporteParaGenerarMovimientos(DataTable dataTable) {
        List<Meta> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Meta.class);
        theActorInTheSpotlight().attemptsTo(
                AportaAMeta.datosMet(amortiTabla));
    }

    @Entonces("^ingresa a los movimientos de (.*) para (.*) el archivo$")
    public void ingresaALosMovimientosDeParaExportarElArchivo (String nombreMeta, String opcion) {
        theActorInTheSpotlight().attemptsTo(
                ValidarExportarMovimientosMeta.deMeta(nombreMeta,opcion));
    }

    @Entonces("^ingresa a los movimientos de (.*) para (.*) el documento$")
    public void ingresaALosMovimientosDeParaImprimirElDocumento(String nombreMeta, String opcion) {
        theActorInTheSpotlight().attemptsTo(
                ValidarImprimirMovimientosMeta.deMeta(nombreMeta,opcion));
    }
}