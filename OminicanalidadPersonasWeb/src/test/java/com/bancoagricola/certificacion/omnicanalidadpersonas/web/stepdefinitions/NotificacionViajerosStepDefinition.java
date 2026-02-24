package com.bancoagricola.certificacion.omnicanalidadpersonas.web.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.NotifViajeros1Tarj;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.NotifViajerosTodasTarj;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.TransformacionALista;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.ServiciosPage.TTL_SOLICITUD_EXITOSA;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class NotificacionViajerosStepDefinition {

    @Dado("^crea la gestion para notificación de viajeros para una tarjeta$")
    public void creaLaGestionParaNotificaciónDeViajerosParaUnaTarjeta(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                NotifViajeros1Tarj.datosP(amortiTabla));
    }

    @Dado("^crea la gestion para notificación de viajeros para todas las tarjetas$")
    public void creaLaGestionParaNotificaciónDeViajerosParaTodasLasTarjetas(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                NotifViajerosTodasTarj.datosP(amortiTabla));
    }

    @Entonces("^valida que se muestre mensaje de confirmación de creación de gestión$")
    public void ValidaQueSeMuestreMensajeDeConfirmaciónDeCreaciónDeGestión() {
        LeerArchivoProperties.esperar(1);
        WaitUntil.the(TTL_SOLICITUD_EXITOSA, isVisible()).forNoMoreThan(60).seconds().performAs(theActorInTheSpotlight());
    }
}