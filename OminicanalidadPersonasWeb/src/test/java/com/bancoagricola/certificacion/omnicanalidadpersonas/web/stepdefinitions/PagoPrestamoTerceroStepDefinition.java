package com.bancoagricola.certificacion.omnicanalidadpersonas.web.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.RealizarPagoPrestamoNuevo;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.RealizarPagoPrestamoNuevoCC;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.TransformacionALista;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Y;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class PagoPrestamoTerceroStepDefinition {
    @Y("^realiza el pago de prestamo a tercero Nuevo desde CA$")
    public void realizaElPagoDePrestamoATerceroNuevoDesdeCA(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(RealizarPagoPrestamoNuevo.tercero(amortiTabla));
    }

    @Y("^realiza el pago de prestamo a tercero Nuevo desde CC$")
    public void realizaElPagoDePrestamoATerceroNuevoDesdeCC(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(RealizarPagoPrestamoNuevoCC.tercero(amortiTabla));
    }
}