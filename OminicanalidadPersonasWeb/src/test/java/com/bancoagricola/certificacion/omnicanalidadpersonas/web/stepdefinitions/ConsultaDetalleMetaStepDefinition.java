package com.bancoagricola.certificacion.omnicanalidadpersonas.web.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Meta;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.ConsultaDetalleDeMeta;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.TransformacionALista;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ConsultaDetalleMetaStepDefinition {

    @Cuando("^valida el detalle para la meta$")
    public void validaElDetalleParaLaMeta(DataTable dataTable) {
        List<Meta> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Meta.class);
        theActorInTheSpotlight().attemptsTo(ConsultaDetalleDeMeta.datosMet(amortiTabla));
    }
}
