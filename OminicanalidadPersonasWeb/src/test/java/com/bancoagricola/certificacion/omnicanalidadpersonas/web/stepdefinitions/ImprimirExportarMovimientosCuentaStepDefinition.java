package com.bancoagricola.certificacion.omnicanalidadpersonas.web.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.CambiarVentana;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoMenuCAOrigenMovimientos;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.questions.ValidaArchivoDescargadoEnLaRuta;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.AbrirExcel;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.TransformacionALista;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.waits.Wait;

import java.io.IOException;
import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.PATH_MOVIMIENTOS;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.is;

public class ImprimirExportarMovimientosCuentaStepDefinition {

    @Entonces("^consulta los movimientos de la cuenta de ahorro para una fecha especifica y captura encabezados de saldos$")
    public void validaLosMovimientosDeLaCuentaDeAhorroParaUnaFechaEspecificaYCapturaEncabezadoDeSaldos(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                IngresoMenuCAOrigenMovimientos.inicio(amortiTabla),
                ValidarMovimientosCuentasFecha.datosCA(amortiTabla),
                new DetallesCuentaAhorro());
    }

    @Y("^el cliente ve sus movimientos en una nueva pestana a la derecha$")
    public void elClienteVeSusMovimientosEnUnaNuevaPestanaALaDerecha() {
        theActorInTheSpotlight().attemptsTo(
                //CambiarVentana.nueva());
        );
    }

    @Entonces("^el cliente ve el archivo Movimientos\\.xlsx en la carpeta y valida los saldos del encabezado$")
    public void elClienteVeElArchivoMovimientosxlsxEnLaCarpetaYValidalosSaldosDelEncabezado() throws IOException {
        theActorInTheSpotlight().attemptsTo(
                Wait.until(ValidaArchivoDescargadoEnLaRuta.enLaRuta(PATH_MOVIMIENTOS), is(false))
                        .forNoMoreThan(10).seconds());
        AbrirExcel.validarSaldosPantallayExcel(PATH_MOVIMIENTOS);
    }

    @Y("^realiza la accion de generar movimientos (.*)$")
    public void realizaLaAccionDeGenerarMovimientos(String opcion) throws Exception {
        theActorInTheSpotlight().attemptsTo(ImprimirExportar.movimientos(opcion));
    }

    @Y("^realiza la accion de exportar$")
    public void realizaLaAccionDeExportar() throws Exception {
        theActorInTheSpotlight().attemptsTo(
                Exportar.datos());
    }

    @Y("^realiza la accion de imprimir$")
    public void realizaLaAccionDeImprimir() throws Exception {
        theActorInTheSpotlight().attemptsTo(
                Imprimir.datos());
    }
}