package com.bancoagricola.certificacion.omnicanalidadpersonas.web.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoVerMasCtaAhorrobasico;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoVerMasCtaCBasico;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.TransferenciaInternacional;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.TransformacionALista;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class SolicitudTransferenciaInternacionalStepDefinition {

    @Y("^diligencia los campos para realizar la transferencia internacional y guarda la plantilla$")
    public void diligenciaLosCamposParaRealizarLaTransferenciaInternacionalYGuardaLaPlantilla(DataTable dataTable) {
        List<TransferenciaInternacional> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, TransferenciaInternacional.class);
        theActorInTheSpotlight().attemptsTo(
                IngresoVerMasCtaAhorrobasico.inicio(amortiTabla.get(0).getCuentaOrigen()),
                SolicitarTransferenciaInternacional.inicio(),
                RealizarTranferenciaInternacionalCon.plantilla(amortiTabla));
    }

    @Y("^diligencia los campos para realizar la transferencia internacional y guarda la plantilla para CC$")
    public void diligenciaLosCamposParaRealizarLaTransferenciaInternacionalYGuardaLaPlantillaParaCC(DataTable dataTable) {
        List<TransferenciaInternacional> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, TransferenciaInternacional.class);
        theActorInTheSpotlight().attemptsTo(
                IngresoVerMasCtaCBasico.inicio(amortiTabla.get(0).getCuentaOrigen()),
                SolicitarTransferenciaInternacionalCC.inicio(),
                RealizarTranferenciaInternacionalCon.plantilla(amortiTabla));
    }

    @Y("^realiza una transferencia internacional usando una plantilla$")
    public void realizaUnaTransferenciaInternacionalUsandoUnaPlantilla(DataTable dataTable) {
        List<TransferenciaInternacional> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, TransferenciaInternacional.class);
        theActorInTheSpotlight().attemptsTo(
                IngresoVerMasCtaAhorrobasico.inicio(amortiTabla.get(0).getCuentaOrigen()),
                SolicitarTransferenciaInternacional.inicio(),
                TransferirInternacionalmente.usandoPlantilla(amortiTabla));
    }

    @Y("^realiza una transferencia internacional usando una plantilla desde CC$")
    public void realizaUnaTransferenciaInternacionalUsandoUnaPlantillaDesdeCC(DataTable dataTable) {
        List<TransferenciaInternacional> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, TransferenciaInternacional.class);
        theActorInTheSpotlight().attemptsTo(
                IngresoVerMasCtaCBasico.inicio(amortiTabla.get(0).getCuentaOrigen()),
                SolicitarTransferenciaInternacionalCC.inicio(),
                TransferirInternacionalmente.usandoPlantilla(amortiTabla));
    }

    @Y("^diligencia los campos para realizar la transferencia internacional$")
    public void diligenciaLosCamposParaRealizarLaTransferenciaInternacional(DataTable dataTable) {
        List<TransferenciaInternacional> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, TransferenciaInternacional.class);
        theActorInTheSpotlight().attemptsTo(
                IngresoVerMasCtaAhorrobasico.inicio(amortiTabla.get(0).getCuentaOrigen()),
                SolicitarTransferenciaInternacional.inicio(),
                RealizarTranferenciaInternacionalSin.plantilla(amortiTabla));
    }

    @Y("^diligencia los campos para realizar la transferencia internacional desde CC$")
    public void diligenciaLosCamposParaRealizarLaTransferenciaInternacionalDesdeCC(DataTable dataTable) {
        List<TransferenciaInternacional> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, TransferenciaInternacional.class);
        theActorInTheSpotlight().attemptsTo(
                IngresoVerMasCtaCBasico.inicio(amortiTabla.get(0).getCuentaOrigen()),
                SolicitarTransferenciaInternacionalCC.inicio(),
                RealizarTranferenciaInternacionalSin.plantilla(amortiTabla));
    }

    @Entonces("^valida que se muestre el movimiento con la referencia indicada en el ticket$")
    public void validaQueSeMuestreElMovimientoConLaReferenciaIndicadaEnElTicket() {
        theActorInTheSpotlight().attemptsTo(
                ValidaReferenciaTicketCuentaAhorro.conLaReferencia());
    }

    @Entonces("^valida que se muestre el movimiento con la referencia indicada en el ticket para CC$")
    public void validaQueSeMuestreElMovimientoConLaReferenciaIndicadaEnElTicketParaCC() {
        theActorInTheSpotlight().attemptsTo(
                ValidaReferenciaTicketCuentaAhorro.conLaReferencia());
    }

    @Entonces("^valida que se muestre el movimiento con la referencia indicada en el ticket para ahorro programado$")
    public void validaQueSeMuestreElMovimientoConLaReferenciaIndicadaEnElTicketParaAhorroProgramado() {
        theActorInTheSpotlight().attemptsTo(
                ValidaReferenciaTicketAhorroProgramado.conLaReferencia()
        );
    }
}
