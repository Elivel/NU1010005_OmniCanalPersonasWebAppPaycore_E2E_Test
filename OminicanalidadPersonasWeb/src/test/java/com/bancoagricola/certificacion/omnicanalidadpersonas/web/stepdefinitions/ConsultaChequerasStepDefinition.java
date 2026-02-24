package com.bancoagricola.certificacion.omnicanalidadpersonas.web.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoVerMasCtaCorriente;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.questions.CantidadCheques;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.ProcesoConsultaCheques;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.ProcesoConsultaChequesActivos;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.ProcesoConsultaTodosLosCheques;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.ValidaEstadoCheques;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.TransformacionALista;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class ConsultaChequerasStepDefinition {

    @Dado("^realiza proceso para consultar de chequera con cheques activos$")
    public void realizaProcesoParaConsultarDeChequeraConChequesActivos(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                IngresoVerMasCtaCorriente.inicio(amortiTabla.get(0).getCuentaOrigen()),
                ProcesoConsultaChequesActivos.datosCA(amortiTabla));
    }

    @Dado("^realiza proceso para consultar de chequera mostrando todos los cheques$")
    public void realizaProcesoParaConsultarDeChequeraMostrandoTodosLosCheques(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                IngresoVerMasCtaCorriente.inicio(amortiTabla.get(0).getCuentaOrigen()),
                ProcesoConsultaTodosLosCheques.datosCA(amortiTabla));
    }

    @Entonces("^la cantidad de cheques filtrados por estado Activo debe coincidir$")
    public void laCantidadDeChequesPorEstadoActivoDebeCoincidir() {
        theActorInTheSpotlight().should(seeThat(
                CantidadCheques.tiene(), equalTo(Integer.parseInt(theActorInTheSpotlight().recall(VariablesSesion.CHEQUESACTIVOS.toString())))).because("Valida que se la cantidad de cheques 'activos' sea igual a " + "'" + Integer.parseInt(theActorInTheSpotlight().recall(VariablesSesion.CHEQUESACTIVOS.toString())) + "'"));
    }

    @Entonces("^la cantidad de cheques filtrados por estado Todos debe coincidir$")
    public void laCantidadDeRegistrosDeChequesPorEstadoATodosDebeCoincidir() {
        theActorInTheSpotlight().should(
                seeThat(CantidadCheques.tiene(), equalTo(Integer.parseInt(theActorInTheSpotlight().recall(VariablesSesion.TOTALCHEQUES.toString())))).because("Valida que se la cantidad 'total' de cheques sea igual a " + "'" + Integer.parseInt(theActorInTheSpotlight().recall(VariablesSesion.TOTALCHEQUES.toString())) + "'"));
    }

    @Cuando("^realiza proceso para consultar de chequera$")
    public void realizaProcesoParaConsultarDeChequera(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                IngresoVerMasCtaCorriente.inicio(amortiTabla.get(0).getCuentaOrigen()),
                ProcesoConsultaCheques.datosCA(amortiTabla));
    }

    @Entonces("^valida que se muestren solamente los cheques con el estado seleccionado$")
    public void validaQueSeMuestrenSolamenteLosChequesConElEstadoSeleccionado(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                ValidaEstadoCheques.conLaReferencia(amortiTabla));
    }
}