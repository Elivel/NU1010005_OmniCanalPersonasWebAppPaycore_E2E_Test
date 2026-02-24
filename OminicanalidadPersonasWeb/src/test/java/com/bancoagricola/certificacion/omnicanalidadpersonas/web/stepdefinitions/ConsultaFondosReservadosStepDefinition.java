package com.bancoagricola.certificacion.omnicanalidadpersonas.web.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.PagoTarjetaUNIsinFavorito;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.ReservaFondoCuenta;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.ValidaNumeroReservaTicketCAFondosReserLiber;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.ValidaNumeroReservaTicketCAFondosReservados;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.TransformacionALista;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
public class ConsultaFondosReservadosStepDefinition {
    @Cuando("^realiza pago de tarjeta de credito UNI$")
    public void realizaPagoDeTarjetaDeCreditoUNI(DataTable dataTable) {
        List<Transferencias> Transferencias = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                IngresoVerMasCtaAhorro.inicio(Transferencias),
                PagoTarjetaUNIsinFavorito.con(Transferencias));
    }
    @Entonces("^valida que se muestren registros en fondos reservados$")
    public void validaQueSeMuestrenRegistrosEnFondosReservados(DataTable dataTable) {
        List<Transferencias> Transferencias = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                ValidaNumeroReservaTicketCAFondosReservados.conLaReferencia());
    }

    @Entonces("^valida que se muestre el registros en fondos reservados$")
    public void validaQueSeMuestreElRegistrosEnFondosReservados(DataTable dataTable) {
        List<Transferencias> Transferencias = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                IngresoMenuCtaAhorroOrigenMovimientos.inicio(Transferencias),
                ValidaNumeroReservaTicketCAFondosReservados.conLaReferencia());
    }
    @Entonces("^valida que se muestren registros en fondos reservados de la reserva$")
    public void validaQueSeMuestrenRegistrosEnFondosReservadosDeLaReserva(DataTable dataTable) {
        List<Transferencias> Transferencias = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                IngresoMenuCtaAhorroOrigenMovimientos.inicio(Transferencias),
                ValidaNumeroReservaTicketCAFondosReservados.conLaReferencia());
    }
    @Entonces("^valida que se no se muestre el registro en fondos reservados de la liberacion$")
    public void validaQueNoSeMuestreElRegistroEnFondosReservadosDeLaLiberacion(DataTable dataTable) {
        List<Transferencias> Transferencias = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                ValidaNumeroReservaTicketCAFondosReserLiber.conLaReferencia());
    }
    @Dado("^realiza la reserva de fondos para cuentas$")
    public void realizaLaReservaDeFondosParaCuentas(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                IngresoVerMasCtaAhorrobasico.inicio(amortiTabla.get(0).getCuentaOrigen()),
                ReservaFondoCuenta.pagoes(amortiTabla));
    }
}
