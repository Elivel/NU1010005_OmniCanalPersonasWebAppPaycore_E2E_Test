package com.bancoagricola.certificacion.omnicanalidadpersonas.web.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.ConsultaDetalleCuentaDeAhorro;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.TransformacionALista;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Entonces;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ConsultaDetalleCuentaAhorroStepDefinition {

    @Entonces("^valida que se muestren de forma correcta los datos de la cuenta de ahorro$")
    public void validaQueSeMuestrenDeFormaCorrectaLosDatosDeLaCuentaDeAhorro(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(ConsultaDetalleCuentaDeAhorro.datosCA(amortiTabla));
    }
}
