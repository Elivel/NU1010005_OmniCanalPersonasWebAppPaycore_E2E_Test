package com.bancoagricola.certificacion.omnicanalidadpersonas.web.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoMenuProductosDisponibles;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.ProductosDisponibles;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.ProcesoSolicitudEnLinea;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.TransformacionALista;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.ProductosDisponiblesPage.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SolicitudProductosEnLineaStepDefinition {

    @Cuando("^realiza el proceso de solicitud de productos en linea para CrediCash$")
    public void realizaElProcesoDeSolicitudDeProductosEnLineaParaCrediCash(DataTable dataTable) {
        List<ProductosDisponibles> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, ProductosDisponibles.class);
        theActorInTheSpotlight().attemptsTo(
                IngresoMenuProductosDisponibles.inicio(),
                ProcesoSolicitudEnLinea.con(amortiTabla));
    }

    @Entonces("^valida que se genere el numero de solicitud$")
    public void validaQueSeGenereElNumeroDeSolicitud() {
        WaitUntil.the(NUMERO_SOLIC, isVisible()).forNoMoreThan(45).seconds().performAs(theActorInTheSpotlight());

    }
}