package com.bancoagricola.certificacion.omnicanalidadpersonas.web.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoMovimientosCobrosPendientes;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoVerMasCtaCorrientebasico;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.questions.CantidadRegistrosTablaMovimientos;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.questions.ExisteTablaMovimientos;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.TransformacionALista;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;

public class ConsultaCobrosPendientesStepDefinition {

    @Cuando("^ingresa a la sección resumen de movimientos para la cuenta (.*)$")
    public void ingresaALaSecciónResumenDeMovimientosParaLaCuenta(String cuenta) {
        theActorInTheSpotlight().attemptsTo(
                IngresoVerMasCtaCorrientebasico.inicio(cuenta),
                IngresoMovimientosCobrosPendientes.inicio());
    }

    @Entonces("^valida que se muestren registros en Cobros Pendientes$")
    public void validaQueSeMuestrenRegistrosEnCobrosPendientes(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().should(seeThat(ExisteTablaMovimientos.quelatabla(), is(true)).because("Valida que se muestre la tabla de Cobros Pendientes"));
        theActorInTheSpotlight().should(seeThat(CantidadRegistrosTablaMovimientos.tiene(), greaterThanOrEqualTo(1)).because("La cantidad de registros sea mayor o igual a 1"));
    }
}
