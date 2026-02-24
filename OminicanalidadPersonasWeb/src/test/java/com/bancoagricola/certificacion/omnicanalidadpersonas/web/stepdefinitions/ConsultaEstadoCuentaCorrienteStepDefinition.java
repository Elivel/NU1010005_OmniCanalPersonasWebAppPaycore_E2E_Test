package com.bancoagricola.certificacion.omnicanalidadpersonas.web.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoVerMasCtaCorriente;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.questions.ValidaArchivoDescargadoEnLaRuta;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.ConsultarEstadoCuenta;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.TransformacionALista;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.waits.Wait;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.PATH_ESTADO_CTA_CORRIENTE;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.is;

public class ConsultaEstadoCuentaCorrienteStepDefinition {
    @Cuando("^realiza proceso para generación y descarga de estado de cuenta corriente$")
    public void realizaProcesoParaGeneraciónYDescargaDeEstadoDeCuentaCorriente(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                IngresoVerMasCtaCorriente.inicio(amortiTabla.get(0).getCuentaOrigen()),
                ConsultarEstadoCuenta.corriente(amortiTabla));
    }

    @Entonces("^el cliente valida que se muestre el archivo de 'EstadoCuenta\\.pdf' en la carpeta$")
    public void elClienteValidaQueSeMuestreElArchivoDeEstadoCuentaPdfEnLaCarpeta() {
        theActorInTheSpotlight().attemptsTo(
                Wait.until(ValidaArchivoDescargadoEnLaRuta.enLaRuta(PATH_ESTADO_CTA_CORRIENTE), is(false)).forNoMoreThan(10).seconds());
    }
}