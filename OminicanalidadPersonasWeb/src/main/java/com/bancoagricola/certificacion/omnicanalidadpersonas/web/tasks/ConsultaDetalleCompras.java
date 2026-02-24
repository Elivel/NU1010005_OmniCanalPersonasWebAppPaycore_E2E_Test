package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TarjetasPage.*;

public class ConsultaDetalleCompras implements Task {

    private List<Transferencias> datosTransferencias;

    public ConsultaDetalleCompras(List<Transferencias> datosDCA) {
        this.datosTransferencias = datosDCA;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias t = datosTransferencias.get(0);
        actor.attemptsTo(
                Scroll.to(OPCION_MOVTARJE).andAlignToTop(),
                WaitUntil.the(OPCION_OTROS, isEnabled()).forNoMoreThan(15).seconds(),
                WaitUntil.the(OPCION_OTROS, isClickable()).forNoMoreThan(15).seconds(),
                Click.on(OPCION_OTROS)
                //Scroll.to(OPCION_COMPRPLAZ).andAlignToTop(),
               // WaitUntil.the(OPCION_COMPRPLAZ, isVisible()).forNoMoreThan(30).seconds()
        );
        WaitUntil.the(TABLA_COMPRAS_PLAZO, isVisible()).forNoMoreThan(15).seconds().performAs(actor);
        actor.attemptsTo(
                WaitUntil.the(NUMERO_AUTORIZACION.of(t.getNumeroAutorizacion()), isEnabled()).forNoMoreThan(15).seconds(),
                WaitUntil.the(NUMERO_AUTORIZACION.of(t.getNumeroAutorizacion()), isClickable()).forNoMoreThan(15).seconds(),
                Click.on(NUMERO_AUTORIZACION.of(t.getNumeroAutorizacion())));
        WaitUntil.the(LABEL_DETALLE_COMPRA_PLAZO, isVisible()).forNoMoreThan(15).seconds().performAs(theActorInTheSpotlight());
        WaitUntil.the(TABLA_DETALLE_COMPRA_PLAZO, isVisible()).forNoMoreThan(15).seconds().performAs(theActorInTheSpotlight());
    }

    public static ConsultaDetalleCompras aPlazo(List<Transferencias> datosDCA) {
        return Instrumented.instanceOf(ConsultaDetalleCompras.class).withProperties(datosDCA);
    }
}
