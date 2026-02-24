package com.bancoagricola.certificacion.omnicanalidadpersonas.web.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.questions.SeMuestraOpcion;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.EsperaInicial;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.TransformacionALista;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.Administrar.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.is;

public class HabilitarInhabilitarPermisosStepDefinition {

    @Dado("^realiza el proceso inhabilitación de opcion y valida que no se muestre la opcion (.*)")
    public void realizaElProcesoInhabilitaciónDeOpcionYValidaQueNoSeMuestreLaOpcion(String arg1, DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                IngresoMenuAdministrar.inicio(),
                RealizaProcesoInactivacion.inicio(amortiTabla));
        LeerArchivoProperties.esperar(1);
        theActorInTheSpotlight().attemptsTo(
                Click.on(VOLVER_ESCRITORIO),
                EsperaInicial.inicio(),
                IngresoVerMasCtaAhorro.inicio(amortiTabla),
                Scroll.to(PAGOS).andAlignToTop());
        theActorInTheSpotlight().should(seeThat(SeMuestraOpcion.en(), is(false)).because("Valida que no se muestre la opción "+arg1));
    }

    @Entonces("^realiza el proceso de habilitación y valida que se muestre la opcion (.*)")
    public void realizaElProcesoDeHabilitaciónYValidaQueSeMuestreLaOpcion(String arg1, DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                IngresoMenuAdministrar.inicio(),
                RealizaProcesoActivacion.inicio(amortiTabla));
        LeerArchivoProperties.esperar(1);
        theActorInTheSpotlight().attemptsTo(
                Click.on(VOLVER_ESCRITORIO),
                EsperaInicial.inicio(),
                IngresoVerMasCtaAhorro.inicio(amortiTabla),
                Scroll.to(PAGOS).andAlignToTop());
        theActorInTheSpotlight().should(seeThat(SeMuestraOpcion.en(), is(true)).because("Valida que se muestre la opción "+arg1));
    }
}
