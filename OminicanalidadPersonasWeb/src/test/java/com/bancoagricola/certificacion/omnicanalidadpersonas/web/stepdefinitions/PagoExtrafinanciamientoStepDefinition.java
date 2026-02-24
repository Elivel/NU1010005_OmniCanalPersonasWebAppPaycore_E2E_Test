package com.bancoagricola.certificacion.omnicanalidadpersonas.web.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.PagarExtrafinanciciamiento;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.PagarExtrafinanciciamientoCC;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.TransformacionALista;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class PagoExtrafinanciamientoStepDefinition {

    @Cuando("^realiza el pago de extrafinanciamiento usando CA$")
    public void realizaElPagoDeExtrafinanciamientoUsandoCA(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(PagarExtrafinanciciamiento.cuentaPropia(amortiTabla));
    }

    @Cuando("^realiza el pago de extrafinanciamiento usando CC$")
    public void realizaElPagoDeExtrafinanciamientoUsandoCC(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(PagarExtrafinanciciamientoCC.cuentaPropia(amortiTabla));
    }
}