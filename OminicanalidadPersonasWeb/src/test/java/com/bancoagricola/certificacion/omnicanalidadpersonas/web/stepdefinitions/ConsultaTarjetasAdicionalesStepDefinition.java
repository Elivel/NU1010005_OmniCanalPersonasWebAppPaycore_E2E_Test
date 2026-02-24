package com.bancoagricola.certificacion.omnicanalidadpersonas.web.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.IngresarTarjetasAdicionales;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.ValidarDetalleTDCAdicionales;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.TransformacionALista;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ConsultaTarjetasAdicionalesStepDefinition {
    @Cuando("^el cliente ingresa a la opcion consulta de tarjetas adicionales$")
    public void elClienteIngresaALaOpcionConsultaDeTarjetasAdicionales(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(IngresarTarjetasAdicionales.inicio(amortiTabla));

    }


    @Entonces("^consulta el detalle de las tarjetas adicionales$")
    public void consultaElDetalleDeLasTarjetasAdicionales(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(ValidarDetalleTDCAdicionales.inicio(amortiTabla));

    }

}
