package com.bancoagricola.certificacion.omnicanalidadpersonas.web.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.CapturaDetallePrestamo;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.ConsultaDetallePrestamo;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.VerificarDetallesPantallasF;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.TransformacionALista;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ConsultaDetallePrestamoStepDefinition {

    @Entonces("^valida que se muestren de forma correcta los datos de préstamo$")
    public void validaQueSeMuestrenDeFormaCorrectaLosDatosDePréstamo(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(ConsultaDetallePrestamo.datosCA(amortiTabla));
    }
}
