package com.bancoagricola.certificacion.omnicanalidadpersonas.web.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.MovimientosRangoFechas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.ConsultarChequesConformados;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.AhorrosPage.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ConsultaChequeConformadoStepDefinition {
    @Entonces("^debe visualizar el cheque con el cual se realizo el pago$")
    public void debeVisualizarElChequeConElCualSeRealizoElPago() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(CONTENEDOR_CHEQUE, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(CONTENEDOR_CHEQUE, isEnabled()).forNoMoreThan(30).seconds());
        LeerArchivoProperties.esperar(1);
        WaitUntil.the(CONTENEDOR_CHEQUE, isVisible()).forNoMoreThan(30).seconds().performAs(theActorInTheSpotlight());
        WaitUntil.the(CONTENEDOR_CHEQUE, isEnabled()).forNoMoreThan(30).seconds().performAs(theActorInTheSpotlight());
        LeerArchivoProperties.esperar(3);
    }

    @Y("^realiza el proceso para consultar los pagos realizados con referencia de cheque (.*)$")
    public void realizaElProcesoParaConsultarLosPagosRealizadosConReferenciaDeCheque(String referencia) {
        theActorInTheSpotlight().attemptsTo(
                MovimientosRangoFechas.datosCA(),
                ConsultarChequesConformados.desdeMovimientos(referencia));
    }
}
