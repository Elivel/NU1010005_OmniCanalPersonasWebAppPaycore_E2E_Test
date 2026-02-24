package com.bancoagricola.certificacion.omnicanalidadpersonas.web.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoVerMasCtaCorriente;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.questions.CantidadCheques;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.ProcesoConsultaChequeEstSupendido;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.ProcesoConsultaChequeSuspendido;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.TransformacionALista;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.MONTO_TICKET_UNI;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.REG_TAB_CHEQ;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.TEXT_CONTENT;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class ConsultaChequeSuspendidoStepDefinition {
    @Cuando("^ingresa a los cheques suspendidos de la cuenta corriente a validar en un lote de cheques$")
    public void ingresaALosChequesSuspendidosDeLaCuentaCorrienteAValidarUnLoteDeCheques(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                IngresoVerMasCtaCorriente.inicio(amortiTabla.get(0).getCuentaOrigen()),
                ProcesoConsultaChequeSuspendido.lote(amortiTabla));
    }

    @Cuando("^realiza proceso para consulta de chequera con estado Revocado$")
    public void realizaProcesoParaConsultaDeChequeraConEstadoRevocado(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                IngresoVerMasCtaCorriente.inicio(amortiTabla.get(0).getCuentaOrigen()),
                ProcesoConsultaChequeEstSupendido.lote(amortiTabla));
    }

    @Entonces("^la cantidad de registros en estado Revocado debe coincidir con los cheques suspendidos$")
    public void laCantidadDeRegistrosEnEstadoRevocadoDebeCoincidirConLosChequesSuspendidos() {
        Integer referencia = Integer.parseInt(theActorInTheSpotlight().recall(VariablesSesion.REFERENCIA.toString()).toString());
        Integer valor = REG_TAB_CHEQ.resolveAllFor(theActorInTheSpotlight()).size();
        Task.where(theActorInTheSpotlight() + " valida que la cantidad de cheques en estado 'Revocado' sea igual a " + "'" + referencia + "'", Ensure.that(valor).isEqualTo(referencia)).performAs(theActorInTheSpotlight());
    }
}