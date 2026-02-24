package com.bancoagricola.certificacion.omnicanalidadpersonas.web.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Cliente;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.TransformacionALista;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.InicioPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.CLIENTE;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class RecuperarUsuarioStepDefinition {
    @Before
    public void iniciarNavegador() {
        OnStage.setTheStage(new OnlineCast());
        //OnStage.theActorCalled(CLIENTE);
    }

    @After
    public void finalizarNavegador() {
        BrowseTheWeb.as(theActorInTheSpotlight()).getDriver().close();
    }

    /*  @Dado("^Que el cliente ingresa a e-banca Personas$")
      public void QueElClienteIngresaAEBancaPersonas() {
          theActorCalled(CLIENTE).wasAbleTo(IrA.bancoagricola());
          //OnStage.theActorInTheSpotlight().wasAbleTo(IrA.bancoagricola());

      }
      */
    @Dado("^que el cliente ingresa a e-banca Personas$")
    public void QueElClienteIngresaAEBancaPersonas() {
        theActorCalled(CLIENTE).wasAbleTo(IrA.bancoagricola());
        //OnStage.theActorInTheSpotlight().wasAbleTo(IrA.bancoagricola());

    }

    @Dado("^inicia sesion como cliente (.*)$")
    public void iniciaSesionComoCliente(String usuario) {
        theActorInTheSpotlight().attemptsTo(
                IniciaSesion.bancoagricola(usuario),
                EsperaInicial.inicio());
    }

    @Cuando("^ingresa a recuperar usuario e ingresa los datos de identificacion$")
    public void ingresaARecuperarUsuarioEIngresaLosDatosDeIdentificacion(DataTable dataTable) {
        List<Cliente> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Cliente.class);
        theActorInTheSpotlight().attemptsTo(
                RecuperarUsuarioCliente.conIdentificacion(amortiTabla));
    }

    @Entonces("^se visualiza el resultado de \"([^\"]*)\"$")
    public void seVisualizaElResultadoDe(String mensajeUsuario) {
        WaitUntil.the(LBL_USUARIO_RECUPERADO, isVisible()).forNoMoreThan(60).seconds().performAs(theActorInTheSpotlight());
        LeerArchivoProperties.esperar(1);
    }

    @Y("^inicia sesion como clienteD (.*)$")
    public void iniciaSesionComoClienteD(String usuario) {
        theActorInTheSpotlight().attemptsTo(
                IniciaSesionDev.bancoagricola(usuario),
                EsperaInicial.inicio());
    }

}