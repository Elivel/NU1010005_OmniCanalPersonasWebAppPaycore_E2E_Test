package com.bancoagricola.certificacion.omnicanalidadpersonas.web.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoMenuTarjetasMovimentos;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoVerMasTarjetas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.LiberarFondoTarjeta;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.ReservaFondoTarjeta;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.TransformacionALista;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Y;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TarjetasPage.DISPONIBILIDAD_TARJETA;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ReservarLiberarFondosTarjetasStepDefinition {

    @Y("^realiza la reserva de fondos$")
    public void realizaLaReservaDeFondos(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                IngresoVerMasTarjetas.inicio(amortiTabla),
                ReservaFondoTarjeta.pagoes(amortiTabla),
                IngresoMenuTarjetasMovimentos.inicio(amortiTabla));
        theActorInTheSpotlight().remember(VariablesSesion.MONTO_FINAL_TC.toString(), DISPONIBILIDAD_TARJETA.resolveFor(theActorInTheSpotlight()).getText());
    }

    @Y("^realiza la liberacion de fondos de la tarjeta (.*)$")
    public void realizaLaLiberacionDeFondosDeLaTarjeta(String numeroTarjeta) {
        theActorInTheSpotlight().attemptsTo(
                LiberarFondoTarjeta.pagoes(numeroTarjeta));
    }
}