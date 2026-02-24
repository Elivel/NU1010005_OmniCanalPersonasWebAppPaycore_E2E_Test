package com.bancoagricola.certificacion.omnicanalidadpersonas.web.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.CerrarSesion;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Cliente;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.DesbloquearUsuario;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.IniciaSesion;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.ProcesoCambioDeClave;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.RecuperarClave;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.TransformacionALista;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.InicioPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.LoginPage.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class AutogestionUsuarioClaveStepDefinition {
    @Cuando("^ingresa a desbloquear usuario e ingresa los datos de telebanca$")
    public void ingresaADesbloquearUsuarioEIngresaLosDatosDeTelebanca() {
        theActorInTheSpotlight().attemptsTo(
                DesbloquearUsuario.cliente());
    }

    @Entonces("^para el desbloqueo se debe visualizar el resultado de (.*)")
    public void paraElDesbloqueoSeDebeVisualizarElResultadoDe(String mensajeUsuario) {
        WaitUntil.the(LBL_USUARIO_DESBLOQUEADO, isVisible()).forNoMoreThan(30).seconds().performAs(theActorInTheSpotlight());
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(BTN_FINALIZAR, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(BTN_FINALIZAR, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(BTN_FINALIZAR));
    }

    @Cuando("^ingresa a recuperar clave para el usuario e ingresa los datos de la nueva clave$")
    public void ingresaARecuperarClaveParaElUsuarioEIngresaLosDatosDeLaNuevaClave(DataTable dataTable) {
        List<Cliente> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Cliente.class);
        theActorInTheSpotlight().attemptsTo(
                RecuperarClave.cliente(amortiTabla));
    }

    @Cuando("^verifica que este en la pagina de inicio$")
    public void verificaQueEsteEnLaPaginaDeInicio() {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(LABEL).isDisplayed());
    }

    @Cuando("^realiza el cambio de password$")
    public void realizaElCambioDePassword(List<String> pass) {
        theActorInTheSpotlight().attemptsTo(
                ProcesoCambioDeClave.alUsuarioConLasClaves(pass));
    }

    @Entonces("^cierra sesion e inicia sesion como cliente (.*)")
    public void cierraSesionEIniciaSesionComoCliente(String usuario) {
        theActorInTheSpotlight().attemptsTo(
                CerrarSesion.usuario(),
                IniciaSesion.bancoagricola(usuario));
    }
}
