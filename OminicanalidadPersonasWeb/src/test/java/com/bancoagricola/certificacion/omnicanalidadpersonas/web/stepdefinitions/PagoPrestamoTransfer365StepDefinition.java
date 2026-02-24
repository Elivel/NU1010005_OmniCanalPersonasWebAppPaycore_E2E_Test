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

public class PagoPrestamoTransfer365StepDefinition {

    @Cuando("^diligencia los campos para realizar el pago de prestamo a otro banco usando Transfer 365$")
    public void diligenciaLosCamposParaRealizarElPagoPrestamoAOtroBancoUsandoTransfer365(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                ValidadorEliminarFavoritos.datosCA(amortiTabla),
                IngresoVerMasCtaAhorro.inicio(amortiTabla),
                IngresarPagoPrestamoTransfer365.inicio(),
                PagarUsandoTransfer365SinFavorito.datosCorrectos(amortiTabla));
    }

    @Cuando("^diligencia los campos para realizar el pago de prestamo a otro banco usando Transfer 365 desde CC$")
    public void diligenciaLosCamposParaRealizarElPagoPrestamoAOtroBancoUsandoTransfer365DesdeCC(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                ValidadorEliminarFavoritos.datosCA(amortiTabla),
                IngresoVerMasCtaCorriente.inicio(amortiTabla.get(0).getCuentaOrigen()),
                IngresarPagoPrestamoTransfer365.inicio(),
                PagarUsandoTransfer365SinFavorito.datosCorrectos(amortiTabla));
    }

    @Cuando("^realiza el pago de prestamo a otro banco usando Transfer 365 desde un favorito$")
    public void RealizaElPagoPrestamoAOtroBancoUsandoTransfer365DesdeUnFavorito(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                IngresarFavoritoPagoPrestamoTransfer365.inicio(amortiTabla));
    }

    @Cuando("^realiza el pago de prestamo a otro banco usando Transfer 365 desde un favorito desde CC$")
    public void RealizaElPagoPrestamoAOtroBancoUsandoTransfer365DesdeUnFavoritoDesdeCC(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                IngresarFavoritoPagoPrestamoTransfer365CC.inicio(amortiTabla));
    }
}