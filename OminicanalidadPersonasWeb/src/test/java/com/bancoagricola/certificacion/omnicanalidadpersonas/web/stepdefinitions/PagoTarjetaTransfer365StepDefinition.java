package com.bancoagricola.certificacion.omnicanalidadpersonas.web.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoVerMasCtaAhorro;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoVerMasCtaCorriente;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.TransformacionALista;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Y;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class PagoTarjetaTransfer365StepDefinition {
    @Y("^diligencia los campos para realizar el pago de tarjeta a otro banco usando Transfer 365 desde CA$")
    public void diligenciaLosCamposParaRealizarElPagoDeTarjetaAOtroBancoUsandoTransferDesdeCA(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                ValidadorEliminarFavoritos.datosCA(amortiTabla),
                IngresoVerMasCtaAhorro.inicio(amortiTabla),
                IngresarPagoTarjetaTransfer365.inicio(),
                PagarTarjetaUsandoTransfer365SinFavorito.datosCorrectos(amortiTabla));
    }

    @Y("^diligencia los campos para realizar el pago de tarjeta a otro banco usando Transfer 365 desde CC$")
    public void diligenciaLosCamposParaRealizarElPagoDeTarjetaAOtroBancoUsandoTransferDesdeCC(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                ValidadorEliminarFavoritos.datosCA(amortiTabla),
                IngresoVerMasCtaCorriente.inicio(amortiTabla.get(0).getCuentaOrigen()),
                IngresarPagoTarjetaTransfer365.inicio(),
                PagarTarjetaUsandoTransfer365SinFavorito.datosCorrectos(amortiTabla));
    }

    @Y("^realiza el pago de tarjeta a otro banco usando Transfer 365 desde un favorito$")
    public void realizaElPagoDeTarjetaAOtroBancoUsandoTransferDesdeUnFavorito(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        LeerArchivoProperties.esperar(2);
        theActorInTheSpotlight().attemptsTo(
                IngresarFavoritoPagoTarjetaTransfer365.inicio(amortiTabla));
    }

    @Y("^realiza el pago de tarjeta a otro banco usando Transfer 365 desde un favorito CC$")
    public void realizaElPagoDeTarjetaAOtroBancoUsandoTransferDesdeUnFavoritoCC(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        LeerArchivoProperties.esperar(2);
        theActorInTheSpotlight().attemptsTo(
                IngresarFavoritoPagoTarjetaTransfer365CC.inicio(amortiTabla));
    }
}