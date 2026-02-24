package com.bancoagricola.certificacion.omnicanalidadpersonas.web.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.PagarPrestamoUNIConFavorito;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.PagarPrestamoUNISinFavorito;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.PagarPrestamoUNISinFavoritoCC;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.TransformacionALista;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Dado;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class PagoPrestamosUNIStepDefinition {

    @Dado("^realiza el pago de prestamo UNI$")
    public void realizaElPagoDePrestamoUNI(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                PagarPrestamoUNISinFavorito.datosP(amortiTabla));
    }

    @Dado("^realiza el pago de prestamo UNI desde CC$")
    public void realizaElPagoDePrestamoUNIDesdeCC(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                PagarPrestamoUNISinFavoritoCC.datosP(amortiTabla));
    }

    @Dado("^realiza el pago de prestamo UNI desde favorito$")
    public void realizaElPagoDePrestamoUNIDesdeFavorito(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                PagarPrestamoUNIConFavorito.datosP(amortiTabla));
    }

    @Dado("^realiza el pago de prestamo UNI desde favorito desde CC$")
    public void realizaElPagoDePrestamoUNIDesdeFavoritodesdeCC(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                PagarPrestamoUNIConFavorito.datosP(amortiTabla));
    }
}