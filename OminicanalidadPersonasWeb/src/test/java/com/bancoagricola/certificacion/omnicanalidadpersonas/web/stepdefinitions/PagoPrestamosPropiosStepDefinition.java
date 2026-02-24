package com.bancoagricola.certificacion.omnicanalidadpersonas.web.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoMenuCAOrigenMovimientos;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoMenuCtaAhorroOrigenMovimientos;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoMenuCtaCorrienteOrigenMovimientos;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.TransformacionALista;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class PagoPrestamosPropiosStepDefinition {

    @Dado("^valida los saldos antes de realizar la transacción$")
    public void validaLosSaldosPrevioAntesDeRealizarLaTransaccion(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                IngresoMenuCtaAhorroOrigenMovimientos.inicio(amortiTabla),
                ValidaSaldoDispCAAntes.datosP(amortiTabla));
    }

    @Dado("^valida los saldos antes de realizar la transacción para CC$")
    public void validaLosSaldosPrevioAntesDeRealizarLaTransaccionParaCC(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                IngresoMenuCtaCorrienteOrigenMovimientos.inicio(amortiTabla),
                ValidaSaldoDispCAAntes.datosP(amortiTabla)
        );
    }


    @Dado("^realiza el proceso de pago de préstamo propio desde la cuenta de ahorro$")
    public void realizaElProcesoDePagoDePréstamoPropioDesdeLaCuentaDeAhorro(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                PagoPrestamoDesdeCA.datosP(amortiTabla));
    }

    @Entonces("^Valida los saldos posterior a realizar la transacción$")
    public void ValidaLosSaldosPosteriorARealizarLaTransaccion(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                IngresoMenuCtaAhorroOrigenMovimientos.inicio(amortiTabla)
                //ValidaSaldoDispCADespues.datosP(amortiTabla)
        );
    }

    @Entonces("^valida los saldos posterior a realizar la transacción para CC$")
    public void validaLosSaldosPosteriorARealizarLaTransaccionParaCC(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                IngresoMenuCtaCorrienteOrigenMovimientos.inicio(amortiTabla)
                // ValidaSaldoDispCADespues.datosP(amortiTabla)
        );
    }

    @Entonces("^valida los saldos posterior a realizar la transacción visualizando un incremento$")
    public void validaLosSaldosPosteriorARealizarLaTransaccionVisualizandoUnIncremento(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                IngresoMenuCtaAhorroOrigenMovimientos.inicio(amortiTabla),
                ValidaSaldoDispCADespuesAgg.datosP(amortiTabla));
    }

    @Entonces("^valida los saldos posterior a realizar la transacción visualizando un incremento CC$")
    public void validaLosSaldosPosteriorARealizarLaTransaccionVisualizandoUnIncrementoCC(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                IngresoMenuCtaCorrienteOrigenMovimientos.inicio(amortiTabla),
                ValidaSaldoDispCADespuesAgg.datosP(amortiTabla));
    }

    @Dado("^realiza el proceso de pago de préstamo propio desde el préstamo$")
    public void realizaElProcesoDePagoDePréstamoPropioDesdeElPréstamo(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                PagoPrestamoDesdePR.datosP(amortiTabla));
    }

    @Dado("^realiza el proceso de pago de préstamo propio desde la cuenta corriente$")
    public void realizaElProcesoDePagoDePréstamoPropioDesdeLaCuentaCorriente(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                PagoPrestamoDesdeCC.datosP(amortiTabla));
    }

    @Entonces("^valida que se muestre el fondo reservado con la referencia indicada en el ticket$")
    public void validaQueSeMuestreElFondoReservadoConLaReferenciaIndicadaEnElTicket() {
        theActorInTheSpotlight().attemptsTo(
                ValidaReferenciaTicketCAFondosReservados.conLaReferencia());
    }

    @Entonces("^valida que se muestre el fondo reservado con el numero de reserva indicado en el ticket$")
    public void validaQueSeMuestreElFondoReservadoConElNumeroDeReferenciaIndicadoEnElTicket() {
        theActorInTheSpotlight().attemptsTo(
                ValidaReferenciaTicketCAFondosReservados.conLaReferencia());
    }
}