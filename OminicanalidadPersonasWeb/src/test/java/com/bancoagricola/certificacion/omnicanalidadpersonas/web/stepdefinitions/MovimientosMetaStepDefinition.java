package com.bancoagricola.certificacion.omnicanalidadpersonas.web.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Meta;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.ValidaMovimientosDeMeta;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.TransformacionALista;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class MovimientosMetaStepDefinition {

    @Cuando("^valida que para la meta se muestren los movimientos$")
    public void validaQueParaLaMetaSeMuestrenLosMovimientos(DataTable dataTable) {
        List<Meta> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Meta.class);
        theActorInTheSpotlight().attemptsTo(ValidaMovimientosDeMeta.datosMet(amortiTabla));
    }
}