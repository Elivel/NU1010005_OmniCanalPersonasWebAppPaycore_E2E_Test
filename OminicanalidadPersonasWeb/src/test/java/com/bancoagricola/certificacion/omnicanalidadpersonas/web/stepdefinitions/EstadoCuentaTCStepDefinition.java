package com.bancoagricola.certificacion.omnicanalidadpersonas.web.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoVerMasTarjetas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.questions.ValidaArchivoDescargadoEnLaRuta;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.ProcesoEstadoCuentaTC;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.TransformacionALista;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.waits.Wait;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.PATH_ESTADO_CUENTA_TC;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.is;

public class EstadoCuentaTCStepDefinition {

    @Dado("^realiza proceso para generación y descarga de estado de cuenta de tarjeta de crédito$")
    public void realizaProcesoParaGeneraciónYDescargaDeEstadoDeCuentaDeTarjetaDeCrédito(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                IngresoVerMasTarjetas.inicio(amortiTabla),
                ProcesoEstadoCuentaTC.datosCA(amortiTabla));
    }

    @Entonces("^el cliente valida que se muestre el archivo de 'EstadoDeCuenta\\.pdf' en la carpeta$")
    public void elClienteValidaQueSeMuestreElArchivoDeEstadoDeCuentaPdfEnLaCarpeta() {
        LeerArchivoProperties.esperar(5);
        Wait.until(ValidaArchivoDescargadoEnLaRuta.enLaRuta(PATH_ESTADO_CUENTA_TC), is(true)).forNoMoreThan(10).seconds().performAs(theActorInTheSpotlight());
    }
}