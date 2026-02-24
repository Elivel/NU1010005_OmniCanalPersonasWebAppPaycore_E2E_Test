package com.bancoagricola.certificacion.omnicanalidadpersonas.web.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.RealizarPagoTarjetaCreditoPropiaCuentas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.RealizarPagoTarjetaCreditoPropiaCuentasCC;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.RealizarPagoTarjetaCreditoPropiaTarjetas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.RealizarPagoTarjetaCreditoPropiaTarjetasCC;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.TransformacionALista;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Y;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class PagoTarjetaCreditoPropiaStepDefinition {
    @Y("^realiza el pago de tarjeta desde cuentas con CA$")
    public void realizaElPagoDeTarjetaDesdeCuentasConCA(DataTable dataTable){
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                RealizarPagoTarjetaCreditoPropiaCuentas.datosCompletos(amortiTabla));
    }

    @Y("^realiza el pago de tarjeta desde tarjetas con CA$")
    public void realizaElPagoDeTarjetaDesdeTarjetasConCA(DataTable dataTable){
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                RealizarPagoTarjetaCreditoPropiaTarjetas.datosCompletos(amortiTabla));
    }

    @Y("^realiza el pago de tarjeta desde cuentas con CC$")
    public void realizaElPagoDeTarjetaDesdeCuentasConCC(DataTable dataTable){
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                RealizarPagoTarjetaCreditoPropiaCuentasCC.datosCompletos(amortiTabla));
    }

    @Y("^realiza el pago de tarjeta desde tarjetas con CC$")
    public void realizaElPagoDeTarjetaDesdeTarjetasConCC(DataTable dataTable){
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                RealizarPagoTarjetaCreditoPropiaTarjetasCC.datosCompletos(amortiTabla));
    }
}