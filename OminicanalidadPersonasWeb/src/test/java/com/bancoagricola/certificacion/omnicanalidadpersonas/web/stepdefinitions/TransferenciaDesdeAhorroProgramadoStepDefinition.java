package com.bancoagricola.certificacion.omnicanalidadpersonas.web.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoMenuAhorrosAPMovimientos;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoMenuCtaAhorroDestinoMovimientos;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoMenuCtaCorrienteDestinoMovimientos;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngrsoMenAhorrosAPMovmts;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngrsoMenCADstnoMovim;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoMenuCCDestinoMovimientos;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoVerMasAhorroProgramado;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.TransformacionALista;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class TransferenciaDesdeAhorroProgramadoStepDefinition {

    @Dado("^valida los saldos antes de realizar la transacción para ambas cuentas$")
    public void validaLosSaldosAntesDeRealizarLaTransacciónParaAmbasCuentas(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                IngresoMenuAhorrosAPMovimientos.inicio(amortiTabla),
                ValidaSaldoDispAPAntes.datosP(amortiTabla),
                IngresoMenuCtaAhorroDestinoMovimientos.inicio(amortiTabla),
                ValidaSaldoDispCAAntes.datosP(amortiTabla));
    }

    @Dado("^valida los saldos antes de realizar la transacción para ambas cuentas CC$")
    public void validaLosSaldosAntesDeRealizarLaTransacciónParaAmbasCuentasCC(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                IngresoMenuAhorrosAPMovimientos.inicio(amortiTabla),
                ValidaSaldoDispAPAntes.datosP(amortiTabla),
                IngresoMenuCtaCorrienteDestinoMovimientos.inicio(amortiTabla),
                ValidaSaldoDispCAAntes.datosP(amortiTabla));
    }

    @Dado("^realiza el proceso de transferencia de saldo de la cuenta origen a la cuenta destino$")
    public void realizaElProcesoDeTransferenciaDeSaldoDeLaCuentaOrigenALaCuentaDestino(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                IngresoVerMasAhorroProgramado.inicio(amortiTabla),
                RealizarTransferenciasEntreAPCA.cuentasPropias(amortiTabla),
                ValidaTicketTransferenciaCPAP.datosCorrectos(amortiTabla));
    }

    @Dado("^realiza el proceso de transferencia de saldo de la cuenta origen a la cuenta destino inicial$")
    public void realizaElProcesoDeTransferenciaDeSaldoDeLaCuentaOrigenALaCuentaDestinoInicial(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                IngresoVerMasAhorroProgramado.inicio(amortiTabla),
                RealizarTransferenciasEntreAPCA.cuentasPropias(amortiTabla));
    }

    @Entonces("^valida los saldos posterior a realizar la transacción para ambas cuentas validando la referencia en movimientos$")
    public void validaLosSaldosPosteriorARealizarLaTransacciónParaAmbasCuentasValidandoLaReferenciaEnMovimientos(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                IngresoMenuAhorrosAPMovimientos.inicio(amortiTabla),
                ValidaSaldoDispAPDespues.datosP(amortiTabla),
                ValidaReferenciaTicketAhorroProgramado.conLaReferencia(),
                IngresoMenuCtaAhorroDestinoMovimientos.inicio(amortiTabla),
                ValidaSaldoDispCADespuesDestino.datosP(amortiTabla),
                ValidaReferenciaTicketCuentaAhorro.conLaReferencia());
    }

    @Entonces("^valida los saldos posterior a realizar la transacción para ambas cuentas validando la referencia en movimientos CC$")
    public void validaLosSaldosPosteriorARealizarLaTransacciónParaAmbasCuentasValidandoLaReferenciaEnMovimientosCC(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                IngresoMenuAhorrosAPMovimientos.inicio(amortiTabla),
                ValidaSaldoDispAPDespues.datosP(amortiTabla),
                ValidaReferenciaTicketAhorroProgramado.conLaReferencia(),
                IngresoMenuCtaCorrienteDestinoMovimientos.inicio(amortiTabla),
                ValidaSaldoDispCADespuesDestino.datosP(amortiTabla),
                ValidaReferenciaTicketCuentaCorriente.conLaReferencia());
    }

    @Dado("^el cliente verifica el saldo de AP al inicio de la transferencia$")
    public void elClienteVerificaElSaldoDeAPAlInicioDeLaTransferencia(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                IngresoMenuAhorrosAPMovimientos.inicio(amortiTabla),
                ValidaSaldoDispAPAntes.datosP(amortiTabla));
    }

    @Dado("^realiza el proceso de transferencia de saldo de la cuenta origen a la cuenta destino tercero seleccionando cuenta$")
    public void realizaElProcesoDeTransferenciaDeSaldoDeLaCuentaOrigenALaCuentaDestinoTerceroSeleccionandoCuenta(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                IngresoVerMasAhorroProgramado.inicio(amortiTabla),
                RealizarTransferenciasEntreAPTerceroCuenta.cuentasTerceros(amortiTabla),
                ValidaTicketTransferenciaAPTerCue.datosCorrectos(amortiTabla));
    }

    @Entonces("^debe visualizar una disminucion en el saldo de AP$")
    public void debeVisualizarUnaDisminucionEnElSaldoDeAP(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                IngresoMenuAhorrosAPMovimientos.inicio(amortiTabla),
                ValidaSaldoDispAPDespues.datosP(amortiTabla));
    }

    @Dado("^realiza el proceso de transferencia de saldo de la cuenta origen a la cuenta destino tercero seleccionando celular$")
    public void realizaElProcesoDeTransferenciaDeSaldoDeLaCuentaOrigenALaCuentaDestinoTerceroSeleccionandoCelular(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                IngresoVerMasAhorroProgramado.inicio(amortiTabla),
                RealizarTransferenciasEntreAPTerceroCelular.cuentasTerceros(amortiTabla),
                ValidaTicketTransferenciaAPTerCel.datosCorrectos(amortiTabla));
    }
}