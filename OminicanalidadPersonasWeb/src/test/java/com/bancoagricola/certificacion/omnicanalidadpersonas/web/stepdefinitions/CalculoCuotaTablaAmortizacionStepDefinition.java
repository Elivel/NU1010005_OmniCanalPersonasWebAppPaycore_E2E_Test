package com.bancoagricola.certificacion.omnicanalidadpersonas.web.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoMenuServicios;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Servicios;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.questions.CantidadRegistrosTablaAmortización;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.questions.ExisteTablaAmotización;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.ProcesoCalculoCuotaTablaAmortizacion;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.TransformacionALista;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;


import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.*;

public class CalculoCuotaTablaAmortizacionStepDefinition {

    @Cuando("^realiza el proceso de calculo de cuota y tabla de amortizacion$")
    public void realizaElProcesoDeCalculoDeCuotaYTablaDeAmortizacion(DataTable dataTable) {

        List<Servicios> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Servicios.class);

        theActorInTheSpotlight().attemptsTo(
                IngresoMenuServicios.inicio(),
                ProcesoCalculoCuotaTablaAmortizacion.conlosdatos(amortiTabla)
        );
    }

    @Entonces("^valida que la cantidad de registros en la tabla sea igual a (.*)$")
    public void validaQueLaCantidadDeRegistrosEnLaTablaSeaIgualA(int plazo) {
        theActorInTheSpotlight().should(seeThat(ExisteTablaAmotización.quelatabla(), is(true)).because("Valida que se muestre la tabla de amortización"));
        theActorInTheSpotlight().should(seeThat(CantidadRegistrosTablaAmortización.tiene(), equalTo(plazo)).because("La cantidad de registros en la tabla de amortización sea igual a: " + "'" + plazo + "'"));
    }
}
