package com.bancoagricola.certificacion.omnicanalidadpersonas.web.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.LiberarFondoCuenta;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.ReservaFondoCuenta;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.TransformacionALista;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ReservarLiberarFondosCuentasStepDefinition {
    @Y("^realiza la reserva de fondos desde CA$")
    public void realizaLaReservaDeFondosDesdeCA(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                IngresoVerMasCtaAhorrobasico.inicio(amortiTabla.get(0).getCuentaOrigen()),
                ReservaFondoCuenta.pagoes(amortiTabla));
    }

    @Y("^realiza la reserva de fondos desde CC$")
    public void realizaLaReservaDeFondosDesdeCC(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                IngresoVerMasCtaCorrientebasico.inicio(amortiTabla.get(0).getCuentaOrigen()),
                ReservaFondoCuenta.pagoes(amortiTabla));
    }

    @Entonces("^realiza la liberacion de fondos desde CA$")
    public void realizaLaLiberacionDeFondosDesdeCA(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                IngresoVerMasCtaAhorro.inicio(amortiTabla),
                LiberarFondoCuenta.pagoes(amortiTabla));
    }

    @Entonces("^realiza la liberacion de fondos desde CC$")
    public void realizaLaLiberacionDeFondosDesdeCC(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                IngresoVerMasCtaCorriente.inicio(amortiTabla.get(0).getCuentaOrigen()),
                LiberarFondoCuenta.pagoes(amortiTabla));
    }
}