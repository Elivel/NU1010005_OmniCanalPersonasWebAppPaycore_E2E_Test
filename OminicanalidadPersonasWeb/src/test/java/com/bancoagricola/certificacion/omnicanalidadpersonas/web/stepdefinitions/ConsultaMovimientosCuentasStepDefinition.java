package com.bancoagricola.certificacion.omnicanalidadpersonas.web.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.TransformacionALista;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Entonces;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ConsultaMovimientosCuentasStepDefinition {

    //Cuenta de ahorro
    @Entonces("^valida los movimientos de la cuenta de ahorro para semana actual$")
    public void validaLosMovimientosDeLaCuentaDeAhorroParaSemanaActual(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                IngresoMenuCtaAhorroOrigenMovimientos.inicio(amortiTabla),
                ValidarMovimientosCuentasOpcion.datosCA(amortiTabla),
                MovimientosSemanaActual.datosCA());
    }

    @Entonces("^valida los movimientos de la cuenta de ahorro para mes actual$")
    public void validaLosMovimientosDeLaCuentaDeAhorroParaMesActual(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                IngresoMenuCtaAhorroOrigenMovimientos.inicio(amortiTabla),
                ValidarMovimientosCuentasOpcion.datosCA(amortiTabla),
                MovimientosMesActual.datosCA());
    }

    @Entonces("^valida los movimientos de la cuenta de ahorro para Últimos seis meses$")
    public void validaLosMovimientosDeLaCuentaDeAhorroParaÚltimosSeisMeses(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                IngresoMenuCtaAhorroOrigenMovimientos.inicio(amortiTabla),
                ValidarMovimientosCuentasOpcion.datosCA(amortiTabla),
                MovimientosUltimosSeisMeses.datosCA());
    }

    @Entonces("^valida los movimientos de la cuenta de ahorro para una fecha especifica$")
    public void validaLosMovimientosDeLaCuentaDeAhorroParaUnaFechaEspecifica(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                IngresoMenuCtaAhorroOrigenMovimientos.inicio(amortiTabla),
                ValidarMovimientosCuentasFecha.datosCA(amortiTabla),
                MovimientosRangoFechas.datosCA());
    }

    //Cuenta corriente
    @Entonces("^valida los movimientos de la cuenta corriente para semana actual$")
    public void validaLosMovimientosDeLaCuentaCorrienteParaSemanaActual(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                IngresoMenuCtaCorrienteOrigenMovimientos.inicio(amortiTabla),
                ValidarMovimientosCuentasOpcion.datosCA(amortiTabla),
                MovimientosSemanaActual.datosCA());
    }

    @Entonces("^valida los movimientos de la cuenta corriente para mes actual$")
    public void validaLosMovimientosDeLaCuentaCorrienteParaMesActual(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                IngresoMenuCtaCorrienteOrigenMovimientos.inicio(amortiTabla),
                ValidarMovimientosCuentasOpcion.datosCA(amortiTabla),
                MovimientosMesActual.datosCA());
    }

    @Entonces("^valida los movimientos de la cuenta corriente para Últimos seis meses$")
    public void validaLosMovimientosDeLaCuentaCorrienteParaÚltimosSeisMeses(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                IngresoMenuCtaCorrienteOrigenMovimientos.inicio(amortiTabla),
                ValidarMovimientosCuentasOpcion.datosCA(amortiTabla),
                MovimientosUltimosSeisMeses.datosCA());
    }

    @Entonces("^valida los movimientos de la cuenta corriente para una fecha especifica$")
    public void validaLosMovimientosDeLaCuentaCorrienteParaUnaFechaEspecifica(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                IngresoMenuCtaCorrienteOrigenMovimientos.inicio(amortiTabla));
               // ValidarMovimientosCuentasFecha.datosCA(amortiTabla),
               // MovimientosRangoFechas.datosCA());
    }
}