package com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.AhorrosPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.AhorrosPage.COBROS_PENDIENTES;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.AhorrosPage.LNK_MOVIMIENTOS;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class IngresoMovimientosCobrosPendientes implements Interaction {

    @Step("{0} 'ingresa a la sección de Cobros Pendientes'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        LeerArchivoProperties.esperar(3);
              actor.attemptsTo(
                      WaitUntil.the(LNK_MOVIMIENTOS, isEnabled()).forNoMoreThan(60).seconds(),
                      WaitUntil.the(LNK_MOVIMIENTOS, isClickable()).forNoMoreThan(60).seconds(),
                      Click.on(LNK_MOVIMIENTOS),
                      WaitUntil.the(TTL_MOVIMIENTOS, isCurrentlyVisible()).forNoMoreThan(60).seconds(),
                      Scroll.to(MOVIMIENTOS).andAlignToTop(),
                      WaitUntil.the(MOVIMIENTOS,isEnabled()).forNoMoreThan(15).seconds(),
                      WaitUntil.the(COBROS_PENDIENTES,isEnabled()).forNoMoreThan(15).seconds(),
                      WaitUntil.the(COBROS_PENDIENTES,isClickable()).forNoMoreThan(15).seconds(),
                      Click.on(COBROS_PENDIENTES),
                      WaitUntil.the(TABLA_MOV_CA, isClickable()).forNoMoreThan(15).seconds());
    }

    public static IngresoMovimientosCobrosPendientes inicio(){
        return Instrumented.instanceOf(IngresoMovimientosCobrosPendientes.class).withProperties();
    }
}