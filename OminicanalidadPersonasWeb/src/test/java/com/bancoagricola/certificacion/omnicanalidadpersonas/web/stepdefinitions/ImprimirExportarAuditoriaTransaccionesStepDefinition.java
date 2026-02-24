package com.bancoagricola.certificacion.omnicanalidadpersonas.web.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoMenuServicios;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.questions.ValidaArchivoDescargadoEnLaRuta;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.FiltrarExportarAuditoriaTransacciones;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.ImprimirAuditoriaTransacciones;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.waits.Wait;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.PATH_AUDITORIA;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.is;

public class ImprimirExportarAuditoriaTransaccionesStepDefinition {
    @Y("^filtra la generacion de la transaccion en Auditoria de transacciones$")
    public void filtraLaGeneracionDeLaTransaccionEnAuditoriaDeTransacciones() {
        theActorInTheSpotlight().attemptsTo(
                IngresoMenuServicios.inicio(),
                FiltrarExportarAuditoriaTransacciones.hoy());
    }

    @Entonces("^el cliente ve el archivo Auditoria\\.xlsx en la carpeta$")
    public void elClienteVeElArchivoAuditoriaXlsxEnLaCarpeta() {
        theActorInTheSpotlight().attemptsTo(
                Wait.until(ValidaArchivoDescargadoEnLaRuta.enLaRuta(PATH_AUDITORIA), is(false))
                        .forNoMoreThan(90).seconds());
    }

    @Y("^filtra para generar las transacciones en Auditoria transacciones e imprime$")
    public void filtraParaGenerarLasTransaccionesEnAuditoriaTransaccionesEImprime() {
        theActorInTheSpotlight().attemptsTo(
                IngresoMenuServicios.inicio(),
                ImprimirAuditoriaTransacciones.hoy());
    }
}