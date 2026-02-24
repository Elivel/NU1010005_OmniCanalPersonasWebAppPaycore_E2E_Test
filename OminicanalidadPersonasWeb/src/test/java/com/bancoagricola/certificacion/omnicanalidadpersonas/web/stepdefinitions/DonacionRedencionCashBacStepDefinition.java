package com.bancoagricola.certificacion.omnicanalidadpersonas.web.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.CalculosTranferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.TransformacionALista;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.ensure.Ensure;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class DonacionRedencionCashBacStepDefinition {

    @Entonces("^debe visualizar una disminucion en el saldo CashBac por el monto de (.*)$")
    public void debeVisualizarUnaDisminucionEnElSaldoCashBacPorElMontoDe(String monto) {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(CalculosTranferencias.obtenerMontoCashBacFinal()).isEqualTo(CalculosTranferencias.validarMontoCashBacFinal(monto)));
    }

    @Cuando("^el cliente verifica el saldo de la cuenta a transferir$")
    public void ElClienteVerificaElSaldoDeLaCuentaATransferir(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                CapturarSaldoCtaDestino.inicio(amortiTabla));
    }

    @Cuando("^el cliente verifica el saldo de la cuenta a transferir para CC$")
    public void ElClienteVerificaElSaldoDeLaCuentaATransferirParaCC(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                CapturarSaldoCtaDestinoCC.inicio(amortiTabla));
    }

    @Cuando("^valida saldo y realiza la donacion para una ONG$")
    public void validaSaldoYrealizaLaDonacionParaUnaONG(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                DonarCashBacOng.datosCorrectos(amortiTabla));
    }

    @Y("^valida saldo y realiza la transferencia de cashbac a una cuenta propia$")
    public void validaSaldoYrealizaLaTransferenciadeCashBacAunaCuentaPropia(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                RedencionCashBac.datosCorrectos(amortiTabla));
    }

    @Y("^valida saldo y realiza la transferencia de cashbac a una cuenta propia para CC$")
    public void validaSaldoYrealizaLaTransferenciadeCashBacAunaCuentaPropiaParaCC(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                RedencionCashBacCC.datosCorrectos(amortiTabla));
    }
}