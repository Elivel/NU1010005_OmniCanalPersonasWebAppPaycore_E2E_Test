package com.bancoagricola.certificacion.omnicanalidadpersonas.web.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoVerMasADS;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.TransformacionALista;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class TransferenciasConADSStepDefinition {
    @Cuando("^el cliente verifica los saldos al inicio de la transferencia de ADS a CA$")
    public void elClienteVerificaLosSaldosAlInicioDeLaTransferenciaDeADSACA(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                CapturarSaldoCtaOrigenDestinoADSaCA.inicio(amortiTabla));
    }

    @Cuando("^realiza el traslado de saldo de la cuenta ADS a la cuenta destino CA$")
    public void realizaElTrasladoDeSaldoDeLaCuentaADSALaCuentaDestinoCA(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                IngresoVerMasADS.inicio(amortiTabla),
                RealizarTransferenciasEntreADS_CP.cuentasPropias(amortiTabla),
                RealizarCapturaValoresDespues.cuentas(amortiTabla));
    }

    @Cuando("^el cliente verifica los saldos al inicio de la transferencia de ADS a CC$")
    public void elClienteVerificaLosSaldosAlInicioDeLaTransferenciaDeADSACC(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                CapturarSaldoCtaOrigenDestinoADSaCC.inicio(amortiTabla));
    }

    @Cuando("^realiza el traslado de saldo de la cuenta ADS a la cuenta destino CC$")
    public void realizaElTrasladoDeSaldoDeLaCuentaADSALaCuentaDestinoCC(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                IngresoVerMasADS.inicio(amortiTabla),
                RealizarTransferenciasEntreADS_CP.cuentasPropias(amortiTabla),
                RealizarCapturaValoresDespuesCC.cuentas(amortiTabla));
    }

    @Cuando("^el cliente verifica el saldo de la cuenta (.*) antes de transferir desde ADS$")
    public void elClienteVerificaElSaldoDeLaCuentaAntesDeTransferirDesdeADS(String cuenta) {
        theActorInTheSpotlight().attemptsTo(
                CapturarSaldoCtaOrigenADS.transferencia(cuenta));
    }

    @Cuando("^realiza el traslado de saldo de la cuenta ADS a la cuenta tercero Nuevo$")
    public void realizaElTrasladoDeSaldoDeLaCuentaADSALaCuentaTerceroNuevo(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                RealizarTransferenciaTerceroNuevoADS.nuevo(amortiTabla));
    }

    @Cuando("^realiza el traslado de saldo de la cuenta ADS a la cuenta tercero favorito$")
    public void realizaElTrasladoDeSaldoDeLaCuentaADSALaCuentaTerceroFavorito(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                RealizarTransferenciaTerceroFavoritoADS.favorito(amortiTabla));
    }

    @Cuando("^realiza el traslado de saldo de la cuenta ADS a la cuenta tercero celular Nuevo$")
    public void realizaElTrasladoDeSaldoDeLaCuentaADSALaCuentaTerceroCelularNuevo(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                RealizarTransferenciaTerceroNuevoCelularADS.nuevo(amortiTabla));
    }

    @Cuando("^realiza el traslado de saldo de la cuenta ADS a la cuenta tercero celular favorito$")
    public void realizaElTrasladoDeSaldoDeLaCuentaADSALaCuentaTerceroCelularFavorito(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                RealizarTransferenciaTerceroFavoritoCelularADS.favorito(amortiTabla));
    }
}