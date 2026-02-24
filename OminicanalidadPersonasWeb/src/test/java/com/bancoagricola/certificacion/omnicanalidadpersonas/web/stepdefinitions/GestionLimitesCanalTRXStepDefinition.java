package com.bancoagricola.certificacion.omnicanalidadpersonas.web.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.TransformacionALista;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.Limites.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class GestionLimitesCanalTRXStepDefinition {

    @Cuando("^actualiza los valores de limites de transacción y valida que se muestren los nuevos limites$")
    public void actualizaLosValoresDeLimitesDeTransacciónYValidaQueSeMuestrenLosNuevosLimites(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                ActualizaLimitesTrx.datosP(amortiTabla));
    }

    @Cuando("^realiza el traslado de saldo de la cuenta propia a la cuenta tercero superando el limite por transacción$")
    public void realizaElTrasladoDeSaldoDeLaCuentaPropiaALaCuentaTerceroSuperandoElLimitePorTransacción(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                RealizarTransferenciaTerceroExcedeLim.con(amortiTabla));
        WaitUntil.the(MSG_EX_LM_TRX, isVisible()).forNoMoreThan(60).seconds().performAs(theActorInTheSpotlight());
    }

    @Entonces("^reestablece los valores de limite de transacción por defecto$")
    public void reestableceLosValoresDeYLimiteDeTransacciónPorDefecto(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                ActualizaLimitesTrxPorDefecto.datosP(amortiTabla));
    }

    @Cuando("^actualiza los valores de limites de canal y limites de transacción y valida que se muestren los nuevos limites$")
    public void actualizaLosValoresDeLimitesDeCanalYLimitesDeTransacciónYValidaQueSeMuestrenLosNuevosLimites(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                ActualizaLimitesTrxSem.datosP(amortiTabla));
    }

    @Cuando("^realiza el traslado de saldo de la cuenta propia a la cuenta tercero superando el limite por acumulado semanal$")
    public void realizaElTrasladoDeSaldoDeLaCuentaPropiaALaCuentaTerceroSuperandoElLimitePorAcumuladoSemanal(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo();
              //  RealizarTransferenciaTerceroExcedeLim.con(amortiTabla));
        //WaitUntil.the(MSG_EX_LM_SEM2, isVisible()).forNoMoreThan(120).seconds().performAs(theActorInTheSpotlight());
    }

    @Entonces("^reestablece todos los valores de limite de transacción por defecto$")
    public void reestableceTodosLosValoresDeLimiteDeTransacciónPorDefecto(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                ActualizaLimitesPorDefecto.datosP(amortiTabla));
    }
}