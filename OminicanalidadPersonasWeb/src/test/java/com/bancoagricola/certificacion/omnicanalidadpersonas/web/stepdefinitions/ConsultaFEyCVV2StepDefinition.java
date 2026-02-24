package com.bancoagricola.certificacion.omnicanalidadpersonas.web.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoMenuTarjetasVerMasECARD;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.ValidaCVV2yFE;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.TransformacionALista;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Dado;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ConsultaFEyCVV2StepDefinition {

    @Dado("^realiza validación de  datos de e-card$")
    public void realizaValidaciónDeDatosDeECard(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
    theActorInTheSpotlight().attemptsTo(
            IngresoMenuTarjetasVerMasECARD.inicio(amortiTabla),
            ValidaCVV2yFE.datosCA(amortiTabla));
    }
}
