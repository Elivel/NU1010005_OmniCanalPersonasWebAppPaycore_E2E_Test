package com.bancoagricola.certificacion.omnicanalidadpersonas.web.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoVerMasCtaAhorro;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoVerMasCtaCorriente;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.CalculosTranferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.TransformacionALista;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.ensure.Ensure;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.CalculosTranferencias.obtenerMontoOrigenFinal;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class TransferenciasConCuentasPropiasStepDefinition {

    @Cuando("^el cliente verifica los saldos al inicio de la transferencia de CA a CA$")
    public void ElClienteVerificaLosSaldosAlInicioDeLaTransferenciaDeCAaCA(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                CapturarSaldoCtaOrigenDestinoCAaCA.inicio(amortiTabla));
    }

    @Cuando("^el cliente verifica los saldos al inicio de la transferencia de CC a CC$")
    public void ElClienteVerificaLosSaldosAlInicioDeLaTransferenciaDeCCaCC(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                CapturarSaldoCtaOrigenDestinoCCaCC.inicio(amortiTabla));
    }

    @Cuando("^el cliente verifica los saldos al inicio de la transferencia de CA a CC$")
    public void ElClienteVerificaLosSaldosAlInicioDeLaTransferenciaDeCAaCC(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                CapturarSaldoCtaOrigenDestinoCAaCC.inicio(amortiTabla));
    }

    @Cuando("^el cliente verifica los saldos al inicio de la transferencia de CC a CA$")
    public void ElClienteVerificaLosSaldosAlInicioDeLaTransferenciaDeCCaCA(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                CapturarSaldoCtaOrigenDestinoCCaCA.inicio(amortiTabla));
    }

    @Cuando("^realiza el traslado de saldo de la cuenta origen a la cuenta destino de CA a CA$")
    public void realizaElTrasladoDeSaldoDeLaCuentaOrigenALaCuentaDestinoDeCAaCA(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                IngresoVerMasCtaAhorro.inicio(amortiTabla),
                RealizarTransferenciasEntreCAaCA.cuentasPropias(amortiTabla));
    }

    @Cuando("^realiza el traslado de saldo de la cuenta origen a la cuenta destino de CC a CC$")
    public void realizaElTrasladoDeSaldoDeLaCuentaOrigenALaCuentaDestinoDeCCaCC(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                IngresoVerMasCtaCorriente.inicio(amortiTabla.get(0).getCuentaOrigen()),
                RealizarTransferenciasEntreCCaCC.cuentasPropias(amortiTabla));
    }

    @Cuando("^realiza el traslado de saldo de la cuenta origen a la cuenta destino de CA a CC$")
    public void realizaElTrasladoDeSaldoDeLaCuentaOrigenALaCuentaDestinoDeCAaCC(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                IngresoVerMasCtaAhorro.inicio(amortiTabla),
                RealizarTransferenciasEntreCAaCC.cuentasPropias(amortiTabla));
    }

    @Cuando("^realiza el traslado de saldo de la cuenta origen a la cuenta destino de CC a CA$")
    public void realizaElTrasladoDeSaldoDeLaCuentaOrigenALaCuentaDestinoDeCCaCA(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                IngresoVerMasCtaCorriente.inicio(amortiTabla.get(0).getCuentaOrigen()),
                RealizarTransferenciasEntreCCaCA.cuentasPropias(amortiTabla));
    }

    @Cuando("^el cliente verifica el saldo de la cuenta (.+) antes de transferir$")
    public void elClienteVerificaElSaldoDeLaCuentaAntesDeTransferir(String cuenta) {
        theActorInTheSpotlight().attemptsTo(
               // CapturarSaldoCtaOrigen.transferencia(cuenta));
        );
    }

    @Cuando("^el cliente verifica el saldo de la cuenta (.+) antes de transferir desde CC$")
    public void elClienteVerificaElSaldoDeLaCuentaAntesDeTransferirDesdeCC(String cuenta) {
        theActorInTheSpotlight().attemptsTo(
                CapturarSaldoCtaOrigenCC.transferencia(cuenta));
    }

    @Cuando("^realiza el traslado de saldo de la cuenta propia a la cuenta tercero Nuevo$")
    public void realizaElTrasladoDeSaldoDeLaCuentaPropiaALaCuentaTerceroNuevo(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo();
                RealizarTransferenciaTerceroNuevo.nuevo(amortiTabla);
    }

    @Cuando("^realiza el traslado de saldo de la cuenta propia a la cuenta tercero Nuevo desde CA$")
    public void realizaElTrasladoDeSaldoDeLaCuentaPropiaALaCuentaTerceroNuevoDesdeCA(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                RealizarTransferenciaTerceroNuevo.nuevo(amortiTabla));
    }

    @Cuando("^el cliente verifica el saldo de la cuenta (.+) antes de transferir para CC$")
    public void elClienteVerificaElSaldoDeLaCuentaAntesDeTransferirParaCC(String cuenta) {
        theActorInTheSpotlight().attemptsTo(
                //CapturarSaldoCtaOrigenCC.transferencia(cuenta));
        );
    }

    @Cuando("^realiza el traslado de saldo de la cuenta propia a la cuenta tercero Nuevo para CC$")
    public void realizaElTrasladoDeSaldoDeLaCuentaPropiaALaCuentaTerceroNuevoParaCC(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                RealizarTransferenciaTerceroNuevoCC.nuevo(amortiTabla));
    }

    @Cuando("^realiza el traslado de saldo de la cuenta propia a la cuenta tercero celular Nuevo desde CA$")
    public void realizaElTrasladoDeSaldoDeLaCuentaPropiaALaCuentaTerceroCelularNuevoParaCA(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                RealizarTransferenciaTerceroNuevoCelular.nuevo(amortiTabla));
    }

    @Cuando("^realiza el traslado de saldo de la cuenta propia a la cuenta tercero celular Nuevo desde CC$")
    public void realizaElTrasladoDeSaldoDeLaCuentaPropiaALaCuentaTerceroCelularNuevoParaCC(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                RealizarTransferenciaTerceroNuevoCelularCC.nuevo(amortiTabla));
    }

    @Cuando("^realiza el traslado de saldo de la cuenta propia a la cuenta tercero favorito para CC$")
    public void realizaElTrasladoDeSaldoDeLaCuentaPropiaALaCuentaTerceroFavoritoParaCC(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                RealizarTransferenciaTerceroFavoritoCC.favorito(amortiTabla));
    }

    @Cuando("^realiza el traslado de saldo de la cuenta propia a la cuenta tercero celular favorito desde CA$")
    public void realizaElTrasladoDeSaldoDeLaCuentaPropiaALaCuentaTerceroCelularFavoritoDesdeCA(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                RealizarTransferenciaTerceroFavoritoCelular.favorito(amortiTabla));
    }

    @Cuando("^realiza el traslado de saldo de la cuenta propia a la cuenta tercero celular favorito desde CC$")
    public void realizaElTrasladoDeSaldoDeLaCuentaPropiaALaCuentaTerceroCelularFavoritoDesdeCC(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                RealizarTransferenciaTerceroFavoritoCelularCC.favorito(amortiTabla));
    }

    @Cuando("^realiza el traslado de saldo de la cuenta propia a la cuenta tercero favorito$")
    public void realizaElTrasladoDeSaldoDeLaCuentaPropiaALaCuentaTerceroFavorito(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                RealizarTransferenciaTerceroFavorito.favorito(amortiTabla));
    }

    @Entonces("^debe visualizar una disminucion de monto (.*) en el saldo cuenta origen$")
    public void debeVisualizarUnaDisminucionDeEnElSaldoCuentaOrigen(String monto) {
       /* Serenity.recordReportData().withTitle("Monto Cuenta al Final").andContents(obtenerMontoOrigenFinal().toString());
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(CalculosTranferencias.obtenerMontoOrigenFinal()).isEqualTo(CalculosTranferencias.validarMontoOrigenFinal(monto)));*/
    }

    @Y("^valida el movimiento de la cuenta de la que se debito$")
    public void validaElMovimientoDeLaCuentaDeLaQueSeDebito(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                Movimiento.datosM(amortiTabla));
    }
    @Y("^valida el movimiento de la cuenta de la que se acredito$")
    public void validaElMovimientoDeLaCuentaDeLaQueSeAcredito(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                ValidaReferenciaTicketCuentaAhorro.conLaReferencia());
    }
    @Y("^valida el movimiento de la cuenta a terceros de la que se debito$")
    public void validaElMovimientoDeLaCuentaATercerosDeLaQueSeDebito(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                MovimientoTerceros.datosM(amortiTabla));
    }

    @Y("^consulta el movimiento de la cuenta de la que se debito$")
    public void consultaElMovimientoDeLaCuentaDeLaQueSeDebito(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                MovimientoTdcACa.datosM(amortiTabla));
    }

    @Y("^valida el registro de la cuenta de la que se debito$")
    public void validaElRegistroDeLaCuentaDeLaQueSeDebito(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                MovimientoTarjetaPropia.datosM(amortiTabla));
    }
}