package com.bancoagricola.certificacion.omnicanalidadpersonas.web.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoVerMasTarjetas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.EliminarSolictudEnvio;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.SolicitudEnvioEstadoCuenta;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.ValidaTicketSolicElimEstCueEmail_Can;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.ValidaTicketSolicElimEstCueEmail_Rec;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.TransformacionALista;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TarjetasPage.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SolicitudElimEstCtaViaEmailStepDefinition {

    @Cuando("^el cliente selecciona una tarjeta para solicitar el envio de estado cuenta$")
    public void elClienteSeleccionaUnaTarjetaParaSolicitarElEnvioDeEstadoCuenta(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                IngresoVerMasTarjetas.inicio(amortiTabla),
                SolicitudEnvioEstadoCuenta.tarjeta(amortiTabla),
                ValidaTicketSolicElimEstCueEmail_Rec.datosCorrectos(amortiTabla));
    }

    @Entonces("^valida que se muestre el mensaje de solicitud$")
    public void validaQueSeMuestreElMensajeDeSolicitud() {
        WaitUntil.the(RESULTADO1, isVisible()).forNoMoreThan(45).seconds().performAs(theActorInTheSpotlight());
        WaitUntil.the(NOPERACION, isVisible()).forNoMoreThan(45).seconds().performAs(theActorInTheSpotlight());
    }

    @Entonces("^verifica que se pueda eliminar la solicitud de envio de estado de cuenta$")
    public void verificaQueSePuedaEliminarLaSolicitudDeEnvioDeEstadoDeCuenta(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                EliminarSolictudEnvio.tarjeta(amortiTabla),
                ValidaTicketSolicElimEstCueEmail_Can.datosCorrectos(amortiTabla));
    }
}