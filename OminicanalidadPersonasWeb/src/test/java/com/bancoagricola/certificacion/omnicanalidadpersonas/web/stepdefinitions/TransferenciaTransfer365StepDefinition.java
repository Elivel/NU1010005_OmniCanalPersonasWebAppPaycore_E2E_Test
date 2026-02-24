package com.bancoagricola.certificacion.omnicanalidadpersonas.web.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoVerMasCtaAhorro;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoVerMasCtaCorriente;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.TransformacionALista;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Y;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class TransferenciaTransfer365StepDefinition {

    @Cuando("^diligencia los campos para realizar la transferencia a otro banco usando Transfer 365$")
    public void diligenciaLosCamposParaRealizarLaTransferenciaAOtroBancoUsandoTransfer365(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                ValidadorEliminarFavoritos.datosCA(amortiTabla),
                IngresoVerMasCtaAhorro.inicio(amortiTabla),
                TransferenciaTransfer365SinFavorito.datosCorrectos(amortiTabla));
    }

    @Cuando("^diligencia los campos para realizar la transferencia a otro banco usando Transfer 365 desde CC$")
    public void diligenciaLosCamposParaRealizarLaTransferenciaAOtroBancoUsandoTransfer365DesdeCC(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                ValidadorEliminarFavoritos.datosCA(amortiTabla),
                IngresoVerMasCtaCorriente.inicio(amortiTabla.get(0).getCuentaOrigen()),
                TransferenciaTransfer365SinFavorito.datosCorrectos(amortiTabla));
    }

    @Cuando("^realiza la transferencia a otro banco usando Transfer 365 desde un favorito$")
    public void realizaLaTransferenciaAOtroBancoUsandoTransfer365DesdeUnFavorito(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                TransferenciaTransfer365ConFavorito.datosCorrectos(amortiTabla));
    }

    @Y("^consulta los fondos reservados$")
    public void consultaLosFondosReservados(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                FondosReservadosPagoes.datosFR(amortiTabla));
    }
    @Y("^consulta los fondos reservados de tarjeta$")
    public void consultaLosFondosReservadosDeTarjeta(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                FondosReservadosPagoesTDC.datosFR(amortiTabla));
    }

    @Y("^no encuentra consulta los fondos reservados$")
    public void noEncuentraConsultaLosFondosReservados(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                FondosLiberadosPagoes.datosFR(amortiTabla));
    }

    @Y("^no encuentra consulta los fondos reservados de tarjeta$")
    public void noEncuentraConsultaLosFondosReservadosDeTarjeta(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                FondosLiberadosPagoesTDC.datosFR(amortiTabla));
    }

    @Cuando("^diligencia los campos para realizar la transferencia a otro banco usando Transfer 365 movil$")
    public void diligenciaLosCamposParaRealizarLaTransferenciaAOtroBancoUsandoTransfer365Movil(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                ValidadorEliminarFavoritos.datosCA(amortiTabla),
                IngresoVerMasCtaAhorro.inicio(amortiTabla),
                TransferenciaTransfer365MovilSinFavorito.datosCorrectos(amortiTabla));
    }

    @Cuando("^diligencia los campos para realizar la transferencia a otro banco usando Transfer 365 movil CC$")
    public void diligenciaLosCamposParaRealizarLaTransferenciaAOtroBancoUsandoTransfer365MovilCC(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                ValidadorEliminarFavoritos.datosCA(amortiTabla),
                IngresoVerMasCtaCorriente.inicio(amortiTabla.get(0).getCuentaOrigen()),
                TransferenciaTransfer365MovilSinFavorito.datosCorrectos(amortiTabla));
    }

    @Cuando("^realiza la transferencia a otro banco usando Transfer 365 movil desde un favorito$")
    public void realizaLaTransferenciaAOtroBancoUsandoTransfer365MovilDesdeUnFavorito(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                TransferenciaTransfer365MovilConFavorito.datosCorrectos(amortiTabla));
    }
}