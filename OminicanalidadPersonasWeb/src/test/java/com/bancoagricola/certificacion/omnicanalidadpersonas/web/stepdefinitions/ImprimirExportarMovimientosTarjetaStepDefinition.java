package com.bancoagricola.certificacion.omnicanalidadpersonas.web.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoMenuTarjetasMovimentos;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.questions.ValidaArchivoDescargadoEnLaRuta;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.CapturarSaldoSoloTarjeta;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.ValidarMovimientosTDCFecha;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.AbrirExcel;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.TransformacionALista;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.waits.Wait;

import java.io.IOException;
import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.PATH_MOVIMIENTOS;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.is;

public class ImprimirExportarMovimientosTarjetaStepDefinition {
    @Cuando("^valida los movimientos de tarjeta de crédito para una fecha especifica y captura encabezados$")
    public void validaLosMovimientosDeTarjetaDeCréditoParaUnaFechaEspecificaYCapturaEncabezados(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                IngresoMenuTarjetasMovimentos.inicio(amortiTabla),
                ValidarMovimientosTDCFecha.datosCA(amortiTabla),
                CapturarSaldoSoloTarjeta.alInicio());
    }

    @Entonces("^el cliente ve el archivo de movimientos de tarjeta en la carpeta y compara saldos$")
    public void elClienteVeElArchivoDeMovimientosDeTarjetaEnLaCarpetaYComparaSaldos() throws IOException {
        theActorInTheSpotlight().attemptsTo(
                Wait.until(ValidaArchivoDescargadoEnLaRuta.enLaRuta(PATH_MOVIMIENTOS), is(false)).forNoMoreThan(10).seconds());
        AbrirExcel.validarSaldosPantallayExcelTarjetas(PATH_MOVIMIENTOS);
    }
}