package com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TarjetasPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ValidaDetalleMovimientoTDC implements Interaction {

    private List<Transferencias> datosTransferencias;
    public ValidaDetalleMovimientoTDC(List<Transferencias> datosDCA) { this.datosTransferencias = datosDCA;}

    @Step("{0} 'valida que se muestre detalle de registro de movimiento de tarjeta de crédito'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias t = datosTransferencias.get(0);

        actor.attemptsTo(
                Click.on(REGISTRO_MOV_TC.of(t.getCargo())),
                WaitUntil.the(VENT_EMER_DETA_MOV, isEnabled()).forNoMoreThan(60).seconds(),
                Ensure.that(VENT_EMER_DETA_MOV).isDisplayed(),
                WaitUntil.the(TTL_VENT_EMER_DETA_MOV, isEnabled()).forNoMoreThan(60).seconds(),
                Ensure.that(TTL_VENT_EMER_DETA_MOV).isDisplayed());
    }

    public static ValidaDetalleMovimientoTDC inicio(List<Transferencias> datosTransferencias){
        return Instrumented.instanceOf(ValidaDetalleMovimientoTDC.class).withProperties(datosTransferencias);
    }
}
