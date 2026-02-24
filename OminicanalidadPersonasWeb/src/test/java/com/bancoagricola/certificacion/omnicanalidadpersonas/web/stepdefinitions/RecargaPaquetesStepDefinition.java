package com.bancoagricola.certificacion.omnicanalidadpersonas.web.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoMenuTarjetasMovimentos;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.*;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.TransformacionALista;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Y;
import io.cucumber.java.es.Entonces;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TarjetasPage.DISPONIBILIDAD_TARJETA;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class RecargaPaquetesStepDefinition {

    @Dado("^realiza una recarga para la compañia desde cuenta de ahorro$")
    public void realizaUnaRecargaParaLaCompañiaDesdeCuentaDeAhorro(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                RecargaSinFavoritoCtaAhorro.datosCA(amortiTabla));
    }
    @Dado("^realiza una recarga para la compañia desde Cuenta Corriente$")
    public void realizaUnaRecargaParaLaCompañiaDesdeCuentaCorriente(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                RecargaSinFavoritoCtaAhorro.datosCA(amortiTabla));
    }


    @Dado("^realiza una recarga para la compañia desde cuenta de ahorro con favorito$")
    public void realizaUnaRecargaParaLaCompañiaDesdeCuentaDeAhorroConFavorito(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                RecargaConFavoritoCtaAhorro.datosCA(amortiTabla));
    }

    @Dado("^realiza una recarga para la compañía desde la Cuenta Corriente con favorito$")
    public void realizaUnaRecargaParaLaCompañiaDesdeLaCuentaCorrienteConFavorito(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                RecargaConFavoritoCtaAhorro.datosCA(amortiTabla));
    }

    @Cuando("^valida los saldos antes de realizar la transaccion desde Tarjetas$")
    public void validaLosSaldosAntesDeRealizarLaTransaccionDesdeTarjetas(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                IngresoMenuTarjetasMovimentos.inicio(amortiTabla),
                CapturarSaldoSoloTarjeta.alInicio());
    }

    @Y("^realiza una recarga para la compañia desde tarjetas desde cero$")
    public void realizaUnaRecargaParaLaCompaiaDesdeTarjetasDesdeCero(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                RecargaSinFavoritoTarjeta.datosCorrectos(amortiTabla));
    }

    @Y("^realiza una recarga para la compañia desde tarjetas con favorito$")
    public void realizaUnaRecargaParaLaCompaiaDesdeTarjetasConFavorito(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                RecargaConFavoritoTarjeta.datosCorrectos(amortiTabla),
                IngresoMenuTarjetasMovimentos.inicio(amortiTabla));
        theActorInTheSpotlight().remember(VariablesSesion.MONTO_FINAL_TC.toString(), DISPONIBILIDAD_TARJETA.resolveFor(theActorInTheSpotlight()).getText());
    }

    @Dado("^valida los puntos BA antes de realizar la transacción$")
    public void validaLosPuntosBAAntesDeRealizarLaTransacción() {
        theActorInTheSpotlight().attemptsTo(
                ValidaPuntosBAAntes.puntos());
    }

    @Dado("^realiza una recarga para la compañia desde Puntos BA$")
    public void realizaUnaRecargaParaLaCompañiaDesdePuntosBA(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                RecargaSinFavoritoPuntosBA.datosCA(amortiTabla));
    }

    @Dado("^realiza una recarga para la compañia desde Puntos BA con favorito$")
    public void realizaUnaRecargaParaLaCompañiaDesdePuntosBAConFavorito(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                RecargaConFavoritoPuntosBA.datosCA(amortiTabla));
    }

    @Entonces("^valida los puntos BA posterior a realizar la transacción$")
    public void validaLosPuntosBAPosteriorARealizarLaTransacción(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                ValidaPuntosBADespues.datosP(amortiTabla));

    }

    @Dado("^realiza agenda de recargas para la compañia indicada desde cuenta de ahorro$")
    public void realizaAgendaDeRecargasParaLaCompañiaIndicadaDesdeCuentaDeAhorro(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                RecargaSinFavoritoCtaAhorroAgendado.datosCA(amortiTabla));
    }
    @Dado("^realiza agenda de recargas para la compañia indicada desde una TDC")
    public void realizaAgendaDeRecargasParaLaCompañiaIndicadaDesdeUnaTDC(DataTable dataTable) {
        List<Transferencias> datosTDC = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                RecargaSinFavoritoTDCAgendado.datosTDC(datosTDC));
    }
}