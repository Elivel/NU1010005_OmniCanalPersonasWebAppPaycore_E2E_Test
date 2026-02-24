package com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TarjetasPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class IngresoVerMasPuntosBA implements Interaction {

    @Step("{0} 'ingresa al menú'")
    @Override
    public <T extends Actor> void performAs(T actor) {

        LeerArchivoProperties.esperar(3);
        actor.attemptsTo(
                WaitUntil.the(MENU_VERTICAL, isEnabled()).forNoMoreThan(15).seconds(),
                WaitUntil.the(MENU_VERTICAL,isClickable()).forNoMoreThan(15).seconds(),
                WaitUntil.the(MENU_TARJETAS, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(MENU_TARJETAS, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(MENU_TARJETAS),
                WaitUntil.the(TOTAL_TDC, isCurrentlyVisible()).forNoMoreThan(400).seconds(),
                WaitUntil.the(LNK_VER_MAS_PUNTOS, isEnabled()).forNoMoreThan(400).seconds(),
                WaitUntil.the(LNK_VER_MAS_PUNTOS, isClickable()).forNoMoreThan(400).seconds(),
                Click.on(LNK_VER_MAS_PUNTOS),
                WaitUntil.the(TTL_RES_PUNTOS, isVisible()).forNoMoreThan(400).seconds(),
                WaitUntil.the(TTL_RES_PUNTOS, isEnabled()).forNoMoreThan(400).seconds());
    }

    public static IngresoVerMasPuntosBA inicio(){
        return Instrumented.instanceOf(IngresoVerMasPuntosBA.class).withProperties();
    }
}
