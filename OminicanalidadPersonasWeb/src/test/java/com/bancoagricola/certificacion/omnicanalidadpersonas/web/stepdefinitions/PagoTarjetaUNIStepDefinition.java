package com.bancoagricola.certificacion.omnicanalidadpersonas.web.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.PagarTarjetaUniFavorito;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.PagarTarjetaUniFavoritoCC;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.PagarTarjetaUniNuevo;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.PagarTarjetaUniNuevoCC;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.TransformacionALista;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class PagoTarjetaUNIStepDefinition {

    @Cuando("^realiza el pago de tarjeta entre banco sin favorito$")
    public void realizaElPagoDeTarjetaEntreBancoSinFavorito(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                PagarTarjetaUniNuevo.datosCorrectos(amortiTabla));
    }

    @Cuando("^realiza el pago de tarjeta entre banco con favorito$")
    public void realizaElPagoDeTarjetaEntreBancoConxFavorito(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                PagarTarjetaUniFavorito.datosCorrectos(amortiTabla));
    }

    @Cuando("^realiza el pago de tarjeta entre banco sin favorito desde CC$")
    public void realizaElPagoDeTarjetaEntreBancoSinFavoritoDesdeCC(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                PagarTarjetaUniNuevoCC.datosCorrectos(amortiTabla));
    }

    @Cuando("^realiza el pago de tarjeta entre banco con favorito desde CC$")
    public void realizaElPagoDeTarjetaEntreBancoConxFavoritoDesdeCC(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                PagarTarjetaUniFavoritoCC.datosCorrectos(amortiTabla));
    }
}