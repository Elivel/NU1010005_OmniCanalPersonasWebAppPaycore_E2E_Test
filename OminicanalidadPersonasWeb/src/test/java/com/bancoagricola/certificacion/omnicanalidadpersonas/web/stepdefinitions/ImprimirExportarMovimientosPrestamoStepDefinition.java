package com.bancoagricola.certificacion.omnicanalidadpersonas.web.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.questions.ValidaArchivoDescargadoEnLaRuta;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.waits.Wait;

import java.io.IOException;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.PATH_MOVIMIENTOS;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.is;

public class ImprimirExportarMovimientosPrestamoStepDefinition {

    @Entonces("^el cliente ve el archivo de Movimientos\\.xlsx en la carpeta$")
    public void elClienteVeElArchivoDeMovimientosXlsxEnLaCarpeta() throws IOException {
        theActorInTheSpotlight().attemptsTo(
                Wait.until(ValidaArchivoDescargadoEnLaRuta.enLaRuta(PATH_MOVIMIENTOS), is(false)).forNoMoreThan(10).seconds());
        LeerArchivoProperties.esperar(3);
        BrowseTheWeb.as(theActorInTheSpotlight()).getDriver().quit();
    }
}
