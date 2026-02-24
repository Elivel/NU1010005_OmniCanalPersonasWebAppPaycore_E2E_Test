package com.bancoagricola.certificacion.omnicanalidadpersonas.web.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Servicios;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.TransformacionALista;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Dado;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

import javax.xml.crypto.Data;
import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.ServiciosPage.REG_TABLA_RES;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.ServiciosPage.TABLA_RES;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AuditoriaTransaccionesStepDefinition {

    @Dado("^valida que se muestren registros al buscar registros por Tipo de transacción$")
    public void validaQueSeMuestrenRegistrosAlBuscarRegistrosPorTipoDeTransacción(DataTable dataTable) {

        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);

        theActorInTheSpotlight().attemptsTo(
                SeleccionaRangoFechasTipoTransaccionAudTrx.datosAud(amortiTabla),
                SeleccionaCanal.datosAud(amortiTabla));
        Task.where(theActorInTheSpotlight() + " 'valida que se muestre la tabla con los resultados'", WaitUntil.the(TABLA_RES, isVisible()).forNoMoreThan(60).seconds()).performAs(theActorInTheSpotlight());
        Task.where(theActorInTheSpotlight() + " 'valida que la cantidad de registros sea: 'mayor o igual a 1''", Ensure.that(REG_TABLA_RES.resolveAllFor(theActorInTheSpotlight()).size()).isGreaterThanOrEqualTo(1));
        theActorInTheSpotlight().attemptsTo(
                ValidaTipoTransaccion.datosAud(amortiTabla));
    }

    @Dado("^valida que se muestren registros al buscar registros por rango de monto$")
    public void validaQueSeMuestrenRegistrosAlBuscarRegistrosPorRangoDeMonto(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);

        theActorInTheSpotlight().attemptsTo(
                SeleccionaRangoFechasTipoTransaccionAudTrx.datosAud(amortiTabla),
                IngresaRangoFechasAudTrx.datosAud(amortiTabla),
                SeleccionaCanal.datosAud(amortiTabla));
        LeerArchivoProperties.esperar(5);
        Task.where(theActorInTheSpotlight() + " 'valida que se muestre la tabla con los resultados'", WaitUntil.the(TABLA_RES, isVisible()).forNoMoreThan(60).seconds()).performAs(theActorInTheSpotlight());
        Task.where(theActorInTheSpotlight() + " 'valida que la cantidad de registros sea: 'mayor o igual a 1''", Ensure.that(REG_TABLA_RES.resolveAllFor(theActorInTheSpotlight()).size()).isGreaterThanOrEqualTo(1));
        theActorInTheSpotlight().attemptsTo(
                ValidaRangoMontoValido.datosAud(amortiTabla));
    }

    @Dado("^valida que se muestren registros al buscar registros por estado$")
    public void validaQueSeMuestrenRegistrosAlBuscarRegistrosPorEstado(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                SeleccionaRangoFechasTipoTransaccionAudTrx.datosAud(amortiTabla),
                SeleccionaEstado.datosAud(amortiTabla),
                SeleccionaCanal.datosAud(amortiTabla));
        Task.where(theActorInTheSpotlight() + " 'valida que se muestre la tabla con los resultados'", WaitUntil.the(TABLA_RES, isVisible()).forNoMoreThan(60).seconds()).performAs(theActorInTheSpotlight());
        Task.where(theActorInTheSpotlight() + " 'valida que la cantidad de registros sea: 'mayor o igual a 1''", Ensure.that(REG_TABLA_RES.resolveAllFor(theActorInTheSpotlight()).size()).isGreaterThanOrEqualTo(1));
        theActorInTheSpotlight().attemptsTo(
                ValidaEstado.datosAud(amortiTabla));
    }
}