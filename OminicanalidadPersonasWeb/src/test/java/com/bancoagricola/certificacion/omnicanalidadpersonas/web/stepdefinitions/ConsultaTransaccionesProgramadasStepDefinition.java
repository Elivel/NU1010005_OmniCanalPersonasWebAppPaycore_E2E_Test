package com.bancoagricola.certificacion.omnicanalidadpersonas.web.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.questions.CantidadRegistrosTablaMovimientos;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.questions.ExisteTablaMovimientos;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.RealizarConsultaTrxProgramadas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.ValidaEstadoAgendada;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.TransformacionALista;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.ArrayList;
import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static org.hamcrest.Matchers.*;

public class ConsultaTransaccionesProgramadasStepDefinition {
    private static List<String> listaObtenida = new ArrayList<>();

    @Cuando("^realizar consulta de transacciones programadas$")
    public void realizarConsultaDeTransaccionesProgramadas(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                RealizarConsultaTrxProgramadas.nuevo(amortiTabla));
    }

    @Entonces("^debe visualizar el listado de movimientos con el estado (.*)$")
    public void debeVisualizarElListadoDeMovimientosConElEstado(String estado) {
        theActorInTheSpotlight().attemptsTo(
                Scroll.to(TABLA_MOV_CA).andAlignToTop());
        WaitUntil.the(TABLA_MOV_CA, isVisible()).forNoMoreThan(60).seconds().performAs(theActorInTheSpotlight());
        theActorInTheSpotlight().should(seeThat(ExisteTablaMovimientos.quelatabla(), is(true)).because("Valida que se muestre la tabla de movimientos"));
        theActorInTheSpotlight().should(seeThat(CantidadRegistrosTablaMovimientos.tiene(), greaterThanOrEqualTo(1)).because("La cantidad de registros sea mayor o igual a 1"));
        theActorInTheSpotlight().attemptsTo(ValidaEstadoAgendada.datosAud(estado));
    }
}
