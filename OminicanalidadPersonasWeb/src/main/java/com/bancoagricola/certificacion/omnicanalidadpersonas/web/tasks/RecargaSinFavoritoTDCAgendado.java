package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoVerMasCtaAhorro;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoVerMasTarjetas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.LNK_RECARGA_CEL;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class RecargaSinFavoritoTDCAgendado implements Task {
    private List<Transferencias> datosTDC;

    public RecargaSinFavoritoTDCAgendado(List<Transferencias> datosTDC) {
        this.datosTDC = datosTDC;
    }

    public static RecargaSinFavoritoTDCAgendado datosTDC(List<Transferencias> datosTDC) {
        return Instrumented.instanceOf(RecargaSinFavoritoTDCAgendado.class).withProperties(datosTDC);
    }
    @Step("{0} 'agenda recargas/compra de paquetes para celular'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                IngresoVerMasTarjetas.inicio(datosTDC),
                WaitUntil.the(LNK_RECARGA_CEL, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(LNK_RECARGA_CEL, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(LNK_RECARGA_CEL),
                ProcesoDeAgendaRecargaTDC.datosT(datosTDC));



    }
}
