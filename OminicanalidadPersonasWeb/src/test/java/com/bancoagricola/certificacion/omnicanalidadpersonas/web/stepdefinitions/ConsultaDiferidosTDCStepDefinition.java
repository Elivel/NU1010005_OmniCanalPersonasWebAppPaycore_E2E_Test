package com.bancoagricola.certificacion.omnicanalidadpersonas.web.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoMenuTarjetasMovimentos;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.questions.CantidadRegistrosTablaDiferidosTC;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.questions.ExisteTablaDiferidos;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.TransformacionALista;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TarjetasPage.OPCION_OTROS;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TarjetasPage.TTL_FONDOS_RESERV;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;

public class ConsultaDiferidosTDCStepDefinition {

    @Entonces("^valida que se muestre la tabla y registros de diferidos de tarjeta de crédito$")
    public void validaQueSeMuestreLaTablaYRegistrosDeDiferidosDeTarjetaDeCrédito(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                IngresoMenuTarjetasMovimentos.inicio(amortiTabla),
                WaitUntil.the(OPCION_OTROS, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(OPCION_OTROS),
                WaitUntil.the(TTL_FONDOS_RESERV, isEnabled()).forNoMoreThan(60).seconds(),
                Scroll.to(TTL_FONDOS_RESERV));
        theActorInTheSpotlight().should(seeThat(ExisteTablaDiferidos.quelatabla(), is(false)).because("Valida que se muestre la tabla de diferidos"));
        theActorInTheSpotlight().should(seeThat(CantidadRegistrosTablaDiferidosTC.tiene(), greaterThanOrEqualTo(0)).because("La cantidad de registros sea mayor o igual a 1"));
    }
}