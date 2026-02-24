package com.bancoagricola.certificacion.omnicanalidadpersonas.web.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.RealizarPagoComprasAPlazo;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.RealizarPagoComprasAPlazoCC;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.TransformacionALista;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Entonces;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class PagoComprasAPlazoStepDefinition {
    @Entonces("^se realiza el proceso de pagos de compras a plazo$")
    public void seRealizaElProcesoDePagosDeComprasAPlazo(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                RealizarPagoComprasAPlazo.datosP(amortiTabla));
    }

    @Entonces("^se realiza el proceso de pagos de compras a plazo desde CC$")
    public void seRealizaElProcesoDePagosDeComprasAPlazoDesdeCC(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                RealizarPagoComprasAPlazoCC.datosP(amortiTabla));
    }
}