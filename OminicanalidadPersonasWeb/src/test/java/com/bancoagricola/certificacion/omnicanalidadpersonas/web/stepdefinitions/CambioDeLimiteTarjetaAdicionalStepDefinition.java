package com.bancoagricola.certificacion.omnicanalidadpersonas.web.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.CambioLimiteTarjetaAdicional;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.CapturarComprobanteCambioLimiteTdcAd;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.TransformacionALista;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CambioDeLimiteTarjetaAdicionalStepDefinition {

    @Cuando("^el cliente realiza la gestion de cambio de limite en tarjeta adicional$")
    public void elClienteRealizaLaGestionDeCambioDeLimiteEnTarjetaAdicional(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(CambioLimiteTarjetaAdicional.inicio(amortiTabla));

    }


    @Entonces("^debe visualizarse el limite actualizado en la tarjeta adicional$")
    public void debeVisualizarseElLimiteActualizadoEnLaTarjetaAdicional(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(CapturarComprobanteCambioLimiteTdcAd.inicio(amortiTabla));
        

    }

}
