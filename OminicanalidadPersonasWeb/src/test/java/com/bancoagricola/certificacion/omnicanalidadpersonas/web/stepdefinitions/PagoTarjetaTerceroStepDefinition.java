package com.bancoagricola.certificacion.omnicanalidadpersonas.web.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.RealizarPagoTarjeta;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.RealizarPagoTarjetaCC;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.TransformacionALista;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Y;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class PagoTarjetaTerceroStepDefinition {

    @Y("^realiza el pago de tarjeta a tercero desde la cuenta propia$")
    public void realizaElPagoDeTarjetaATerceroDesdeLaCuentaPropia(DataTable dataTable)  {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                RealizarPagoTarjeta.datosCompletos(amortiTabla));
    }

    @Y("^realiza el pago de tarjeta a tercero desde CC$")
    public void realizaElPagoDeTarjetaATerceroDesdeCC(DataTable dataTable)  {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                RealizarPagoTarjetaCC.datosCompletos(amortiTabla));
    }
}