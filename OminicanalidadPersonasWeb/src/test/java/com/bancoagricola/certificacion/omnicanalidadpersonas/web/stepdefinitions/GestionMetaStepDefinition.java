package com.bancoagricola.certificacion.omnicanalidadpersonas.web.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Meta;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.TransformacionALista;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class GestionMetaStepDefinition {

    @Cuando("^completa el proceso para crear meta$")
    public void completaElProcesoParaCrearMeta(DataTable dataTable) {
        List<Meta> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Meta.class);
        theActorInTheSpotlight().attemptsTo(
                ValidadorEliminarMeta.datosCA(amortiTabla),
                CreaMeta.datosMet(amortiTabla));
    }

    @Cuando("^realiza el proceso de modificación de la meta y valida los cambios$")
    public void realizaElProcesoDeModificaciónDeLaMetaYValidaLosCambios(DataTable dataTable) {
        List<Meta> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Meta.class);
        theActorInTheSpotlight().attemptsTo(
                ModificaMeta.datosMet(amortiTabla));
    }

    @Entonces("^realiza el proceso de eliminacion de la meta$")
    public void realizaElProcesoDeEliminacionDeLaMeta(DataTable dataTable) {
        List<Meta> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Meta.class);
        theActorInTheSpotlight().attemptsTo(
                EliminaMeta.datosMet(amortiTabla));
    }

    @Cuando("^realiza el proceso de aporte a la meta y valida los cambios$")
    public void realizaElProcesoDeAporteALaMetaYValidaLosCambios(DataTable dataTable) {
        List<Meta> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Meta.class);
        theActorInTheSpotlight().attemptsTo(
                AportaAMeta.datosMet(amortiTabla));
    }

    @Cuando("^realiza el proceso de retiro a la meta y valida los cambios$")
    public void realizaElProcesoDeRetiroALaMetaYValidaLosCambios(DataTable dataTable) {
        List<Meta> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Meta.class);
        theActorInTheSpotlight().attemptsTo(
                RetiraDeMeta.datosMet(amortiTabla));
    }
}
