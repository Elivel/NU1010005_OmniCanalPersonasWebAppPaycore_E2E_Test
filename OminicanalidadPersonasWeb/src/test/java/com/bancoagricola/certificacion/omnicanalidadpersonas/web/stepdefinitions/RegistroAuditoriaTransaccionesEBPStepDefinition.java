package com.bancoagricola.certificacion.omnicanalidadpersonas.web.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.TransformacionALista;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class RegistroAuditoriaTransaccionesEBPStepDefinition {

    @Cuando("^valida la generacion de la transaccion en Auditoria de transacciones para hoy$")
    public void validaLaGeneracionDeLaTransaccionEnAuditoriaDeTransaccionesParaHoy(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
    theActorInTheSpotlight().attemptsTo(RegistrosAuditoritaTRX.datosAud(amortiTabla));
    }
}