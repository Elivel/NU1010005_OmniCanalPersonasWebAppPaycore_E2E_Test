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
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.OPC_MAS_DETALLE;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.TTL_MAS_DETALLE_CA;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class IngresoAhorroNavidenoMovimientos implements Interaction {
    private String contrato;

    public IngresoAhorroNavidenoMovimientos(String contrato) {
        this.contrato = contrato;
    }

    @Step("{0} 'ingresa a la opción de movimientos'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(OPC_MAS_DETALLE, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPC_MAS_DETALLE, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(OPC_MAS_DETALLE),
                WaitUntil.the(TTL_MAS_DETALLE_CA, isVisible()).forNoMoreThan(60).seconds());
        actor.attemptsTo(
                Scroll.to(TABLA_AHORRO_NAVIDENO1).andAlignToBottom(),
                WaitUntil.the(TABLA_AHORRO_NAVIDENO1, isVisible()));
        LeerArchivoProperties.esperar(1);
        actor.attemptsTo(
                Scroll.to(REGISTRO.of(contrato)).andAlignToBottom(),
                WaitUntil.the(REGISTRO.of(contrato), isVisible()));
        LeerArchivoProperties.esperar(1);
        actor.attemptsTo(
                WaitUntil.the(REGISTRO.of(contrato), isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(REGISTRO.of(contrato), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(REGISTRO.of(contrato)));
        WaitUntil.the(RES_AHO_NAV, isVisible()).forNoMoreThan(60).seconds().performAs(actor);
        LeerArchivoProperties.esperar(2);
        actor.attemptsTo(
                WaitUntil.the(LNK_MOVIMIENTOS, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(LNK_MOVIMIENTOS, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(LNK_MOVIMIENTOS, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(LNK_MOVIMIENTOS),
                WaitUntil.the(MES_ACTUAL, isCurrentlyVisible()).forNoMoreThan(60).seconds());
    }

    public static IngresoAhorroNavidenoMovimientos inicio(String contrato) {
        return Instrumented.instanceOf(IngresoAhorroNavidenoMovimientos.class).withProperties(contrato);
    }
}
