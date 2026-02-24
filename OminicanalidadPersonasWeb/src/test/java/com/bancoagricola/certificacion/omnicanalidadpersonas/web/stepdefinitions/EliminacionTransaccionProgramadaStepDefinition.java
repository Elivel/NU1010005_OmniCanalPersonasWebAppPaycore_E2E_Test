package com.bancoagricola.certificacion.omnicanalidadpersonas.web.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoMenuServicios;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoVerMasCtaAhorro;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.EliminarTransferencia;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.ProgramarTransferencia;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.TransformacionALista;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.ensure.Ensure;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.MSG_ELIMINACION_TRX;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class EliminacionTransaccionProgramadaStepDefinition {


    @Cuando("^programa una transferencia entre cuentas para el dia siguiente$")
    public void programaUnaTransferenciaEntreCuentasParaElDiaSiguiente(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                IngresoVerMasCtaAhorro.inicio(amortiTabla),
                ProgramarTransferencia.diaSiguiente(amortiTabla));
    }

    @Cuando("^debe eliminar la transferencia programada segun el concepto (.*) y estado (.*)$")
    public void debeEliminarLaTransferenciaProgramadaSegunElConceptoYEstado(String estado, String concepto) {
        theActorInTheSpotlight().attemptsTo(
                IngresoMenuServicios.inicio(),
                EliminarTransferencia.programada(estado, concepto));
    }
}