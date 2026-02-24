package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoVerMasCtaAhorro;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class RecargaSinFavoritoCtaAhorroAgendado implements Task {
    private List<Transferencias> datosDCA;

    public RecargaSinFavoritoCtaAhorroAgendado(List<Transferencias> datosDCA) {
        this.datosDCA = datosDCA;
    }

    @Step("{0} 'agenda recargas/compra de paquetes para celular'")
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                IngresoVerMasCtaAhorro.inicio(datosDCA),
                WaitUntil.the(LNK_RECARGA_CEL, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(LNK_RECARGA_CEL, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(LNK_RECARGA_CEL),
                ProcesoDeAgendaRecarga.datosCA(datosDCA));
    }

    public static RecargaSinFavoritoCtaAhorroAgendado datosCA(List<Transferencias> datosDCA) {
        return Instrumented.instanceOf(RecargaSinFavoritoCtaAhorroAgendado.class).withProperties(datosDCA);
    }
}