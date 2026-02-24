package com.bancoagricola.certificacion.omnicanalidadpersonas.web.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.CapturarSaldoInicialTcCtaCC;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.RealizarTransferenciaDeTc;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.CapturarSaldoInicialTcCta;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.RealizarTransferenciaDeTcCC;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.CalculosTranferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.TransformacionALista;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.ensure.Ensure;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.CalculosTranferencias.obtenerMontoDestinoFinal;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class TransferenciasTarjetaStepDefinition {

    /*Transferencia de una TDC a una cta propia*/
    @Cuando("^el cliente verifica los saldos al inicio de la transferencia para la tarjeta$")
    public void elClienteVerificaLosSaldosAlInicioDeLaTransferenciaParaLaTarjeta(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                CapturarSaldoInicialTcCta.transferenciaTarjeta(amortiTabla));
    }

    @Cuando("^el cliente verifica los saldos al inicio de la transferencia para la tarjeta y CC$")
    public void elClienteVerificaLosSaldosAlInicioDeLaTransferenciaParaLaTarjetaYCC(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                CapturarSaldoInicialTcCtaCC.transferenciaTarjeta(amortiTabla));
    }

    @Cuando("^realiza el traslado de saldo de la tarjeta a la cuenta destino$")
    public void realizaElTrasladoDeSaldoDeLaTarjetaALaCuentaDestino(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                RealizarTransferenciaDeTc.cuentaPropia(amortiTabla));
    }

    @Cuando("^realiza el traslado de saldo de la tarjeta a la cuenta destino CC$")
    public void realizaElTrasladoDeSaldoDeLaTarjetaALaCuentaDestinoCC(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                RealizarTransferenciaDeTcCC.cuentaPropia(amortiTabla));
    }

    @Entonces("^debe visualizar una disminucion en el saldo cuenta de la TC$")
    public void debeVisualizarUnaDisminucionEnElSaldoCuentaDeLaTC(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(CalculosTranferencias.obtenerMontoTarjetaFinal())
                        .isEqualTo(CalculosTranferencias.validarMontoTarjetaFinal(amortiTabla)));
    }

    @Y("^debe visualizar un aumento en el saldo cuenta destino por el monto de (.*)$")
    public void ddebeVisualizarUnAumentoEnElSaldoCuentaDestino(String monto) {
        Serenity.recordReportData().withTitle("Monto Cuenta Destino al Final").andContents(obtenerMontoDestinoFinal().toString());
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(CalculosTranferencias.obtenerMontoDestinoFinal()).isEqualTo(CalculosTranferencias.validarMontoDestinoFinal(monto)));
    }
}