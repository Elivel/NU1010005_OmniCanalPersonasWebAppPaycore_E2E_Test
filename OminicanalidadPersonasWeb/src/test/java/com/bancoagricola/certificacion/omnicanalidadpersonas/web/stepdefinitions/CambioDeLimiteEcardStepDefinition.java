package com.bancoagricola.certificacion.omnicanalidadpersonas.web.stepdefinitions;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.CambioLimiteEcard;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.CapturarComprobanteCambioLimiteEcard;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.TransformacionALista;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;

import javax.xml.crypto.Data;
import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CambioDeLimiteEcardStepDefinition {
    @Cuando("^el cliente realiza la gestion de cambio de limite en tarjeta ecard$")
    public void elClienteRealizaLaGestionDeCambioDeLimiteEnTarjetaEcard(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(CambioLimiteEcard.inicio(amortiTabla));

    }


    @Entonces("^debe visualizarse el limite actualizado en la tarjeta ecard$")
    public void debeVisualizarseElLimiteActualizadoEnLaTarjetaEcard(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(CapturarComprobanteCambioLimiteEcard.inicio(amortiTabla));


    }

}
