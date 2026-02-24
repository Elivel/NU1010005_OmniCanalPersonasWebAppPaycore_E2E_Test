package com.bancoagricola.certificacion.omnicanalidadpersonas.web.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoMenuServicios;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoMenuTarjetas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Servicios;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.TransformacionALista;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TarjetasPage.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class IntegrarCuentasTarjetaDebitoStepDefinition {
    @Cuando("^el cliente selecciona una cuenta principal e incluye una cuenta para asociar$")
    public void elClienteSeleccionaUnaCuentaPrincipalEincluyeUnaCuentaParAsociar(DataTable dataTable) {
        List<Servicios> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Servicios.class);
        theActorInTheSpotlight().attemptsTo(
                IngresoMenuServicios.inicio(),
                IntegrarCtaPrincipalyAsociarOtras.cuentas(amortiTabla));
    }

    @Cuando("^el cliente se dirige a Tarjetas y selecciona una TDD para integrar cuentas$")
    public void elClienteSeDirigeATarjetasYSeleccionaUnaTDDParaIntegrarCuentas(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                IngresoMenuTarjetas.inicio(amortiTabla),
                WaitUntil.the(TTL_RES_DETALLE_TDD, isVisible()).forNoMoreThan(15).seconds()

        );

    }

    @Y("^valida que se encuentre dentro de operaciones la opción 'Integración de cuentas a tarjeta de débito'$")
    public void validaQueSeEncuentreDentroDeOperacionesLaOpciónIntegraciónDeCuentasATarjetaDeDébito(DataTable dataTable) {
        List<Servicios> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Servicios.class);
        
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(OPC_INTEGRACIONCUENTA, isVisible()).forNoMoreThan(15).seconds(),
                Click.on(OPC_INTEGRACIONCUENTA)

        );
        theActorInTheSpotlight().attemptsTo(
                IntegrarCtaPrincipalesyAsociarOtrasTDD.cuentas(amortiTabla)
        );
    }

    @Entonces("^valida que se muestre el mensaje de cuentas integradas$")
    public void validaQueSeMuestreElMensajeDeCuentasIntegradas() {
        theActorInTheSpotlight().attemptsTo(
                ValidacionMensaje.con());
    }

    @Y("^verifica que se pueda desasociar una cuenta (.*)$")
    public void verificaQueSePuedaDesasociarUnaCuenta(String ctaAsociar) {
        theActorInTheSpotlight().attemptsTo(
                IngresoMenuServicios.inicio(),
                DesintegrarCuenta.asociada(ctaAsociar));
                //ValidacionMensaje.con());
    }
    @Y("^verifica que se pueda desasociar de la TDD una cuenta$")
    public void verificaQueSePuedaDesasociarDeLaTDDUnaCuenta(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                IngresoMenuTarjetas.inicio(amortiTabla),
                DesintegrarCuentaTDD.asociada(amortiTabla),
                ValidacionMensaje.con()
        );
    }
}