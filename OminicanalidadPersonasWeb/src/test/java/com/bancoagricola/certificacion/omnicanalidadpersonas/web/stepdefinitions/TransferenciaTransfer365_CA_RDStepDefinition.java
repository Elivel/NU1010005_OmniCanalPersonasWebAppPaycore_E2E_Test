package com.bancoagricola.certificacion.omnicanalidadpersonas.web.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoVerMasCtaAhorro;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoVerMasCtaCorriente;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.TransformacionALista;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class TransferenciaTransfer365_CA_RDStepDefinition {
    @Cuando("^diligencia los campos para realizar la transferencia a otro banco usando Transfer 365 CA-RD$")
    public void diligenciaLosCamposParaRealizarLaTransferenciaAOtroBancoUsandoTransfer365CARD(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                ValidadorEliminarFavoritos.datosCA(amortiTabla),
                IngresoVerMasCtaAhorro.inicio(amortiTabla),
                TransferenciaTransfer365CARDSinFavorito.datosCorrectos(amortiTabla));

    }


    @Cuando("^realiza la transferencia a otro banco usando Transfer 365 CA-RD desde un favorito$")
    public void realizaLaTransferenciaAOtroBancoUsandoTransfer365CARDDesdeUnFavorito(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(TransferenciaTransfer365SIPAConFavorito.datosCorrectos(amortiTabla));
    }

    @Cuando("^diligencia los campos para realizar la transferencia a otro banco usando Transfer 365 CA-RD CC$")
    public void diligenciaLosCamposParaRealizarLaTransferenciaAOtroBancoUsandoTransfer365CARDCC(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                ValidadorEliminarFavoritos.datosCA(amortiTabla),
                IngresoVerMasCtaCorriente.inicio(amortiTabla.get(0).getCuentaOrigen()),
                TransferenciaTransfer365CARDSinFavorito.datosCorrectos(amortiTabla));

    }
}
