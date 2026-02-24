package com.bancoagricola.certificacion.omnicanalidadpersonas.web.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoMenuCtaPrestamoMovimientos;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoMenuExtrafinanciamientoMovimientos;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.MovimientosRangoFechas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.questions.ValidaArchivoDescargadoEnLaRuta;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.ValidarMovimientosPrestamosFecha;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.TransformacionALista;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.waits.Wait;

import java.io.IOException;
import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.PATH_MOVIMIENTOS;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.is;
public class ImprimirExportarMovimientosExtrafinanciamientoStepDefinition {

    @Entonces("^valida los movimientos del extrafinanciamiento para la fecha$")
    public void validaLosMovimientosDelExtrafinanciamientoParaLaFecha(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                IngresoMenuExtrafinanciamientoMovimientos.con(amortiTabla),
                ValidarMovimientosPrestamosFecha.datosCA(amortiTabla),
                MovimientosRangoFechas.datosCA());
    }
}
