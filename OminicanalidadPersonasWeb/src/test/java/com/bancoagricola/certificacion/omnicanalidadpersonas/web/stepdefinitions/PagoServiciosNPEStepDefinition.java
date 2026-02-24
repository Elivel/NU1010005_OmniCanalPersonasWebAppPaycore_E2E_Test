package com.bancoagricola.certificacion.omnicanalidadpersonas.web.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.TransformacionALista;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class PagoServiciosNPEStepDefinition {

    @Dado("^realiza el proceso de pago de servicio con NPE desde CA$")
    public void realizaElProcesoDePagoDeServicioConNPEDesdeCA(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        
        theActorInTheSpotlight().attemptsTo(
                IngresoVerMasCtaAhorro.inicio(amortiTabla),
                PagoServiciosNPE.datosCA(amortiTabla),
                ValidaTicketPagoServicioNPECuentas.datosCorrectos(amortiTabla));
    }

    @Dado("^realiza el proceso de pago de servicio con NPE desde CC$")
    public void realizaElProcesoDePagoDeServicioConNPEDesdeCC(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                IngresoVerMasCC.inicio(amortiTabla),
                PagoServiciosNPE.datosCA(amortiTabla),
                ValidaTicketPagoServicioNPECuentas.datosCorrectos(amortiTabla));
    }

    @Cuando("^realiza el proceso de pago de servicio con NPE desde tarjeta de crédito$")
    public void realizaElProcesoDePagoDeServicioConNPEDesdeTarjetaDeCrédito(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                IngresoVerMasTarjetas.inicio(amortiTabla),
                PagoServiciosNPE.datosCA(amortiTabla),
                ValidaTicketPagoServicioNPETarjeta.datosCorrectos(amortiTabla));
    }

    @Cuando("^valida los saldos antes de realizar la transaccion con tarjeta de credito$")
    public void validaLosSaldosAntesDeRealizarLaTransaccionConTarjetaDeCredito(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                IngresoMenuTarjetasMovimentos.inicio(amortiTabla),
                ValidaSaldoDispTCAntes.datosP(amortiTabla));
    }

    @Entonces("^valida los saldos posterior a realizar la transacción con tarjeta de credito$")
    public void validaLosSaldosPosteriorARealizarLaTransacciónConTarjetaDeCredito(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                IngresoMenuTarjetasMovimentos.inicio(amortiTabla),
                ValidaSaldoDispTCDespues.datosP(amortiTabla));
    }
}